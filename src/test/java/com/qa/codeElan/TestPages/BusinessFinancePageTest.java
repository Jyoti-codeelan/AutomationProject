package com.qa.codeElan.TestPages;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.codeElan.Utils.JiraPolicy;
import com.qa.codeElan.basetest.BaseTest;
import com.qa.codeElan.pojo.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class BusinessFinancePageTest extends BaseTest{
	
	
public static Logger log = Logger.getLogger(BusinessFinancePageTest.class.getName());
	
	
	@BeforeMethod
	public void BusinessFinancePageLogin(){
	log.info("Enter BF Credentials......");		
	//credentials = new Credentials(prop.getProperty("username_BF"), prop.getProperty("password"));
	Map<String, List<String>> loginData = obj.getLoginData();
	credentials = new Credentials(loginData.get("BusinessFinance").get(10),loginData.get("Level1").get(1));
	homePage = loginPage.getLogin(credentials);
	
	
	
	}
	
	@JiraPolicy(logTicketReady=true)
	@Test(priority=4)
	@Description("Approve quick idea on Business Finance page-----postive test case")
	@Severity(SeverityLevel.CRITICAL)
	public void getApproveIdeaOnBFPageTest(){
	homePage.goToBFPage();
	log.info("Idea Validate By BusinessFinance Page ..........");	
	bfPage.getIdeaValidateOnBFPage();
	}

}
