package com.wucstone.ssm;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestMybatis {
	
	
	@Test
	public void MybatisTest(){
		/** 先获得SqlSessionFactory 会话工厂对象 */
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Thread.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));
		/** 获得SqlSession 会话对象 */
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		/** 使用会话工厂操作数据库 */
		Student student = sqlSession.selectOne("com.xuyi.usemybatis.pojo.Student.selectStudentById", 4);
	}

}
