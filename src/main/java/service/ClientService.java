package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Client;
import beans.Crenom;
import beans.Salle;
import connexion.Connexion;
import doa.IDao;

public class ClientService implements IDao<Client> {
	public boolean create (Client o) {
		String req= "insert into clients  values(null,?,?)";
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setString(1,o.getNom());
			ps.setString(2,o.getPrenom());
			 
			if(ps.executeUpdate()==1) {
				return true;
			}
		}catch(Exception e ) {
			System.out.println("create"+e.getMessage());
		}
		return false;
	} 
	@Override
	public boolean update (Client o) {
		String req= "update clients set Nom=?,Prenom=? where ID=?";
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setString(1,o.getNom());
			ps.setString(2,o.getPrenom());
		 
			ps.setInt(3,o.getId());
			if(ps.executeUpdate()==1) {
				return true;
			}
		}catch(Exception e ) {
			System.out.println("Update"+e.getMessage());
		}
		return false;
	}
	
	public boolean delete (Client o) {
		String req= "delete from clients  where ID=?";
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
	
	
	public  Client  findById (int id) {
		String req= "select *  from clients  where ID=?";
		Salle ls= null;
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setInt(1,id); 
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				return  new Client(rs.getInt("ID"),rs.getString("Nom"),rs.getString("Prenom")) ;
			} 
				 
			 
		}catch(Exception e ) {
			System.out.println("findById "+e.getMessage());
		}
		return null;
	}
	@Override
	public List<Client>  findAll() {
		List<Client> ls= new ArrayList<Client>();
		String req= "select * from clients ";
		
		try {
			PreparedStatement ps= Connexion.getInstane().getConnection().prepareStatement(req);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				 ls.add( new Client(rs.getInt("ID"),rs.getString("Nom"),rs.getString("Prenom"))) ;
			} 	 
		}catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
		return ls;
	}
}
