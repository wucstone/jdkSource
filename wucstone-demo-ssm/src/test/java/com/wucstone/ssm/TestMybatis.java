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
<<<<<<< HEAD
<<<<<<< HEAD:wucstone-demo-ssm/src/test/java/com/wucstone/ssm/TestMybatis.java
=======
=======
<<<<<<< HEAD:wucstone-ssm-demo/src/test/java/com/wucstone/ssm/TestMybatis.java
>>>>>>> b04cff4b293bca8f64f601a86902dd85ee2b5a6c
		/** 使用会话工厂操作数据库 */
		Map param=new HashMap();
		param.put("userName","wucstone");
		param.put("userAge",26);
		param.put("userAddr","北京昌平天通苑");
		sqlSession.insert("com.wucstone.ssm.dao.UserMapper.insertUserInfo", param);
//		sqlSession.commit();
		sqlSession.rollback();
<<<<<<< HEAD
>>>>>>> mybatis demo 实例:wucstone-ssm-demo/src/test/java/com/wucstone/ssm/TestMybatis.java
=======
=======
>>>>>>> 95bf2d1f72c1903781cbb992b8355835bab58a69:wucstone-demo-ssm/src/test/java/com/wucstone/ssm/TestMybatis.java
>>>>>>> b04cff4b293bca8f64f601a86902dd85ee2b5a6c
	}

}
