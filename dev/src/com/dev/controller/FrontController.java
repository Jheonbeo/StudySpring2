package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
//servlet 상속
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	String charset = null;
	HashMap<String, Controller> list = null;
	//서블릿 객체 삭제시 호출 : 자원 해제
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
		
	//서블릿 객체 생성시 호출 : 초기화 : 최초 요청시
	//객체 주입 처음 한번만 실행! 그 이후 service에서 알아서 처리한다.
	@Override
	public void init(ServletConfig sc) throws ServletException {

		charset = sc.getInitParameter("charset");
		
		list = new HashMap<String, Controller>();
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberSearch.do", new MemberSearchController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memberList.do", new MemberListController());

	}

	//요청이 들어올 때마다 실행
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding(charset);
		
		//http://70.12.220.93:80/edu/memberInsert.do
		String url = request.getRequestURI();
		//http://70.12.220.93:80/edu/
		String contextPath = request.getContextPath();
		//memberInsert.do 길이 만큼 뽑아서 url string 리턴
		String path = url.substring(contextPath.length());

		Controller subController = list.get(path);
		subController.execute(request, response);
	}
}
