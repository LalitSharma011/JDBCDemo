package uk.co.natwest.jdbc;

import java.sql.*;

public class JDBC_Demo2 {
    private static final String URL = DB_Utility.getProperty("mysql.url");
    private static final String USER = DB_Utility.getProperty("mysql.user");
    private static final String PASSWORD = DB_Utility.getProperty("mysql.password");
    public static void main(String[] args) {
        //create a connection to database.
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            //create a query
            String query = "insert into sakila.actor values(?,?,?,?)";
        //create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //set the values
            preparedStatement.setLong(1,201);
            preparedStatement.setString(2, "Lalit");
            preparedStatement.setString(3,"Sharma");
            preparedStatement.setString(4,"2002-02-10 04:10:22");
            int i = preparedStatement.executeUpdate();
            if(i > 0){
                System.out.println("data inserted");
            }
        }
        catch (SQLException throwables){
            System.out.println("Problem occurred");
            throwables.printStackTrace();
        }
    }
}
