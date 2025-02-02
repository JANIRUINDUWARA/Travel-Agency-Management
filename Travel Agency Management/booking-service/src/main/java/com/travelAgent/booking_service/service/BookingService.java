package com.travelAgent.booking_service.service;

import com.travelAgent.booking_service.model.Booking;
import com.travelAgent.booking_service.repository.BookingRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Booking Service
@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        System.out.println(booking);
        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Long id) {
        try {
            return bookingRepository.findById(id)
                    .orElseThrow(() -> new Exception("Booking not found"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = getBookingById(id);
        BeanUtils.copyProperties(bookingDetails, booking, "id");
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }
}
