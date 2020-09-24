package com.adobe.panchtantra.repository;

import com.adobe.panchtantra.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {

    List<Package> findByOttId(Long ottId);
}