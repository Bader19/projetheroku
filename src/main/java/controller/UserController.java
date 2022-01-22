package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import beans.Client;
import beans.Occupation;
import beans.Users;
import service.OccupationService;
import service.UsersService;

/**
 * Servlet implementation class UserController
 */
@WebServlet(name = "UserController", urlPatterns = { "/UserController" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	UsersService ms = new UsersService();
	OccupationService sc = new OccupationService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("load")) {
						response.setContentType("application/json");
						List<Occupation> ls = sc.validation();
						Gson gson = new Gson();
						response.getWriter().write(gson.toJson(ls));

					 
   

			 
			} else if (request.getParameter("op").equals("update")) {

				int id = Integer.parseInt(request.getParameter("id"));
				String username = request.getParameter("Username1");
				String pwd =  request.getParameter("Password1"); 
				String email1 =  request.getParameter("email1"); 
				String phoneNumber1 =  request.getParameter("phoneNumber1"); 
				boolean role1 = Boolean.parseBoolean(  request.getParameter("role1")); 
			 
				ms.update(new Users(id, username, pwd,email1,phoneNumber1,role1));
				response.setContentType("application/json");
				List<Users> ls = ms.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(ls));

			}else if (request.getParameter("op").equals("log")) {
				String msg;
				JsonObject obj = new JsonObject();
				String username = request.getParameter("nom1");
				String admin;
				String pwd =  request.getParameter("pass1"); 
				response.setContentType("application/json");
				Users us= ms.findrole(username, pwd);
				List<Users> ls = ms.currentuser(username,pwd);
				if(us.isRole()==true) {
					admin="Admin";
				}else {
					admin="user";
				}
				HttpSession session = request.getSession();
				Gson gson = new Gson();
				if(ls.isEmpty()==false) {
					session.setAttribute("username", username);
					session.setAttribute("role", admin);
					out.println(gson.toJson(ls));
				 
				}
			
				
		 
			 
					
				 
				

			}else if (request.getParameter("op").equals("AdminValid")) {
				OccupationService cs= new OccupationService();
				int id = Integer.parseInt(request.getParameter("id"));
			 
				cs.updateV(id);
				response.setContentType("application/json");
				List<Users> ls = ms.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(ls));
		}} else {

			 
			
			String username = request.getParameter("Username1");
			String pwd =  request.getParameter("Password1"); 
			String email1 =  request.getParameter("email1"); 
			String phoneNumber1 =  request.getParameter("phoneNumber1"); 
			boolean role1 = Boolean.parseBoolean(  request.getParameter("role1")); 
			ms.create(new Users( username, pwd,email1,phoneNumber1,role1));
			response.setContentType("application/json");
			List<Users> ls = ms.findAll();
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(ls));
		}
	}
}
 
