package com.taskplz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taskplz.model.Tag;
import com.taskplz.model.TagVO;
import com.taskplz.service.TagService;

@RestController
@RequestMapping(value="/r/tag")
public class TagRController {
	@Autowired
	private TagService service;

	//Set
	@RequestMapping(value="", method = RequestMethod.POST)
	public ResponseEntity<Boolean> setTag(@RequestBody TagVO vo){
		ResponseEntity<Boolean> entity = null; 
		try{
			entity = new ResponseEntity<Boolean>(service.createTag(vo),HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	//GET
	@RequestMapping(value="/{tag}", method = RequestMethod.GET)
	public ResponseEntity<List<Tag>> tagAutocomplete(@PathVariable String tag){
		ResponseEntity<List<Tag>> entity = null;
		
		try {
			entity = new ResponseEntity<List<Tag>>(service.getSimilarTags(tag),HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<List<Tag>>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return entity;
	}
	
}
