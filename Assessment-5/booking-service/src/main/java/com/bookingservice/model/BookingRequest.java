package com.bookingservice.model;

import lombok.Data;

@Data
public class BookingRequest {
	private Long movieId;
	private Integer tickets;
}
