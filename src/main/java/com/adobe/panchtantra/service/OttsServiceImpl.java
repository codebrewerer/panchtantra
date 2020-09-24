package com.adobe.panchtantra.service;

import com.adobe.panchtantra.mapper.OttMapper;
import com.adobe.panchtantra.model.ModelPackage;
import com.adobe.panchtantra.model.Otts;
import com.adobe.panchtantra.model.Packages;
import com.adobe.panchtantra.repository.OttRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OttsServiceImpl {

    @Autowired
    private OttRepository ottRepository;

    @Autowired
    private OttMapper ottMapper;

    public Otts getAllOtts() {
        return ottMapper.convertListOfOttToOtts(ottRepository.findAll());
    }

    public Packages getPackages(Long ottId) {
        return null;
    }

    public ModelPackage getPackage(Long ottId, Long packageId) {
        return null;
    }
}
