package com.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.LoginBean;
import com.project.dao.loginDAO;
import com.project.util.ValidationUtils;

/**
 * Servlet implementation class Validation
 */
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flag=false;
		String username=request.getParameter("unm");
		String password=request.getParameter("pwd");
		
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		
		if(ValidationUtils.isValid(username)){
			
		}else{
			request.setAttribute("err1", "Please Enter Valid Username");
			flag=true;
		}
		if(ValidationUtils.isValid(password)){
			
		}else{
			request.setAttribute("err2", "Please Enter Valid Password");
			flag=true;
		}
		RequestDispatcher rd=null;
		if(flag){
			rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}else{
			LoginBean lb=new LoginBean();
			loginDAO dao=new loginDAO();
			lb.setUserName(username);
			lb.setPassword(password);
			dao.insert(lb);
			HttpSession s=request.getSession();
			s.setAttribute("username",username);
			s.setAttribute("password", password);
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
