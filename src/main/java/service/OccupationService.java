package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beans.Occupation;

import connexion.Connexion;
import doa.IDao;

public class OccupationService {
	public boolean create(Occupation p) {

		String req = "insert into occupation  values(null,?,?,?,?,false)";
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setDate(1, new java.sql.Date(p.getDate().getTime()));
			ps.setInt(2, p.getCrenom().getId());
			ps.setInt(3, p.getSalle().getId());
			ps.setInt(4, p.getClientid().getId());

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("create service" + e.getMessage());

		}

		return false;
	}

	public boolean update(Occupation o) {
		String req = "update occupation set Date=?, IDCrenom=?,IDSalle=?,Idclient=? where ID=?";
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setDate(1, new java.sql.Date(o.getDate().getTime()));
			ps.setInt(2, o.getCrenom().getId());
			ps.setInt(3, o.getSalle().getId());
			ps.setInt(4, o.getClientid().getId());
			ps.setInt(5, o.getId());
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Update" + e.getMessage());
		}
		return false;
	}

	public boolean delete(Occupation o) {
		String req = "delete from occupation  where ID=?";
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setInt(1, o.getId());
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("delete" + e.getMessage());
		}
		return false;
	}

	public Occupation findById(int id) {
		String req = "select *  from occupation  where ID=?";
		Occupation ls = null;
		CrenomService service = new CrenomService();
		SalleService service2 = new SalleService();
		ClientService client = new ClientService();
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Occupation(rs.getInt("ID"), rs.getDate("Date"), service.findById(rs.getInt("IDCrenom")),
						service2.findById(rs.getInt("IDSalle")), client.findById(rs.getInt("Idclient")),
						rs.getBoolean("Validation"));
			}

		} catch (Exception e) {
			System.out.println("findById " + e.getMessage());
		}
		return null;
	}

	public List<Occupation> findAll() {
		List<Occupation> ls = new ArrayList<Occupation>();
		String req = "select * from occupation where Validation=" + false + "";
		CrenomService service = new CrenomService();
		SalleService service2 = new SalleService();
		ClientService client = new ClientService();
		;
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(new Occupation(rs.getInt("ID"), rs.getDate("Date"), service.findById(rs.getInt("IDCrenom")),
						service2.findById(rs.getInt("IDSalle")), client.findById(rs.getInt("Idclient")),
						rs.getBoolean("Validation")));
			}
		} catch (SQLException e) {
			System.out.println("findAll " + e.getMessage());
		}
		return ls;
	}

	public List<Occupation> findBySalleDate(int salle, java.util.Date date) {
		List<Occupation> occupations = new ArrayList<Occupation>();

		String sql = "select * from occupation where IDSalle=? and Date=?  ";
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ps.setInt(1, salle);
			ps.setDate(2, new Date(date.getTime()));
			ResultSet rs = ps.executeQuery();
			CrenomService service = new CrenomService();
			SalleService service2 = new SalleService();
			ClientService client = new ClientService();
			while (rs.next()) {
				occupations.add(
						new Occupation(rs.getInt("ID"), rs.getDate("Date"), service.findById(rs.getInt("IDCrenom")),
								service2.findById(rs.getInt("IDSalle")), client.findById(rs.getInt("Idclient"))));
			}

		} catch (SQLException e) {
			System.out.println("findAll " + e.getMessage());
		}
		return occupations;
	}

	public List<Occupation> validation() {
		List<Occupation> ls = new ArrayList<Occupation>();
		String req = "select * from occupation where Validation= false";
		CrenomService service = new CrenomService();
		SalleService service2 = new SalleService();
		ClientService client = new ClientService();
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ls.add(new Occupation(rs.getInt("ID"), rs.getDate("Date"), service.findById(rs.getInt("IDCrenom")),
						service2.findById(rs.getInt("IDSalle")), client.findById(rs.getInt("Idclient"))));
			}
		} catch (SQLException e) {
			System.out.println("validation " + e.getMessage());
		}
		return ls;
	}

	public Map<Integer,Integer> chart(int param) {

		String req = "select ID, count(*) as total,month(Date)as mois from occupation where IDSalle = ? "
				+ "and Validation=true GROUP BY month(Date)";

		 Map<Integer,Integer>  countrow = new  HashMap<Integer,Integer> ();

		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setInt(1, param);
			ResultSet rs = ps.executeQuery();
	
			while (rs.next()) {
				countrow.put(rs.getInt("mois"), rs.getInt("total"));
			}
		} catch (SQLException e) {
			System.out.println("chart " + e.getMessage());
		}
		return countrow;

	}

	public boolean updateV(int id) {
		String req = "update occupation set Validation =" + true + " where ID=?";
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setInt(1, id);
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Admin Valid" + e.getMessage());
		}
		return false;
	}

}
