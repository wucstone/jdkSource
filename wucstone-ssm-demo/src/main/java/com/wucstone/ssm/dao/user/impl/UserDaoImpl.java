package com.wucstone.ssm.dao.user.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wucstone.ssm.dao.common.BaseDao;
import com.wucstone.ssm.dao.user.UserDao;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {
	

	

	public void insertUserInfo(Map userInfo) {

	}

	public Map<String, String> getUserInfoByParams(Map<String, String> params) {
		List<Map<String,String>> mapList= sqlSession.selectList("user.getUserInfoByParams", params);
		return mapList.get(0);
	}
	@Override
	public int getUserCountByParams(Map<String, String> params)throws Exception {
		return sqlSession.selectOne("user.getUserCountByParams",params);
	}
	@Override
	public List<Map<String, String>> getUserListByParams(Map<String, String> params) throws Exception {
		return sqlSession.selectList("user.getUserInfoByParams",params);
	}

}
