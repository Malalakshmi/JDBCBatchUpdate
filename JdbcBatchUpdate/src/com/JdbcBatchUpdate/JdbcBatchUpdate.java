package com.JdbcBatchUpdate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.JdbcUtil.JdbcUtil;

public class JdbcBatchUpdate {
    static String SqlInsertQuery = "insert into employee(EmpName,EmpAge,EmpAddress) values(?,?,?)";
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int id=0;
		String name=null;
		int age=0;
		String address=null;
		String option = null;
		try {
			con = JdbcUtil.getJdbcConnection();
			if(con!=null) {
				pstmt = con.prepareStatement(SqlInsertQuery);
			}
			while(true) {
			Scanner sc=new Scanner(System.in);
			if(sc!=null) {
				
				System.out.print("Enter EmpName:: ");
				name=sc.next();
				System.out.print("Enter EmpAge:: ");
				age=sc.nextInt();
				System.out.print("Enter EmpAddress:: ");
				address=sc.next();
			}
			if(pstmt!=null) {
				
				pstmt.setString(1, name);
				pstmt.setInt(2, age);
				pstmt.setString(3, address);
			
				pstmt.addBatch();
				System.out.println("Do u want to insert one more record?Yes/No:: ");
				option=sc.next();
				if(option.equalsIgnoreCase("no")) {
					break;
					
				}
				
					
			}
		}
			pstmt.executeBatch();
			System.out.println("records Inserted successfully...");
			
	
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}

	}

}
