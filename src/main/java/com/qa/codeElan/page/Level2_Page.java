package com.qa.codeElan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.codeElan.Base.BasePage;
import com.qa.codeElan.Utils.ElementUtils;

import io.qameta.allure.Step;

public class Level2_Page extends BasePage{
	
	public ElementUtils elementUtils;
	
	private By notification = By.xpath("//a[contains(@id,'BtnNotification')]");
	private By profileIcon = By.xpath("//a[contains(@class,'dropdown-toggle')]");
	private By approvalsDrop = By.xpath("//a[contains(text(),'Approvals')]");
	private By approve = By.xpath("//button[contains(@name,'btnApproveContent')]");
	private By IdeaName = By.xpath("//table/tbody/tr[1]/td[3]/a[contains(text(),'TestIdea')]");
	private By approveBtm = By.xpath("//button[contains(@name,'btnApproveContent')]");
	private By oKBtm = By.xpath("//button[contains(@id,'btnApproveConfirm')]");
	
	
	
	public Level2_Page(WebDriver driver){
	this.driver = driver;
	elementUtils =  new ElementUtils(this.driver);
	}

	@Step("Level2 Page Approve")
	public void getIdeaValidateOnLevel2Page(){
	elementUtils.doMoveToElement(profileIcon);
	elementUtils.getMoveElement(approvalsDrop);
		
	elementUtils.doClick(approve);
	elementUtils.doClick(oKBtm);
	}
	
}
