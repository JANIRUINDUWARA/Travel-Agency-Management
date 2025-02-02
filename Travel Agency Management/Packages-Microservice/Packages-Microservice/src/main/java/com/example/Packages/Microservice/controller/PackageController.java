package com.example.Packages.Microservice.controller;

import com.example.Packages.Microservice.model.TravelPackage;
import com.example.Packages.Microservice.service.PackageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
public class PackageController {

    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @Operation(summary = "Create a new travel package", description = "Adds a new travel package to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created package",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TravelPackage.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TravelPackage createPackage(@RequestBody TravelPackage travelPackage) {
        return packageService.createPackage(travelPackage);
    }

    @Operation(summary = "Get all travel packages", description = "Retrieves a list of all available travel packages")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TravelPackage.class)))
    })
    @GetMapping
    public List<TravelPackage> getAllPackages() {
        return packageService.getAllPackages();
    }

    @Operation(summary = "Get travel package by ID", description = "Fetches a travel package using its unique ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Package found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TravelPackage.class))),
            @ApiResponse(responseCode = "404", description = "Package not found")
    })
    @GetMapping("/{id}")
    public TravelPackage getPackageById(
            @Parameter(description = "ID of the travel package", required = true) @PathVariable Long id) {
        return packageService.getPackageById(id);
    }

    @Operation(summary = "Update travel package details", description = "Updates an existing travel package")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Package successfully updated",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TravelPackage.class))),
            @ApiResponse(responseCode = "404", description = "Package not found"),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PutMapping("/{id}")
    public TravelPackage updatePackage(
            @Parameter(description = "ID of the travel package", required = true) @PathVariable Long id,
            @RequestBody TravelPackage updatedPackage) {
        return packageService.updatePackage(id, updatedPackage);
    }

    @Operation(summary = "Delete travel package", description = "Removes a travel package from the system by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Package successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Package not found")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePackage(
            @Parameter(description = "ID of the travel package", required = true) @PathVariable Long id) {
        packageService.deletePackage(id);
    }
}
