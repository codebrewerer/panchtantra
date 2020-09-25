package com.adobe.panchtantra.mapper;

import com.adobe.panchtantra.entity.PackageEntity;
import com.adobe.panchtantra.model.PackageModel;
import com.adobe.panchtantra.model.Packages;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class PackageMapper {

    public Packages convertPackagesToModelPackages(List<PackageEntity> packageEntities) {
        if(CollectionUtils.isEmpty(packageEntities)) {
            return null;
        }
        Packages modelPackages = new Packages();
        packageEntities.stream().forEach(p -> modelPackages.add(convertPackageToModelPackage(p)));
        return modelPackages;
    }

    public PackageModel convertPackageToModelPackage(PackageEntity p) {
        if(p == null) {
            return null;
        }
        PackageModel packageModel = new PackageModel();
        packageModel.id(p.getId()).name(p.getName()).noOfSeats(p.getNoOfSeats()).pricing(p.getPrice());
        packageModel.status(p.getStatus() != null ? PackageModel.StatusEnum.valueOf(p.getStatus()) : null);
        packageModel.basis(p.getBasis() != null ? PackageModel.BasisEnum.valueOf(p.getBasis()) : null);
        return packageModel;
    }
}
