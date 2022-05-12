package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.UserController;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		UserController uc = new UserController();
		Javalin app = Javalin.create(
				config ->{
					config.enableCorsForAllOrigins();
				}
			).start(5000);
		
		
		app.post("/login", uc.loginHandler);
		
		
	}
	
}
