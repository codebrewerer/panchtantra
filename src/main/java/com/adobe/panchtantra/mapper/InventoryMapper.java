package com.adobe.panchtantra.mapper;

import com.adobe.panchtantra.entity.Inventory;
import com.adobe.panchtantra.model.Inventories;
import com.adobe.panchtantra.model.ModelPackage;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class InventoryMapper {

    public Inventories convertListOfInventoryToInventories(List<Inventory> listOfInventory, ModelPackage aPackage) {
        if(CollectionUtils.isEmpty(listOfInventory)) {
            return null;
        }
        Inventories inventories = new Inventories();
        listOfInventory.stream().forEach(inventory -> inventories.add(convertInventoryToInventoryDto(inventory,aPackage)));
        return inventories;
    }

    private com.adobe.panchtantra.model.Inventory convertInventoryToInventoryDto(Inventory inventory, ModelPackage aPackage) {
        if(inventory == null) {
            return null;
        }

        com.adobe.panchtantra.model.Inventory inventoryDto = new com.adobe.panchtantra.model.Inventory();
        inventoryDto.
                id(inventory.getId()).
                noOfSeats(inventory.getNoOfSeats()).
                status(com.adobe.panchtantra.model.Inventory.StatusEnum.valueOf(inventory.getStatus())).
                ottUsername(inventory.getOttUserName()).
                ottPassword(inventory.getOttPassword()).
                _package(aPackage).
                startDate(inventory.getStartsAt().toString()).
                endDate(inventory.getExpiresAt().toString());
        
        return inventoryDto;
    }
}
