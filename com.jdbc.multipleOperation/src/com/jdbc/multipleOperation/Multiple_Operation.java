package com.jdbc.multipleOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Multiple_Operation {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc=new Scanner(System.in);
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
		
		PreparedStatement ps=null;
	do {	
		System.out.println("1.Insert 2.Update 3.Delete 4.Select 5.Exit");
		System.out.println("Which Operation:- ");
		
		int op=sc.nextInt();
		switch(op) {
		
		case 1:
			
			ps=con.prepareStatement("insert into employee(eid,ename,email,elocation,emob,esalary) values (?,?,?,?,?,?)");
			
			System.out.println("Enter Employee Id");
			int id=sc.nextInt();
			
			System.out.println("Enter Employee Name");
			String name=sc.next();
			
			System.out.println("Enter Employee Email");
			String email=sc.next();
			
			System.out.println("Enter Employee Location");
			String loc=sc.next();
			
			System.out.println("Enter Employee Mob.no.");
			String mob=sc.next();
			
			System.out.println("Enter Employee salary");
			String salary=sc.next();
			
			
			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setString(3,email);
			ps.setString(4,loc);
			ps.setString(5,mob);
			ps.setString(6,salary);
			
			ps.executeUpdate();
			break;
			
			
		case 2:
			
			ps=con.prepareStatement("update employee set ename=? where eid=?");
			
			System.out.println("Enter Employee Id");
			 id=sc.nextInt();
			
			System.out.println("Enter Employee Name");
			 name=sc.next();
			 
			 ps.setInt(1, id);
			 ps.setString(2,name);
					
			ps.executeUpdate();
			break;
			
			
		case 3:
			
			ps=con.prepareStatement("delete from employee where eid=?");
			
			System.out.println("Enter Employee eId");
			id=sc.nextInt();
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			break;
			
		case 4:
			ps=con.prepareStatement("select * from employee where eid=?");
			
			System.out.println("Enter Employee Id");
			id=sc.nextInt();
			
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			System.out.println(rs.getInt("eid") +"-"+rs.getString("ename")+"-"+rs.getString("email")+"-"+rs.getString("elocation")+"-"+rs.getString("emob")+"-"+rs.getString("esalary"));
			break;
			
		case 5:
			System.exit(0);
			
			default:
				System.out.println("Plzz Enter Number Only 1 to 4");
			
		
		}
		
		
	}while(true);	
		

	}

}
