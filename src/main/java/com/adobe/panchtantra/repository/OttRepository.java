package com.adobe.panchtantra.repository;

import com.adobe.panchtantra.entity.OttEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OttRepository extends JpaRepository<OttEntity, Long> {

}
