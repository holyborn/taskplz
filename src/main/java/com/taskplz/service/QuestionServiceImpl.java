package com.taskplz.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskplz.model.LikeVO;
import com.taskplz.model.ModelException;
import com.taskplz.model.ModelManager;
import com.taskplz.model.Question;
import com.taskplz.model.QuestionLike;
import com.taskplz.model.QuestionVO;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private ModelManager modelManager;

	@Override
	public QuestionVO uploadQuestion(QuestionVO vo) {
		Question question = null;
		
		question = modelManager.newQuestion();
		question.copy(vo);
		try {
			question.save();
		} catch (ModelException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Question loadQuestion(String uuid) {

		Question question = null;
		try {
			question = modelManager.getQuestion(uuid);
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return question;
	}

	@Override
	public QuestionVO updateQuestion(QuestionVO vo) {
		Question question = null;
		
		try {
			question = modelManager.getQuestion(vo.getQuestionID());
			question.copy(vo);
			question.setModifyDate(new java.sql.Timestamp(System.currentTimeMillis()));
			question.save();
			return vo;
		} catch (ModelException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteQuestion(String uuid) {
		Question question = null;
		
		try {
			question = modelManager.getQuestion(uuid);
			question.delete();
			return true;
		} catch (ModelException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<QuestionVO> getQuestions(int amount, int page, String orderby) {

		List<QuestionVO> questions = new ArrayList<QuestionVO>();
		questions = modelManager.getQuestions(amount, page, orderby);
		
		return questions;
	}

	@Override
	public List<QuestionVO> getQuestionsILike(int amount, int page, String clientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getQuestionsWithAllInfo(int amount, int page, String orderby) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean likeQuestion(LikeVO vo) {
		try {
			Question question = modelManager.getQuestion(vo.getTargetID());
			if(!question.didILiked(vo.getClientID())){
				QuestionLike like = question.appendLike();
				like.copy(vo);
				like.save();
			}
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean unlikeQuestion(LikeVO vo) {
		QuestionLike like = null;
		try {
			Question question = modelManager.getQuestion(vo.getTargetID());
			if(question.didILiked(vo.getClientID())){
				like = question.bringLike(vo.getClientID());
				like.copy(vo);
				like.save();
			}
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
}
