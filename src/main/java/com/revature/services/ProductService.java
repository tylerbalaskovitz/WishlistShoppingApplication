package com.revature.services;

import com.revature.daos.ProductDAO;
import com.revature.models.Wishlist;

public class ProductService {
	ProductDAO pDAO = new ProductDAO();
	public void addProductService(Wishlist w) {
		pDAO.addProductToUser(w);
		
	}
}
