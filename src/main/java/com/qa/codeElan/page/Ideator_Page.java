package com.qa.codeElan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.codeElan.Base.BasePage;
import com.qa.codeElan.Utils.ElementUtils;
import com.qa.codeElan.constants.Constants;


import io.qameta.allure.Step;

public class Ideator_Page extends BasePage{
	
	public ElementUtils elementUtils;
	//public JavaScriptUtils jsu;
	
	By Employee_Number = By.id("Username");
	By Password = By.id("Password");
	By Login = By.id("btnLogin");

	private By AddQuickIdea = By.xpath("//button[contains(text(),'Add a Quick Idea')]");
	private By ideaTitle = By.xpath("//input[contains(@id,'html_id_title')]");
	private By ideaBriefDescription = By.id("html_id_briefdescription");
	private By category = By.xpath("//select[contains(@id,'html_id_category')]");
	private By division = By.xpath("//select[contains(@id,'html_id_division')]");
	private By subCategory = By.xpath("//select[contains(@id,'html_id_subcategory')]");
	private By department = By.xpath("//select[contains(@id,'html_id_department')]");
	private By save = By.name("btnSaveAsDraftContentForm");
	private By cancel = By.name("btnCancelContentForm");
	private By notification = By.id("BtnNotification");
	private By profileIcon = By.xpath("//a[contains(@class,'dropdown-toggle')]");
	private By approvals = By.xpath("//a[contains(text(),'Approvals')]");
	private By pending = By.xpath("//div[contains(@class,'timelinediv')]");
	
	private By ideaName = By.xpath("//tbody/tr[1]/td[3]/a[contains(text(),'TestIdea')]");
	private By convertMainIdea = By.xpath("//input[contains(@value,'Convert to Main Idea')]");
	private By ideaDescription =  By.xpath("//textarea[contains(@id,'html_id_description')]");
	private By costImpe = By.xpath("//input[contains(@id,'HtmlId_CostOfImplementation')]");
	private By otherResources = By.xpath("//textarea[contains(@id,'html_id_other_resources')]");
	private By costBenefit_costSaving = By.xpath("//label[contains(text(),'Estimated annualized cost saving')]");
	private By costBenefit_revenueGeneration = By.xpath("//label[contains(text(),'Estimated annualized revenue generation')]");
	private By logic = By.xpath("//textarea[contains(@id,'html_id_logic')]");
	private By proposedTeamLead = By.xpath("//input[contains(@id,'html_id_team_leadInput')]");
	private By propTeamLeadDropBox = By.xpath("//div[contains(@id,'html_id_team_leadList')]");
	private By teamMembers = By.xpath("//input[contains(@id,'html_id_23Input')]");
	private By teamMembersDropBox = By.xpath("//div[@id='html_id_23List']");
	private By impTimeLine = By.xpath("//input[contains(@id,'project_estimated_startendate_id')]");
	//private By todayDate = By.xpath("(//td[contains(text(),'"+today+"')])[1]");
	private By CalTabel = By.xpath("//div[@class='daterangepicker ltr show-calendar opensright']//td");
	private By columns = By.tagName("tr");
	private By futureDate = By.xpath("");
	private By benefitMonth = By.xpath("//input[contains(@class,'monthdatepicker hasDatepicker')]");
	private By benifitAmount = By.xpath("//input[contains(@id,'HtmlId_BenefitDate_Amount')]");
	private By submit = By.xpath("//input[contains(@name,'btnPostContentForm')]");
	private By costBenefttAmount = By.xpath("//input[contains(@id,'HtmlId_cost_benefit_amount')]");
	private By BM = By.xpath("//input[@class='monthdatepicker hasDatepicker'][1]");
	private By MonthBenefit = By.xpath("//table/tbody/tr/td/a[contains(text(),'1')]");
	private By applyBtm = By.xpath("//button[contains(text(),'Apply')]");
	private By dropdownpropTeamLead = By.xpath("//*[@id='html_id_team_leadList']/div[1]");
	private By dropdownteamMembers = By.xpath("//*[@id='html_id_23List']/div[3]/div/div[3]");
	
	
	
