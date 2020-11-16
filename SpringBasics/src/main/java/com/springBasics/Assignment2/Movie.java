package com.springBasics.Assignment2;

import org.springframework.stereotype.Component;

@Component("movie")
public class Movie {
	
	private String movieId;
	private String movieName;
	private String movieActor;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
		this.movieActor = "Tom";
		this.movieId = "M1001";
		this.movieName = "Film";
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieActor() {
		return movieActor;
	}
	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieActor=" + movieActor + "]";
	}
	
	
}
