package com.adobe.panchtantra.service;

import com.adobe.panchtantra.entity.Inventory;
import com.adobe.panchtantra.entity.Package;
import com.adobe.panchtantra.mapper.InventoryMapper;
import com.adobe.panchtantra.mapper.OttMapper;
import com.adobe.panchtantra.mapper.PackageMapper;
import com.adobe.panchtantra.model.Inventories;
import com.adobe.panchtantra.model.ModelPackage;
import com.adobe.panchtantra.model.Otts;
import com.adobe.panchtantra.model.Packages;
import com.adobe.panchtantra.repository.InventoryRepository;
import com.adobe.panchtantra.repository.OttRepository;
import com.adobe.panchtantra.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OttsServiceImpl {

    @Autowired
    private OttRepository ottRepository;

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private OttMapper ottMapper;

    @Autowired
    private PackageMapper packageMapper;
    
    @Autowired
    private InventoryMapper inventoryMapper;

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
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date startDate=format.parse(startDateString);
            Date endDate=format.parse(endDateString);
            List<Inventory> inventories = inventoryRepository.findAllByPackageIdAndStartsAtEqualsAndExpiresAtEquals(packageId,startDate,endDate);
            return inventoryMapper.convertListOfInventoryToInventories(inventories);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid Date");
        }
        
    }
}
