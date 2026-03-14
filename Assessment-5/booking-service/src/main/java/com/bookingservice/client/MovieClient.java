package com.bookingservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookingservice.model.Movie;

@FeignClient(name = "MOVIE-SERVICE",fallback=MovieClientFallback.class)
public interface MovieClient {
	@GetMapping("/movies/{id}")
	Movie getMovieById(@PathVariable Long id);
}
