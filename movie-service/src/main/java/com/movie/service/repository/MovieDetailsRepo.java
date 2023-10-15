package com.movie.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.service.model.MovieDetails;
@Repository
public interface MovieDetailsRepo extends JpaRepository<MovieDetails, Long> {


}
