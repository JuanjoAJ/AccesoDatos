package Ejercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private static Connection connection;


    public Connection getConnection()
    {
        if(connection==null)
        {
    createConnection();
        }
        return connection;
    }

    private void createConnection()
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/nombrebbdd", "","");
        } catch (SQLException e) {
            System.out.println("Fallo en la conexión con la base de datos");
        }
    }



}
