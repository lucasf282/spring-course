package com.springcourse.api.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.springcourse.api.domain.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class RequestStage {
	private Long id;
	private String descripition;
	private Date realizationDate;
	private RequestState state;
	private Request request;
	private User user;
}
