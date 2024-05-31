package com.jspider.doctor_patient_portal.doctor_controller;

import java.io.IOException;

import com.jspider.doctor_patient_portal.connection.DBConnection;
import com.jspider.doctor_patient_portal.dao.AppointmentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UpdateStatus extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			 int 	id = Integer.parseInt(req.getParameter("id"));
			 int 	doctorId = Integer.parseInt(req.getParameter("doctorId"));
			 String comment = req.getParameter("comment");
			 
			 AppointmentDAO appDAO = new AppointmentDAO(DBConnection.getConn());
			 boolean f = appDAO.updateDrAppointmentCommentStatus(id, doctorId, comment);
			 
			 HttpSession session = req.getSession();
			 
			 
			 if(f == true) {
				 session.setAttribute("successMsg", "Comment updated");
				 resp.sendRedirect("doctor/patient.jsp");
				 
			 }else {
				 
				 session.setAttribute("errorMsg", "Something went wrong on server!");
				 resp.sendRedirect("doctor/patient.jsp");
				 
			 }
			 
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
