package com.wucstone.ssm;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestMybatis {
	
	
	@Test
	public void MybatisTest(){
		/** 先获得SqlSessionFactory 会话工厂对象 */
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml"));
		/** 获得SqlSession 会话对象 */
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		/** 使用会话工厂操作数据库 */
		Map param=new HashMap();
		param.put("userName","wucstone");
		param.put("userAge",26);
		param.put("userAddr","北京昌平天通苑");
		sqlSession.insert("com.wucstone.ssm.dao.UserMapper.insertUserInfo", param);
//		sqlSession.commit();
		sqlSession.rollback();
	}

}
