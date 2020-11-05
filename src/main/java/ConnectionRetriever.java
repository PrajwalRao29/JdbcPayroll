import java.sql.*;
import java.util.*;

public class ConnectionRetriever {
   public static synchronized Connection getConnection(){
        String url="jdbc:mysql://localhost:3306/testdb?useSSL=false";
        String userName="root";
        String password="Darkdr@nzer29";
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        listDrivers();
        try{
            connection=DriverManager.getConnection(url,userName,password);
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private static void listDrivers(){
        Enumeration<Driver> driverList=DriverManager.getDrivers();
        while (driverList.hasMoreElements()){
            Driver driverClass=(Driver)driverList.nextElement();
        }
    }
}
