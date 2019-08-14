package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.bean.RegistrationBean;
import com.project.util.DbConnectionMSSql;

public class regDAO {
	
	static Connection conn;
	
	public boolean insert(RegistrationBean rb){
		boolean flag=false;
		conn=DbConnectionMSSql.getConnectionObj();
		PreparedStatement pstmt=null;
		String insertQuery="INSERT INTO Reg VALUES(?,?,?,?,?,?,?)";
		int rowseffected=0;
		if (conn!=null) {
			try {
				pstmt = conn.prepareStatement(insertQuery);
				pstmt.setString(1,rb.getFirstName());
				pstmt.setString(2, rb.getLastName());
				pstmt.setString(3, rb.getAddress());
				pstmt.setString(4,rb.getMobileno());
				pstmt.setString(5, rb.getEmail());
				pstmt.setString(6,rb.getGender());
				pstmt.setString(7,rb.getHobby() );
				rowseffected=pstmt.executeUpdate();
				if (rowseffected > 0) {
					flag = true;
				} else {
					flag = false;
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Db not Connected: "+conn);
		}
		return flag;
	}
	
	public ArrayList<RegistrationBean> getData(){
		String getData="Select * from Reg ";
		conn=DbConnectionMSSql.getConnectionObj();
		ResultSet rs=null;
		ArrayList<RegistrationBean> list=new ArrayList<RegistrationBean>();
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement(getData);
				rs=pstmt.executeQuery();
				
				while (rs.next()) {
					RegistrationBean rb=new RegistrationBean();
					rb.setId(rs.getInt(1));
					rb.setFirstName(rs.getString(2));
					rb.setLastName(rs.getString(3));
					rb.setAddress(rs.getString(4));
					rb.setGender(rs.getString(5));
					rb.setHobby(rs.getString(6));
					rb.setMobileno(rs.getString(7));
					rb.setEmail(rs.getString(8));
					
					list.add(rb);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<RegistrationBean> edit(RegistrationBean rb){
		String getData="Select * from Reg where Id='"+rb.getId()+"' ";
		conn=DbConnectionMSSql.getConnectionObj();
		ResultSet rs=null;
		ArrayList<RegistrationBean> list=new ArrayList<RegistrationBean>();
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement(getData);
				rs=pstmt.executeQuery();
				
				while (rs.next()) {
					rb.setId(rs.getInt(1));
					rb.setFirstName(rs.getString(2));
					rb.setLastName(rs.getString(3));
					rb.setAddress(rs.getString(4));
					rb.setGender(rs.getString(5));
					rb.setHobby(rs.getString(6));
					rb.setMobileno(rs.getString(7));
					rb.setEmail(rs.getString(8));
					
					list.add(rb);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public boolean Update(RegistrationBean rb){
		boolean flag=false;
		conn=DbConnectionMSSql.getConnectionObj();
		PreparedStatement pstmt=null;
		String updateQuery="UPDATE Reg set FirstName=?, LastName=? ,Address=?, MobileNo=?, Email=? where Id='"+rb.getId()+"'";
		int rowseffected=0;
		if (conn!=null) {
			try {
				
				pstmt=conn.prepareStatement(updateQuery);
				pstmt.setString(1,rb.getFirstName());
				pstmt.setString(2, rb.getLastName());
				pstmt.setString(3, rb.getAddress());
				pstmt.setString(4, rb.getMobileno());
				pstmt.setString(5, rb.getEmail());
				rowseffected=pstmt.executeUpdate();
				if (rowseffected>0) {
					flag=true;
				} else {
					flag=false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			System.out.println("Db not Connected");
		}
		return flag;
	}
	
	public boolean Delete(RegistrationBean rb){
		boolean flag=false;
		conn=DbConnectionMSSql.getConnectionObj();
		PreparedStatement pstmt=null;
		String deleteQuery="DELETE FROM Reg WHERE Id='"+rb.getId()+"'";
		int rowseffected=0;
		if (conn!=null) {
			try {
				pstmt=conn.prepareStatement(deleteQuery);
				rowseffected=pstmt.executeUpdate();
				if (rowseffected>0) {
					flag=true;
				} else {
					flag=false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			System.out.println("Db not Connected");
		}
		return flag;
	}
}
