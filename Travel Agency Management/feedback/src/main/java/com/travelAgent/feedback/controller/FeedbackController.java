package com.travelAgent.feedback.controller;

import com.travelAgent.feedback.model.Feedback;
import com.travelAgent.feedback.service.FeedbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Operation(summary = "Create a new feedback", description = "Adds a new feedback to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created feedback",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Feedback.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        return ResponseEntity.ok(feedbackService.createFeedback(feedback));
    }

    @Operation(summary = "Get feedback by ID", description = "Fetches feedback details by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Feedback found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Feedback.class))),
            @ApiResponse(responseCode = "404", description = "Feedback not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(
            @Parameter(description = "ID of the feedback", required = true) @PathVariable Long id) {
        return ResponseEntity.ok(feedbackService.getFeedbackById(id));
    }

    @Operation(summary = "Get all feedbacks", description = "Retrieves a list of all feedback entries")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved feedback list",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Feedback.class)))
    })
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        return ResponseEntity.ok(feedbackService.getAllFeedbacks());
    }

    @Operation(summary = "Update feedback details", description = "Updates an existing feedback entry")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Feedback successfully updated",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Feedback.class))),
            @ApiResponse(responseCode = "404", description = "Feedback not found"),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(
            @Parameter(description = "ID of the feedback", required = true) @PathVariable Long id,
            @RequestBody Feedback feedbackDetails) {
        return ResponseEntity.ok(feedbackService.updateFeedback(id, feedbackDetails));
    }

    @Operation(summary = "Delete feedback", description = "Removes a feedback entry from the system by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Feedback successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Feedback not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(
            @Parameter(description = "ID of the feedback", required = true) @PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.ok().build();
    }
}
