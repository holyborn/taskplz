package com.taskplz.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.taskplz.model.Client;
import com.taskplz.model.ClientVO;
import com.taskplz.model.Tag;
import com.taskplz.model.TagVO;

/*20171006 이찬영 Client Service*/
public interface TagService {
	public boolean createTag(TagVO vo);
	public List<Tag> getSimilarTags(String tag);
}