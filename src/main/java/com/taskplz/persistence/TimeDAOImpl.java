package com.taskplz.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class TimeDAOImpl implements TimeDAO {
	@Inject
	SqlSession sqlSession;
	private static final String MAPPERNS = "com.petzword.mapper.ClientMapper.";
	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		System.out.println(sqlSession);
		return sqlSession.selectOne(MAPPERNS + "getTime");
	}

}
