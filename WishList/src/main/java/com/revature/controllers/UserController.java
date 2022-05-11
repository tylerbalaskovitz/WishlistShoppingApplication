package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;

import io.javalin.http.Handler;

public class UserController {

	public Handler loginHandler = (ctx) -> {
		
		String loginCreds = ctx.body();
		Gson gson = new Gson();
		LoginDTO lDTO = gson.fromJson(loginCreds, LoginDTO.class);
		
		if(lDTO.username.equals("trainer") && lDTO.password.equals("password")) {
		
		lDTO.id = 1;
		String loginJSON = gson.toJson(lDTO);
		ctx.result(loginJSON);
		ctx.status(202);
		}else {
			ctx.status(401);
		}
	};
}
