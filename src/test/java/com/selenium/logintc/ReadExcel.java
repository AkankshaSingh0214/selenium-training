package com.selenium.logintc;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.*;

public class ReadExcel {

	public static void main(String[] args)throws Exception {
   
		String projectPath=System.getProperty("user.dir");		

		FileInputStream fin=new FileInputStream(projectPath+"\\testdata\\LoginDataMutual.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fin);
        XSSFSheet sheet=wb.getSheet("Sheet1");
        
        XSSFRow row=sheet.getRow(3);
        XSSFCell cell=row.getCell(0);
        
        String showData=cell.toString();
        System.out.println(showData);
        
		
		
	}

}
