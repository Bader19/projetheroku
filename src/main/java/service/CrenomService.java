package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Crenom;
import beans.Occupation;
import beans.Salle;
import connexion.Connexion;
import doa.IDao;

public class CrenomService {
	public boolean create(Crenom o) {
		String req = "insert into crenom  values(null,?,?)";
		try {

			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setString(1,  o.getHeureDebut()  );
			ps.setString(2, o.getHeureFin()  );

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("create" + e.getMessage());
		}
		return false;
	}

	public boolean update(Crenom o) {
		String req = "update crenom set HeureDebut=?,HeureFin=? where ID=?";
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setString(1,  o.getHeureDebut() );
			ps.setString(2,  o.getHeureFin()  );

			ps.setInt(3, o.getId());
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Update" + e.getMessage());
		}
		return false;
	}

	public boolean delete(Crenom o) {
		String req = "delete from crenom  where ID=?";
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

	public Crenom findById(int id) {
		String req = "select * from crenom where ID=?";

		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Crenom(rs.getInt("ID"), rs.getTime("HeureDebut"), rs.getTime("HeureFin"));
			}

		} catch (Exception e) {
			System.out.println("findById " + e.getMessage());
		}
		return null;
	}

	public List<Crenom> findAll() {
		List<Crenom> ls = new ArrayList<Crenom>();
		String req = "select * from crenom ";

		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(new Crenom(rs.getInt("id"), rs.getTime("HeureDebut"), rs.getTime("HeureFin")));
			}
		} catch (SQLException e) {
			System.out.println("findAll " + e.getMessage());
		}
		return ls;
	}

	public List<Crenom> findDispo(int salle, java.util.Date d) {
		OccupationService os = new OccupationService();
		List<Crenom> valable = new ArrayList<Crenom>();

		for (Crenom c : findAll()) {
			int check = 0;
			// System.out.println(c);
			for (Occupation o : os.findBySalleDate(salle, d)) {
				check = 0;
				// System.out.println(o);
				if ( (c.getHeureDebut().compareTo(o.getCrenom().getHeureDebut()) < 0
								&& c.getHeureFin().compareTo(o.getCrenom().getHeureFin()) > 0)
						|| (c.getHeureDebut().compareTo(o.getCrenom().getHeureFin()) <0
								&& c.getHeureFin().compareTo(o.getCrenom().getHeureFin()) >0)) {
					// System.out.println("skip");
					check = 1;
					break;
				}

			}

			if (check == 0) {
				valable.add(c);
			}
		}

		return valable;
	}
}
