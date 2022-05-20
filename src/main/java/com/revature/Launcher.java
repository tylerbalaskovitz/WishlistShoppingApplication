package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.ProductController;
import com.revature.controllers.UserController;
import com.revature.daos.UserDAO;
import com.revature.models.User;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		UserController uc = new UserController();
		ProductController pc = new ProductController();
		Javalin app = Javalin.create(
				config ->{
					config.enableCorsForAllOrigins();
				}
				
			).start(5000);
		System.out.print("Got here");
		
		//This HTTP request is used to login using the User Controller's login handler
		app.post("/login", uc.loginHandler);
		
		//handler for getting a specific user's wishlist based on their id
		app.get("/userwishlist/{id}", pc.getUserWishlist);
		
		app.post("/addnewitem", pc.addProductHandler);
		//This HTTP request is used to create a new user using the newUserHandler in the User Controller 
		app.post("/createuser", uc.newUserHandler);
		
		app.delete("/deleteitem/{id}", pc.deleteProductHandler);
		
		System.out.println("Hello, test for the GIT Pull and Pushes inconsistencies");
		
//		UserDAO uDAO = new UserDAO();
//		User u1 = new User("username", "password", "BoB", "Anderson", "BoB@bob.com");
//		User u2 = new User("username2", "password2", "Bill", "Steve", "steve@steve");
//		uDAO.makeUser(u1);
//		uDAO.makeUser(u2);
	}
}
