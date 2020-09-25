package com.adobe.panchtantra.service;

import com.adobe.panchtantra.entity.BookingEntity;
import com.adobe.panchtantra.entity.InventoryEntity;
import com.adobe.panchtantra.entity.PackageEntity;
import com.adobe.panchtantra.entity.UserEntity;
import com.adobe.panchtantra.mapper.InventoryMapper;
import com.adobe.panchtantra.mapper.OttMapper;
import com.adobe.panchtantra.mapper.PackageMapper;
import com.adobe.panchtantra.mapper.UserMapper;
import com.adobe.panchtantra.model.*;
import com.adobe.panchtantra.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PanchtantraServiceImpl {

    private static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    @Autowired
    private OttRepository ottRepository;

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private InventoryRepository inventoryRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private OttMapper ottMapper;

    @Autowired
    private PackageMapper packageMapper;
    
    @Autowired
    private InventoryMapper inventoryMapper;
    
    @Autowired
    private UserMapper userMapper;

    public Otts getAllOtts() {
        return ottMapper.convertListOfOttToOtts(ottRepository.findAll());
    }

    public Packages getPackages(Long ottId) {
        List<PackageEntity> packageEntities = packageRepository.findByOttId(ottId);
        return packageMapper.convertPackagesToModelPackages(packageEntities);
    }

    public PackageModel getPackage(Long ottId, Long packageId) {
        PackageEntity p = packageRepository.findOne(packageId);
        if(p == null) {
            throw new RuntimeException("PackageEntity not found with given packageId");
        } else {
            return packageMapper.convertPackageToModelPackage(p);
        }
    }
    
    public Inventories getInventories(String packageId,String startDateString,String endDateString) {
        
        try {
            Map<Long, UserEntity> userMap = new HashMap<>();
            Date startDate=FORMAT.parse(startDateString);
            Date endDate=FORMAT.parse(endDateString);
            
            List<InventoryEntity> inventories = inventoryRepository.findAllByPackageIdAndStartsAtEqualsAndExpiresAtEqualsAndNoOfSeatsIsGreaterThan(packageId,startDate,endDate,1L);
            PackageModel aPackage = getPackage(null,Long.valueOf(packageId));
            Inventories availableInventories = inventoryMapper.convertListOfInventoryToInventories(inventories,aPackage);

            inventories.forEach(inventoryEntity -> userMap.put(inventoryEntity.getId(),userRepository.findOne(Long.valueOf(inventoryEntity.getSellerId()))));
            availableInventories.forEach(inventory -> inventory.setSeller(userMapper.convertUserToModelUser(userMap.get(inventory.getId()))));
            
            return availableInventories;
            
        } catch (ParseException e) {
            throw new RuntimeException("Invalid Date");
        }
        
    }
    
    public void saveUpdateInventory(InventoryModel inventoryModel) {
        try {
            if(!validatePackageDetails(inventoryModel)) {
                throw new RuntimeException("Invalid Package");
            }
            InventoryEntity addUpdateInventoryEntity = inventoryRepository.findFirstBySellerIdAndAndPackageId(inventoryModel.getSeller().getId().toString(),inventoryModel.getPackage().getId().toString());
            if(addUpdateInventoryEntity == null){
                addUpdateInventoryEntity = new InventoryEntity();
                addUpdateInventoryEntity.setSellerId(inventoryModel.getSeller().getId().toString());
                addUpdateInventoryEntity.setPackageId(inventoryModel.getPackage().getId().toString());
            }
            
            addUpdateInventoryEntity.setNoOfSeats(inventoryModel.getNoOfSeats());
            addUpdateInventoryEntity.setStatus(InventoryModel.StatusEnum.ACTIVE);
            addUpdateInventoryEntity.setOttUserName(inventoryModel.getOttPassword());
            addUpdateInventoryEntity.setOttPassword(inventoryModel.getOttPassword());
            addUpdateInventoryEntity.setStartsAt(FORMAT.parse(inventoryModel.getStartDate()));
            addUpdateInventoryEntity.setExpiresAt(FORMAT.parse(inventoryModel.getEndDate()));
            
            inventoryRepository.save(addUpdateInventoryEntity);
        }
        catch (ParseException e){
            throw new RuntimeException("Invalid Date");
        }
    }
    
    public void saveUpdateBooking(BookingModel booking) {
        InventoryEntity inventoryEntity = inventoryRepository.findOne(booking.getInventory().getId());
        
        //Validate Booking
        if(!validateBookingDetails(inventoryEntity,booking)){
            throw new RuntimeException("Invalid Booking details - No Seats available");
        }
        
        //Save Booking
        BookingEntity addUpdateBooking = bookingRepository.findFirstByBuyerIdAndInventoryId(booking.getBuyer().getId(),booking.getInventory().getId());

        if(addUpdateBooking == null){
            addUpdateBooking = new BookingEntity();
            addUpdateBooking.setInventoryId(booking.getInventory().getId());
            addUpdateBooking.setInventoryId(booking.getBuyer().getId());
        }
        addUpdateBooking.setBookedAt(inventoryEntity.getStartsAt());
        addUpdateBooking.setExpiresAt(inventoryEntity.getExpiresAt());
        addUpdateBooking.setNoOfSeats(booking.getNoOfSeats());
        addUpdateBooking.setStatus(BookingModel.StatusEnum.ACTIVE);

        bookingRepository.save(addUpdateBooking);

        //Update Inventory
        inventoryEntity.setNoOfSeats(inventoryEntity.getNoOfSeats() - booking.getNoOfSeats());
        inventoryRepository.save(inventoryEntity);
    }
    
    private boolean validateBookingDetails(InventoryEntity inventory,BookingModel booking) {
        if(inventory == null || inventory.getStatus() == InventoryModel.StatusEnum.INACTIVE)
            return false;
        if(inventory.getNoOfSeats() < booking.getNoOfSeats())
            return false;
        
        return true;
    }
    
    private boolean validatePackageDetails(InventoryModel inventoryModel) {
        PackageEntity packageEntity = packageRepository.findOne(inventoryModel.getPackage().getId());
        
        if(packageEntity == null || packageEntity.getStatus().equals(PackageModel.StatusEnum.INACTIVE.name()))
            return false;
        if(inventoryModel.getNoOfSeats() > packageEntity.getNoOfSeats())
            return false;
        
        return true;
    }
}
