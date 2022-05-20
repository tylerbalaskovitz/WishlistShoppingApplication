package com.revature.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.models.Wishlist;
import com.revature.utils.HibernateUtil;

public class ProductDAO {
public int id;

	public void addProductToUser(User currentUser, Wishlist w) {
			//we are starting the session via hibernate
			Session ses = HibernateUtil.getSession();
			//we use the session object that has been instantiate with the save method and the object w. 
			Query q = ses.createQuery("Insert into Wishlist w "
					+ "SELECT " + w.getId() + ", " + w.getCategory() + " ," + w.getDescription() + " ," + w.getImage() + " ," + w.getPrice() + " ," + w.getTitle()
					+ " WHERE w.user_fk.id = ?0");
			q.setParameter(0, currentUser.getId());
			//the closeSession method is used with the hibernate utility to close the session. 
			HibernateUtil.closeSession();
		}
		
		
	
		//List is used for getting a Wishlist by the id, so we can have individualized user information. What gets sent as the ID needs to be determined
		//on the front end.
public List<Wishlist> getUserWishList(int user_id){
		
		//open a Session object to connect to the DB
		Session ses = HibernateUtil.getSession();
		//create a query with a parameter that takes in the user's id (given in the method argument)
		//"find every product, p, where the id of it's Director object = ?"
		//"m" is an alias (different name) that we gave to Movie, so help us make a cleaner query
		Query q = ses.createQuery("FROM Wishlist w WHERE w.user_fk.id = ?0");
		//set the ? to the id sent in the method call. This is how we PARAMETERIZE HQL
		q.setParameter(0, user_id);
		//create a List of Movies based on the results of the query
		List<Wishlist> wishlist = q.getResultList();

		//ends the hibernate session
		HibernateUtil.closeSession();
		
		return wishlist;
		
	}


	
	public void deleteItembyUser(Wishlist w, int id) {
		//opening a new hibernate session
		Session ses = HibernateUtil.getSession();
		
		Transaction tran = ses.beginTransaction();
		//this needs to be inside of a transaction that needs to be updated
		
		//SQL statement used to delete an item
		Query q = ses.createQuery("Delete FROM Wishlist w WHERE w.user_fk.user_id = ?0 and where w.id = ?1");
		q.setParameter(0, id);
		//the parameter 0 matches the 0 above in the query statement from above and the user_id int would be the row that it is deleting from 
		q.setParameter(1, w.getId());
		
		//just like JDBC, the execute update needs to occur
		q.executeUpdate();

		//finally a commit must occur when updating and/or deleting data from the databases.
		tran.commit();

		HibernateUtil.closeSession();
		//the hibernate session closes
	}
	
	
	
	
	}


