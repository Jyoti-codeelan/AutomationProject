package com.qa.codeElan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.codeElan.Base.BasePage;
import com.qa.codeElan.Utils.ElementUtils;

import io.qameta.allure.Step;

public class Level3_Page extends BasePage{

public ElementUtils elementUtils;
	
	//private By notification = By.xpath("//a[contains(@id,'BtnNotification')]");
	//private By IdeaName = By.xpath("//table/tbody/tr[1]/td[3]/a[contains(text(),'TestIdea')]");
	private By profileIcon = By.xpath("//a[contains(@class,'dropdown-toggle')]");
	private By approvalsDrop = By.xpath("//a[contains(text(),'Approvals')]");
	private By approve = By.xpath("//button[contains(@name,'btnApproveContent')]");
	private By oKBtm = By.xpath("//button[contains(@id,'btnApproveConfirm')]");
	private By implementationStartDate = By.xpath("//input[contains(@id,'ImplementationStartDate')]");
	private By impTable = By.xpath("//div[@id='ui-datepicker-div']/table/tbody");
	private By impDate = By.tagName("td");
	private By implementationEndDate = By.xpath("//input[contains(@id,'ImplementationCompletionDate')]");
	private By initiateProjectBtm = By.xpath("//button[contains(@class,'button col-md-3')]");
	private By IMN = By.xpath("//a[contains(@class,'themetxt')]");
	
	
	
	public Level3_Page(WebDriver driver){
	this.driver = driver;
	elementUtils =  new ElementUtils(this.driver);
	}

	@Step("Level3 Page Approve")
	public void getIdeaApproveOnLevel3Page(){
	
	elementUtils.doMoveToElement(profileIcon);
	elementUtils.getMoveElement(approvalsDrop);
	elementUtils.doClick(approve);
	elementUtils.doClick(oKBtm);
	
	}
	
	public void getClickOnInitiateProject(){
	elementUtils.doClick(initiateProjectBtm);	
	}
	
	public void getClickOnImpleStartDate(){
		By[] values = {impDate};
		//elementUtils.doSelectSystemDate(values);
	}
	
	public void getInitiateProject(){	
	elementUtils.doClick(implementationStartDate);	
	elementUtils.doSelectSystemDate(impDate);
	elementUtils.doClick(implementationEndDate);
	elementUtils.doSelectSystemDate(impDate);
	
	elementUtils.doClick(IMN);
		
	}
	 
}
