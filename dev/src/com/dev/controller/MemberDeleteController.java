package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.MemberService;

public class MemberDeleteController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Parameter 추출
		String id = request.getParameter("id");

		// Service 객체의 메서드 호출
		MemberService service = MemberService.getInstance();
		service.memberDelete(id);

		// Output View 페이지로 이동
		HttpUtil.forward(request, response, "/result/memberDeleteOutput.jsp");

	}
}
