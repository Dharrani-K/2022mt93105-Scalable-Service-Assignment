package com.movie.service.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.movie.service.model.MovieDetails;
import com.movie.service.service.MovieDetailsService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MovieDetailsController.class)
@DisplayName("Movie Detail Controller Test")
public class MovieDetailControllerTest {

	@MockBean
	MovieDetailsService movieDetailsSerice;

	@Autowired
	MockMvc mockMvc;

	@Test
	@DisplayName("Fetch all movie junit test")
	public void fetchAllMovie() throws Exception {
		List<MovieDetails> response = Collections.emptyList();
		when(movieDetailsSerice.getAllMoviedetails()).thenReturn(response);
		mockMvc.perform(MockMvcRequestBuilders.get("/fetch-all-movies")).andExpect(status().isOk());
		verify(movieDetailsSerice).getAllMoviedetails();
	}

}
