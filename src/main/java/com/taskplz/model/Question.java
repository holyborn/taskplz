package com.taskplz.model;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

public class Question extends QuestionVO implements IModelCRUD {

	private SqlSession sqlSession;

	protected static final String mapperNS = "com.taskplz.mapper.Question.";

	@SuppressWarnings("unused")
	private Question() {
	};

	protected Question(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	};

	protected Question(SqlSession sqlSession, QuestionVO vo) {
		this.sqlSession = sqlSession;
		this.copy(vo);
	};

	protected String getUUID() {
		return this.getQuestionID();
	}

	protected void setUUID(String uuid) {
		this.setQuestionID(uuid);
	}

	public void load(String QuestionID) throws ModelException {
		try {
			QuestionVO vo = sqlSession.selectOne(mapperNS + "select", QuestionID);
			if (vo == null)
				throw new ModelException(null, "310000", "UUID로 해당 Model을 읽어드릴 수 없습니다");
			this.copy(vo);
		} catch (Throwable e) {
			throw new ModelException(e, "300000", "모르겠습니다.");
		}
	}

	public void save() throws ModelException {
		// ClientID의 Null유무로 신규 생성 여부 결정
		if (this.getQuestionID() == null) {
			// Insert
			try {
				this.setQuestionID(UUID.randomUUID().toString());
				sqlSession.insert(mapperNS + "insert", this);
			} catch (Throwable e) {
				this.setQuestionID(null);
				throw new ModelException(e, "300000", "모르겠습니다.");
			}
		} else {
			// Update
			try {
				sqlSession.update(mapperNS + "update", this);
			} catch (Throwable e) {
				throw new ModelException(e, "300000", "모르겠습니다.");
			}
		}
	}

	public void delete() throws ModelException {
		try {
			sqlSession.delete(mapperNS + "delete", this.getQuestionID());
		} catch (Throwable e) {
			throw new ModelException(e, "300000", "모르겠습니다.");
		}
	}
	
	public boolean didILiked(String clientID){
		PagingParameters param = new PagingParameters();
		LikeVO vo = null;
		param.put("clientID", clientID);
		param.put("questionID", this.getQuestionID());
		try {
			vo = sqlSession.selectOne(mapperNS + "selectByClientIDNQuestionID", param);
			if(vo != null) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public QuestionLike bringLike(String clientID){
		PagingParameters param = new PagingParameters();
		param.put("clientID", clientID);
		param.put("questionID", this.getQuestionID());
		return sqlSession.selectOne(mapperNS + "selectByClientIDNQuestionID", param); 
	}
	
	public QuestionLike appendLike(){
		QuestionLike like = new QuestionLike(sqlSession);
		like.setTargetID(this.getQuestionID());
		return like;
	}
	
	public List<LikeVO> getLike(){
		return sqlSession.selectList(mapperNS, this.getQuestionID());
	}
}
