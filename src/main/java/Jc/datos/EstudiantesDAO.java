package Jc.datos;

import Jc.dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static Jc.Conexion.Conexion.getConexion;

public class EstudiantesDAO {
    public List<Estudiante> list(){
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiantes ORDER BY id_estudiantes";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var estudiante = new Estudiante();
                estudiante.setIdEstudiantes(rs.getInt("id_estudiantes"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setCorreo(rs.getString("email"));
                estudiantes.add(estudiante);
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error");
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error");
            }
        }
    return estudiantes;
    };

    public boolean findById(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiantes WHERE id_estudiantes = ?";
        try {
          ps =  con.prepareStatement(sql);
          ps.setInt(1, estudiante.getIdEstudiantes());
          rs = ps.executeQuery();
          if (rs.next()){
              estudiante.setNombre(rs.getString("nombre"));
              estudiante.setApellido(rs.getString("apellido"));
              estudiante.setTelefono(rs.getString("telefono"));
              estudiante.setCorreo(rs.getString("email"));
              return true;
          }

        }catch (Exception e){
            System.out.println("Ocurrio un error");
        }finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error");
            }
        }
        return false;
    }
    public boolean addEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO estudiantes(nombre, apellido, telefono, email)" +
                     "VALUES(?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getCorreo());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Ocurrio un error");
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error");
            }
        }
        return false;
    }
    public boolean modify(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE estudiantes SET nombre=?, apellido=?, telefono=?, email=? " +
                "WHERE id_estudiantes = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getCorreo());
            ps.setInt(5, estudiante.getIdEstudiantes());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Ocurrio un error");
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error");
            }
        }
        return false;
    }
    public boolean delete(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM estudiantes WHERE id_estudiantes = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiantes());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Ocurrio un error");
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error");
            }
        }
        return false;
    }
}
