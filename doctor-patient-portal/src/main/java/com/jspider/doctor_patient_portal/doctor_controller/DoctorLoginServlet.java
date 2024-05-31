package com.jspider.doctor_patient_portal.doctor_controller;

import java.io.IOException;

import com.jspider.doctor_patient_portal.connection.DBConnection;
import com.jspider.doctor_patient_portal.dao.DoctorDAO;
import com.jspider.doctor_patient_portal.dto.Doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoctorLoginServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//get email and password which is coming from doctor_login.jsp page
				String email = req.getParameter("email");
				String password = req.getParameter("password");

				//create session
				HttpSession session = req.getSession();

				//create DB connection
				DoctorDAO docDAO = new DoctorDAO(DBConnection.getConn());
				
				//call loginDoctor() method for doctor login which method declared in DoctorDAO 
				Doctor doctor = docDAO.loginDoctor(email, password);

				if (doctor != null) {
					//means doctor is valid or exist
					//then store particular logged in doctor object in session
					session.setAttribute("doctorObj", doctor);
					//and redirect the particular doctor index page which is reside doctor folder
					resp.sendRedirect("doctor/index.jsp");//doctor index means dashboard of doctors
				} else {
					session.setAttribute("errorMsg", "Invalid email or password");
					resp.sendRedirect("doctor_login.jsp");
				}
	}

}
