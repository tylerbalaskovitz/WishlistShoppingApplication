package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.revature.models.ProductDTO;
import com.revature.models.User;
import com.revature.models.Wishlist;
import com.revature.services.ProductService;

import io.javalin.http.Handler;

public class ProductController {
	//A new ProductService object is instantiated to be used in the controller layer.
	ProductService ps = new ProductService();
	
	public Handler addProductHandler = (ctx) ->{
		// the body String is created using the Handler's configuration's body
				
		ProductDTO pDTO = new ProductDTO();
		String body = ctx.body();
//		ctx.result(ctx.formParam("id")) ;
		Gson gson = new Gson();
		ProductDTO newItem = gson.fromJson(body, ProductDTO.class);
		
		ps.addProductService(newItem);
		ctx.status(202);
		
	};
	
	public Handler getUserWishlist = (ctx) -> {
		
		String body = ctx.body();
		Gson gson = new Gson();
		int user_id = Integer.parseInt(ctx.pathParam("user_id"));
		List<Wishlist> userWishlist = ps.getUserWishList(user_id);
		System.out.print(userWishlist);
		ctx.result(gson.toJson(ps.getUserWishList(user_id)));
		ctx.status(202);
		
	};
	
	public Handler deleteProductHandler = (ctx) -> {
//		String body = ctx.body();
		int user_id = Integer.parseInt(ctx.pathParam("user_id"));
		int product_id = Integer.parseInt(ctx.pathParam("product_id"));
//		Gson gson = new Gson();
	//	Wishlist deleteWishlist = gson.fromJson(body, Wishlist.class);
		ps.deleteUserItem(user_id, product_id);
		ctx.status(202);
	};
}
