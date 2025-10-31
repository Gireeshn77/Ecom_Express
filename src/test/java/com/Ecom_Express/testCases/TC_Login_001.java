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

	


	//Example Five if we have n number of test method arguments like username,password,etc providing n number of arguments is not advisable  ------------>>>
	//for that we can go with single dimension array as argument
	
	@Test(dataProvider = "datasetfive")
	public void BasicTestfive(String[] s) throws Exception
	{ 
		System.out.println("user data col1 set from data provider -------->> "+ s[0]);
		System.out.println("user data col2 set from data provider -------->> "+ s[1]);
		System.out.println("user data col3 set from data provider -------->> "+ s[2]);
		System.out.println("user data col4 set from data provider -------->> "+ s[3]);
		
		
	}
	
	@DataProvider(indices = {0,4}) 
	public String[][] datasetfive()
	{
		String[][] data = new String[][]  {
			{"userone","passone","studentone","branchone"},
			{"usertwo","passtwo","studenttwo","branchtwo"},
			{"userthree","passthree","studentthree","branchthree"},
			{"userfour","passfour","studentfour","branchfour"},
			{"userfive","passfove","studentfour","branchfour"}
		};
		 
		return data;
	}

	//Example Six :  A jagged array (or irregular 2D array) in TestNG’s @DataProvider means that each test case row can have a different number of parameters.
	

	@Test(dataProvider = "datasetsix")
	public void BasicTestsix(Object[] s) throws Exception
	{ 
		for(int i=0;i<s.length ;i++) 
		{
			System.out.println("jagged array Row "+ s[i]);
		}
		
		System.out.println(" -------->> ");
	
	}
	
	@DataProvider() 
	public Object[][] datasetsix()
	{
		Object[][] data = new Object[][]  {
			{"userone","passone",1234,"branchone"},
			{"usertwo","passtwo","branchtwo"},
			{"userthree","passthree",76543,"branchthree"},
			{"userfour",98765,"branchfour"},
			{"userfive"}
		};
		 
		return data;
	}

	
	// new statement added 06/02
	
	//new line of code
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
