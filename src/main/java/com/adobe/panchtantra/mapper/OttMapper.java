package com.adobe.panchtantra.mapper;

import com.adobe.panchtantra.entity.Ott;
import com.adobe.panchtantra.model.Otts;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Component
public class OttMapper {

    public Otts convertListOfOttToOtts(List<Ott> listOfOtt) {
        if(CollectionUtils.isEmpty(listOfOtt)) {
            return null;
        }
        Otts otts = new Otts();
        listOfOtt.stream().forEach(ott -> otts.add(convertOttToOttDto(ott)));
        return otts;
    }

    public  com.adobe.panchtantra.model.Ott convertOttToOttDto(Ott ott) {
        if(ott == null) {
            return null;
        }

        com.adobe.panchtantra.model.Ott ottDto = new com.adobe.panchtantra.model.Ott();
        ottDto.id(ott.getId()).ottName(ott.getName()).status(ott.getStatus());
        return ottDto;
    }
}
