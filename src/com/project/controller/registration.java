package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.RegistrationBean;
import com.project.dao.regDAO;
import com.project.util.ValidationUtils;

/**
 * Servlet implementation class registration
 */
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String flag=request.getParameter("flag");
		regDAO dao=new regDAO();
		HttpSession s=request.getSession();
		
		if(flag.equals("edit")){
			
			int id=Integer.parseInt(request.getParameter("id"));
			RegistrationBean rb=new RegistrationBean();
			rb.setId(id);
			List<RegistrationBean> ls1=dao.edit(rb);
			s.setAttribute("list1", ls1);
			response.sendRedirect("Edit.jsp");
		}
		
		if(flag.equals("delete")){
			RegistrationBean rb=new RegistrationBean();
			int id=Integer.parseInt(request.getParameter("id"));
			rb.setId(id);
			dao.Delete(rb);
			response.sendRedirect("Search");
		}
		
		
		/*String fname=request.getParameter("Fname");
		String lname=request.getParameter("Lname");
		String address=request.getParameter("Address");
		String gender=request.getParameter("Gender");
		int mobileNo=Integer.parseInt(request.getParameter("MobileNo"));
		String email=request.getParameter("Email");
		String hobby[]=request.getParameterValues("hobby");
		String h="";
		if(hobby!=null){
			for(int i=0;i<hobby.length;i++)
			{
				h=h+hobby[i]+",";
			}
		}
		
		RegistrationBean rb=new RegistrationBean();
		rb.setFirstName(fname);
		rb.setLastName(lname);
		rb.setAddress(address);
		rb.setGender(gender);
		rb.setMobileno(mobileNo);
		rb.setEmail(email);
		rb.setHobby(h);
		
		regDAO dao=new regDAO();
		
		dao.insert(rb);
		
		
		response.sendRedirect("Search");*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		regDAO dao=new regDAO();
		
		if(flag.equals("insert")){
			RegistrationBean rb=new RegistrationBean();
			
			boolean flag1=false;
			String fname=request.getParameter("Fname");
			String lname=request.getParameter("Lname");
			String address=request.getParameter("Address");
			String gender=request.getParameter("Gender");
			String no=request.getParameter("MobileNo");
			String email=request.getParameter("Email");
			String hobby[]=request.getParameterValues("hobby");
			String h="";
			if(hobby!=null){
				for(int i=0;i<hobby.length;i++)
				{
					h=h+hobby[i]+",";
				}
			}
			
			
			if(ValidationUtils.isValid(fname)){
				request.setAttribute("fname", fname);
				rb.setFirstName(fname);


			}else{
				request.setAttribute("err1", "Please Enter Valid Firstname");
				flag1=true;
			}
			if(ValidationUtils.isValid(lname)){
				request.setAttribute("lname", lname);
				rb.setLastName(lname);


			}else{
				request.setAttribute("err2", "Please Enter Valid Lastname");
				flag1=true;
			}
			
			if(ValidationUtils.isValid(email)){
				request.setAttribute("email", email);
				
				rb.setEmail(email);




			}else{
				request.setAttribute("err3", "Please Enter Valid Email");
				
				flag1=true;
			}
			if(ValidationUtils.isValid(address)){
				request.setAttribute("address", address);

				rb.setAddress(address);


			}else{
				request.setAttribute("err4", "Please Enter Valid Address");
				flag1=true;
			}
			if(ValidationUtils.isValid(no)){
				

				request.setAttribute("mobileNo", no);
				rb.setMobileno(no);

				

				
			}else{
				request.setAttribute("err5", "Please Enter Valid MobileNO");
				flag1=true;
			}
			
			RequestDispatcher rd=null;
			if (flag1) {
				rd=request.getRequestDispatcher("Registration.jsp");
				rd.forward(request, response);
			} else {
				
		
				rb.setGender(gender);
				rb.setHobby(h);
				
				dao.insert(rb);		
				
			}
			
			response.sendRedirect("Search");

			
		}
		
		if(flag.equals("update")){
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
	}

}
