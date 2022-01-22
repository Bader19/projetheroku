package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Salle;
import service.SalleService;

/**
 * Servlet implementation class SalleController
 */
@WebServlet(name = "SalleController", urlPatterns = { "/SalleController" })
public class SalleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SalleService ms = new SalleService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalleController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("load")) {
				response.setContentType("application/json");
				List<Salle> ls = ms.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(ls));
			} else if (request.getParameter("op").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				ms.delete(ms.findById(id));
				response.setContentType("application/json");
				List<Salle> ls = ms.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(ls));
			} else if (request.getParameter("op").equals("update")) {

				int id = Integer.parseInt(request.getParameter("id"));
				String Code = request.getParameter("Code1");
				int capacite = Integer.parseInt(request.getParameter("Capacite1"));
				String Type = request.getParameter("Type1");
				ms.update(new Salle(id, Code, capacite, Type));
				response.setContentType("application/json");
				List<Salle> ls = ms.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(ls));

			}
		} else {
			String Code = request.getParameter("Code1");
			int capacite = Integer.parseInt(request.getParameter("Capacite1"));
			String Type = request.getParameter("Type1");
			ms.create(new Salle(Code, capacite, Type));
			response.setContentType("application/json");
			List<Salle> ls = ms.findAll();
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(ls));
		}
		// response.sendRedirect("index.jsp");
		// doGet(request, response);
	}

}
