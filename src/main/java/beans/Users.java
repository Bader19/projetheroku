package beans;

public class Users {
	private int id;
	private String login;
	private String password;
	private String email;
	private String Phone;
	private boolean role;

	public Users(int id, String pwd, String login, String email, String phone, boolean role) {
		super();
		this.id = id;
		this.password = pwd;
		this.login = login;
		this.email = email;
		this.Phone = phone;
		this.role = role;
	}

	public Users(String username, String pwd, String email1, String phoneNumber1, boolean role) {
		this.login = username;
		this.password = pwd;
		this.email = email1;
		this.Phone = phoneNumber1;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", login=" + this.login + ", password=" + this.password + ", email=" + email + ", Phone="
				+ Phone + ", role=" + role + "]";
	}

}