	public Ideator_Page(WebDriver driver){
	this.driver = driver;
	elementUtils = new ElementUtils(this.driver);
	//jsu = new JavaScriptUtils(this.driver);
	}
	
	
	public void getClickOnAddQuickIdea(){
		elementUtils.doClick(AddQuickIdea);	
		
	}
	
	@Step("Create an Quick Idea on Ideator Page.........")
	public Level1_Page getCreateNewIdea(){
		getClickOnAddQuickIdea();
		elementUtils.doSendKeys(ideaTitle, Constants.IDEA_TITLES);
		elementUtils.doSendKeys(ideaBriefDescription, Constants.IDEA_BRIEF_DESCRIPTION);
		elementUtils.selectValueFromDropDown(category, Constants.CATEGORY);
		elementUtils.selectValueFromDropDown(division, Constants.DIVISION);
		elementUtils.selectValueFromDropDown(subCategory, Constants.SUBCATEGORY);
		elementUtils.selectValueFromDropDown(department, Constants.DEPARTMENT);
		elementUtils.doClick(save);
		
		return new Level1_Page(driver);
	}
	
	public void getClickOnNotification(){
	elementUtils.doClick(notification);
	
	
	}
	
	public void getClickOnIdeaOnIdeatorPage(){
	getClickOnNotification();
	elementUtils.doClick(ideaName);
		
	}
	
	public void getClickOnConvertMainIdeaOnIdeatorPage(){
	getClickOnIdeaOnIdeatorPage();
	elementUtils.doClick(convertMainIdea);
	}
	
	
	public void getSelectTeamsName(){	
//	jsu.scrollIntoView(elementUtils.getElement(proposedTeamLead));
	
	elementUtils.doSendKeys(proposedTeamLead, Constants.TEAM);	
	//elementUtils.getMoveElement(propTeamLeadDropBox);
	//elementUtils.getClickOnElements(propTeamLeadDropBox, Constants.TEAMLEADNAME);
	elementUtils.doClick(dropdownpropTeamLead);
	elementUtils.doSendKeys(teamMembers, Constants.TEAM);
	//elementUtils.selectValueFromSearchDropBox(teamMembersDropBox, Constants.TEAMMEMBER);
	elementUtils.doClick(dropdownteamMembers);
	}
	
	public void getSelectCalendarDate(){
		
	//	By[] cloumn = {CalTabel} ;
		elementUtils.datePickerTest();
		//elementUtils.doClick(applyBtm);
		
	}
	
	@Step("Convet Quick Idea in to Main Idea......")
	public void getConvertToMainIdeaOnIdeatorPage(){
		
	getClickOnConvertMainIdeaOnIdeatorPage();
	
	elementUtils.doSendKeys(ideaDescription, Constants.IDEA_DESCRIPTION);
	elementUtils.doSendKeys(costImpe, Constants.COI_level4);
		//elementUtils.doSendKeys(otherResources,Constants.);
	elementUtils.doClick(costBenefit_costSaving);
	elementUtils.doSendKeys(costBenefttAmount, Constants.CBA_Rev);
	elementUtils.doSendKeys(logic,Constants.LOGIC);
	getSelectTeamsName();
	
	//elementUtils.doSendKeys(proposedTeamLead, Constants.TEAMLEADNAME);
	//elementUtils.doSendKeys(teamMembers, Constants.TEAMMEMBER);
	elementUtils.doClick(impTimeLine);
	getSelectCalendarDate();
	
		//elementUtils.getSelectDateFromCalendar(locator);
	//jsu.scrollIntoView(elementUtils.getElement(MonthBenefit));
	//jsu.scrollPageDown();
	//elementUtils.getClickAllElement(BM, MonthBenefit);
	
	elementUtils.doClick(BM);
	elementUtils.doClick(MonthBenefit);
	
	//elementUtils.getClicOnElements(BM, MonthBenefit);
	//jsu.scrollIntoView(elementUtils.getElement(benifitAmount));
	
	elementUtils.doEnterAmount(benifitAmount,Constants.BA);
		
	elementUtils.doClick(submit);
		
		
		
	}
	
	
	
	
	
	
}
