package com.adobe.panchtantra.mapper;

import com.adobe.panchtantra.entity.Package;
import com.adobe.panchtantra.model.ModelPackage;
import com.adobe.panchtantra.model.Packages;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class PackageMapper {

    public Packages convertPackagesToModelPackages(List<Package> packages) {
        if(CollectionUtils.isEmpty(packages)) {
            return null;
        }
        Packages modelPackages = new Packages();
        packages.stream().forEach(p -> modelPackages.add(convertPackageToModelPackage(p)));
        return modelPackages;
    }

    public ModelPackage convertPackageToModelPackage(Package p) {
        if(p == null) {
            return null;
        }
        ModelPackage modelPackage = new ModelPackage();
        modelPackage.id(p.getId()).name(p.getName()).noOfSeats(p.getNoOfSeats()).pricing(p.getPrice());
        modelPackage.status(p.getStatus() != null ? ModelPackage.StatusEnum.valueOf(p.getStatus()) : null);
        modelPackage.basis(p.getBasis() != null ? ModelPackage.BasisEnum.valueOf(p.getBasis()) : null);
        return modelPackage;
    }
}
