package bw_dd_testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bw_dd_core.Page;
import bw_dd_util.TestUtil;

public class AdminSanity {
	/*
	 * Out Put 
	 *  script verifies navigation issues at left menu of Sales Module
	 *  script Identified navigation(404) issues 
	 *  Script  verifies Left Menu access to user
	 */
@BeforeTest
public void isSkip()
{
		
	if(!TestUtil.isExecutable("AdminSanity"))
	{
			
		throw new SkipException("Skipping the test as the Run mode is No");
			
	}
		
}
	
//Login functioanlity
@Test(priority=1)
public void login() throws IOException
{
	
	try
	{
	System.out.println("\nTest_case 1: Login Functionality Sanity Begins ");
	
	Page.findelement("SubmitaRelease_x").click();
	Page.findelement("emailId_x").sendKeys(Page.config.getProperty("Su_account_email"));
	Page.findelement("signin_x").click();
	Page.findelement("password_x").sendKeys(Page.config.getProperty("Su_account_pwd"));
	Page.findelement("loginbutton_x").click();
	
	System.out.println("Login functionality verified sucessfully");
	}
	catch(Exception e)
	{
	
		System.out.println("Login Functionality fails due to exception = " + e );
		Assert.fail();
	}
	
}


//Account dashboard
@Test (priority=2)
public void AdminDashboard() throws IOException
{
	try{
		System.out.println("\nTest_case 2: Superadmin Dashboard sanity Begins ");
		WebElement suadmin_dashboard=Page.findelement("Su_Adminmain_menux");
		WebElement su_dashboard= Page.findelement("Su_Dashboard_x");
		
		suadmin_dashboard.click();
		Page.wait.until(ExpectedConditions.visibilityOf(su_dashboard)).click();
		//su_dashboard.click();
		
/*Actions a= new Actions(Page.driver);
		
		Action series= a
				.moveToElement(suadmin_dashboard)
				.click()
				.moveToElement(su_dashboard)
				.click()
				.build();
		series.perform();
		*/
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Su_dashboard_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String dashboardLabel= Page.findelement("Su_Dashboard_Label_x").getText();
		
		if(dashboardLabel.equals(Page.or.getProperty("Su_Dashboard_Label")))
		{
			System.out.println("Superadmin Dashboard URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("Su_Dashboard_Label"));
			Assert.fail();
		}
	}
	
	else
	{
		
		System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl() );
		Assert.fail();
	}
	
	//More account dashboard verification
	}
	catch(Exception e)
	{
		
		System.out.println("Superadmin Dashboard menu Functionality fails due to exception = " + e);
		Assert.fail();
	}
}

//Account dashboard
@Test (priority=3)
public void Createaccount() throws IOException
{
	try{
		System.out.println("\nTest_case 3: Create Account sanity Begins ");
		//WebElement suadmin_dashboard=Page.findelement("Su_Adminmain_menux");
		WebElement su_Createaccount= Page.findelement("Su_Createaccount_x");
		
		Page.wait.until(ExpectedConditions.visibilityOf(su_Createaccount)).click();
		
/*Actions a= new Actions(Page.driver);
		
		Action series= a
				.moveToElement(suadmin_dashboard)
				.click()
				.moveToElement(su_Createaccount)
				.click()
				.build();
		series.perform();*/
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Su_Createaccount_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String dashboardLabel= Page.findelement("Su_Createaccount_Label_x").getText();
		
		if(dashboardLabel.equals(Page.or.getProperty("Su_Createaccount_Label")))
		{
			System.out.println("Create account  verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("Su_Createaccount_Label"));
			Assert.fail();
		}
	}
	
	else
	{
		
		System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl() );
		Assert.fail();
	}
	
	//More account dashboard verification
	}
	catch(Exception e)
	{
		
		System.out.println("Create account menu Functionality fails due to exception = " + e);
		Assert.fail();
	}
}

//Logout functionality
@AfterTest
	public void logout() throws IOException
	{
	try
	{	
		System.out.println("\nTest_case 4: Logout method");
		WebElement Logoutdropdown=Page.findelement("Logoutdropdown_menux");
		WebElement logout= Page.findelement("Logout_x");
		
		Actions a= new Actions(Page.driver);
		
		Action series= a
				.moveToElement(Logoutdropdown)
				.click()
				.moveToElement(logout)
				.click()
				.build();
		series.perform();
					
		if(Page.driver.getCurrentUrl().equals(Page.or.getProperty("Home_Logout_url")))
		{
			System.out.println("Login functionality verified sucessfully: " + Page.driver.getCurrentUrl());
			Thread.sleep(3000);	
		}
	}
	catch(Exception e)
	{
		
		System.out.println("Login Functionality fails due to exception = " + e );
		Assert.fail();
	}

	}


}
