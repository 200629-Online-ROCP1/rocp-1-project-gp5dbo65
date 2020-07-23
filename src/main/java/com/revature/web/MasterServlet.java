/* MasterServlet.java */

package com.revature.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.LoginController;
//import com.revature.controllers.UserController;

public class MasterServlet extends HttpServlet {
	
	//private static final ObjectMapper om = new ObjectMapper();
	private static final LoginController lc = new LoginController();
	//private static final UserController uc = new UserController();
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		System.out.println("URI = " + URI + "<<<");
		String[] portions = URI.split("/");
		System.out.println("portions[] has " + portions.length + " entries");
		System.out.println(Arrays.toString(portions));
		
		try {
			switch (portions[0]) {
				case "accounts":
					System.out.println("switch case : accounts");
					break;
					
				case "login" :
					System.out.println("switch case : login");
					lc.login(req, resp);
					break;
					
				case "logout":
					System.out.println("switch case : logout");
					//lc.logout(req, resp);
					break;

				case "passTime":
					System.out.println("switch case : passTime");
					//  ?.?(req, resp);
					break;

				case "register":
					System.out.println("switch case : register");
					break;
					
				case "users":
					System.out.println("switch case : users");
					break;
			} //end switch block
			
		} //end try block
		catch (NumberFormatException e) {
			e.printStackTrace();
			resp.setStatus(400);
			resp.getWriter().println("The id you provided is not an integer");
		} //end catch block
	
	} //end doGet(req, resp) method
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		doGet(req, resp);
	} //end doPost(req, resp) method

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPut(req, resp);
	} //end doPut(req, resp) method
	
} //end of MasterServlet class
