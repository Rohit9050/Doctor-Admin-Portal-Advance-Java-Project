//package com.jspider.doctor_patient_portal.controller;
//
//import java.io.IOException;
//
//
//import com.jspider.doctor_patient_portal.dto.User;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//public class AdminLoginServlet extends HttpServlet{
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	
//try {
//			
//			//create one static Admin for this project
//			String email = req.getParameter("email");
//			String password = req.getParameter("password");
//			
//			HttpSession session = req.getSession();
//			
//			//logic for a static Admin
//			if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
//				
//				//if "adminObj" obj available then give the access of admin page, 
//				//otherwise "adminObj" is not present in obj then others user is login(which is not admin). so dont give him the access of Admin.
//				//the below line specially check the admin is log in or not! "adminObj" object is available that means admin is log in.
//				session.setAttribute("adminObj", new User());
//				resp.sendRedirect("admin/index.jsp");
//			}
//			else {
//				session.setAttribute("errorMsg", "Invalid Username or Password.");
//				resp.sendRedirect("admin_login.jsp");
//			}
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}


//package com.jspider.doctor_patient_portal.controller;
//
//import java.io.IOException;
//
//import com.jspider.doctor_patient_portal.dao.AdminDAO;
////import com.jspider.doctor_patient_portal.dao.AdminDao;
//import com.jspider.doctor_patient_portal.dto.Admin;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//public class AdminLoginServlet extends HttpServlet {
//    private AdminDAO adminDao;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        // Initialize AdminDao instance
//        adminDao = new AdminDAO();
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            String email = req.getParameter("email");
//            String password = req.getParameter("password");
//
//            HttpSession session = req.getSession();
//
//            // Validate admin credentials
//            if (adminDao.isValidAdmin(email, password)) {
//                // Create an Admin object (not really necessary in this case)
//                Admin admin = new Admin();
//                admin.setEmail(email);
//                admin.setPassword(password);
//
//                // Set admin object in session
//                session.setAttribute("adminObj", admin);
//                resp.sendRedirect("admin/index.jsp");
//            } else {
//                session.setAttribute("errorMsg", "Invalid Username or Password.");
//                resp.sendRedirect("admin_login.jsp");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}


//package com.jspider.doctor_patient_portal.controller;
//
//import java.io.IOException;
//
//import com.jspider.doctor_patient_portal.connection.DBConnection;
//import com.jspider.doctor_patient_portal.dao.AdminDao;
//import com.jspider.doctor_patient_portal.dao.UserDAO;
//import com.jspider.doctor_patient_portal.dto.Admin;
//import com.jspider.doctor_patient_portal.dto.User;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//public class AdminLoginServlet extends HttpServlet {
//     
//
////    @Override
////    public void init() throws ServletException {
////        super.init();
////        // Initialize AdminDao instance
////        adminDao = new AdminDao();
////    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            String email = req.getParameter("email");
//            String password = req.getParameter("password");
//
//            HttpSession session = req.getSession();
//            
//
//    		AdminDao userDAO = new AdminDao(DBConnection
//    				.getConn());
//    		User user = adminDao.loginUser(email, password);
//
//            // Validate admin credentials
//            if (adminDao.isValidAdmin(email, password)) {
//                // Create an Admin object (not really necessary in this case)
//                Admin admin = new Admin();
//                admin.setEmail(email);
//                admin.setPassword(password);
//
//                // Set admin object in session
//                session.setAttribute("adminObj", admin);
//                resp.sendRedirect("admin/index.jsp");
//            } else {
//                session.setAttribute("errorMsg", "Invalid Username or Password.");
//                resp.sendRedirect("admin_login.jsp");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}



//package com.jspider.doctor_patient_portal.controller;
//
//import java.io.IOException;
//
//import com.jspider.doctor_patient_portal.dao.AdminDao;
//import com.jspider.doctor_patient_portal.dto.Admin;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//public class AdminLoginServlet extends HttpServlet {
//    
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            // Get email and password parameters from the request
//            String email = req.getParameter("email");
//            String password = req.getParameter("password");
//            
//            // Instantiate AdminDao and check credentials
//            AdminDao adminDao = new AdminDao();
//            Admin admin = adminDao.loginAdmin(email, password);
//            
//            if (admin != null) {
//                // If admin credentials are valid, create session and redirect to admin page
//                HttpSession session = req.getSession();
//                session.setAttribute("adminObj", admin);
//                resp.sendRedirect("admin/index.jsp");
//            } else {
//                // If credentials are invalid, set error message and redirect back to login page
//                HttpSession session = req.getSession();
//                session.setAttribute("errorMsg", "Invalid Username or Password.");
//                resp.sendRedirect("admin_login.jsp");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

package com.jspider.doctor_patient_portal.controller;

import java.io.IOException;
import java.sql.Connection;

import com.jspider.doctor_patient_portal.connection.DBConnection;
import com.jspider.doctor_patient_portal.dao.AdminDao;
import com.jspider.doctor_patient_portal.dto.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminLoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Get email and password parameters from the request
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            
            // Obtain a connection object
            Connection conn = DBConnection.getConn();
            
            // Instantiate AdminDao with the connection object
            AdminDao adminDao = new AdminDao(conn);
            
            // Check admin credentials
            Admin admin = adminDao.loginAdmin(email, password);
            
            if (admin != null) {
                // If admin credentials are valid, create session and redirect to admin page
                HttpSession session = req.getSession();
                session.setAttribute("adminObj", admin);
                resp.sendRedirect("admin/index.jsp");
            } else {
                // If credentials are invalid, set error message and redirect back to login page
                HttpSession session = req.getSession();
                session.setAttribute("errorMsg", "Invalid Username or Password.");
                resp.sendRedirect("admin_login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

