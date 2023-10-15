package com.movie.service.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.service.model.MovieDetails;
import com.movie.service.repository.MovieDetailsRepo;

@Service
public class MovieDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieDetailsService.class);

	@Autowired
	private MovieDetailsRepo movieDetailsRepo;


	public List<MovieDetails> getAllMoviedetails() {
		LOGGER.info("entering service method getAllMoviedetails");
		return movieDetailsRepo.findAll();
	}

	
	public MovieDetails getMovidetailById(Long id) {
		LOGGER.info("entering service method getMovidetailById");
		return movieDetailsRepo.findById(id).orElse(null);
	}
	
}
