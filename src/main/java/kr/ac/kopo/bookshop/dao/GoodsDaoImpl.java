package kr.ac.kopo.bookshop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import kr.ac.kopo.bookshop.model.Goods;
import kr.ac.kopo.bookshop.pager.Pager;

@Repository
public class GoodsDaoImpl implements GoodsDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public int total(Pager pager) {
		return em.createQuery("SELECT COUNT(*) FROM Goods", Long.class).getSingleResult().intValue();
	}

	@Override
	public List<Goods> list(Pager pager) {
		return em.createQuery("FROM Goods g ORDER BY g.goodsId", Goods.class).setFirstResult(pager.getOffset())
				.setMaxResults(pager.getPerPage()).getResultList();
	}

	@Override
	@Transactional
	public void add(Goods item) {
		em.persist(item);

	}

	@Override
	public Goods item(int goodsId) {
		return em.find(Goods.class, goodsId);
	}

	@Override
	@Transactional
	public void update(Goods item) {
		em.merge(item);
	}

	@Override
	@Transactional
	public void delete(int goodsId) {
		Goods item = em.find(Goods.class, goodsId);

		em.remove(item);

	}

	@Override
	@Transactional
	public void delete(Goods item) {
		em.remove(item);
	}

	@Override
	public List<Goods> findAll() {
		return em.createQuery("FROM Goods g ORDER BY g.goodsId", Goods.class).getResultList();
	}

}
