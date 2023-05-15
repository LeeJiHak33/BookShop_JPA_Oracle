package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.BookDao;
import kr.ac.kopo.bookshop.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao dao;
	
	@Override
	public List<Book> list() {
		return dao.findAll();
	}

	@Override
	public void add(Book item) {
		dao.save(item);
	}

	@Override
	public Book item(int bookid) {
		return dao.findOneByBookid(bookid);
	}

	@Override
	public void update(Book item) {
		dao.save(item);
	}

	@Override
	public void delete(int bookid) {
		// TODO Auto-generated method stub
		dao.deleteById(bookid);
	}

}
