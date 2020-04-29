package com.cognizant.moviecruiser.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.MovieRepository;

@Service("movieService")
public class MovieService {
	@Autowired
	private MovieDao movieDao;
	
	@Autowired
	private MovieRepository movieRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);
	
	
	public void setMovieDao(MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	
	@Transactional
	public List<Movie> getMovieListAdmin(){
		LOGGER.info("Start");
		return movieRepository.findAll();
	}
	
	@Transactional
	public List<Movie> getMovieListCustomer(){
		LOGGER.info("Start");
		return movieRepository.findAllActiveMovies();
	}

	@Transactional
	public void modifyMovie(Movie movie) {
		LOGGER.info("Start");
		movieRepository.save(movie);
		LOGGER.info("End");
	}

	@Transactional
	public Movie getMovie(long movieId) {
		LOGGER.info("Start");
		return movieRepository.getOne(movieId);
	}
}
