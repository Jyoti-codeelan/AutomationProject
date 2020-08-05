package com.qa.codeElan.listeners;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.codeElan.Utils.ExcelUtils;
import com.qa.codeElan.Utils.JiraPolicy;
import com.qa.codeElan.Utils.JiraServiceProvider;

public class TestJiraListener implements ITestListener {
	
	
	Map<String, String> configData ;
	public static final String CONFIG_DATA_SHEET = "ConfigData_Sheet";
	public ExcelUtils obj;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		obj = new ExcelUtils();
     	configData = obj.getData(CONFIG_DATA_SHEET);

		JiraPolicy jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		boolean isTicketReady = jiraPolicy.logTicketReady();
		if (isTicketReady) {
			// raise jira ticket:
			System.out.println("is ticket ready for JIRA: " + isTicketReady);
			
			JiraServiceProvider jiraSp = new JiraServiceProvider(configData.get("JiraUrl"),
					configData.get("UserName"), configData.get("Password"),configData.get("ProjectName"));
			
//			JiraServiceProvider jiraSp = new JiraServiceProvider("https://dasjyoti.atlassian.net/",
//					"jyotid@codeelan.com", "kNjA5NXg7CDfFlVvut5g4BF7", "COD");
//			
			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()
					+ "got failed due to some assertion or exception";
			String issueDescription = result.getThrowable().getMessage() + "\n";
			issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));

			jiraSp.createJiraTicket("Bug", issueSummary, issueDescription, "CodeElan");
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
