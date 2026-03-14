package com.movieservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.movieservice.model.Movie;

@Service
public class MovieService {
	private final List<Movie> movies = new ArrayList<>(List.of(
	        new Movie(1L, "Inception", "English", 250.0),
	        new Movie(2L, "RRR", "Telugu", 200.0),
	        new Movie(3L, "3 Idiots", "Hindi", 180.0),
	        new Movie(4L, "Interstellar", "English", 300.0)
	    ));
	
	public List<Movie> getAllMovies() {
        return movies;
    }

    public Optional<Movie> getMovieById(Long id) {
        return movies.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    }
}
