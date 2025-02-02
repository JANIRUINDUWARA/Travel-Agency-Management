package com.example.Packages.Microservice.repository;

import com.example.Packages.Microservice.model.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<TravelPackage, Long> {
}
//Predefined functions microservice ekata import kara gannawa