package com.movie.service.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.service.model.MovieDetails;
import com.movie.service.service.MovieDetailsService;


@RestController
@RequestMapping("/")
public class MovieDetailsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieDetailsController.class);

	@Autowired
	private MovieDetailsService movieDetailsSerice;

	@GetMapping("fetch-all-movies")
	public ResponseEntity<List<MovieDetails>> fetchAllMovie() throws IOException {

		LOGGER.info("entering controller method fetchAllMovie");
		List<MovieDetails> response = movieDetailsSerice.getAllMoviedetails();
		LOGGER.info("exiting controller method fetchAllMovie");
		return ResponseEntity.ok().body(response);

	}

	@GetMapping("fetch-movie-by-id/{id}")
	public ResponseEntity<MovieDetails> fetchMovieById(@PathVariable("id") Long id) throws IOException {

		LOGGER.info("entering controller method fetchMovieById");
		MovieDetails response = movieDetailsSerice.getMovidetailById(id);

		if (response == null) {
			LOGGER.info("No records found for the given id");
			return ResponseEntity.notFound().build();
		}
		LOGGER.info("exiting controller method fetchMovieById");
		return ResponseEntity.ok().body(response);

	}

}
