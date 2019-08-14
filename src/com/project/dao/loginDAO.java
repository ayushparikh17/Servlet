package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.bean.LoginBean;
import com.project.util.DbConnectionMSSql;

public class loginDAO {
	
	static Connection conn;
	
	public boolean insert(LoginBean lb){
		boolean flag=false;
		conn=DbConnectionMSSql.getConnectionObj();
		String insertQuery="Insert into Login values(?,?)";
		int rowseffected=0;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			try {
				pstmt=conn.prepareStatement(insertQuery);
				pstmt.setString(1, lb.getUserName());
				pstmt.setString(2, lb.getPassword());
				rowseffected=pstmt.executeUpdate();
				if(rowseffected>0){
					flag=true;
				}
				else{
					flag=false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("DB not Connected");
		}
		return flag;
	}
}
