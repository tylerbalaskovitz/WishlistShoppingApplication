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
	
	public boolean newUserService(User u) {
		if(uDAO.getUser(u.getUsername()) != null) {
			uDAO.makeUser(u);
			return true;
		}else {
			return false;
		}
	}
}