package mini.project.daaw.Model;

public class User {
	
	private String email;
	private String password;
	private String role;
	private String user_name;
	private String name;
	private String surname;
	private String phone;
	private String module;

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String email, String password, String role, String user_name, String name, String surname, String phone, String module) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.user_name = user_name;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.module = module;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setModule(String module) { this.module = module; }

	public User() {
		
	}


	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getPhone() {
		return phone;
	}

	public String getModule() { return module; }
}
