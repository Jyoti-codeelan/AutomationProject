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

public class Level4PageTest extends BaseTest{

public static Logger log = Logger.getLogger(Level4PageTest.class.getName());  
	
	@BeforeMethod
	public void level4PageLogin(){
	log.info("Enter Level4 Credentials......");		
	//credentials = new Credentials(prop.getProperty("username_4"), prop.getProperty("password"));
	Map<String, List<String>> loginData = obj.getLoginData();
	credentials = new Credentials(loginData.get("Level4").get(8),loginData.get("Level4").get(1));
	homePage = loginPage.getLogin(credentials);
	//homePage.goToLevel3Page();
	
	
	}
	
	@JiraPolicy(logTicketReady=true)
	@Test(priority=7,enabled=true)
	@Description("Approve quick idea on Level4  page-----postive test case")
	@Severity(SeverityLevel.CRITICAL)
	public void getApproveLevel4PageTest(){
	homePage.goToLevel3Page();
	log.info("Idea Approve By Level4 Page ..........");	
	level4Page.getInitiateProjectForBreakThrough();
	
	
	}
}
