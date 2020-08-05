package com.qa.codeElan.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.codeElan.Base.BasePage;
import com.qa.codeElan.Utils.ElementUtils;
import com.qa.codeElan.Utils.ExcelUtils;
import com.qa.codeElan.Utils.TimeUtil;
import com.qa.codeElan.page.BusinessFinance_Page;
import com.qa.codeElan.page.HomePage;
import com.qa.codeElan.page.Ideator_Page;
import com.qa.codeElan.page.Level1_Page;
import com.qa.codeElan.page.Level2_Page;
import com.qa.codeElan.page.Level3_Page;
import com.qa.codeElan.page.Level4_Page;
import com.qa.codeElan.page.LoginPage;
import com.qa.codeElan.pojo.Credentials;

public class BaseTest {

	
	public BasePage basePage;
	

	public WebDriver driver;
	public LoginPage loginPage;
	public ElementUtils elementutils;
	public HomePage homePage;
	public Credentials credentials;
	public Ideator_Page ideatorPage;
	public Level1_Page level1Page;
	public BusinessFinance_Page bfPage;
	public Level2_Page level2Page;
	public Level3_Page level3Page;
	public Level4_Page level4Page;
	public ExcelUtils obj;
	//public Map<String, List<String>> loginData ;
	
	@BeforeMethod
	//@Parameters(value= {"browser"})
	//public void setUp(String browserName){
	  public void setUp(){
		basePage = new BasePage();
	
		obj = new ExcelUtils();
		driver = basePage.initialize_driver(obj);
		elementutils = new ElementUtils(driver);
		loginPage = new LoginPage(driver);
		ideatorPage = new Ideator_Page(driver);
		level1Page = new Level1_Page(driver);
		bfPage = new BusinessFinance_Page(driver);
		level2Page = new Level2_Page(driver);
		level3Page = new Level3_Page(driver);
		level4Page = new Level4_Page(driver);

		//credentials = new Credentials(prop.getProperty("username_1"), prop.getProperty("password_1"));
		
		
	}
	
	
	@AfterMethod
	public  void quit(ITestResult result ) {
	TimeUtil.mediumWait();
//	if(result.getStatus()==ITestResult.FAILURE){
//		SendingEmailUtil.getMail();	
//	}
	
	
	 if(driver!=null) {
		driver.quit();
			}

	
	}
	
	
}
