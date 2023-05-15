package kr.ac.kopo.bookshop.dao;

import java.util.List;

import kr.ac.kopo.bookshop.model.Goods;
import kr.ac.kopo.bookshop.pager.Pager;

public interface GoodsDao {

	int total(Pager pager);

	List<Goods> list(Pager pager);

	void add(Goods item);

	Goods item(int goodsId);

	void update(Goods item);

	void delete(int goodsId);

	void delete(Goods item);

	List<Goods> findAll();


}
