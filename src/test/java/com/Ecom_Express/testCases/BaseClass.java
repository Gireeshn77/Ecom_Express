package com.Ecom_Express.testCases;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Ecom_Express.utilities.EmployeeData;
import com.Ecom_Express.utilities.LoginData;
import com.Ecom_Express.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
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
	public void setup() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get(baseUrl);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public void takeScreenshot(String tname) throws IOException {

		TakesScreenshot shot = (TakesScreenshot) driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		sdf = new SimpleDateFormat("dd-MM-YYYY,HH.mm.ss");
		date = new Date();
		dateformat = sdf.format(date);
		Repname = tname + dateformat + ".png";
		File dst = new File("C:\\Users\\ngire\\eclipse-workspace\\Delivery\\Screenshots" + Repname);
		FileUtils.copyFile(src, dst);

		System.out.println("Screenshot taken");
	}

	public void getSQLData1() throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "Admin123");
		Statement stmt = con.createStatement();
		String s = "select employee_id,first_name,last_name from employees";

		ResultSet rs = stmt.executeQuery(s);
		while (rs.next()) {
			int eid = rs.getInt("EMPLOYEE_ID");
			String fname = rs.getString("FIRST_NAME");
			String lname = rs.getString("LAST_NAME");

			System.out.println(eid + " " + fname + " " + lname);
		}

		con.close();
		System.out.println("Query Executed .!");
	}

	public EmployeeData getSQLData() throws SQLException {

		EmployeeData emp = null;

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "Admin123");

		String query = "select employee_id,first_name,last_name " + "from employees where employee_id=?";

		PreparedStatement pstmt = con.prepareStatement(query);

		pstmt.setInt(1, 102);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {

			int eid = rs.getInt("employee_id");
			String fname = rs.getString("first_name");
			String lname = rs.getString("last_name");

			emp = new EmployeeData(eid, fname, lname);
		}

		rs.close();
		pstmt.close();
		con.close();

		return emp;
	}

	public LoginData getLoginData(int agentId) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		LoginData loginData = null;

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin", "root", "Admin123");

		String query = "select username,passwd from LoginCredentilas where Agent_id=?";

		PreparedStatement pstmt = con.prepareStatement(query);

		pstmt.setInt(1, agentId);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {

			String uname = rs.getString("username");
			String pwd = rs.getString("passwd");

			loginData = new LoginData(uname, pwd);
		}

		rs.close();
		pstmt.close();
		con.close();

		return loginData;
	}

}
