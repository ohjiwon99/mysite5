package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	// 필드
	@Autowired
	private UserService userService;

	// 로그인 폼
	@RequestMapping(value = "/user/loginform", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginform() {
		System.out.println("UserController.loginform()");

		return "/user/loginForm";
	}

	// 로그인
	@RequestMapping(value = "/user/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {

		UserVo authUser = userService.exeLogin(userVo);

		session.setAttribute("authUser", authUser);

		// 성공하면 메인으로 리다이렉트
		return "redirect:/main";

	}

	// 로그아웃
	@RequestMapping(value = "/user/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) {
		System.out.println("UserController.logout()");
		// HttpSession session == 주소
		session.invalidate();

		// 성공하면 메인 리다이렉트
		return "redirect:/main";
	}

	// 회원가입폼
	@RequestMapping(value = "/user/joinform", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinform() {
		System.out.println("UserController.joinform");

		return "/user/joinForm";
	}

	// 회원가입
	@RequestMapping(value = "/user/joinok", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinok(@ModelAttribute UserVo userVo) {// UserVo로 묶어서 받기
		System.out.println("UserController.join");

		System.out.println(userVo.toString());

		userService.exeJoin(userVo); //서비스로 userVo
		// 메인페이지로 리다이렉트
		return "redirect:/user/joinok";
	}

	// 회원정보수정폼
	@RequestMapping(value = "/user/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm() {
		System.out.println("UserController.modifyForm");

		return "/user/modifyForm";
	}

	// 회원정보 수정
	@RequestMapping(value = "/user/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.modify");

		// 서비스로 묶은거 넘기기
		userService.exeModify(userVo);

		// 메인화면으로 리다이렉트
		return "redirect:/main";
	}
	
	// 회원정보삭제
		@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
		public String delete(@RequestParam(value = "no") int no) {

			System.out.println("UserController.delete()");

			// System.out.println(personId);

			userService.exeDelete(no);

			// 리스트로 리다이렉트
			return "redirect:/main";

		}

}
