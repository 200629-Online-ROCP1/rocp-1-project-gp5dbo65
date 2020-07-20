package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;

public class LoginController {

	private static final LoginService ls = new LoginService();
	private static final ObjectMapper om = new ObjectMapper();

	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		if(req.getMethod().equals("POST")) {
			BufferedReader reader = req.getReader();
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			
			while(line != null) {
				sb.append(line);
				line = reader.readLine();
			} //end while loop
			
			String body = new String(sb);
			LoginDTO l = om.readValue(body, LoginDTO.class);
			
			if(ls.login(l)) {
				HttpSession ses = req.getSession();
				ses.setAttribute("user", l);
				ses.setAttribute("loggedin", true);
				resp.setStatus(200);
				resp.getWriter().println("Login Successful!");
			} //end if block
			else {
				HttpSession ses = req.getSession(false);
				if(ses != null) {
					ses.invalidate();
				} //end if block
				resp.setStatus(401);
				resp.getWriter().println("Login Failed");
			} //end else block
		} //end if block
		else if(req.getMethod().equals("GET")
					&& (req.getParameterMap().containsKey("username")
							&& (req.getParameterMap().containsKey("password")))) {
			LoginDTO l = new LoginDTO();
			l.username = req.getParameter("username");
			l.password = req.getParameter("password");
			
			if(ls.login(l)) {
				HttpSession ses = req.getSession();
				ses.setAttribute("user", l);
				ses.setAttribute("loggedin", true);
				resp.setStatus(200);
				resp.getWriter().println("Login Successful!");
			} //end if block
			else {
				HttpSession ses = req.getSession(false);
				if(ses != null) {
					ses.invalidate();
				} //end if block
				resp.setStatus(401);
				resp.getWriter().println("Login Failed");
			} //end else block
		} //end else if block
		
	} //end login method
	
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession ses = req.getSession(false);
		
		if(ses != null) {
			LoginDTO l = (LoginDTO) ses.getAttribute("user");
			ses.invalidate();
			resp.setStatus(200);
			resp.getWriter().println(l.username + " you are logged out.");			
		} //end if block
		else {
			resp.setStatus(400);
			resp.getWriter().println("You must be logged in to log out.");
		} //end else block
	} //end logout method

} //end LogingController class
