package com.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
	private Long bookingId;
	private Long movieId;
	private String movieName;
	private Integer tickets;
	private Double totalAmount;
	
}
