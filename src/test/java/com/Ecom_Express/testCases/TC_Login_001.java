package com.Ecom_Express.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ecom_Express.pageObjects.Loginpage;
import com.Ecom_Express.utilities.ExcelDataSupplier;
 
public class TC_Login_001 extends BaseClass
{

	//Data from other class Actual procedure
	
	@Test(dataProvider = "dataset" , dataProviderClass  = ExcelDataSupplier.class)
	public void LoginTest() throws Exception
	{
	 	
		Loginpage lp = new Loginpage(driver);
		lp.setusername(username);
		Thread.sleep(5000); 
		lp.setpassword(password);
		Thread.sleep(5000); 
		lp.signin();
		Thread.sleep(5000); 
		System.out.println("sign in button clicked -------->>");
		 
	}
	
	//Example one --------->>>
	 
	@Test(dataProvider = "Onedata")
	public void BasicTest(String user) throws Exception
	{
		System.out.println("user from data provider -------->> "+ user);		 
	}
	
	
	@DataProvider(name="Onedata") 
	public String[] datasetone()
	{
		 String[] data = new String[] {"GIreesh" , 
				                        "userone ",
				                         "Usertwo"
		 };
		 
		return data;
		
	}
	
	//Example two ------------>>>
	
	
	@Test(dataProvider = "datasettwo")
	public void BasicTesttwo(String user , String password) throws Exception
	{ 
		System.out.println("user datasettwo from data provider -------->> "+ user);
		System.out.println("password datasettwo from data provider -------->> "+ password);
	}
	
	@DataProvider() 
	public Object[][] datasettwo()
	{
		Object[][] data = new Object[2][2]  ;
		 
		data[0][0] = "Admin";
		data[0][1] = "admin123";
		
		data[1][0] = "Admin";
		data[1][1] = "test123";
		 
		return data;
		
	}
	
	

	//Example Three ------------>>>
	
	
	@Test(dataProvider = "datasetthree")
	public void BasicTestthree(String user , String password) throws Exception
	{ 
		System.out.println("user datasetthree from data provider -------->> "+ user);
		System.out.println("password datasetthree from data provider -------->> "+ password);
	}
	
	@DataProvider() 
	public Object[][] datasetthree()
	{
		Object[][] data = new Object[][]  {
			{"userone","passone"},
			{"usertwo","passtwo"},
			{"userthree","passthree"},
			{"userfour","passfour"},
			{"userfive","passfove"}
		};
		 
		return data;
	}


	

	//Example Four Indices  ------------>>>
	
	
	@Test(dataProvider = "datasetfour")
	public void BasicTestfour(String user , String password) throws Exception
	{ 
		System.out.println("user datasetfour from data provider -------->> "+ user);
		System.out.println("password datasetfour from data provider -------->> "+ password);
	}
	
	@DataProvider(indices = {2,4}) 
	public Object[][] datasetfour()
	{
		Object[][] data = new Object[][]  {
			{"userone","passone"},
			{"usertwo","passtwo"},
			{"userthree","passthree"},
			{"userfour","passfour"},
			{"userfive","passfove"}
		};
		 
		return data;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
