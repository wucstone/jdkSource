package com.wucstone.ssm;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestMybatis {
	
	
	@Test
	public void testMybatis(){
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml"));
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Map params=new HashMap();
		params.put("userName", "wucstone");
		params.put("userAge", 27);
		params.put("userAddr", "亚信大厦");
		sqlSession.insert("com.wucstone.ssm.mapper.UserMapper.insertUserInfo",params);
	}

}
