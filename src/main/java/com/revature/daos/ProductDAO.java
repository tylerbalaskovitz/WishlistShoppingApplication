package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

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
		
		
	
public List<Wishlist> getUserWishList(){
		
		//open a Session object to connect to the DB
		Session ses = HibernateUtil.getSession();
		
		//SELECT ALL movies using HQL instead of sessions methods.
		List<Wishlist> userWishList = ses.createQuery("FROM Wishlist").list();
		//we're selecting ALL records FROM the movies table. Remember, HQL uses Class names, not DB table names
		
		//close the session
		HibernateUtil.closeSession();
		
		//return the List of Movies
		return userWishList;
		
	}
	
	
	
	
	}


