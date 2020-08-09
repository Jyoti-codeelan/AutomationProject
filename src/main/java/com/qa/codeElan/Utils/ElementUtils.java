package com.qa.codeElan.Utils;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.codeElan.Base.BasePage;

public class ElementUtils extends BasePage{
	
	WebDriver driver;
	WebElement element;
	List<WebElement> elements;
	WebDriverWait wait;
	Properties prop;
	Actions action;
	

	/************** ElementUtils Constructor *****************/
	public ElementUtils(WebDriver driver){
		//prop = super.prop;
		this.driver = driver;
		action = new Actions(this.driver);
	}
	
	/************* Get Element using getElement Method  ****************/
	
	public WebElement getElement(By locator){
		waitForElementPresent(locator);
		 element = null;

		try {
			element = driver.findElement(locator);
			
			
		} catch (Exception e) {
			System.out.println("some exception occurred while creating the element " + locator+" "+e.getMessage());
			
		}
		return element;
		
	}
	
	/*****************  Get Elements Using GetElements Method ******************/
	
	public List<WebElement> getElements(By locator){
		elements = driver.findElements(locator);
		
		return elements;
		
	}
	
	/**
	 * @implicit wait for Element Present
	 * @param locator
	 */
	
	public void waitForElementPresent(By locator){
	WebDriverWait wait=new WebDriverWait(driver,60);
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(Exception e) {
			System.out.println("some exception occurred while waiting for the element"+locator.toString());
		}
     }
	
	
	/**
	 * @@ doEntermAmount method is for enter no.of Elements on by one
	 * @param locator
	 * @param value
	 */
	
	public void doEnterAmount(By locator,String value){
		waitForElementPresent(locator);
		getElements(locator);
		//System.out.println(elements.size());
		for(int i=0;i<elements.size();i++){
			
			elements.get(i).sendKeys(value);
		}
		
	}
	
	/**
	 * @@doSendkeys method is use for :: Sendkeys 
	 * @param locator
	 * @param value
	 */
	
	public void doSendKeys(By locator, String value) {
		try {
			waitForElementVisible(locator);
			getElement(locator).clear();
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception occurred while sending the key on the element " + locator);
			e.printStackTrace();
		}
	}
  
	
	/**
	 * @@ doClick method is used for :: click Element
	 * @param locator
	 */
	
