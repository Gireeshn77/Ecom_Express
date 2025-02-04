package com.Ecom_Express.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Ecom_Express.utilities.ReadConfig;
 
public class BaseClass
{
    ReadConfig readconfig = new ReadConfig();
	public String baseUrl = readconfig.getApplicationuURL();
	public static WebDriver driver;
	public String username = readconfig.getusername();
	public String password = readconfig.getpassword();
	
	SimpleDateFormat sdf;
	Date date;
	String dateformat;
	String Repname;
	
	@BeforeClass
	public void setup()
	{	 
		driver = new ChromeDriver();	
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown()
	{ 
	  driver.quit();
	}
	
	 public void takeScreenshot(String tname) throws IOException
	   {
		  
		   TakesScreenshot shot=(TakesScreenshot)driver;
		   File src=shot.getScreenshotAs(OutputType.FILE);
		   sdf=new SimpleDateFormat("dd-MM-YYYY,HH.mm.ss");
		   date=new Date();
		   dateformat=sdf.format(date);
		   Repname=tname+dateformat+".png";
		   File dst =new File("C:\\Users\\ngire\\eclipse-workspace\\Delivery\\Screenshots"+Repname);
		   FileUtils.copyFile(src, dst);
		
		  System.out.println("Screenshot taken");
	   }
	
	
	
	

}
