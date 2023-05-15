package kr.ac.kopo.bookshop.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import kr.ac.kopo.bookshop.model.Movie;

public interface MovieDao extends Repository<Movie, Integer> {

	List<Movie> findAll();

	Object save(Movie item);

	Movie findByMovieId(int movieId);

	void deleteById(int movieId);
	
}
