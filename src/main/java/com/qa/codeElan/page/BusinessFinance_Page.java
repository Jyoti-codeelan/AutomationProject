package com.qa.codeElan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.codeElan.Base.BasePage;
import com.qa.codeElan.Utils.ElementUtils;
import com.qa.codeElan.constants.Constants;


public class BusinessFinance_Page extends BasePage{
	
public ElementUtils elementUtils;
	
	private By notification = By.xpath("//div//a[contains(@id,'BtnNotification')]");
	private By profileIcon = By.xpath("//div[contains(@class,'icons-def-prof-img1')]");
	private By approvals = By.xpath("//a[contains(text(),'Approvals')]");
	private By ValidateBtm = By.xpath("//button[contains(@name,'btnValidateContent')]");
	private By typeOfBenefit = By.xpath("//select[contains(@id,'BenefitThreshold')]");
	private By yesBtm = By.xpath("//button[contains(@id,'btnvalidateContentYes')]");
	
	
	
	public BusinessFinance_Page(WebDriver driver){
	this.driver = driver;
	elementUtils =  new ElementUtils(this.driver);
	}

	
	
	public void getSelectOnIdeaFromList(){
		elementUtils.doMoveToElement(profileIcon);
		elementUtils.getMoveElement(approvals);
		}
	
	
	public void getIdeaValidateOnBFPage(){
		elementUtils.waitForElementClickable(notification);
		getSelectOnIdeaFromList();
		elementUtils.getDynamicValue(Constants.IDEA_TITLES);
		elementUtils.doClick(ValidateBtm);
		elementUtils.doClick(typeOfBenefit);
		elementUtils.selectValueFromDropDown(typeOfBenefit,Constants.IDEA_DESCRIPTION);
		elementUtils.doClick(yesBtm);
	}

}
