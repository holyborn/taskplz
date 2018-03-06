package com.taskplz.service;

import java.util.List;

import com.taskplz.model.LikeVO;
import com.taskplz.model.Question;
import com.taskplz.model.QuestionVO;

/*20170302 이찬영 Question Service*/
public interface QuestionService {
	//Question CRUD
	public QuestionVO uploadQuestion(QuestionVO vo);
	public Question loadQuestion(String uuid);
	public QuestionVO updateQuestion(QuestionVO vo);
	public boolean deleteQuestion(String uuid);
	
	//SELECT BY Specific keys
	public List<QuestionVO> getQuestions(int amount, int page, String orderby);
	public List<QuestionVO> getQuestionsILike(int amount, int page, String clientID);
	
	// Get All Informations
	public List<Question> getQuestionsWithAllInfo(int amount, int page, String orderby);
	
	//Like
	public boolean likeQuestion(LikeVO vo);
	public boolean unlikeQuestion(LikeVO vo);
}