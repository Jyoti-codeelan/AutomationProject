package com.qa.codeElan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.codeElan.Base.BasePage;
import com.qa.codeElan.Utils.ElementUtils;

import io.qameta.allure.Step;

public class Level4_Page extends BasePage{
	
	public ElementUtils elementUtils;
	
	private By profileIcon = By.xpath("//a[contains(@class,'dropdown-toggle')]");
	private By approvalsDrop = By.xpath("//a[contains(text(),'Approvals')]");
	private By approve = By.xpath("//button[contains(@name,'btnApproveContent')]");
	private By okBtm = By.xpath("//button[contains(@id,'btnApproveConfirm')]");
	private By implementationStartDate = By.xpath("//input[contains(@id,'ImplementationStartDate')]");
	private By impTable = By.xpath("//div[@id='ui-datepicker-div']/table/tbody");
	private By implementationEndDate = By.xpath("//input[contains(@id,'ImplementationCompletionDate')]");
	private By initiateProjectBtm = By.xpath("//button[contains(text(),'Initiate Project')]");
	
	public Level4_Page(WebDriver driver){
	this.driver = driver;
	elementUtils = new ElementUtils(this.driver);
	}

	@Step("Level4 Page Approve")
	public void getIdeaApproveOnLevel4Page(){
		elementUtils.doMoveToElement(profileIcon);
		elementUtils.getMoveElement(approvalsDrop);
		elementUtils.doClick(approve);
		elementUtils.doClick(okBtm);
		
		}
	
	public void getDate(){
		elementUtils.doClick(implementationStartDate);
		elementUtils.getCurrentDay();
		elementUtils.doClick(implementationEndDate);
		elementUtils.getCurrentDay();
	}
	
	public void getInitiateProjectForBreakThrough(){
		getIdeaApproveOnLevel4Page();
//		elementUtils.doClick(implementationStartDate);	
//		elementUtils.getStartDate(impTable);
//		elementUtils.doClick(implementationEndDate);
//		elementUtils.getStartDate(impTable);
		
		getDate();
		elementUtils.doClick(initiateProjectBtm);
		
		
			
		}
	
}
