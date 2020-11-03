package com.selenium.logintc;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args)throws Exception {


		String projectPath=System.getProperty("user.dir");		
		FileInputStream fin=new FileInputStream(projectPath+"\\config.properties");
		
		Properties prop=new Properties();
		prop.load(fin);
		
		String browser=prop.getProperty("browser");
		System.out.println(browser);
		
		String baseUrl=prop.getProperty("baseUrl");
		System.out.println(baseUrl);
		
		
		
	}

}
