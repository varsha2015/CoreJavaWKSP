package com.psl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.xpath.internal.operations.Div;

public class JdbcDemo {
	public static void main(String[] args) {
		// 1. Load Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(" Driver is loaded....");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2. Define Connection URL
		
		String url="jdbc:mysql://localhost:3306/testmydb";
		String userName="root";
		String password="root";
		Connection cn=null;
		//3. Establish connection
		try {
			 cn=DriverManager.getConnection(url,userName,password);
			 cn.setAutoCommit(false);
			System.out.println("Connected using connection :"+cn);
			
		//4. Create Statement 
			Statement stmt=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
		//5. Execute Query
			String query="Select * from emp";
			
			
			String qr1="insert into emp values(115,'Reema','IT')";
			String qr2="update emp set dept='It' where empname='Vikas'";
			String qr3="delete from emp where id=103";
			
			
			
			stmt.addBatch(qr1);
			stmt.addBatch(qr2);
			stmt.addBatch(qr3);
			
			int[] i=stmt.executeBatch();
			cn.commit();
			
			PreparedStatement pstmt=cn.prepareStatement("insert into emp values(?,?,?)");
			
			pstmt.setInt(1, 107);
			pstmt.setString(2, "Teena");
			pstmt.setString(3, "Sales");
			
			pstmt.executeUpdate();
			cn.commit();
			
			//6. Process ResultSet
			ResultSet rs=stmt.executeQuery(query);
			
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			
			
			
			// go to first
			
			rs.absolute(1);
			rs.updateString(2, "Vikas");
			rs.updateRow();
			System.out.println("Record updated...");
			
			//inserting record..
			rs.moveToInsertRow();
			rs.updateInt(1, 103);
			rs.updateString(2, "Seema");
			rs.updateString(3, "Sales");
			rs.insertRow();
			System.out.println("Record Inserted...");
			
			
			
		
			
			
			
			rs.absolute(2);
			rs.deleteRow();
			cn.commit();
			rs.absolute(2);
			rs.deleteRow();
			cn.commit();
			
			
		} catch (SQLException e) {
			try {
				cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			if(cn!=null)
			{
				// 7. close connection
				try {
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		
	}
}
