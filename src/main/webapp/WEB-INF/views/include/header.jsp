<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.javaex.vo.UserVo" %>

<%
	UserVo authUser = (UserVo)session.getAttribute("authUser");
%>



		<div id="header" class="clearfix">
			<h1>
				<a href="${pageContext.request.contextPath}/main">MySite-${pageContext.request.contextPath}</a>
			</h1>
			
			<c:if test="${!(empty sessionScope.authUser)}"> 
			<ul> <!-- 로그인 했을때 -->
				<li>${sessionScope.authUser.name}님 안녕하세요^^</li>
				<li><a href="" class="btn_s">로그아웃</a></li>
				<li><a href="" class="btn_s">회원정보수정</a></li>
			</ul>
			</c:if>
			
			
			<c:if test="${empty sessionScope.authUser}"> 
			<ul> <!-- 로그인 안했을때 -->
				<li><a href="" class="btn_s">로그인</a></li>
				<li><a href="" class="btn_s">회원가입</a></li>
			</ul>
			</c:if>
		</div>
		<!-- //header -->




		<div id="nav">
			<ul class="clearfix">
				<li><a href="">입사지원서</a></li>
				<li><a href="">게시판</a></li>
				<li><a href="">갤러리</a></li>
				<li><a href="">방명록</a></li>
			</ul>
		</div>
		<!-- //nav -->