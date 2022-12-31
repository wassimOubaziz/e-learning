package mini.project.daaw.Model;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {

	public UserDAO() {

	}

	// connection to database
	public Connection connectDB() throws InstantiationException, IllegalAccessException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/daawproject", "root", "root");
			System.out.println("DATA BASE is reddy to receive data");
		} catch (ClassNotFoundException cnf) {
			System.out.print("Driver not found");
		} catch (SQLException sqlex) {
			System.out.println("I can not connect to this data base...");
		}
		return connection;

	}




	public void addUser(User user) throws InstantiationException, IllegalAccessException {

		Connection connection = null;
		String requete;
		PreparedStatement stmt;

		connection = connectDB();

		try {

			requete = "INSERT INTO users(email,password,role,user_name,name,surname,phone,module) VALUES(?,?,?,?,?,?,?,?)";
			stmt = connection.prepareStatement(requete);

			stmt.setString(1,user.getEmail());
			stmt.setString(2,user.getPassword());
			stmt.setString(3,user.getRole());
			stmt.setString(4,user.getUser_name());
			stmt.setString(5,user.getName());
			stmt.setString(6,user.getSurname());
			stmt.setString(7,user.getPhone());
			stmt.setString(8,user.getModule());

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public User getUser(int ID)
			throws InstantiationException, IllegalAccessException {

		Connection connection = null;
		String requete;
		PreparedStatement statement;

		User user = null;

		try {

			connection = connectDB();

			requete = "SELECT * FROM users WHERE id = ? ";
			statement = connection.prepareStatement(requete);
			statement.setInt(1, ID);


			ResultSet result = statement.executeQuery();

			if (result.next()) {
				user = new User();
				user.setEmail(result.getString("email"));
				user.setPassword(result.getString("password"));
				user.setRole(result.getString("role"));
				user.setUser_name(result.getString("user_name"));
				user.setName(result.getString("name"));
				user.setSurname(result.getString("surname"));
				user.setPhone(result.getString("phone"));
				user.setModule(result.getString("module"));

			}

			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return user;
	}

	//// filter users /////

	public ArrayList<User> filterUsers(String str) throws InstantiationException, IllegalAccessException {

		Connection connection = null;
		String requete;
		PreparedStatement statement;

		User user = null;
		ArrayList<User> usersList = new ArrayList<User>();

		try {

			connection = connectDB();

			requete = "SELECT * FROM users where user_name like ?";
			statement = connection.prepareStatement(requete);
			statement.setString(1, "%"+str+"%");

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				user = new User();
				user.setEmail(result.getString("email"));
				user.setPassword(result.getString("password"));
				user.setRole(result.getString("role"));
				user.setUser_name(result.getString("user_name"));
				user.setName(result.getString("name"));
				user.setSurname(result.getString("surname"));
				user.setPhone(result.getString("phone"));
				user.setModule(result.getString("module"));


				usersList.add(user);
			}

			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return usersList;
	}

	//////////////end filtering /////////
	public ArrayList<User> getUsers() throws InstantiationException, IllegalAccessException {

		Connection connection = null;
		String requete;
		PreparedStatement statement;

		User user = null;
		ArrayList<User> usersList = new ArrayList<User>();

		try {

			connection = connectDB();

			requete = "SELECT * FROM users";
			statement = connection.prepareStatement(requete);


			ResultSet result = statement.executeQuery();

			while (result.next()) {

				user = new User();
				user.setEmail(result.getString("email"));
				user.setPassword(result.getString("password"));
				user.setRole(result.getString("role"));
				user.setUser_name(result.getString("user_name"));
				user.setName(result.getString("name"));
				user.setSurname(result.getString("surname"));
				user.setPhone(result.getString("phone"));
				user.setModule(result.getString("module"));

				usersList.add(user);
			}

			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return usersList;
	}

	public User checkLogin(String email, String password)
			throws InstantiationException, IllegalAccessException {

		Connection connection = null;
		String requete;
		PreparedStatement statement;

		User user = null;

		try {

			connection = connectDB();

			requete = "SELECT * FROM users WHERE email = ? and password = ?";
			statement = connection.prepareStatement(requete);
			statement.setString(1, email);
			statement.setString(2, password);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				user = new User();
				user.setEmail(result.getString("email"));
				user.setPassword(result.getString("password"));
				user.setRole(result.getString("role"));
				user.setUser_name(result.getString("user_name"));
				user.setName(result.getString("name"));
				user.setSurname(result.getString("surname"));
				user.setPhone(result.getString("phone"));
				user.setModule(result.getString("module"));
			}

			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return user;
	}



	// delete user

	public boolean deleteUser(String email)
			throws InstantiationException, IllegalAccessException {

		Connection connection = null;
		String requete;
		PreparedStatement statement;


		try {

			connection = connectDB();

			requete = "delete from users where email = ?";
			statement = connection.prepareStatement(requete);
			statement.setString(1, email);
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}


	// update user
	public boolean updateUser(String email, String password, String phone, String surname, String name, String role, String user_name, String module)
			throws InstantiationException, IllegalAccessException {

		Connection connection = null;
		String requete;
		PreparedStatement statement;

		try {

			connection = connectDB();

			requete = "update users set user_name = ?, surname = ?, password = ? , phone = ?, role = ?, name = ?, module = ? where email = ?";
			statement = connection.prepareStatement(requete);
			statement.setString(1, user_name);
			statement.setString(2,surname);
			statement.setString(3,password);
			statement.setString(4,phone);
			statement.setString(5, role);
			statement.setString(6, name);
			statement.setString(7, module);
			statement.setString(8, email);
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}


}

