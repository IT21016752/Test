package com.itp.controller;

import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

import com.itp.connection.StaffDBUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StaffRegistration
 */
@WebServlet("/StaffRegistration")
public class StaffRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String Age = request.getParameter("Age");
		String Address = request.getParameter("Address");
		String Email = request.getParameter("Email");
		String AccNo = request.getParameter("AccNo");
		String JoinedYear = request.getParameter("JoinedYear");
		String Password = request.getParameter("Password");
		String StaffType = request.getParameter("StaffType");
		String ContractYears = request.getParameter("ConrtactYears");
		String BasicSalary = request.getParameter("BasicSalary");
		String Ot = request.getParameter("Ot");
		
		boolean isTrue;
		
		isTrue = StaffDBUtil.insertStaff(FirstName, LastName, Age, Address, Email, AccNo, JoinedYear, Password, StaffType, ContractYears, BasicSalary, Ot);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
