/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import Modelo.Curso;
import Modelo.DTOAlumno;
import Modelo.DTOCurso;
import Modelo.Modalidad;
import Modelo.Sexo;
import Modelo.TipoCurso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author desi
 */
public class Gestor {

    private String CONN = "jdbc:sqlserver://emade;databaseName=AcademiaProg2020";
    private String USER = "sa";
    private String PASS = "Juan1203";

    private Connection con;

    private void abrirConexion() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void agregarAlumno(Alumno a) {

        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("INSERT INTO Alumnos(apellido,nombre,telefono,email,idSexo) VALUES(?,?,?,?,?)");

            st.setString(1, a.getApellido());
            st.setString(2, a.getNombre());
            st.setString(3, a.getTelefono());
            st.setString(4, a.getEmail());
            st.setInt(5, a.getIdSexo());

            st.executeUpdate();

            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

    }
     public void agregarCurso(Curso c) {

        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("INSERT INTO Cursos(nombre,precioTotal,duracion,idModalidad,idTipoCurso,fechaInicio,descripcion) VALUES(?,?,?,?,?,?,?)");

            st.setString(1, c.getNombre());
            st.setDouble(2, c.getPrecioTotal());
            st.setString(3, c.getDuracion());
            st.setInt(4, c.getIdModalidad());
            st.setInt(5, c.getIdTipoCurso());
            st.setString(6, c.getFechaInicio());
            st.setString(7, c.getDescripcion());

            st.executeUpdate();

            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

    }


    public ArrayList<Sexo> ObtenerSexos() {

        ArrayList<Sexo> lista = new ArrayList<>();

        try {

            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Sexos");
            while (rs.next()) {
                int id = rs.getInt("idSexo");
                String apellido = rs.getString("descripcion");
                
                Sexo s=new Sexo(id, apellido);

                lista.add(s);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }
    public ArrayList<Modalidad> ObtenerModalidades() {

        ArrayList<Modalidad> lista = new ArrayList<>();

        try {

            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Modalidades");
            while (rs.next()) {
                int id = rs.getInt("idModalidad");
                String desccripcion = rs.getString("descripcion");
                
                Modalidad mod=new Modalidad(id, desccripcion);

                lista.add(mod);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }
     public ArrayList<TipoCurso> ObtenerTiposCursos() {

        ArrayList<TipoCurso> lista = new ArrayList<>();

        try {

            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM TiposCursos");
            while (rs.next()) {
                int id = rs.getInt("idTipoCurso");
                String descripcion = rs.getString("descripcion");
                
               TipoCurso t=new TipoCurso(id, descripcion);

                lista.add(t);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }

    public ArrayList<DTOAlumno> ObtenerListadoAlumnos() {

        ArrayList<DTOAlumno> lista = new ArrayList<DTOAlumno>();

        try {

            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT a.apellido, a.nombre, a.telefono, a.email, s.descripcion \n"
                    + "FROM  Alumnos a, Sexos s\n"
                    + "WHERE a.idSexo=s.idSexo");

            while (rs.next()) {
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String descripcion = rs.getString("descripcion");

                DTOAlumno dto = new DTOAlumno(apellido, nombre, telefono, email, descripcion);
                lista.add(dto);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }
    public ArrayList<DTOCurso> ObtenerListadoCursos() {

        ArrayList<DTOCurso> lista = new ArrayList<DTOCurso>();

        try {

            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT c.nombre, c.precioTotal, c.duracion, m.descripcion as modalidad, t.descripcion as tipoCurso, c.fechaInicio, c.descripcion\n" +
                                            "FROM Cursos c, Modalidades m, TiposCursos t\n" +
                                            "WHERE c.idModalidad=m.idModalidad and c.idTipoCurso=t.idTipoCurso");

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                double precioTotal = rs.getDouble("precioTotal");
                String duracion = rs.getString("duracion");
                String modalidad = rs.getString("modalidad");
                String tipoCurso = rs.getString("tipoCurso");
                String fecha = rs.getString("fechaInicio");
                String descripcion = rs.getString("descripcion");
                
                
               DTOCurso dto=new DTOCurso(nombre, precioTotal, duracion, modalidad, tipoCurso, fecha, descripcion);
                lista.add(dto);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }

//    public void actualizarVenta(Venta venta) {
//        try {
//            abrirConexion();
//            PreparedStatement ps = con.prepareStatement("UPDATE Ventas SET idProducto = ?, cantidad = ? WHERE id = ?");
//            ps.setInt(1, venta.getIdProducto());
//            ps.setInt(2, venta.getCantidad());
//            ps.setInt(3, venta.getId());
//            ps.executeUpdate();
//        } catch (Exception exc) {
//            exc.printStackTrace();
//        } finally {
//            cerrarConexion();
//        }
//    }
//    public Venta obtenerVentaPorId(int idVenta)
//    {
//        Venta v = null;
//        try
//        {
//            abrirConexion();
//            PreparedStatement st = con.prepareStatement("SELECT * FROM Ventas WHERE id = ?");
//            st.setInt(1, idVenta);
//            ResultSet rs = st.executeQuery();
//            if(rs.next())
//            {
//                int id = rs.getInt("id");
//                int idProducto = rs.getInt("idProducto");
//                int cantidad = rs.getInt("cantidad");
//                
//                v = new Venta(id, idProducto, cantidad);
//               
//            }
//            rs.close();
//        }
//        catch(Exception exc)
//        {
//            exc.printStackTrace();
//        }
//        finally
//        {
//            cerrarConexion();
//        }
//        
//        return v;
//    }
//    public void eliminarVenta(int idVenta)
//    {
//        try
//        {
//            abrirConexion();
//            PreparedStatement ps = con.prepareStatement("DELETE Ventas WHERE id = ?"); // BAJA FISICA
//            //PreparedStatement ps = con.prepareStatement("UPDATE Ventas SET fechaBaja = GETDATE() WHERE id = ?"); //BAJA LOGICA
//            //UPDATE Ventas SET estado = 0 WHERE id = ?
//            ps.setInt(1, idVenta);
//            ps.executeUpdate();
//        }
//        catch(Exception exc)
//        {
//            exc.printStackTrace();
//        }
//        finally
//        {
//            cerrarConexion();
//        }
//    }
//    private Sexo obenerTipoSexo(int idTipoSexo) {
//        Sexo resultado = null;
//        try {
//            abrirConexion();
//            PreparedStatement st = con.prepareStatement("SELECT * FROM Sexos WHERE id=?");
//
//            st.setInt(1, idTipoSexo);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                String descripcion = rs.getString("descripcion");
//
//                resultado = new Sexo(idTipoSexo, descripcion);
//
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            cerrarConexion();
//        }
//        return resultado;
//
//    }

}
