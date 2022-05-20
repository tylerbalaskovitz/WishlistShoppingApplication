package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.models.User;

public class UserService {
	UserDAO uDAO = new UserDAO();
	
	public User login(String username, String password) {
		// a new user object is instantiating that is equal to the User Dao's username gathered from the getter and setters
		User userAttempt = uDAO.getUser(username);
		
		// if the user attempt is not null initialize the conditional loop
		if (userAttempt != null) {
			
			//if the pass ghat is gathered from the userattempt is equal to the password gather from the uDao get user, the user attempt is success and 
			//userAttempt is returned
			if(userAttempt.getPassword().equals(password)) {
				return userAttempt;
			}else {
				//failed login attempted
				return null;
			}
		}else {
			//invalid user attempt
			return null;
		}
	}
	
	// a boolean is created for a true or false value of user
	public User newUserService(User u) {
		
			//the userDao make user method is used using the model User, value u
			uDAO.makeUser(u);
		
			//the created User value is returned. 
			return u;
		}
	
}