/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.Gestor;
import Modelo.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author desi
 */
@WebServlet(name = "AltaAlumnoServlet", urlPatterns = {"/AltaAlumnoServlet"})
public class AltaAlumnoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Gestor gestor=new Gestor();
  
        request.setAttribute("lista", gestor.ObtenerSexos());
        RequestDispatcher rd =getServletContext().getRequestDispatcher("/altaAlumno.jsp");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gestor gestor=new Gestor();
        
        String apellido=request.getParameter("txtApellido");
        String nombre=request.getParameter("txtNombre");
        String telefono=request.getParameter("txtTelefono");
        String email=request.getParameter("txtEmail");
        String idSexo = request.getParameter("cboTipoSexos");
           
        Alumno nuevo= new Alumno(0,apellido,nombre,telefono,email,Integer.parseInt(idSexo));
                    
           
        gestor.agregarAlumno(nuevo);
        request.setAttribute("alumnos", gestor.ObtenerListadoAlumnos());
        RequestDispatcher rd = request.getRequestDispatcher("/listadoAlumnos.jsp");
        rd.forward(request, response);       
           
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
