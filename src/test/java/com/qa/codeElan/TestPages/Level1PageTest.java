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

public class Level1PageTest extends BaseTest{
	
	public static Logger log = Logger.getLogger(Level1PageTest.class.getName());
	
	
	@BeforeMethod
	@Description("Approve quick idea on level1 page-----postive test case")
	@Severity(SeverityLevel.CRITICAL)
	public void level1Login(){
	log.info("Enter Level1 Credentials......");		
	Map<String, List<String>> loginData = obj.getLoginData();
	credentials = new Credentials(loginData.get("Level1").get(2),loginData.get("Level1").get(1));
	homePage = loginPage.getLogin(credentials);
	
	}
	
	@JiraPolicy(logTicketReady=true)
	@Test(priority=2)
	@Description("Approve quick idea on level1 page-----postive test case")
	@Severity(SeverityLevel.CRITICAL)
	public void getApproveIdeaOnLevel1Page(){
	homePage.goToLevel1Page();
	log.info("Idea Approve By Level1 ..........");	
	level1Page.getApproveIdeaOnLevel1Page();
	}

}
