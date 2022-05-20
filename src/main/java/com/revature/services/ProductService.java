package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.daos.ProductDAO;
import com.revature.models.Wishlist;

public class ProductService {
	//the product down
	ProductDAO pDAO = new ProductDAO();
	
	
	public void addProductService(Wishlist w) {
		pDAO.addProductToUser(w);
		
	}
	
	public List<Wishlist> getUserWishList(int user_id){
	//get the list of wishlist from the DAO
	List<Wishlist> userWishlist = pDAO.getUserWishList(user_id);
	//return that List of wishlist.
	return userWishlist;
		
	}
	
	public void deleteUserItem(Wishlist w, int user_id) {
		pDAO.deleteItembyUser( w, user_id);
	}
}
