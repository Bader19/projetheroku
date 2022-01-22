package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Salle;
import connexion.Connexion;
import doa.IDao;

public class SalleService implements IDao<Salle> {
	
	public boolean create (Salle o) {
		String req= "insert into salle  values(null,?,?,?)";
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setString(1,o.getCode());
			ps.setInt(2,o.getCapacite());
			ps.setString(3,o.getType());
			if(ps.executeUpdate()==1) {
				return true;
			}
		}catch(Exception e ) {
			System.out.println("create"+e.getMessage());
		}
		return false;
	} 
	@Override
	public boolean update (Salle o) {
		String req= "update salle set Code=?,Capacite=?,Type=? where ID=?";
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setString(1,o.getCode());
			ps.setInt(2,o.getCapacite());
			ps.setString(3,o.getType());
			ps.setInt(4,o.getId());
			if(ps.executeUpdate()==1) {
				return true;
			}
		}catch(Exception e ) {
			System.out.println("Update"+e.getMessage());
		}
		return false;
	}
	
	public boolean delete (Salle o) {
		String req= "delete from salle  where ID=?";
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setInt(1,o.getId()); 
			if(ps.executeUpdate()==1) {
				return true;
			}
		}catch(Exception e ) {
			System.out.println("delete"+e.getMessage());
		}
		return false;
	}
	
	
	public  Salle  findById (int id) {
		String req= "select *  from salle  where ID=?";
		Salle ls= null;
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setInt(1,id); 
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				return  new Salle(rs.getInt("ID"),rs.getString("Code"),rs.getInt("Capacite"),rs.getString("Type")) ;
			} 
				 
			 
		}catch(Exception e ) {
			System.out.println("findById "+e.getMessage());
		}
		return null;
	}
	@Override
	public List<Salle>  findAll() {
		List<Salle> ls= new ArrayList<Salle>();
		String req= "select * from salle ";
		
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				 ls.add( new Salle(rs.getInt("ID"),rs.getString("Code"),rs.getInt("Capacite"),rs.getString("Type"))) ;
			} 	 
		}catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
		return ls;
	}
	 

	
	 
}
