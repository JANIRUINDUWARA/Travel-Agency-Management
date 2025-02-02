package com.example.Packages.Microservice.service;

import com.example.Packages.Microservice.model.TravelPackage;
import com.example.Packages.Microservice.repository.PackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;

    @Override
    public TravelPackage createPackage(TravelPackage travelPackage) {
        return packageRepository.save(travelPackage);
    }

    @Override
    public List<TravelPackage> getAllPackages() {
        return packageRepository.findAll();
    }

    @Override
    public TravelPackage getPackageById(Long id) {
        return packageRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Package not found"));
    }

    @Override
    public TravelPackage updatePackage(Long id, TravelPackage updatedPackage) {
        TravelPackage existing = getPackageById(id);
        existing.setPackageName(updatedPackage.getPackageName());
        existing.setDescription(updatedPackage.getDescription());
        existing.setDestination(updatedPackage.getDestination());
        existing.setDurationDays(updatedPackage.getDurationDays());
        existing.setPrice(updatedPackage.getPrice());
        existing.setAvailableSlots(updatedPackage.getAvailableSlots());
        return packageRepository.save(existing);
    }

    @Override
    public void deletePackage(Long id) {
        packageRepository.deleteById(id);
    }
}