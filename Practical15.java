/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practical15;

import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author KSC6
 */
public class Practical15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vk","root","");
            //practical 15
            /*String p15="{call ins_without_p()}";
            CallableStatement cs=con.prepareCall(p15);
            cs.executeUpdate(p15);*/
            
           // practical 16
           /*String p16="{call ins_with_p(?,?,?,?,?)}";
            Scanner sc=new Scanner(System.in);
            System.out.print("enter name=");
            String nm=sc.next();
	
            System.out.print("enter designation=");
            String des=sc.next();
	
            System.out.print("enter city=");
            String City=sc.next();
	
            System.out.print("enter salary=");
            int sal=sc.nextInt();
	
            System.out.print("enter department=");
            String dp=sc.next();
            
            CallableStatement cs=con.prepareCall(p16);
            
            cs.setString(1,nm);
            cs.setString(2,des);
            cs.setString(3,City);
            cs.setInt(4,sal);
            cs.setString(5,dp);
            cs.executeUpdate();
            
            cs.executeUpdate();*/
            
            //practical 17
            /*Scanner sc=new Scanner(System.in);
            
            System.out.print("enter your id=");
            int i=sc.nextInt();
	
            String p17="{call select_sp(?)}";
	
            CallableStatement cs=con.prepareCall(p17);
           
            cs.setInt(1,i);
            ResultSet rs=cs.executeQuery();
            while(rs.next())
            {
		System.out.println("designation:"+rs.getString("designation"));
            }*/
            
            //practicle 18
            Scanner sc=new Scanner(System.in);
            
            System.out.print("enter your designation=");
            String d=sc.next();
	
            String p18="{call sel_des(?)}";
	
            CallableStatement cs=con.prepareCall(p18);
           
            cs.setString(1,d);
            ResultSet rs=cs.executeQuery();
            while(rs.next())
            {
		System.out.println("empno:"+rs.getInt(1));
		System.out.println("empnm:"+rs.getString(2));
		System.out.println("designation:"+rs.getString(3));
		System.out.println("city:"+rs.getString(4));
		System.out.println("salary:"+rs.getInt(5));
		System.out.println("department:"+rs.getString(6));
            }

        }
         catch(Exception e)
         {
             System.out.println("error"+e);
         }
    }
    
}
