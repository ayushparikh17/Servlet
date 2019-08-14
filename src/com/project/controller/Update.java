package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.RegistrationBean;
import com.project.dao.regDAO;

/**
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		regDAO dao=new regDAO();
		int id=Integer.parseInt(request.getParameter("id"));
		String fname=request.getParameter("Fname");
		String lname=request.getParameter("Lname");
		String address=request.getParameter("Address");
		String mobileno=request.getParameter("MobileNo");
		String email=request.getParameter("Email");
		
		RegistrationBean rb=new RegistrationBean();
		rb.setId(id);
		rb.setFirstName(fname);
		rb.setLastName(lname);
		rb.setAddress(address);
		rb.setMobileno(mobileno);
		rb.setEmail(email);
		
		dao.Update(rb);
		response.sendRedirect("Search");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
