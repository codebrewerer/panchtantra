package com.adobe.panchtantra.service;

import com.adobe.panchtantra.entity.InventoryEntity;
import com.adobe.panchtantra.entity.PackageEntity;
import com.adobe.panchtantra.entity.UserEntity;
import com.adobe.panchtantra.mapper.InventoryMapper;
import com.adobe.panchtantra.mapper.OttMapper;
import com.adobe.panchtantra.mapper.PackageMapper;
import com.adobe.panchtantra.mapper.UserMapper;
import com.adobe.panchtantra.model.*;
import com.adobe.panchtantra.repository.InventoryRepository;
import com.adobe.panchtantra.repository.OttRepository;
import com.adobe.panchtantra.repository.PackageRepository;
import com.adobe.panchtantra.repository.UserRepository;
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
            
            List<InventoryEntity> inventories = inventoryRepository.findAllByPackageIdAndStartsAtEqualsAndExpiresAtEquals(packageId,startDate,endDate);
            PackageModel aPackage = getPackage(null,Long.valueOf(packageId));
            Inventories availableInventories = inventoryMapper.convertListOfInventoryToInventories(inventories,aPackage);

            inventories.forEach(inventoryEntity -> userMap.put(inventoryEntity.getId(),userRepository.findOne(Long.valueOf(inventoryEntity.getSellerId()))));
            availableInventories.forEach(inventory -> inventory.setSeller(userMapper.convertUserToModelUser(userMap.get(inventory.getId()))));
            
            return availableInventories;
            
        } catch (ParseException e) {
            throw new RuntimeException("Invalid Date");
        }
        
    }
    
    public void saveInventory(InventoryModel inventoryModel) {
        try {
            InventoryEntity addInventoryEntity = new InventoryEntity();

            addInventoryEntity.setNoOfSeats(inventoryModel.getNoOfSeats());
            addInventoryEntity.setStatus(InventoryModel.StatusEnum.ACTIVE.name());
            addInventoryEntity.setOttUserName(inventoryModel.getOttPassword());
            addInventoryEntity.setOttPassword(inventoryModel.getOttPassword());
            addInventoryEntity.setStartsAt(FORMAT.parse(inventoryModel.getStartDate()));
            addInventoryEntity.setExpiresAt(FORMAT.parse(inventoryModel.getEndDate()));
            addInventoryEntity.setSellerId(inventoryModel.getSeller().getId().toString());
            addInventoryEntity.setPackageId(inventoryModel.getPackage().getId().toString());

            inventoryRepository.save(addInventoryEntity);
        }
        catch (ParseException e){
            throw new RuntimeException("Invalid Date");
        }
    }
    
    public void saveBookingsByInventoryId(BookingModel booking) {
        
    }
}
