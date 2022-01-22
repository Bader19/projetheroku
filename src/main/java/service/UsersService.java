package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import beans.Salle;
import beans.Users;
import connexion.Connexion;
import doa.IDao;

public class UsersService {
	private String hashpass = "";

	public String getHashPass(String password) throws NoSuchAlgorithmException {

		String plainText = password;
		MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
		mdAlgorithm.update(plainText.getBytes());

		byte[] digest = mdAlgorithm.digest();
		StringBuffer hexString = new StringBuffer();

		for (int i = 0; i < digest.length; i++) {
			plainText = Integer.toHexString(0xFF & digest[i]);

			if (plainText.length() < 2) {
				plainText = "0" + plainText;
			}

			hexString.append(plainText);
		}
		hashpass = hexString.toString();

		return hashpass;
	}

	public boolean create(Users o) {
		String req = "insert into users  values(null,?,?,?,?,?)";

		try {

			String hashpass = getHashPass(o.getPassword());
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setString(1, o.getLogin());
			ps.setString(2, hashpass);
			ps.setString(3, o.getEmail());
			ps.setString(4, o.getPhone());
			ps.setBoolean(5, o.isRole());
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("create" + e.getMessage());
		}
		return false;
	}

	public boolean update(Users o) {
		String req = "update users set Username=?,password=? where ID=?";
		try {
			String hashpass = getHashPass(o.getPassword());
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setString(1, o.getLogin());
			ps.setString(2, hashpass);

			ps.setInt(4, o.getId());
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Update" + e.getMessage());
		}
		return false;
	}

	public boolean delete(Users o) {
		String req = "delete from users  where ID=?";
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

	public Users findById(int id) {
		String req = "select *  from users  where ID=?";
		Users ls = null;
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Users(rs.getInt("ID"), rs.getString("Username"), rs.getString("Password"),
						rs.getString("Email"), rs.getString("Phone"), rs.getBoolean("Admin"));
			}

		} catch (Exception e) {
			System.out.println("findById " + e.getMessage());
		}
		return null;
	}

	public List<Users> findAll() {
		List<Users> ls = new ArrayList<Users>();
		String req = "select * from users ";

		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(new Users(rs.getInt("ID"), rs.getString("Username"), rs.getString("Password"),
						rs.getString("Email"), rs.getString("Phone"), rs.getBoolean("Admin")));
			}
		} catch (SQLException e) {
			System.out.println("findAll " + e.getMessage());
		}
		return ls;
	}

	public boolean connexion(String username, String pass) {
		try {
	 
			String req = "select * from users where Username=? and Password =?";
			PreparedStatement rs = Connexion.getInstane().getConnection().prepareStatement(req);
			
			rs.setString(1, username);
			rs.setString(2, getHashPass(pass));
			ResultSet ms = rs.executeQuery();

			if (ms.next()) {
			 
				return true;

			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		return false;
	}
	public Users findrole(String username, String pass) {
		try {
			 
			String req = "select * from users where Username=? and Password =?";
			PreparedStatement rs = Connexion.getInstane().getConnection().prepareStatement(req);
			 
			rs.setString(1, username);
			rs.setString(2, getHashPass(pass));
			ResultSet ms = rs.executeQuery();
			if (ms.next()) {
				return new Users(ms.getInt("ID"), ms.getString("Username"), ms.getString("Password"),
						ms.getString("Email"), ms.getString("Phone"), ms.getBoolean("Admin")) ;
			 

			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	 
	}
	public List<Users> currentuser(String username, String pass) {
		List<Users> ls = new ArrayList<Users>();
		try {
			
			String req = "select * from users where Username=? and Password =?";
			PreparedStatement rs = Connexion.getInstane().getConnection().prepareStatement(req);
			
			rs.setString(1, username);
			rs.setString(2, getHashPass(pass));
			ResultSet ms = rs.executeQuery();
			
			if (ms.next()) {
				ls.add(new Users(ms.getInt("ID"),ms.getString("Password"), ms.getString("Username"), 
						ms.getString("Email"), ms.getString("Phone"), ms.getBoolean("Admin")));

			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		return ls;

	}

}
