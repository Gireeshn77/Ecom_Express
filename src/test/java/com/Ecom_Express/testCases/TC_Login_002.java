package com.Ecom_Express.testCases;

import org.testng.annotations.Test;

import com.Ecom_Express.pageObjects.Loginpage;
import com.Ecom_Express.utilities.DBDataProvider;
import com.Ecom_Express.utilities.LoginData;

public class TC_Login_002 extends BaseClass {

	@Test(dataProvider = "agentIds", dataProviderClass = DBDataProvider.class)
	public void DataTest(int agentId) throws Exception {

		LoginData login = getLoginData(agentId);

		System.out.println("Username : " + login.getUsername());
		System.out.println("Password : " + login.getPassword());

		Loginpage lp = new Loginpage(driver);

		lp.setusername(login.getUsername());
		Thread.sleep(3000);
		lp.setpassword(login.getPassword());
		Thread.sleep(3000);
		lp.signin();
		Thread.sleep(3000);
		System.out.println("Login completed");
	}

}
