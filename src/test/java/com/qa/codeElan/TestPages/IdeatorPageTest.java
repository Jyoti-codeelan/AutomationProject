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
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Epic("----Orient Electric Level1 Module------")
@Feature("UserStory-001:: Define the level1 feature for OEP")

public class IdeatorPageTest extends BaseTest{
	
	public static Logger log = Logger.getLogger(IdeatorPageTest.class.getName());
	
	
	
	@BeforeMethod
	public void ideatorLogin(){
	
	log.info("Enter Ideator Credentials......");	
	//credentials = new Credentials(prop.getProperty("username_ideator"), prop.getProperty("password"));
	Map<String, List<String>> loginData = obj.getLoginData();
	credentials = new Credentials(loginData.get("Ideator").get(0),loginData.get("Ideator").get(1));
	homePage = loginPage.getLogin(credentials);
	
	
	}
	
	@JiraPolicy(logTicketReady=false)
	@Test(priority=1,enabled=true)
	@Description("Add a Quick idea on Ideator Page")
	
	public void getCreateIdeaTest(){
	log.info("Create an idea on ideator page");
	ideatorPage = homePage.goToIdeatorPage();
	ideatorPage.getCreateNewIdea();
	
	}

	@JiraPolicy(logTicketReady=false)
	@Test(priority=3,enabled=true)
	@Description("Convert quick idea into Main idea on Ideator Page")
	@Severity(SeverityLevel.CRITICAL)
	public void getConvertMainIdeaTest(){
	ideatorPage.getConvertToMainIdeaOnIdeatorPage();
		
		
	}
}
