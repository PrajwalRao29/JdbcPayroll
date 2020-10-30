import java.sql.*;
import java.util.*;

public class DbDemo {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/testdb?useSSL=false";
        String userName="root";
        String password="Darkdr@nzer29";
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        listDrivers();
        try{
            System.out.println("Connecting to database:"+url);
            connection=DriverManager.getConnection(url,userName,password);
            System.out.println("Connected ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private static void listDrivers(){
        Enumeration<Driver> driverList=DriverManager.getDrivers();
        while (driverList.hasMoreElements()){
            Driver driverClass=(Driver)driverList.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }
}
