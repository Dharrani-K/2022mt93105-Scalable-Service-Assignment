package com.movie.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the movie_details database table.
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	public long id;
	public String title;
	public String language;
	public String cast;
	public String releaseDate;

}
