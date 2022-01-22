package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Crenom;
import beans.Occupation;
import beans.Salle;
import service.ClientService;
import service.CrenomService;
import service.OccupationService;
import service.SalleService;

/**
 * Servlet implementation class OccupationController
 */
@WebServlet(name = "OccupationController", urlPatterns = { "/OccupationController" })
public class OccupationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OccupationService ms = new OccupationService();
	SalleService ss = new SalleService();
	ClientService clients = new ClientService();
	CrenomService cs = new CrenomService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OccupationController() {
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
				List<Occupation> ls = ms.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(ls));
			} else if (request.getParameter("op").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				ms.delete(ms.findById(id));
				response.setContentType("application/json");
				List<Occupation> ls = ms.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(ls));
			} else if (request.getParameter("op").equals("update")) {

				try {
					int id = Integer.parseInt(request.getParameter("id"));
					int idsalle = Integer.parseInt(request.getParameter("Idsalle1"));
					int idcrenom = Integer.parseInt(request.getParameter("Idcrenom1"));
					int Idclient1 = Integer.parseInt(request.getParameter("Idclient1"));
					Date date = new Date(request.getParameter("Date1").replace("-", "/"));

					ms.update(new Occupation(id, date, cs.findById(idcrenom), ss.findById(idsalle),
							clients.findById(Idclient1), false));
					response.setContentType("application/json");
					List<Occupation> ls = ms.findAll();
					Gson gson = new Gson();
					response.getWriter().write(gson.toJson(ls));

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (request.getParameter("op").equals("addition")) {

				int idsalle = Integer.parseInt(request.getParameter("Idsalle1"));
				int idcrenom = Integer.parseInt(request.getParameter("Idcrenom1"));
				int Idclient1 = Integer.parseInt(request.getParameter("Idclient1"));
				Date date = new Date(request.getParameter("Date1").replace("-", "/"));

				ms.create(
						new Occupation(date, cs.findById(idcrenom), ss.findById(idsalle), clients.findById(Idclient1)));
				response.setContentType("application/json");
				System.out.println(Idclient1);
				List<Occupation> ls = ms.findAll();
				Gson gson = new Gson();

				response.getWriter().write(gson.toJson(ls));
			}  else if (request.getParameter("op").equals("disponibilite")) {
				 
				int salle = Integer.parseInt(request.getParameter("Idsalle1"));

				List<Crenom> creneaux = null;

				try {
					creneaux = cs.findDispo(salle, new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Date1")));
					Gson json = new Gson();
					response.setContentType("application/json");
					response.getWriter().write(json.toJson(creneaux));
				} catch ( Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}else if (request.getParameter("op").equals("chart")) {
				 
				int salle = Integer.parseInt( request.getParameter("idsalle1")) ;

				Map<Integer,Integer> chart = null;

				try {
					chart = 	ms.chart(salle);
					Gson json = new Gson();
					response.setContentType("application/json");
					response.getWriter().write(json.toJson(chart));
				} catch ( Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
		}
	}

}
