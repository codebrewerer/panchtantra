package com.adobe.panchtantra.repository;

import com.adobe.panchtantra.entity.BookingEntity;
import com.adobe.panchtantra.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity,Long> {

    BookingEntity findFirstByBuyerIdAndInventoryId(Long buyerId,Long inventoryId);
    
    List<BookingEntity> findAllByBuyerIdAndStatus(Long buyerId, BookingModel.StatusEnum status);
}
