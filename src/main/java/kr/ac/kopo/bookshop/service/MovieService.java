package kr.ac.kopo.bookshop.service;

import java.util.List;

import kr.ac.kopo.bookshop.model.Movie;

public interface MovieService {

	List<Movie> list();

	void add(Movie item);

	Movie item(int movieId);

	void update(Movie item);

	void delete(int movieId);

	void attachDelete(int attachId);

}
