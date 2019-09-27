package com.springcourse.api.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.api.domain.RequestStage;
import com.springcourse.api.domain.enums.RequestState;
import com.springcourse.api.exception.NotFoundException;
import com.springcourse.api.repository.RequestRepository;
import com.springcourse.api.repository.RequestStageRepository;

@Service
public class RequestStageService {
	@Autowired private RequestStageRepository requestStageRepository;
	@Autowired private RequestRepository requestRepository;
	
	public RequestStage save(RequestStage stage) {
		stage.setRealizationDate(new Date());
		RequestStage createdRequestStage = requestStageRepository.save(stage);
		
		Long requestId = stage.getRequest().getId();
		RequestState state = stage.getState();
		
		requestRepository.updateStatus(requestId, state);
		return createdRequestStage;
	}
	
	public RequestStage getById(Long id) {
		Optional<RequestStage> result = requestStageRepository.findById(id);
		return result.orElseThrow(()-> new NotFoundException("Não há um estagio com o id informado"));
	}
	
	public List<RequestStage> listAll() {
		List<RequestStage> stages = requestStageRepository.findAll();
		return stages;
	}

	public List<RequestStage> listAllByRequestId(Long requestId) {
		List<RequestStage> stages = requestStageRepository.findAllByRequestId(requestId);
		return stages;
	}
	
}
