package com.farmfinder.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="LoginServlet", urlPatterns="/login")
public class loginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username") ;
		String password = request.getParameter ("password") ;
		try{
			request.login(username,password) ; 
			response.setStatus(200) ;
		}		  
		catch(Exception e){
			e.printStackTrace();
			try {
				response.sendError(500, "Unable to log user in");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
}
