/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import es.albarregas.beans.Ave;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rpk19
 */
public class AccesoBD extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          Connection conexion = null;
          Statement sentencia = null;
          PreparedStatement preparada = null;
            ResultSet resultado = null;
            Ave ave;
            ArrayList<Ave> aves = new ArrayList<Ave>();
            String url = null;
            //cargo el driver
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            String connectionString = "jdbc:mysql://localhost:3306/pruebasJava";
            try {
                conexion = DriverManager.getConnection(connectionString, "java2017", "2017");
               if(request.getParameter("uno")!=null){
                   //obtener un pajarete
                   String sql = "SELECT * FROM aves WHERE anilla = ?";
                   preparada = conexion.prepareStatement(sql);
                   preparada.setString(1, request.getParameter("txtAnilla"));
                   
                   resultado = preparada.executeQuery();
                   while(resultado.next()){
                   ave = new Ave();
                   ave.setAnilla(resultado.getString("anilla"));
                     ave.setEspecie(resultado.getString("especie"));
                       ave.setFecha(resultado.getString("fecha"));
                         ave.setLugar(resultado.getString("lugar"));
                         request.setAttribute("ave", ave);}
                        url = "unPollo.jsp";
               } 
               if(request.getParameter("todos")!=null){
                   //obtengo todos los pollos
                   String sql = "SELECT * FROM aves";
                   sentencia = conexion.createStatement();
                   resultado = sentencia.executeQuery(sql);
                   while(resultado.next()){
                         
                   ave = new Ave();
                   ave.setAnilla(resultado.getString("anilla"));
                   ave.setEspecie(resultado.getString("especie"));
                   ave.setFecha(resultado.getString("fecha"));
                   ave.setLugar(resultado.getString("lugar"));
                   aves.add(ave);
                   }
                         
                   url="TodosPollos.jsp";
                   request.setAttribute("aves", aves);
               }if(request.getParameter("btnRandom")!=null){
                    String sql = "SELECT * FROM aves ORDER BY RAND() LIMIT "+request.getParameter("txtNumRandom");
                   sentencia = conexion.createStatement();
                   resultado = sentencia.executeQuery(sql);
                   
                  
                   
                   while(resultado.next()){
                     ave = new Ave();
                   ave.setAnilla(resultado.getString("anilla"));
                   ave.setEspecie(resultado.getString("especie"));
                   ave.setFecha(resultado.getString("fecha"));
                   ave.setLugar(resultado.getString("lugar"));
                   aves.add(ave);
               }
                   url ="TodosPollos.jsp";
                    request.setAttribute("aves", aves);
               }
                  conexion.close();
            } catch (SQLException ex) {
             ex.printStackTrace();
            }
            //redirijo a la pagina segun lo que el user haga
            
          
   
                    request.getRequestDispatcher(url).forward(request, response); 
        }
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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
