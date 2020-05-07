package com.occamsrazor.web.util;

import java.io.File;

public enum Data {
	USER_PATH , ADMIN_PATH, LOST_PATH , CSV , LIST;
	@Override
	public String toString() {
		String returnValue ="";
		switch(this) {
		case USER_PATH: returnValue ="C:"+ File.separator+"Users"+File.separator+ 
				"user"+ File.separator+ "git"+File.separator + 
				"repository2"+File.separator+"occamsrazor-1"+ File.separator + 
				"src"+ File.separator + "main"+ File.separator+ 
				"resources" +File.separator+ "static" + File.separator+
				"resources" + File.separator +
				"file" + File.separator; break;
		
		case ADMIN_PATH: returnValue ="C:"+ File.separator+"Users"+File.separator+ 
				"user"+ File.separator+ "git"+File.separator + 
				"repository2"+File.separator+"occamsrazor-1"+ File.separator + 
				"src"+ File.separator + "main"+ File.separator+ 
				"resources" +File.separator+ "static" + File.separator+
				"resources" + File.separator +
				"file" + File.separator; break;
				
		case LOST_PATH: returnValue = "C:"+ File.separator+"Users"+File.separator+ 
				"user"+ File.separator+ "git"+File.separator + 
				"repository2"+File.separator+"occamsrazor-1"+ File.separator + 
				"src"+ File.separator + "main"+ File.separator+ 
				"resources" +File.separator+ "static" + File.separator+
				"resources" + File.separator +
				"file" + File.separator; break;
				
		case CSV: returnValue = ".csv"; break;
		case LIST: returnValue= "list"; break;
		default:
			break;
		}
		return returnValue;
	}
}

/*
 * 
 *
public enum Data {
	ADMIN, USERS, IOSTS;
	@Override
	public String toString() {
		String returnValue =""C:"+ File.separator+"Users"+File.separator+ 
				"user"+ File.separator+ "git"+File.separator + 
				"repository2"+File.separator+"occamsrazor-1"+ File.separator + 
				"src"+ File.separator + "main"+ File.separator+ 
				"resources" +File.separator+ "static" + File.separator+
				"resources" + File.separator +
				"file" + File.separator";
		String
		switch(this) {
		
				
		case CSV: returnValue =".csv"; break;
		case ADMIN: returnValue.concat("admin_list.csv"); break;
		case USERS: returnValue.concat("users_list.csv"); break;
		case IOSTS: returnValue.concat("losts_list.csv"); break;
		default:
			break;
		}
		return returnValue;
	}
} 
 * 
 * */
