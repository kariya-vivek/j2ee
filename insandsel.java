/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 practical26
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author KSC6
 */
public class insandsel extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vk","root","");
                String s1="insert into stud1 (firstname,lastname,course,semester) values(?,?,?,?)";
                String fnm=request.getParameter("sfnm");
                String lnm=request.getParameter("slnm");
                String sc=request.getParameter("course");
                String stsem=request.getParameter("ssem");
                PreparedStatement pst=con.prepareStatement(s1);
                pst.setString(1, fnm);
                pst.setString(2, lnm);
                pst.setString(3, sc);
                pst.setString(4, stsem);
                pst.executeUpdate();
                
                String s2="select * from stud1";
                PreparedStatement psts=con.prepareStatement(s2);
                ResultSet rs=psts.executeQuery();
                out.println("<table border=2px>");
                out.println("<tr><th>rollno</td><th>firstname</th><th>lastname</th><th>course</th><th>semester</th>");
                while(rs.next())
                {
                  out.println("<tr><td>"+rs.getInt("rollno")+"</td><td>"+rs.getString("firstname")+"</td>"+"<td>"+rs.getString("lastname")+"</td><td>"+rs.getString("course")+"</td>"+"</td><td>"+rs.getString("semester")+"</td></tr>");
                }
            }
            catch(Exception e)
            {
               out.println("error"); 
            }
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

