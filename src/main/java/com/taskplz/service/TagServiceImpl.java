package com.taskplz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskplz.model.ModelException;
import com.taskplz.model.ModelManager;
import com.taskplz.model.Tag;
import com.taskplz.model.TagVO;

@Service
public class TagServiceImpl implements TagService {
	
	@Autowired
	private ModelManager modelManager;

	@Override
	public boolean createTag(TagVO vo) {
		
		Tag tag = null;
		
		try {
			tag = modelManager.newTag();
			tag.copy(vo);
			tag.save();
			return true;
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Tag> getSimilarTags(String tag) {
		
		List<Tag> tags = new ArrayList<Tag>();
		tags = modelManager.getSimilarTags(tag);
		
		return tags;
	}
}
