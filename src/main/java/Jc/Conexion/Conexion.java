package Jc.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion() {
        Connection conexion = null;
        var baseDatos = "estudiantes_db";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "1828";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }
        return conexion;
    }
}
