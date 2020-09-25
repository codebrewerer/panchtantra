package com.adobe.panchtantra.repository;

import com.adobe.panchtantra.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity,Long> {

    BookingEntity findFirstByBuyerIdAndInventoryId(Long buyerId,Long inventoryId);
}
