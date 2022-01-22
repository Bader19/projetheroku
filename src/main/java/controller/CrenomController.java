package controller;

import java.io.IOException;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Crenom;
import beans.Salle;
import service.CrenomService;
 

/**
 * Servlet implementation class CrenomController
 */
@WebServlet(name = "CrenomController", urlPatterns = { "/CrenomController" })
public class CrenomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CrenomService ms= new CrenomService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrenomController() {
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
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
				if (request.getParameter("op") != null) {
					if (request.getParameter("op").equals("load")) {
						response.setContentType("application/json");
						List<Crenom> ls = ms.findAll();
						Gson gson = new Gson();
						response.getWriter().write(gson.toJson(ls));
					} else if (request.getParameter("op").equals("delete")) {
						int id = Integer.parseInt(request.getParameter("id"));
						ms.delete(ms.findById(id));
						response.setContentType("application/json");
						List<Crenom> ls = ms.findAll();
						Gson gson = new Gson();
						response.getWriter().write(gson.toJson(ls));
					} else if (request.getParameter("op").equals("update")) {
						
						
						try {
							int id = Integer.parseInt(request.getParameter("id"));
							  
							 Date HeureDebut =   sdf.parse(request.getParameter("HeureDebut"));
							 Date HeureFin =    sdf.parse(request.getParameter("HeureFin"));
							 
							ms.update(new Crenom(id, HeureDebut, HeureFin));
							response.setContentType("application/json");
							List<Crenom> ls = ms.findAll();
							Gson gson = new Gson();
							response.getWriter().write(gson.toJson(ls));

						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				} else {

					 
					 
					try {
						Date HeureDebut =  sdf.parse(request.getParameter("HeureDebut"));
						Date HeureFin =    sdf.parse(request.getParameter("HeureFin"));
						ms.create(new Crenom( HeureDebut, HeureFin));
						response.setContentType("application/json");
						List<Crenom> ls = ms.findAll();
						Gson gson = new Gson();
						response.getWriter().write(gson.toJson(ls));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
	}

}
