package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Client;
 
import service.ClientService;

/**
 * Servlet implementation class Clinet
 */
@WebServlet(name = "ClientsController", urlPatterns = { "/ClientsController" })
public class ClientsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientService ms = new ClientService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientsController() {
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
		//doGet(request, response);
		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("load")) {
				response.setContentType("application/json");
				List<Client> ls = ms.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(ls));
			} else if (request.getParameter("op").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				ms.delete(ms.findById(id));
				response.setContentType("application/json");
				List<Client> ls = ms.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(ls));
			} else if (request.getParameter("op").equals("update")) {

				int id = Integer.parseInt(request.getParameter("id"));
				String nom = request.getParameter("Nom");
				String prenom =  request.getParameter("Prenom");
				 
				ms.update(new Client(id, nom, prenom));
				response.setContentType("application/json");
				List<Client> ls = ms.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(ls));

			}
		} else {

			 
			String nom = request.getParameter("Nom");
			String prenom =  request.getParameter("Prenom");
			ms.create(new Client( nom, prenom));
			response.setContentType("application/json");
			List<Client> ls = ms.findAll();
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(ls));
		}
	}

}
