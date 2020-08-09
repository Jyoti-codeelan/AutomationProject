package com.qa.codeElan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.codeElan.Base.BasePage;
import com.qa.codeElan.Utils.ElementUtils;

import io.qameta.allure.Step;

public class TeamLead_Page extends BasePage{
	
public ElementUtils elementUtils;
	
	private By profileIcon = By.xpath("//a[contains(@class,'dropdown-toggle')]");
	private By approvalsDrop = By.xpath("//a[contains(text(),'Approvals')]");
	private By approve = By.xpath("//button[contains(@name,'btnApproveContent')]");
	private By okBtm = By.xpath("//button[contains(@id,'btnApproveConfirm')]");
	
	
	
	public TeamLead_Page(WebDriver driver){
	this.driver = driver;
	elementUtils = new ElementUtils(this.driver);
	}

	@Step("Approve Idea on TeamLead Page.......")
	public void getApprovalOnTeamLeadPage(){
	elementUtils.doClick(profileIcon);
	elementUtils.getMoveElement(approvalsDrop);
		
	}
}
