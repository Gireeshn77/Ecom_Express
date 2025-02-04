package com.Ecom_Express.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier 
{

	@DataProvider(name="dataset")
	public  String[][] getData() throws IOException 
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
		 

	    String[][] data = new String[noofrows][noofcolumns];
	    for(int i=1;i<noofrows;i++)
	    {
	    	for(int j =0;j<noofcolumns;j++)
	    	{
	    		DataFormatter df = new DataFormatter();
	    		data[i][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
	    		
	    	}
	    	
	    }
	    
	   
	    
	    workbook.close();
	    fis.close();
	    
	    return data;
	}

}
