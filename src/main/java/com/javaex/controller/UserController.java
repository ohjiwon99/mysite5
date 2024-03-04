package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	//필드
	@Autowired
	private UserService userService;

	
	// 로그인 폼
	@RequestMapping(value="/user/loginform" , method={RequestMethod.GET, RequestMethod.POST})
	public String loginform() {
		System.out.println("UserController.loginform()");
		
		return "/user/loginForm";
	}
	
	
	
	// 로그인
	@RequestMapping(value="/user/login" , method={RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {//UserVo에서 setId,setPasswordf로 넣어줌.-> jsp에서 name값이 pw로 쓰면 setPw()로 되어서 값이 안나올 수 있음.
		System.out.println("UserController.login()");
		
		//(id pw)vo->vo는 계속 쓰일거같으니 map보다 vo로 묶는게 나을것!
		//System.out.println(userVo);// 담아지는거 꼭 확인하고 넘어가기
		
		//service에게 보낸다. -> vo(no name)받는다. -> 세션에 저장한다.
		UserVo authUser = userService.exeLogin(userVo);
	
		
		session.setAttribute("authUser", authUser);
		
		//성공하면 메인으로 리다이렉트
		
		return "redirect:/main";
//		return "/user/loginOk";
	}
	
	// 로그아웃
	@RequestMapping(value="/user/logout" , method={RequestMethod.GET, RequestMethod.POST})
	public String logout(@ModelAttribute UserVo userVo, HttpSession session) {//UserVo에서 setId,setPasswordf로 넣어줌.-> jsp에서 name값이 pw로 쓰면 setPw()로 되어서 값이 안나올 수 있음.
		System.out.println("UserController.logout()");
		
		//(id pw)vo->vo는 계속 쓰일거같으니 map보다 vo로 묶는게 나을것!
		//System.out.println(userVo);// 담아지는거 꼭 확인하고 넘어가기
		
		//service에게 보낸다. -> vo(no name)받는다. -> 세션에 저장한다.
		UserVo authUser = userService.exeLogout(userVo);
	
		
		session.setAttribute("authUser", authUser);
		
		//성공하면 메인으로 리다이렉트
		
		return "redirect:/main";
//		return "/user/loginOk";
	}
	
	
	
	
}
