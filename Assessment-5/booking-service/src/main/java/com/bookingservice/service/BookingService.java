package com.bookingservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.client.MovieClient;
import com.bookingservice.model.Booking;
import com.bookingservice.model.BookingRequest;
import com.bookingservice.model.Movie;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class BookingService {
	
	@Autowired
	private MovieClient movieClient;
	
	private final List<Booking> bookings = new ArrayList<>();
	private final AtomicLong idCounter = new AtomicLong(100);
	
	@CircuitBreaker(name = "movieServiceCB",fallbackMethod = "bookingFallback")
	public Booking createBooking(BookingRequest request) {
		Movie movie = movieClient.getMovieById(request.getMovieId());
		double totalAmount = movie.getPrice()*request.getTickets();
		
		Booking booking = new Booking(
				idCounter.incrementAndGet(),
				request.getMovieId(),
				movie.getName(),
				request.getTickets(),
				totalAmount
				);
		bookings.add(booking);
		return booking;
	}
	
	public Booking bookingFallback(BookingRequest request,Throwable t) {
		return new Booking(
				-1L,
				request.getMovieId(),
				"Movie Service is currently unabailable. Please try again later.",
				request.getTickets(),
				0.0
				);
	}
	
	public List<Booking> getAllBookings(){
		return bookings;
	}

}
