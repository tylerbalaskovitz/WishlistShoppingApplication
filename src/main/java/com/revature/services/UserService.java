package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.models.User;

public class UserService {
	UserDAO uDAO = new UserDAO();
	
	public User login(String username, String password) {
		User userAttempt = uDAO.getUser(username);
		
		if (userAttempt != null) {
			if(userAttempt.getPassword().equals(password)) {
				return userAttempt;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	
	// a boolean is created for a true or false value of user
	public User newUserService(User u) {
		
	
			uDAO.makeUser(u);
		
			return u;
		}
	
}