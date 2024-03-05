package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	// 필드
	@Autowired
	private UserDao userDao;

	// 생성자
	// 메소드-gs
	// 메소드-일반
	
	//로그인
	public UserVo exeLogin(UserVo userVo) {
		System.out.println("UserService.exeLogin");

		UserVo authUser = userDao.userSelectByIdPw(userVo);
		System.out.println(authUser);
		return authUser;
	}
	// 회원가입
		public int exeJoin(UserVo userVo) {
			System.out.println("UserService.exeJoin()");

			int count = userDao.userInsert(userVo);

			return count;
		}

		// 회원정보수정
		public int exeModify(UserVo userVo) {
			System.out.println("UserService.exeModify()");

			int count = userDao.userModify(userVo);
			return count;
		}

		// 삭제
		public int exeDelete(int no) {
			System.out.println("UserService.exeDelete()");

			int count = userDao.userDelete(no);

			return count;
		}
}
