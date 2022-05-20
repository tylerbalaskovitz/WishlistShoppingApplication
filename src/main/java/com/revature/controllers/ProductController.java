package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.models.Wishlist;
import com.revature.services.ProductService;

import io.javalin.http.Handler;

public class ProductController {
	ProductService ps = new ProductService();
	public Handler addProductHandler = (ctx) ->{
		// the body String is created using the Handler's configuration's body
				
		String body = ctx.body();
		Gson gson = new Gson();
		Wishlist newWishlist = gson.fromJson(body, Wishlist.class);
				
		ps.addProductService(newWishlist);
		ctx.status(202);
		
	};
	
}
