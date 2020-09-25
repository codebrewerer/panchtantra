package com.adobe.panchtantra.mapper;

import com.adobe.panchtantra.entity.InventoryEntity;
import com.adobe.panchtantra.model.Inventories;
import com.adobe.panchtantra.model.InventoryModel;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class InventoryMapper {

    public Inventories convertListOfInventoryToInventories(List<InventoryEntity> listOfInventoryEntity) {
        if(CollectionUtils.isEmpty(listOfInventoryEntity)) {
            return null;
        }
        Inventories inventories = new Inventories();
        listOfInventoryEntity.stream().forEach(inventoryEntity -> inventories.add(convertInventoryToInventoryDto(inventoryEntity)));
        return inventories;
    }

    public InventoryModel convertInventoryToInventoryDto(InventoryEntity inventoryEntity) {
        if(inventoryEntity == null) {
            return null;
        }

        InventoryModel inventoryModelDto = new InventoryModel();
        inventoryModelDto.
                id(inventoryEntity.getId()).
                noOfSeats(inventoryEntity.getNoOfSeats()).
                status(inventoryEntity.getStatus()).
                ottUsername(inventoryEntity.getOttUserName()).
                ottPassword(inventoryEntity.getOttPassword()).
                startDate(inventoryEntity.getStartsAt().toString()).
                endDate(inventoryEntity.getExpiresAt().toString());
        
        return inventoryModelDto;
    }
}
