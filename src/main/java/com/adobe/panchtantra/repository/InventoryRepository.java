package com.adobe.panchtantra.repository;

import com.adobe.panchtantra.entity.InventoryEntity;
import com.adobe.panchtantra.model.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    
    List<InventoryEntity> findAllByPackageIdAndStartsAtEqualsAndExpiresAtEqualsAndNoOfSeatsIsGreaterThan(String packageId, Date startsAt, Date expiresAt,Long seatsLimit);
    
    InventoryEntity findFirstBySellerIdAndAndPackageId(String sellerId,String packageId);

    List<InventoryEntity> findBySellerIdAndStatusEquals(String sellerId, InventoryModel.StatusEnum status);
}
