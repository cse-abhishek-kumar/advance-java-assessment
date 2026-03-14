package com.bookingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.model.Booking;
import com.bookingservice.model.BookingRequest;
import com.bookingservice.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@PostMapping
	public Booking createBooking(@RequestBody BookingRequest request) {
		return bookingService.createBooking(request);
	}
	
	@GetMapping
	public List<Booking> getAllBookings(){
		return bookingService.getAllBookings();
	}
}
