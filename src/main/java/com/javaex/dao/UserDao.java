package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	//필드
	//생성자
	//메소드-gs
	//메소드-일반
	
	@Autowired
	private SqlSession sqlSession;
	
	//로그인
	public UserVo userSelectByIdPw(UserVo userVo) {
		System.out.println("UserDao.userSelectByIdPw()");
		
		System.out.println(userVo);//id pw
		UserVo authUser = sqlSession.selectOne("user.SelectByIdPw", userVo);
		System.out.println(authUser); //no name
		//여기서부터 db사용이 되어야하기 때문에 추가셋팅 필요!
		return authUser;
		
	}
	
	
}
