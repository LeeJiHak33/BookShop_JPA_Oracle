package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.ac.kopo.bookshop.dao.GoodsDao;
import kr.ac.kopo.bookshop.model.Goods;
import kr.ac.kopo.bookshop.pager.Pager;

@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	GoodsDao dao;

	@Override
	public List<Goods> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void add(Goods item) {
		dao.add(item);

	}

	@Override
	public Goods item(int goodsId) {
		return dao.item(goodsId);
	}

	@Override
	public void update(Goods item) {
		dao.update(item);

	}

	@Override
	public void delete(int goodsId) {
		dao.delete(goodsId);
	}

	@Override
	@Transactional
	public void dummy() {
		for(int i=1; i < 100; i++) {
			Goods item = new Goods();
			
			item.setName("상품" + i);
			item.setVendor("제조" + i);
			item.setPrice(i * 1000);
			
			dao.add(item);
		}
		
	}

	@Override
	@Transactional
	public void init() {
		
		List<Goods> list = dao.findAll();
		
		for(Goods item : list)
			dao.delete(item);
		
	}

}
