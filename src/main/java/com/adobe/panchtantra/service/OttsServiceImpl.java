package com.adobe.panchtantra.service;

import com.adobe.panchtantra.entity.Inventory;
import com.adobe.panchtantra.entity.Package;
import com.adobe.panchtantra.entity.User;
import com.adobe.panchtantra.mapper.InventoryMapper;
import com.adobe.panchtantra.mapper.OttMapper;
import com.adobe.panchtantra.mapper.PackageMapper;
import com.adobe.panchtantra.mapper.UserMapper;
import com.adobe.panchtantra.model.Inventories;
import com.adobe.panchtantra.model.ModelPackage;
import com.adobe.panchtantra.model.Otts;
import com.adobe.panchtantra.model.Packages;
import com.adobe.panchtantra.repository.InventoryRepository;
import com.adobe.panchtantra.repository.OttRepository;
import com.adobe.panchtantra.repository.PackageRepository;
import com.adobe.panchtantra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OttsServiceImpl {

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
        List<Package> packages = packageRepository.findByOttId(ottId);
        return packageMapper.convertPackagesToModelPackages(packages);
    }

    public ModelPackage getPackage(Long ottId, Long packageId) {
        Package p = packageRepository.findOne(packageId);
        if(p == null) {
            throw new RuntimeException("Package not found with given packageId");
        } else {
            return packageMapper.convertPackageToModelPackage(p);
        }
    }
    
    public Inventories getInventories(String packageId,String startDateString,String endDateString) {
        
        try {
            Map<Long,User> userMap = new HashMap<>();
            Date startDate=FORMAT.parse(startDateString);
            Date endDate=FORMAT.parse(endDateString);
            
            List<Inventory> inventories = inventoryRepository.findAllByPackageIdAndStartsAtEqualsAndExpiresAtEquals(packageId,startDate,endDate);
            ModelPackage aPackage = getPackage(null,Long.valueOf(packageId));
            Inventories availableInventories = inventoryMapper.convertListOfInventoryToInventories(inventories,aPackage);

            inventories.forEach(inventory -> userMap.put(inventory.getId(),userRepository.findOne(Long.valueOf(inventory.getSellerId()))));
            availableInventories.forEach(inventory -> inventory.setSeller(userMapper.convertUserToModelUser(userMap.get(inventory.getId()))));
            
            return availableInventories;
            
        } catch (ParseException e) {
            throw new RuntimeException("Invalid Date");
        }
        
    }
    
    public void saveInventory(com.adobe.panchtantra.model.Inventory inventory) {
        try {
            Inventory addInventory = new Inventory();

            addInventory.setNoOfSeats(inventory.getNoOfSeats());
            addInventory.setStatus(com.adobe.panchtantra.model.Inventory.StatusEnum.ACTIVE.name());
            addInventory.setOttUserName(inventory.getOttPassword());
            addInventory.setOttPassword(inventory.getOttPassword());
            addInventory.setStartsAt(FORMAT.parse(inventory.getStartDate()));
            addInventory.setExpiresAt(FORMAT.parse(inventory.getEndDate()));
            addInventory.setSellerId(inventory.getSeller().getId().toString());
            addInventory.setPackageId(inventory.getPackage().getId().toString());

            inventoryRepository.save(addInventory);
        }
        catch (ParseException e){
            throw new RuntimeException("Invalid Date");
        }
    }
}
