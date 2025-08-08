/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practical19;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author KSC6
 */
public class Practical19 {

    /**
     */
    
     public void inse()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vk","root","");
            Scanner sc=new Scanner(System.in);
            
            System.out.print("enter product name=");
            String nm=sc.next();
	
            System.out.print("enter price=");
            int pr=sc.nextInt();
	
            System.out.print("enter quanty=");
            int q=sc.nextInt();

	
            String p12="insert into product (pronm,price,quanty) values(?,?,?)";
	
             PreparedStatement pst=con.prepareStatement(p12);
	
            pst.setString(1,nm);
            pst.setInt(2,pr);
            pst.setInt(3,q);
           
             pst.executeUpdate();
           
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println("error"+e);
        } 
    }
    public void upd()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vk","root","");
            Scanner sc=new Scanner(System.in);
            System.out.print("enter product name=");
            String nm=sc.next();
	
            System.out.print("enter price=");
            int pr=sc.nextInt();
            
            System.out.print("enter quanty=");
            int q=sc.nextInt();
	
            System.out.print("enter your product id=");
            int i=sc.nextInt();
	
            String p13="update product set pronm=?,price=?,quanty=? where pid=?";
	
            PreparedStatement pst=con.prepareStatement(p13);
            
            pst.setString(1,nm);
            pst.setInt(2,pr);
            pst.setInt(3,q);
            pst.setInt(4,i);
	
            pst.executeUpdate();
            
        }
        catch( ClassNotFoundException | SQLException e)
        {
            System.out.println("error"+e);
        }
    }
    public void del()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vk","root","");
            Scanner sc=new Scanner(System.in);
            System.out.print("enter your pid=");
            int pno=sc.nextInt();
            String p14="delete from product where pid=?";
            PreparedStatement pst=con.prepareStatement(p14);
            pst.setInt(1,pno);
            pst.executeUpdate();   
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println("error"+e);
        } 
    }
    public void sel()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vk","root","");
            Scanner sc=new Scanner(System.in);
            System.out.print("enter your pno=");
            int pno=sc.nextInt();
            String p10="select * from product where pid=?";
            PreparedStatement pst=con.prepareStatement(p10);
            pst.setInt(1,pno);
            ResultSet rs=pst.executeQuery();
            System.out.println("pid\tproductname\tprice\tquanty");
            while(rs.next())
            {
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t"+rs.getInt(4));
            }
           
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println("error"+e);
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
         try
        {
            Practical19 obj=new Practical19();
            Scanner sc=new Scanner(System.in);
            System.out.print("enter your choise=");
            int a=sc.nextInt();
            switch(a)
            {
                case 1:
                        obj.inse();
                        break;
                case 2:
                        obj.upd();
                        break;
                case 3:
                        obj.del();
                         break;
                case 4:
                        obj.sel();
                         break;
                default :
                        System.out.println("choos another from 1 to 4");
            }
            
        }
        catch(Exception e)
        {
            System.out.println("error"+e); 
        }
    }
    
}
