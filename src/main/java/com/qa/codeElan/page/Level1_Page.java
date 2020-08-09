package com.qa.codeElan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.codeElan.Base.BasePage;
import com.qa.codeElan.Utils.ElementUtils;
import com.qa.codeElan.Utils.JavaScriptUtils;
import com.qa.codeElan.constants.Constants;

import io.qameta.allure.Step;

public class Level1_Page extends BasePage{
	
	public ElementUtils elementUtils;
	public JavaScriptUtils jsu;

	private By notification = By.xpath("//a[contains(@id,'BtnNotification')]");
	private By profileIcon = By.xpath("//li[contains(@class,'drop_profile')]");
	private By approvals = By.xpath("//a[contains(text(),'Approvals')]");
	//private By pendingApprovalList = By.xpath("//a[contains(@class,'partial_link')][1]");
	//private By pendingApprovalList = By.xpath("//a[contains(@title,'idea')]");
	private By approveIdeaDetailing = By.xpath("//button[contains(@title,'Approve the Idea for Detailing')]");
	//private By approveBtm = By.xpath("//div[contains(@id,'pending-tab')]");
	private By okBtm = By.xpath("//button[contains(@id,'btnApproveDetailingConfirm')]");
	
	//  //tbody/tr[1]/td[3]/a[contains(text(),'TestIdea')]
	
	
	public Level1_Page(WebDriver driver){
		this.driver = driver;
		elementUtils =  new ElementUtils(this.driver);
		jsu = new JavaScriptUtils(this.driver);
	}

	
	public void getNotifications(){
		elementUtils.doClick(notification);

	}
	
	public void getClickOnProfileIcone(){
		//elementUtils.doClick(profileIcon);
		//jsu.doclickElementByJS(elementUtils.getElement(profileIcon));
		elementUtils.doMoveToElement(profileIcon);
		elementUtils.getMoveElement(approvals);
		//elementUtils.doClick(approvals);
		}
		
		public void getSelectOnIdeaFromList(){
		getClickOnProfileIcone();
		//elementUtils.doSelectValue(pendingApprovalList, Constants.IDEA_TITLES);
//		String ab = Constants.IDEA_TITLES;
//		String abc = "//a[contains(@title,'"+ab+"')]" ;
//		WebElement el = driver.findElement(By.xpath(abc));
//		el.click();
		
		elementUtils.getDynamicValue(Constants.IDEA_TITLES);
			
		}
		
	
	@Step("Approve in Level1 Page")
	public HomePage getApproveIdeaOnLevel1Page(){
	getSelectOnIdeaFromList();
	elementUtils.doClick(approveIdeaDetailing);
	elementUtils.doClick(okBtm);
		
	return new HomePage(driver);
	}
	
	
}
