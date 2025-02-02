// PackageService.java
package com.example.Packages.Microservice.service;

import com.example.Packages.Microservice.model.TravelPackage;

import java.util.List;

public interface PackageService {
    TravelPackage createPackage(TravelPackage travelPackage);

    List<TravelPackage> getAllPackages();

    TravelPackage getPackageById(Long id);

    TravelPackage updatePackage(Long id, TravelPackage updatedPackage);

    void deletePackage(Long id);
}