	public void doClick(By locator) {
	  waitForElementClickable(locator);
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception occurred while clicking on the element " + locator);
			e.printStackTrace();
		}
	}
	
	/**
	 * @@ Implicit wait is used for Element Click
	 * @param locator
	 */
	
	public void waitForElementClickable(By locator) {
		wait = new WebDriverWait(driver,70);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	public void waitForElementVisible(By locator) {
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	
	}
	
	/**
	 * @@ This method is used for Select the value From Drop Down
	 * @param locator
	 * @param text
	 * @return
	 */
	
	 public String selectValueFromDropDown(By locator,String text) {
	  waitForElementVisible(locator) ;
   	  element=driver.findElement(locator);
   	  Select select= new Select(element);
   	  select.selectByVisibleText(text);
   	 // return select.getFirstSelectedOption().getText();
   	  return text;
     }
	
	
	 
	 /**
	  * This method is used for select the elements from drop down one by one & match the element
	  * @param locator
	  * @param text
	  */
	 
	 public void selectValueFromSearchDropBox(By locator,String text){
		 TimeUtil.mediumWait();
		 waitForElementPresent(locator) ;
		List<WebElement> list = driver.findElements(locator);
		System.out.println(list.size());
		   
		   for(int i=0;i<list.size();i++){
			   System.out.println(list.get(i).getText());
			   if(list.get(i).getText().contains(text)){
				   list.get(i).click();
				   break;
			   }
		   }
		}
	 
	
	/************** Do click No.of Elements **************/ 
	 
	 public void getClickAllElement(By locator,By locators){
		 getElements(locator);
		 System.out.println(elements.size());
		 for(int i=0;i<elements.size();i++){
				
			elements.get(i).click();
			Actions action = new Actions(driver);
		    //action.moveToElement(driver.findElement(locator)).build().perform();
		    action.moveToElement(getElement(locators)).click().build().perform();
		 }
	 }
		 

	 
	 
	 
	 public void getClickOnElements(By locator,String text){
		 waitForElementClickable(locator) ;
		 getElements(locator);
		 for(int i=0;i<elements.size();i++){
			   System.out.println(elements.get(i).getText());
			   if(elements.get(i).getText().contains(text)){
				   elements.get(i).click();
				   break;
			   }
		   }
		 
	 }
	 
	 
	 
	 
	 
	/******************  Current Date Method *********************/ 
	 
	 public String getCurrentDay (){
//		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//	        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
//	        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
//	        System.out.println("Today Int: " + todayInt +"\n");
//	        String todayStr = Integer.toString(todayInt);
//	        System.out.println("Today Str: " + todayStr + "\n");
//	        
	       
		 Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		 int todayInt = calendar.get(Calendar.DATE);
		 System.out.println("Today Int: " + todayInt +"\n");
		 
		 String todayStr = Integer.toString(todayInt);
	     System.out.println("Today Str: " + todayStr + "\n");
		 
		 
	        return todayStr;
	    }
	 
	 public String getfutureDate(){
		 
		 Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		 //int day = calendar.get(calendar.DATE);
		 //int days = calendar.get(Calendar.DATE);
		 
		 int futureday = calendar.get(Calendar.DATE)+1;
		
		 
		 
//	     System.out.println("Afater 3 day ,date will be ::"+days);
//	     String futureDayStr = Integer.toString(days);
	     
	     System.out.println("Future Day Str::"+futureday);
	     
	     
	     
	    
	     String futureDay = Integer.toString(futureday);
	   
	     
	    return futureDay;
	    
	     
	    
	 }
	
	/**************  Select Date from Calendar ***************/  
	 
	 public void datePickerTest() {
		
	    
		 try{
		   
	       String today = getCurrentDay();
	      
	       System.out.println(today);
	       String future = getfutureDate();
	       System.out.println(future);
	    
	      
	        System.out.println("Today's number: " + today + "\n");  
	        
	       
	        
	        WebElement todaydate=driver.findElement(By.xpath("(//td[contains(text(),'"+today+"')])[1]"));
	        todaydate.click();
	        WebElement futuredate=driver.findElement(By.xpath("(//td[contains(text(),'"+future+"')])[1]"));
	        futuredate.click();
	        
	        
//	        WebElement todaydate = getElement(locator[0]);
//			todaydate.click();
//			 
//			 WebElement futuredate = getElement(locator[1]);
//			 futuredate.click();
	      
	      
		 }
		 catch(Exception e ){}

	           
	 }
	
	       
	 
	 
/***************** Select Date From Calendar using System Date **********************/
	 
	 public void doSelectSystemDate(By locator) {

		 try{
//		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		  
//		  Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
//		 // Calendar calendar = Calendar.getInstance();
//		  int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
//		  System.out.println("Today Int: " + todayInt +"\n");
//		  
//		  String todayDate = sdf.format(calendar.getTime());
//		  System.out.println(todayDate);
			 
			 String today = getCurrentDay();
			 WebElement todaydate=driver.findElement(By.xpath("//a[contains(text(),'"+today+"')]"));
		     todaydate.click();
		     WebElement futuredate=driver.findElement(By.xpath("//a[contains(text(),'"+today+"')]"));
		     futuredate.click();
		 }
		 catch(Exception e){
			 
		 }
		
		      //a[contains(text(),'"+today+"')]
		 
//		 String today = getCurrentDay();
//		 WebElement date = getElement(locator[0]);
//		 List<WebElement> columns = date.findElements(locator[0]);
//		 
//		 for (WebElement cell: columns) {
//		 if (cell.getText().equals(today)) {
//		    cell.click();
//		             
//		   }
//		    else{
//		     System.out.println("Element is not selected"); 
//		      }
//		 	
//		 }
	 }
 
	 
	 public void switchToWindow(){
		  
	Set<String> handles=driver.getWindowHandles();
	Iterator<String> it=handles.iterator();
	String parentWindow=it.next();
			
	String childWindowID=it.next();
	driver.switchTo().window(childWindowID);
			
	  }
	 
	/****************  Select Random Date From Calendar ***************/ 
	 
	 public void selectDateFromCalendr(By locator,String dateValue) {
  
	   getElements(locator);
   	  if (Integer.parseInt(dateValue) < 1 || Integer.parseInt(dateValue) > 31) {
   		  
   		
   		 
   		  System.out.println("Date value is Invalid" +dateValue);
             //log.info("Date Value is Invalid " + dateValue);
             return;
         } else {
             //log.info("Selecting a value in Calendar");
       	  System.out.println("Selecting Value in Calendar");
             for (int date = 0; date < elements.size(); date++) {
                 if (elements.get(date).getText().equalsIgnoreCase(dateValue)) {
                     elements.get(date).click();
                     break;
                 }
             }
         }
	  
	        
    }
	 
	
	
	 /****************** Move To Element *****************************/
	 public void doMoveToElement(By locator){
	 action.moveToElement(getElement(locator)).build().perform();

	}
	 
	 
	 public void doSelectValue(By locator,String name){
		 getElements(locator);
		 for(int i=0;i<elements.size();i++){
			 if(elements.get(i).getText().equals(name)){
				 elements.get(i).click();
			 }
		 }
	 }
	 
	 
	 public void getMoveElement(By locator)
	 {
		 waitForElementVisible(locator);
	     
	     Actions actions = new Actions(driver);
	     actions.moveToElement(getElement(locator)).perform();
	     actions.moveToElement(getElement(locator)).click().perform();
	 }
	 
	 
	
	 
	 public void getDynamicValue(String dynamicUser){
		 
		 //String dynamicUser = "test";
		// String dynamicText = "//div[contains(@title,"+dynamicUser+"')]";
		 
		//String dynamicText = getElement(locator)+ dynamicUser ;
		
		//WebElement user1 = driver.findElement(By.xpath("//div[contains(@title,'test')]"));
		
		// WebElement user2 = driver.findElement(By.xpath(dynamicText));
		 
		// element = getElement(locator);
		 
		 
		   // dynamicUser = Constants.IDEA_TITLES;
			String textValue = "//a[contains(@title,'"+dynamicUser+"')]" ;
		   //String textValue = getElement();
		 
			element = driver.findElement(By.xpath(textValue));
			
			element.click();
	 }
	 
	 
	 
	 
	 public void getStartDate(By locator) {
			
		 waitForElementVisible(locator) ;
		 try{
		   
	       String today = getCurrentDay();
	      
	      
	      
	        System.out.println("Today's is :: " + today + "\n");  
	        
	        
	        
	        
	        WebElement todaydate = driver.findElement(By.xpath("(//td[contains(text(),'"+today+"')])[1]"));
	        todaydate.click();
	        
//	        WebElement todaydate = getElement(locator[0]);
//			todaydate.click();
//			 
//			 WebElement futuredate = getElement(locator[1]);
//			 futuredate.click();
	      
	      
		 }
		 
		 
		 
		 
		 catch(Exception e ){}

	           
	 }
	
	       
	 
	 
	 public void getEndDate(By locator) {
		 waitForElementVisible(locator) ;
		    
		 try{
		   TimeUtil.mediumWait();
	       
	      
	       String future = getfutureDate();
	      
	        
	        
	        System.out.println("Future day's is :: " + future + "\n");  
	        
	        
	       
	        WebElement futuredate=driver.findElement(By.xpath("(//td[contains(text(),'"+future+"')])[1]"));
	        futuredate.click();
	        
	        
//	        WebElement todaydate = getElement(locator[0]);
//			todaydate.click();
//			 
//			 WebElement futuredate = getElement(locator[1]);
//			 futuredate.click();
	      
	      
		 }
		 
		 
		 
		 
		 catch(Exception e ){}

	           
	 }
	
	       
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
