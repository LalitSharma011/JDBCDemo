package uk.co.natwest.jdbc;

import java.sql.*;

public class JDBC_Demo {
    private static final String URL = DB_Utility.getProperty("mysql.url");
    private static final String USER = DB_Utility.getProperty("mysql.user");
    private static final String PASSWORD = DB_Utility.getProperty("mysql.password");
    public static void main(String[] args) {
        //create a connection to database.
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
        //create  a statement obj to send a query
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM actor";
            //execute the query
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                long actor_id = resultSet.getLong("actor_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                Date last_update = resultSet.getDate("last_update");
                System.out.println("actor_id " + actor_id + " first_name " + first_name + " last_name " + last_name + " last_update " + last_update );
            }
        }
        catch (SQLException throwables){
            System.out.println("Problem occurred");
            throwables.printStackTrace();
        }
    }
}
