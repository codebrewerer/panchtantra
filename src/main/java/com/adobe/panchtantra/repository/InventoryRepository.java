package com.adobe.panchtantra.repository;

import com.adobe.panchtantra.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    
    List<InventoryEntity> findAllByPackageIdAndStartsAtEqualsAndExpiresAtEquals(String packageId, Date startsAt, Date expiresAt);
}
