package bw_dd_testcases;

import java.io.IOException;

import org.openqa.selenium.By;
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

public class ContentSanity {


	
	/** Out Put 
	 *  script verifies navigation issues at left menu of Sales Module
	 *  script Identified navigation(404) issues 
	 *  Script  verifies Left Menu access to user
	 */	
	
	@BeforeTest
	public void isSkip()
	{
			
		if(!TestUtil.isExecutable("ContentSanity"))
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
	Page.findelement("emailId_x").sendKeys(Page.config.getProperty("C_account_email"));
	Page.findelement("signin_x").click();
	Page.findelement("password_x").sendKeys(Page.config.getProperty("C_account_pwd"));
	Page.findelement("loginbutton_x").click();
	
	System.out.println("Login functionality verified sucessfully");
	}
	catch(Exception e)
	{
	
		System.out.println("Login Functionality fails due to exception = " + e );
		Assert.fail();
	}
	
}

//Lead dashboard
@Test (priority=2)
public void ContentDashboard() throws IOException
{
	try{
		System.out.println("\nTest_case 2: Content Dashboard sanity Begins ");
		Page.findelement("C_ContentDashboard_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("C_ContentDashboard_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String contentLabel= Page.findelement("C_ContentDashboard_Label_x").getText();
		
		if(contentLabel.equals(Page.or.getProperty("C_ContentDashboard_Label")))
		{
			System.out.println("Content Dashboard URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("C_ContentDashboard_Label"));
			Assert.fail();
		}
	}
	
	else
	{
		
		System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl() );
		Assert.fail();
	}
	
	//More Lead dashboard verification
	}
	catch(Exception e)
	{
		
		System.out.println("Content Dashboard menu Functionality fails due to exception = " + e);
		Assert.fail();
	}
}


//Create Lead 
@Test (priority=3)
public void CreatePressRelease() throws IOException
{
	try{
		System.out.println("\nTest_case 3: Create Press Release Begins ");
		Page.findelement("C_CreatePressRelease_menux").click();
		
	if (Page.driver.getCurrentUrl().contains(Page.or.getProperty("C_CreatePressRelease_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String Createpr= Page.findelement("C_CreatePressRelease_Label_x").getText();
		
		if(Createpr.contains(Page.or.getProperty("C_CreatePressRelease_Label")))
		{
			System.out.println("Create Press Release page verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("C_CreatePressRelease_Label"));
			Assert.fail();
		}
	}
	
	else
	{
		
		System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl() );
		Assert.fail();
	}
	
	//More Lead dashboard verification
	}
	catch(Exception e)
	{
		
		System.out.println("Create Press Release menu Functionality fails due to exception = " + e);
		Assert.fail();
	}
}


//Create Account
@Test (priority=4)
public void CreateBrandResponse() throws IOException
{
	try{
		System.out.println("\nTest_case 4: Create Brand Response sanity Begins ");
		
		Thread.sleep(2000);
		Page.P_element=Page.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Page.or.getProperty("C_CreateBrandResponse_menux")))) ;
		Page.P_element.click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("C_CreateBrandResponse_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String Createbr= Page.findelement("C_CreateBrandResponse_Label_x").getText();
		
		if(Createbr.contains(Page.or.getProperty("C_CreateBrandResponse_Label")))
		{
			System.out.println("Create Brand Response verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("C_CreateBrandResponse_Label"));
			Assert.fail();
		}
	}
	
	else
	{
		
		System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl() );
		Assert.fail();
	}
	
	//More Lead dashboard verification
	}
	catch(Exception e)
	{
		
		System.out.println(" Create Brand Response menu Functionality fails due to exception = " + e);
		Assert.fail();
	}
}



//Sales Dashboard
@Test (priority=5)
public void CreateBrandAddendum() throws IOException
{
	try{
		System.out.println("\nTest_case 5: Create Brand Addendum sanity Begins ");
		Page.findelement("C_CreateBrandAddendum_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("C_CreateBrandAddendum_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String SalesDashboard= Page.findelement("C_CreateBrandAddendum_Label_x").getText();
		
		if(SalesDashboard.equals(Page.or.getProperty("C_CreateBrandAddendum_Label")))
		{
			System.out.println("Create Brand Addendum URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("C_CreateBrandAddendum_Label"));
			Assert.fail();
		}
	}
	
	else
	{
		
		System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl() );
		Assert.fail();
	}
	
	//More Lead dashboard verification
	}
	catch(Exception e)
	{
		
		System.out.println("Create Brand Addendum Functionality fails due to exception = " + e);
		Assert.fail();
	}
}



//Record Sales
@Test (priority=6)
public void CreateBrandCommen() throws IOException
{
	try{
		System.out.println("\nTest_case 6: Create Brand Comment sanity Begins ");
		Page.findelement("C_CreateBrandCommen_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("C_CreateBrandCommen_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String CreateBrandCommen= Page.findelement("C_CreateBrandCommen_Label_x").getText();
		
		if(CreateBrandCommen.equals(Page.or.getProperty("C_CreateBrandComment_Label")))
		{
			System.out.println("Create Brand Comment URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("C_CreateBrandComment_Label"));
			Assert.fail();
		}
	}
	
	else
	{
		
		System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl() );
		Assert.fail();
	}
	
	//More Lead dashboard verification
	}
	catch(Exception e)
	{
	
		System.out.println("Create Brand Comment menu Functionality fails due to exception = " + e);
		Assert.fail();
	}
}


//Create Account
@Test (priority=7)
public void ExecutiveDashboard() throws IOException
{
	try{
		System.out.println("\nTest_case 7: Executive Dashboard sanity Begins ");
		Page.findelement("C_ExecutiveDashboard_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("C_ExecutiveDashboard_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String ExecutiveDashboard= Page.findelement("C_ExecutiveDashboard_Label_x").getText();
		
		if(ExecutiveDashboard.equals(Page.or.getProperty("C_ExecutiveDashboard_Label")))
		{
			System.out.println("Executive Dashboard URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("C_ExecutiveDashboard_Label"));
			Assert.fail();
		}
	}
	
	else
	{
		
		System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl() );
		Assert.fail();
	}
	
	//More Lead dashboard verification
	}
	catch(Exception e)
	{
		
		System.out.println("Executive Dashboard Functionality fails due to exception = " + e);
		Assert.fail();
	}
}



@Test(priority=8)	
public void CreateExecutive() throws IOException
{
	try{
		System.out.println("\nTest_case 8: Create Executive Submenu sanity Begins ");
		
		Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("C_CreateExecutive_menux")))) ;
		Page.P_element.click();
		
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("C_CreateExecutive_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String CreateExecutiveLabel= Page.findelement("C_CreateExecutive_Label_x").getText();
		
		if(CreateExecutiveLabel.equals(Page.or.getProperty("C_CreateExecutive_Label")))
		{
			System.out.println("Create Executive  URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at: " + Page.or.getProperty("C_ContentDashboard_Label"));
			Assert.fail();
		}
	}
	else
	{
		
		System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl() );
		Assert.fail();
	}
	}
	catch(Exception e)
	{
		
		System.out.println("Create Executive  menu fails due to exception = " + e);
		Assert.fail();
	}
}


//Logout functionality
@AfterTest
	public void logout() throws IOException, InterruptedException
	{
	try
	{	
		System.out.println("\nTest_case 9: Logout method");
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
		
		}
	}
	catch(Exception e)
	{

		System.out.println("Login Functionality fails due to exception = " + e );
		Assert.fail();
	}
	

	}

}
