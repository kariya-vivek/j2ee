/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practical20;

import java.sql.*;

/**
 *
 * @author KSC6
 */
public class Practical20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vk","root","");
             DatabaseMetaData dmd=con.getMetaData();
             System.out.println("Driver name:"+dmd.getDriverName());
             System.out.println("Driver name:"+dmd.getURL());
             System.out.println("Driver name:"+dmd.getUserName());
             System.out.println("Driver name:"+dmd.getDriverVersion());
             System.out.println("Driver name:"+dmd.getDriverMajorVersion());  
             System.out.println("Driver name:"+dmd.getDriverMinorVersion());  
        }
        catch(Exception e)
        {
            System.out.println("error"+e);
        }
    }
    
}
