package com.revature.daos;

import org.hibernate.Session;

import com.revature.utils.HibernateUtil;

import com.revature.models.User;


public class UserDAO {

	public User getUser(String username) {
		Session ses = HibernateUtil.getSession();
		User user = ses.get(User.class, username);
		HibernateUtil.closeSession();
		return user;
		
	}
	
	public void makeUser(User u) {
		Session ses = HibernateUtil.getSession();
		ses.save(u);
		HibernateUtil.closeSession();
		
	}

	
}
