package com.bookingservice.client;

import org.springframework.stereotype.Component;

import com.bookingservice.model.Movie;

@Component
public class MovieClientFallback implements MovieClient {
	
	@Override
	public Movie getMovieById(Long id) {
		Movie fallback = new Movie();
		fallback.setId(id);
		fallback.setName("Movie Service Unavailable");
		fallback.setPrice(0.0);
		return fallback;
	}
}
