package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
//servlet ���
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	String charset = null;
	HashMap<String, Controller> list = null;
	//���� ��ü ������ ȣ�� : �ڿ� ����
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
		
	//���� ��ü ������ ȣ�� : �ʱ�ȭ : ���� ��û��
	//��ü ���� ó�� �ѹ��� ����! �� ���� service���� �˾Ƽ� ó���Ѵ�.
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

	//��û�� ���� ������ ����
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding(charset);
		
		//http://70.12.220.93:80/edu/memberInsert.do
		String url = request.getRequestURI();
		//http://70.12.220.93:80/edu/
		String contextPath = request.getContextPath();
		//memberInsert.do ���� ��ŭ �̾Ƽ� url string ����
		String path = url.substring(contextPath.length());

		Controller subController = list.get(path);
		subController.execute(request, response);
	}
}
