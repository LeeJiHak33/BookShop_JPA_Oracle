package kr.ac.kopo.bookshop.dao;

import org.springframework.data.repository.Repository;

import kr.ac.kopo.bookshop.model.Attach;

public interface AttachDao extends Repository<Attach, Integer> {

	void save(Attach attach);

	void deleteById(int attachId);

	Attach findOneByAttachId(int attachId);

}
