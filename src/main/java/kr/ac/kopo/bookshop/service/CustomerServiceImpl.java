package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.CustomerDao;
import kr.ac.kopo.bookshop.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDao dao;
	
	
	@Override
	public List<Customer> list() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void add(Customer item) {
		// TODO Auto-generated method stub
		dao.save(item);
	}

	@Override
	public Customer item(int custid) {
		// TODO Auto-generated method stub
		return dao.findByCustid(custid);
	}

	@Override
	public void update(Customer item) {
		// TODO Auto-generated method stub
		dao.save(item);
	}

	@Override
	public void delete(int custid) {
		// TODO Auto-generated method stub
		dao.deleteById(custid);
	}

}
