package com.project.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbConnectionMSSql {
	static Connection conn=null;
	
	private DbConnectionMSSql(){
		
	}
	
	public static Connection getConnectionObj(){
		if(conn==null){
			conn=DbConnectionMSSql.getConnection();
		}
		return conn;
	}
	
	private static Connection getConnection(){
		FileInputStream fin=null;
		Properties prop=new Properties();
		try {
			fin=new FileInputStream("E:\\workspace\\Servlet-Application\\WebContent\\DBConfigMSSQL.properties");
			prop.load(fin);
		}
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String Urlname=prop.getProperty("URLNAME").trim();
		String driverClass=prop.getProperty("DRIVERCLASS").trim();
		String Username=prop.getProperty("USERNAME").trim();
		String Password=prop.getProperty("PASSWORD").trim();
		
		Connection conn=null;
		try {
			Class.forName(driverClass);
			conn=DriverManager.getConnection(Urlname,Username,Password);
			if (conn != null) {
				System.out.println("DB Connected: " +conn);
				
			}else{
				System.out.println("DB Not Connected: "+conn);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
		
	}
}
