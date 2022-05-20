package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.User;
import com.revature.models.Wishlist;
import com.revature.utils.HibernateUtil;

public class ProductDAO {

	public void addProductToUser(Wishlist w) {
		
			//we are starting the session via hibernate
			Session ses = HibernateUtil.getSession();
			
			//we use the session object that has been instantiate with the save method and the object w. 
			ses.save(w);
			
			//the closeSession method is used with the hibernate utility to close the session. 
			HibernateUtil.closeSession();
			
		}
		
		
	}


