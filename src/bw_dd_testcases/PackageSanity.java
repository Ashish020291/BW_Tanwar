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

public class PackageSanity {


		
		/** Out Put 
		 *  script verifies navigation issues at left menu of Sales Module
		 *  script Identified navigation(404) issues 
		 *  Script  verifies Left Menu access to user
		 */	
		
		@BeforeTest
		public void isSkip()
		{
				
			if(!TestUtil.isExecutable("PackageSanity"))
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
		Page.findelement("emailId_x").sendKeys(Page.config.getProperty("P_account_email"));
		Page.findelement("signin_x").click();
		Page.findelement("password_x").sendKeys(Page.config.getProperty("P_account_pwd"));
		Page.findelement("loginbutton_x").click();
		
		System.out.println("Login functionality verified sucessfully");
		}
		catch(Exception e)
		{
			TestUtil.CaptureScreenshot();
			System.out.println("Login Functionality fails due to exception = " + e );
			Assert.fail();
		}
		
	}

	//Lead dashboard
	@Test (priority=2)
	public void PackageDashboard() throws IOException
	{
		try{
			System.out.println("\nTest_case 2: Package Dashboard sanity Begins ");
			Page.findelement("P_PackageDashboard_menux").click();
			
		if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("P_PackageDashboard_url")))
		{
			System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
			String packageLabel= Page.findelement("P_PackageDashboard_Label_x").getText();
			
			if(packageLabel.equals(Page.or.getProperty("P_PackageDashboard_Label")))
			{
				System.out.println("Package Dashboard URL verified sucessfully");
			}
			else
			{
				System.out.println("UI/CSS issue at " + Page.or.getProperty("P_PackageDashboard_Label"));
				Assert.fail();
			}
		}
		
		else
		{
			TestUtil.CaptureScreenshot();
			System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl() );
			Assert.fail();
		}
		
		//More Lead dashboard verification
		}
		catch(Exception e)
		{
			TestUtil.CaptureScreenshot();
			System.out.println("Package Dashboard menu Functionality fails due to exception = " + e);
			Assert.fail();
		}
	}


	//Create Lead 
	@Test (priority=3)
	public void CreatePackage() throws IOException
	{
		try{
			System.out.println("\nTest_case 3: Create Package sanity Begins ");
			Page.findelement("P_CreatePackage_menux").click();
			
		if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("P_CreatePackage_url")))
		{
			System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
			String Createpkg= Page.findelement("P_CreatePackage_Label_x").getText();
			
			if(Createpkg.equals(Page.or.getProperty("P_CreatePackage_Label")))
			{
				System.out.println("Create Package URL verified sucessfully");
			}
			else
			{
				System.out.println("UI/CSS issue at " + Page.or.getProperty("P_CreatePackage_Label"));
				Assert.fail();
			}
		}
		
		else
		{
			TestUtil.CaptureScreenshot();
			System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl() );
			Assert.fail();
		}
		
		//More Lead dashboard verification
		}
		catch(Exception e)
		{
			TestUtil.CaptureScreenshot();
			System.out.println("Create Package menu Functionality fails due to exception = " + e);
			Assert.fail();
		}
	}


	//Create Account
	@Test (priority=4)
	public void ManagePricing() throws IOException
	{
		try{
			System.out.println("\nTest_case 4: Manage Pricing sanity Begins ");
			Page.findelement("P_ManagePricing_menux").click();
			
		if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("P_ManagePricing_url")))
		{
			System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
			String pricing= Page.findelement("P_ManagePricing_Label_x").getText();
			
			if(pricing.equals(Page.or.getProperty("P_ManagePricing_Label")))
			{
				System.out.println("Manage Pricing URL verified sucessfully");
			}
			else
			{
				System.out.println("UI/CSS issue at " + Page.or.getProperty("P_ManagePricing_Label"));
				Assert.fail();
			}
		}
		
		else
		{
			TestUtil.CaptureScreenshot();
			System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl() );
			Assert.fail();
		}
		
		//More Lead dashboard verification
		}
		catch(Exception e)
		{
			TestUtil.CaptureScreenshot();
			System.out.println(" Manage Pricing menu Functionality fails due to exception = " + e);
			Assert.fail();
		}
	}



	//Create Account
	@Test (priority=5)
	public void ExecutiveDashboard() throws IOException
	{
		try{
			System.out.println("\nTest_case 5: Executive Dashboard sanity Begins ");
			Page.findelement("P_ExecutiveDashboard_menux").click();
			
		if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("P_ExecutiveDashboard_url")))
		{
			System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
			String ExecutiveDashboard= Page.findelement("P_ExecutiveDashboard_Label_x").getText();
			
			if(ExecutiveDashboard.equals(Page.or.getProperty("P_ExecutiveDashboard_Label")))
			{
				System.out.println("Executive Dashboard URL verified sucessfully");
			}
			else
			{
				System.out.println("UI/CSS issue at " + Page.or.getProperty("P_ExecutiveDashboard_Label"));
				Assert.fail();
			}
		}
		
		else
		{
			TestUtil.CaptureScreenshot();
			System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl() );
			Assert.fail();
		}
		
		//More Lead dashboard verification
		}
		catch(Exception e)
		{
			TestUtil.CaptureScreenshot();
			System.out.println("Executive Dashboard Functionality fails due to exception = " + e);
			Assert.fail();
		}
	}


	@Test(priority=6)	
	public void CreateExecutive() throws IOException
	{
		try{
			System.out.println("\nTest_case 6: Create Executive Submenu sanity Begins ");
			
			Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("P_CreateExecutive_menux")))) ;
			Page.P_element.click();
			
			
		if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("P_CreateExecutive_url")))
		{
			System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
			String CreateExecutiveLabel= Page.findelement("P_CreateExecutive_Label_x").getText();
			
			if(CreateExecutiveLabel.equals(Page.or.getProperty("P_CreateExecutive_Label")))
			{
				System.out.println("Create Executive  URL verified sucessfully");
			}
			else
			{
				System.out.println("UI/CSS issue at: " + Page.or.getProperty("P_CreateExecutive_Label"));
				Assert.fail();
			}
		}
		else
		{
			TestUtil.CaptureScreenshot();
			System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl() );
			Assert.fail();
		}
		}
		catch(Exception e)
		{
			TestUtil.CaptureScreenshot();
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
			System.out.println("\nTest_case 11: Logout method");
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
			TestUtil.CaptureScreenshot();
			System.out.println("Login Functionality fails due to exception = " + e );
			Assert.fail();
		}
		

		}

	}

