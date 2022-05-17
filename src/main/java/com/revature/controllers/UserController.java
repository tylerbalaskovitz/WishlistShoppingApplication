package com.revature.controllers;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class UserController {
	UserService us = new UserService();
	public Handler loginHandler = (ctx) -> {
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);
		
		if(us.login(LDTO.getUsername(), LDTO.getPassword()) != null) {
			ctx.req.getSession();
			
			ctx.status(202);
			
			String userJSON = gson.toJson(us.login(LDTO.getUsername(), LDTO.getPassword()));

			ctx.result(userJSON);
		}else {
			ctx.status(401);
			System.out.println("Login Failed");
		}
	};
	
	//This makes a new user
	public Handler newUserHandler = (ctx) ->{
		
		// the body String is created using the Handler's configuration's body
		String body = ctx.body();
		
		
		//We are instantiating a new GSON objecject
		Gson gson = new Gson();
		
		//a new user object is created and taking the body from JSON into GSON using the variables inside of the user class
		User newUser = gson.fromJson(body, User.class);
		
		//if the us(userService) new userUserService is true for a new user then we get a 202 messaging saying that it was a success being sent to the server
		//in the configuration file of the handler. If not a 401 is sent to the configuration file of the handler
		// if the new user is true then the values from the services is being passed up.
		if(us.newUserService(newUser) != null) {
			ctx.status(202);
		}else {
			ctx.status(401);
		}
		
	};
}
