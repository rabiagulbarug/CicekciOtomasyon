package çicekci1.DataBase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private final String url = "jdbc:mysql://localhost:3306/cicekdb?serverTimezone=UTC";
    // private final String url = "jdbc:mysql://localhost/?user=root&password=rootpassword";
    private final String user_name = "root";

    private final String password = "mysql";
    private static DBConnection _dbConnection = null;
    private Connection connection;

    public DBConnection() {
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user_name, password);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /* catch (ClassNotFoundException e) {
            e.printStackTrace();
        } */
    }

    public static DBConnection getInstance() {
        if (_dbConnection == null) {
            _dbConnection = new DBConnection();
        }

        return _dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }

 /*   public  Connection Baglan() {

        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cicekdb?serverTimezone=UTC");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }*/
}

/*
package çicekci1.DataBase;


public class DBConnection {

	 static Connection bag=null;
    public static Connection Baglan(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/Çicek1?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","mysql");
           
            return conn;
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	return null;
        }  
    }
}*/
