package com.travelAgent.feedback.service;

import com.travelAgent.feedback.model.Feedback;
import com.travelAgent.feedback.repository.FeedbackRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback getFeedbackById(Long id) {
        try {
            return feedbackRepository.findById(id)
                    .orElseThrow(() -> new Exception("Feedback not found"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Feedback updateFeedback(Long id, Feedback feedbackDetails) {
        Feedback feedback = getFeedbackById(id);
        BeanUtils.copyProperties(feedbackDetails, feedback, "id");
        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long id) {
        Feedback feedback = getFeedbackById(id);
        feedbackRepository.delete(feedback);
    }
}
