package com.qa.codeElan.Base;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.codeElan.Utils.ExcelUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static Logger log = Logger.getLogger(BasePage.class.getName());
	public WebDriver driver;
	
	
public static final String CONFIG_DATA_SHEET = "ConfigData_Sheet";
	
	
	Map<String, String> configData ;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	
	
	public WebDriver initialize_driver(ExcelUtils obj){	
		obj = new ExcelUtils();
		configData = obj.getData(CONFIG_DATA_SHEET);
		log.info("driver intialize..........");
		String browserName = configData.get("Browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();

			log.info("Lunch Chrome Browser...........");
			//driver = new ChromeDriver();
			tldriver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			log.info("Lunch Firefox Browser...........");
			//driver=new FirefoxDriver();
			tldriver.set(new FirefoxDriver());
			
		}
		else {
			System.out.println("Browser"+browserName+"is not defined in properites file,please give "
					+ "the correct browse nane");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		//getDriver().get(prop.getProperty("URL"));
		getDriver().get(configData.get("URL"));
		//TimeUtil.mediumWait();
		return getDriver();
	}




	
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path= System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		}
		catch(IOException e) {
			
			System.out.println("Capture Failed"+e.getMessage());
		}
		
		return path;
	}
	
}
