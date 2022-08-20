package com.viz.udemy.brewery201.brewery.web.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;

public class BeerPagedList  extends PageImpl{

	public BeerPagedList(List content) {
		super(content);
		// TODO Auto-generated constructor stub
	}

}
