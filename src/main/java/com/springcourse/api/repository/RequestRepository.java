package com.springcourse.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springcourse.api.domain.Request;
import com.springcourse.api.domain.enums.RequestState;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
	
	public List<Request> findAllByOwnerId(Long id);

	@Transactional(readOnly = false)
	@Modifying
	@Query("UPDATE request SET state = ?2 WHERE id = ?1")
	public int updateStatus(Long id, RequestState state);
	
}
