package com.springcourse.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springcourse.api.domain.Request;
import com.springcourse.api.domain.RequestStage;
import com.springcourse.api.domain.enums.RequestState;

@Repository
public interface RequestStageRepository extends JpaRepository<RequestStage, Long>{
	
	public List<RequestStage> findAllByRequestId(Long id);
	
}
