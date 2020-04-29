package com.cognizant.moviecruiser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.moviecruiser.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	@Query("SELECT m FROM Movie m WHERE m.active = 'true' and m.dateOfLaunch <= CURDATE()")
	public List<Movie> findAllActiveMovies();
}
