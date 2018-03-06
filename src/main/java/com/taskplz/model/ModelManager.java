package com.taskplz.model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.taskplz.model.Client;
import com.taskplz.model.ModelException;

@Component
public class ModelManager {
	@Inject
	private SqlSession sqlSession;
	
	//Client
	public Client newClient(){
		Client object = new Client(sqlSession);
		return object;
	}
	
	public Client getClient(String uuid) throws ModelException{
		Client object = newClient();
		object.load(uuid);
		return object;
	}

	public Client getClientByEmail(String email) throws ModelException{
		Client object = null;
		try {
			PagingParameters param= new PagingParameters();
			param.put("email", email);
			
			ClientVO vo = sqlSession.selectOne(Client.mapperNS+"selectByEmail", param);
			if(vo==null) return null;
			
			object = new Client(sqlSession, vo);
		}
		catch(Throwable e){
			throw new ModelException(e, "300000", "모르겠습니다.");
		}
		return object;
	}
	public Client getClientByNickname(String nickname) throws ModelException{
		Client object = null;
		try {
			PagingParameters param= new PagingParameters();
			param.put("nickname", nickname);
			
			ClientVO vo = sqlSession.selectOne(Client.mapperNS+"selectByNickname", param);
			if(vo==null) return null;
			
			object = new Client(sqlSession, vo);
		}
		catch(Throwable e){
			throw new ModelException(e, "300000", "모르겠습니다.");
		}
		return object;
	}
	/*20180228 GET Clients by Tag*/
	public List<ClientVO> getClientsByTag(String tag) throws ModelException{
		List<ClientVO> list = new ArrayList<>();

		try {
			PagingParameters param= new PagingParameters();
			param.put("tag", tag);
			
			list = sqlSession.selectList(Client.mapperNS + "selectByTag", param);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	// Tag

	public Tag newTag(){
		Tag object = new Tag(sqlSession);
		return object;
	}
	
	public List<Tag> getSimilarTags(String tag){
		List<Tag> list = null;
		
		try {
			PagingParameters param = new PagingParameters();
			param.put("tag", tag);
			list = sqlSession.selectList(Tag.mapperNS + "selectByTag", param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	// Question
	public Question newQuestion(){
		Question object = new Question(sqlSession);
		return object;
	}
	
	public Question getQuestion(String uuid) throws ModelException{
		Question object = newQuestion();
		object.load(uuid);
		return object;
	}
	
	public List<QuestionVO> getQuestions(int amount, int page, String orderBy){
		List<QuestionVO> list = null;
		String queryName = "selectOrderBy"+orderBy;
		try {
			PagingParameters param = new PagingParameters();
			param.setLimitRowCount(amount);
			param.setLimitOffsetRow((page-1)*amount);
			list = sqlSession.selectList(Question.mapperNS + queryName, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
