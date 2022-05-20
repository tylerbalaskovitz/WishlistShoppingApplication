package com.revature.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.revature.models.Movie;
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
		
		
	
		//List is used for getting a Wishlist by the id, so we can have individualized user information. What gets sent as the ID needs to be determined
		//on the front end.
public List<Wishlist> getUserWishList(int id){
		
		
	
		//open a Session object to connect to the DB
		Session ses = HibernateUtil.getSession();
		
		
		//create a query with a parameter that takes in the user's id (given in the method argument)
		//"find every product, p, where the id of it's Director object = ?"
		//"m" is an alias (different name) that we gave to Movie, so help us make a cleaner query
		Query q = ses.createQuery("FROM Wishlist w WHERE w.user_fk.user_id = ?0");
		
		//set the ? to the id sent in the method call. This is how we PARAMETERIZE HQL
		q.setParameter(0, id);
		
		//create a List of Movies based on the results of the query
		List<Wishlist> wishlist = q.getResultList();
		
		HibernateUtil.closeSession();
		
		return wishlist;
		
	}
	
	
	
	
	}


