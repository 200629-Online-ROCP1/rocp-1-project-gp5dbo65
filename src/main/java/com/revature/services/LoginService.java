/* LoginService.java */

package com.revature.services;

import com.revature.models.LoginDTO;

public class LoginService {
	
	public boolean login(LoginDTO l) {
		//TDDO add logic to read user database
		
		
		if(l.username.equals("agent") && l.password.equals("0112358")) {
			return true;
		} //end if block
		return false;
	} //end login method

} //end LoginService() class
