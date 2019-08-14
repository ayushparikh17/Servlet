package com.project.util;

public class ValidationUtils {

	public static boolean isValid(String str){
		
		return str.trim().length()>0 && str!=null?true:false;
		
	}
	
}
