package com.movie.service.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.movie.service.model.MovieDetails;
import com.movie.service.repository.MovieDetailsRepo;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MovieDetailsServiceTest {

	@InjectMocks
	MovieDetailsService movieDetailsService;

	@Spy
	MovieDetailsRepo movieDetailsRepo;

	@Test
	@DisplayName("Get all movie details service class test")
	public void getAllMoviedetails() {
		List<MovieDetails> mockResponse = Collections.emptyList();
		when(movieDetailsRepo.findAll()).thenReturn(mockResponse);
		List<MovieDetails> actualResponse = movieDetailsService.getAllMoviedetails();
		assertEquals(mockResponse, actualResponse);
		verify(movieDetailsRepo, times(1)).findAll();

	}

	@Test
	@DisplayName("Get movie details by id service class test")
	public void getMovidetailByIdTest() {
		 when(movieDetailsRepo.findById(anyLong())).thenReturn(getMovieDetails());
		MovieDetails actualResponse = movieDetailsService.getMovidetailById(anyLong());
		assertNotNull(actualResponse);
		verify(movieDetailsRepo, times(1)).findById(anyLong());

	}

	Optional<MovieDetails> getMovieDetails() {
		MovieDetails mockResponse = new MovieDetails();
		return Optional.of(mockResponse);
	}
}
