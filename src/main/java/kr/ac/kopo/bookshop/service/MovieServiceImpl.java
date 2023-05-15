package kr.ac.kopo.bookshop.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.ac.kopo.bookshop.dao.AttachDao;
import kr.ac.kopo.bookshop.dao.MovieDao;
import kr.ac.kopo.bookshop.model.Attach;
import kr.ac.kopo.bookshop.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDao dao;
	
	@Autowired
	AttachDao attachDao;

	@Value("${kopo.upload-path}")
	private String uploadPath;
	
	@Override
	public List<Movie> list() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	@Transactional
	public void add(Movie item) {
		// TODO Auto-generated method stub
		 dao.save(item);
		 for(Attach attach :item.getAttach()) {
			 attach.setMovieId(item.getMovieId());
			 attachDao.save(attach);
		 }
	}

	@Override
	public Movie item(int movieId) {
		// TODO Auto-generated method stub
		return dao.findByMovieId(movieId);
	}

	@Override
	@Transactional
	public void update(Movie item) {
		// TODO Auto-generated method stub
		
		dao.save(item);
		 for(Attach attach :item.getAttach()) {
			 attach.setMovieId(item.getMovieId());
			 attachDao.save(attach);
		 }
	}

	@Override
	@Transactional
	public void delete(int movieId) {
		// TODO Auto-generated method stub
		Movie item=dao.findByMovieId(movieId);
		for(Attach attach :item.getAttach()) {
			String filename=attach.getFilename();
			String uuid=attach.getUuid();
			File file=new File(uploadPath + uuid+"_"+ filename);
			file.delete();
			attachDao.deleteById(attach.getAttachId());
		}
		dao.deleteById(movieId);
	}

	@Override
	public void attachDelete(int attachId) {
		// TODO Auto-generated method stub
		Attach attach=attachDao.findOneByAttachId(attachId);
		
		String filename=attach.getFilename();
		String uuid=attach.getUuid();
		
		File file=new File(uploadPath + uuid+"_"+ filename);
		file.delete();
		attachDao.deleteById(attachId);
			
	
		 
		
	}

}
