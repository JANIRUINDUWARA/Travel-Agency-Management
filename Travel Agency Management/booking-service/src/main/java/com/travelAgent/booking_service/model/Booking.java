package com.travelAgent.booking_service.model;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String packageId;
    private LocalDate bookingDate;
    private LocalDate travelDate;
    private BigDecimal totalPrice;
}
