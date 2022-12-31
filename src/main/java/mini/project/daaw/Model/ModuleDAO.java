package mini.project.daaw.Model;


import java.sql.*;
import java.util.ArrayList;

public class ModuleDAO {
    public ModuleDAO (){

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

    //get Module

    public ArrayList<Module> getModules(String moduleP) throws InstantiationException, IllegalAccessException {

        Connection connection = null;
        String requete;
        PreparedStatement statement;

        Module module = null;
        ArrayList<Module> modulesList = new ArrayList<Module>();

        try {

            connection = connectDB();

            requete = "SELECT * FROM module where module = ? order by date";
            statement = connection.prepareStatement(requete);
            statement.setString(1, moduleP);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                module = new Module();
                module.setModuleName(result.getString("module"));
                module.setFile(result.getString("file"));
                module.setPeriod(result.getString("period"));
                module.setType(result.getString("type"));
                module.setWeek(result.getString("date"));
                module.setPdfName(result.getString("pdfName"));

                modulesList.add(module);
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return modulesList;
    }

    //Add module
    public void addModule(Module module) throws InstantiationException, IllegalAccessException {

        Connection connection = null;
        String requete;
        PreparedStatement stmt;

        connection = connectDB();

        try {

            requete = "INSERT INTO module(module, date, file, period, pdfName, type) VALUES(?,?,?,?,?,?)";
            stmt = connection.prepareStatement(requete);

            stmt.setString(1, module.getModuleName());
            stmt.setString(2, module.getWeek());
            stmt.setString(3, module.getFile());
            stmt.setString(4, module.getPeriod());
            stmt.setString(5, module.getPdfName());
            stmt.setString(6, module.getType());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //Delete module
    public boolean deleteModule(String pdfName, String type) throws InstantiationException, IllegalAccessException {

        Connection connection = null;
        String requete;
        PreparedStatement statement;


        try {

            connection = connectDB();

            requete = "delete from module where pdfName = ? and type = ?";
            statement = connection.prepareStatement(requete);
            statement.setString(1, pdfName);
            statement.setString(2, type);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    //update
    public void updateModule(Module module) throws InstantiationException, IllegalAccessException {

        Connection connection = null;
        String requete;
        PreparedStatement stmt;

        connection = connectDB();

        try {

            requete = "update module set file = ?, period = ? where pdfName = ? and type = ?";
            stmt = connection.prepareStatement(requete);
            stmt.setString(1, module.getFile());
            stmt.setString(2, module.getPeriod());
            stmt.setString(3, module.getPdfName());
            stmt.setString(4, module.getType());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //getModule
    public boolean getModule(String pdfName, String type) throws InstantiationException, IllegalAccessException {

        Connection connection = null;
        String requete;
        PreparedStatement statement;


        try {

            connection = connectDB();

            requete = "select * from module where pdfName = ? and type = ?";
            statement = connection.prepareStatement(requete);
            statement.setString(1, pdfName);
            statement.setString(2, type);

            ResultSet result = statement.executeQuery();
            return result.next();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
