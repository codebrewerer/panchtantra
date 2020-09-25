package com.adobe.panchtantra.repository;

import com.adobe.panchtantra.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    
    List<Inventory> findAllByPackageIdAndStartsAtEqualsAndExpiresAtEquals(String packageId, Date startsAt, Date expiresAt);
}
