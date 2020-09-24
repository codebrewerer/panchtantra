package com.adobe.panchtantra.service;

import com.adobe.panchtantra.model.*;
import org.springframework.stereotype.Service;
import org.threeten.bp.LocalDate;

import java.util.stream.Collectors;


@Service
public class OttServiceImpl {

    private static Otts otts = new Otts();

    private static Packages packagesNetflix = new Packages();
    private static Packages packagesHotstar = new Packages();
    private static Packages packagesAmazon = new Packages();
    private static Packages packagesSony = new Packages();
    
    private static Inventories inventoriesPackageNetflix = new Inventories();
    
    static {
        
        User seller1 = new User().id(1001L).email("abc@netflix.com").name("ABC");
        User seller2 = new User().id(2001L).email("pqr@netflix.com").name("ABC");
        User seller3 = new User().id(3001L).email("xyz@netflix.com").name("ABC");
        User seller4 = new User().id(4001L).email("123@netflix.com").name("ABC");

        User buyer1 = new User().id(5001L).email("456@netflix.com").name("ABC");
        User buyer2 = new User().id(6001L).email("789@netflix.com").name("ABC");
        User buyer3 = new User().id(7001L).email("efg@netflix.com").name("ABC");
        User buyer4 = new User().id(8001L).email("ijk@netflix.com").name("ABC");
        
        
        otts.add(new Ott().id(101L).ottName("Netflix").status("Active"));
        otts.add(new Ott().id(102L).ottName("Hotstar").status("Active"));
        otts.add(new Ott().id(103L).ottName("Amazon Prime").status("Active"));
        otts.add(new Ott().id(104L).ottName("Sony Liv").status("Active"));

        ModelPackage packageNetflix_1 = new ModelPackage().id(201L).name("High Definition").noOfSeats(2L).basis(ModelPackage.BasisEnum.MONTHLY).pricing(499.0).status(ModelPackage.StatusEnum.ACTIVE);
        ModelPackage packageNetflix_2 = new ModelPackage().id(202L).name("4K").noOfSeats(4L).basis(ModelPackage.BasisEnum.MONTHLY).pricing(799.0).status(ModelPackage.StatusEnum.ACTIVE);

        ModelPackage packageHotstar_1 = new ModelPackage().id(202L).name("High Definition").noOfSeats(2L).basis(ModelPackage.BasisEnum.MONTHLY).pricing(499.0).status(ModelPackage.StatusEnum.ACTIVE);
        ModelPackage packageHotstar_2 = new ModelPackage().id(203L).name("4K").noOfSeats(4L).basis(ModelPackage.BasisEnum.MONTHLY).pricing(799.0).status(ModelPackage.StatusEnum.ACTIVE);

        ModelPackage packageAmazon_1 = new ModelPackage().id(204L).name("High Definition").noOfSeats(2L).basis(ModelPackage.BasisEnum.YEARLY).pricing(1099.0).status(ModelPackage.StatusEnum.ACTIVE);
        ModelPackage packageAmazon_2 = new ModelPackage().id(205L).name("4K").noOfSeats(4L).basis(ModelPackage.BasisEnum.YEARLY).pricing(1499.0).status(ModelPackage.StatusEnum.ACTIVE);

        ModelPackage packageSony_1 = new ModelPackage().id(206L).name("High Definition").noOfSeats(2L).basis(ModelPackage.BasisEnum.YEARLY).pricing(1099.0).status(ModelPackage.StatusEnum.ACTIVE);
        ModelPackage packageSony_2 = new ModelPackage().id(207L).name("4K").noOfSeats(4L).basis(ModelPackage.BasisEnum.YEARLY).pricing(1499.0).status(ModelPackage.StatusEnum.ACTIVE);
        
        packagesNetflix.add(packageNetflix_1);
        packagesNetflix.add(packageNetflix_2);

        packagesHotstar.add(packageHotstar_1);
        packagesHotstar.add(packageHotstar_2);

        packagesAmazon.add(packageAmazon_1);
        packagesAmazon.add(packageAmazon_2);

        packagesSony.add(packageSony_1);
        packagesSony.add(packageSony_2);

        inventoriesPackageNetflix.add(new Inventory().
                id(1000L).
                _package(packageNetflix_1).
                seller(seller1).
                noOfSeats(2L).
                ottUsername("abc@xyz.com").
                ottPassword("123456").
                startDate(LocalDate.ofEpochDay(1598967488)).
                endDate(LocalDate.ofEpochDay(1601473088)));
        inventoriesPackageNetflix.add(new Inventory().
                id(1000L).
                _package(packageNetflix_1).
                seller(seller2).
                noOfSeats(2L).
                ottUsername("abc@xyz.com").
                ottPassword("123456").
                startDate(LocalDate.ofEpochDay(1600177088)).
                endDate(LocalDate.ofEpochDay(1601473088)));
        inventoriesPackageNetflix.add(new Inventory().
                id(1000L).
                _package(packageNetflix_1).
                seller(seller3).
                noOfSeats(2L).
                ottUsername("abc@xyz.com").
                ottPassword("123456").
                startDate(LocalDate.ofEpochDay(1598967488)).
                endDate(LocalDate.ofEpochDay(1601473088)));
        inventoriesPackageNetflix.add(new Inventory().
                id(1000L).
                _package(packageNetflix_2).
                seller(seller4).
                noOfSeats(2L).
                ottUsername("abc@xyz.com").
                ottPassword("123456").
                startDate(LocalDate.ofEpochDay(1600177088)).
                endDate(LocalDate.ofEpochDay(1601473088)));
    }

    public Otts getAllOtts() {
        return otts;
    }

    public Packages getPackages(Long id) {

        if(id == 101l)
            return packagesNetflix;
        else if(id == 102l)
            return packagesHotstar;
        else if(id == 103l)
            return packagesAmazon;
        else if(id == 104l)
            return packagesSony;
        else
            throw new RuntimeException("INVALID_ID");

    }
    
    public Inventories getInventories(ModelPackage aPackage,LocalDate startDate, LocalDate endDate) {
        Inventories availableInventories = (Inventories) inventoriesPackageNetflix.stream().
                filter(inventory -> inventory.getPackage().getId() == aPackage.getId() && inventory.getStartDate() == startDate && inventory.getEndDate() == endDate)
                .collect(Collectors.toList());
        return availableInventories;
    }
}
