package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.Ordersdao;
import kr.ac.kopo.bookshop.model.Orders;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	Ordersdao dao;
	
	@Override
	public List<Orders> list() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void add(Orders item) {
		// TODO Auto-generated method stub
		dao.save(item);
	}

	@Override
	public Orders item(int orderid) {
		// TODO Auto-generated method stub
		return dao.findOneByOrderid(orderid);
	}

	@Override
	public void update(Orders item) {
		// TODO Auto-generated method stub
		dao.save(item);
	}

	@Override
	public void delete(int orderid) {
		// TODO Auto-generated method stub
		dao.deleteById(orderid);
	}

}
