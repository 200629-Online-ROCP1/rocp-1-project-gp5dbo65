/* MasterServlet.java */

package com.revature.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.LoginController;
import com.revature.controllers.UserController;
import com.revature.models.LoginDTO;
import com.revature.models.User;

public class MasterServlet extends HttpServlet {
	
	private static final ObjectMapper om = new ObjectMapper();
	private static final LoginController lc = new LoginController();
	private static final UserController uc = new UserController();
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doDelete(req, resp);
	} //end doDelete(req, resp) method

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Do I need this????
		//super.doGet(req, resp);
		
		//Set the default response to not found; we will change it later if the request was successful
		resp.setContentType("application/json");
		resp.setStatus(404);
		
		final String URI = req.getRequestURI().replace("/rocp-project/", "");
		String[] portions = URI.split("/");
		
		try {
			switch (portions[0]) {
				case "accounts":
					System.out.println("switch case : accounts");
					break;
					
				case "login" :
					lc.login(req, resp);
					break;
					
				case "logout":
					lc.logout(req, resp);
					break;

				case "passTime":
					System.out.println("switch case : passTime");
					//  ?.?(req, resp);
					break;

				case "register":
					System.out.println("switch case : register");
					break;
					
				case "users":
					//System.out.println("switch case : users");
					HttpSession ses = req.getSession(false); // Initialize session object to null

					if (ses != null && (Boolean) ses.getAttribute("loggedin")) { 
						//System.out.println("Session is logged in, portions length = " + portions.length);
						if (portions.length == 2) {
							int id = Integer.parseInt(portions[1]);
							//System.out.println("portion[1] = " + portions[1].toString());
							User u = uc.findById(id);
							
							if (u != null) {
								//System.out.println("User object returned from UserControl");

								LoginDTO l = (LoginDTO) ses.getAttribute("user");
								/*
								 * System.out.println("LoginDTO username = " + l.username);
								 * System.out.println("LoginDTO password = " + l.password);
								 * System.out.println("LoginDTO role = " + l.role);
								 * System.out.println("User username = " + u.getUsername());
								 */
								if (l.role.equals("Admin") 
										|| l.role.equals("Employee")
											|| l.username.equals(u.getUsername())) {
									resp.setStatus(200);
									String json = om.writeValueAsString(u);
									resp.getWriter().println(json);
								} // end if block

								else {
									resp.setStatus(401);
									resp.getWriter().println("You are not authorized to use this feature");
								} // end else block
							} // end if block

							else {
								//System.out.println("bad id null object assigned");
								resp.setStatus(404);
								resp.getWriter().println(u);
							} // end else block							
								
						} // end if block
						
						else {
							if (req.getMethod().equals("POST")) {
								System.out.println("This is a POST request");
								// TODO register method
							} // end if block

							else {
								LoginDTO l = (LoginDTO) ses.getAttribute("user");
								/*
								System.out.println("LoginDTO username = " + l.username);
								System.out.println("LoginDTO password = " + l.password);
								System.out.println("LoginDTO role = " + l.role);
								*/
								if (l.role.equals("Admin") || l.role.equals("Employee")) {
									//System.out.println("This must be a GET request, list all users logic");
									List<User> all = uc.findAll();
									resp.setStatus(200);
									resp.getWriter().println(om.writeValueAsString(all));
								} // end if block
								else {
									resp.setStatus(401);
									resp.getWriter().println("You are not authorized to use this feature");
								} // end else block

							} // end else block
						} // end else block
					} // end if block
					else {
						resp.setStatus(401);
						resp.getWriter().println("You must be logged in to do that!");
					} // end else block
					break;
				} // end switch block
			
		} //end try block
		catch (NumberFormatException e) {
			e.printStackTrace();
			resp.setStatus(400);
			resp.getWriter().println("The id you provided is not an integer");
		} //end catch block
	
	} //end doGet(req, resp) method
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPost(req, resp);
		doGet(req, resp);
	} //end doPost(req, resp) method

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPut(req, resp);
	} //end doPut(req, resp) method
	
} //end of MasterServlet class
