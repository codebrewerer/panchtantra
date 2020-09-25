package com.adobe.panchtantra.mapper;

import com.adobe.panchtantra.entity.OttEntity;
import com.adobe.panchtantra.model.OttModel;
import com.adobe.panchtantra.model.Otts;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class OttMapper {

    public Otts convertListOfOttToOtts(List<OttEntity> listOfOttEntity) {
        if(CollectionUtils.isEmpty(listOfOttEntity)) {
            return null;
        }
        Otts otts = new Otts();
        listOfOttEntity.stream().forEach(ottEntity -> otts.add(convertOttToOttDto(ottEntity)));
        return otts;
    }

    public OttModel convertOttToOttDto(OttEntity ottEntity) {
        if(ottEntity == null) {
            return null;
        }

        OttModel ottModelDto = new OttModel();
        ottModelDto.id(ottEntity.getId()).ottName(ottEntity.getName()).status(ottEntity.getStatus());
        return ottModelDto;
    }
}
