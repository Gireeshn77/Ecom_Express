package com.Ecom_Express.testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class demo {

	public static void main(String[] args) throws IOException 
	{

    	File Excelfile = new File("./src/test/java/com/Ecom_Express/testData/Testdata.xls");
	    
	    System.out.println(Excelfile.exists());
	    FileInputStream fis = new FileInputStream(Excelfile);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet =  workbook.getSheet("Sheet1");
	    int noofrows = sheet.getPhysicalNumberOfRows();
	    int noofcolumns = sheet.getRow(0).getLastCellNum();
	    
	    System.out.println(noofrows);
	    System.out.println(noofcolumns);
		 

	    workbook.close();
	    fis.close();
	}

}
