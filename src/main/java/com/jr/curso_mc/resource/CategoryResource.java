package com.jr.curso_mc.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String toList() {
		return "Rest is working";
	}
	
}
