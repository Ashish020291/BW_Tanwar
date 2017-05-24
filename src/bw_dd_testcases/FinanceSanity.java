// Objective: Finance Module Sanity for Admin/Sub-Admin

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


public class FinanceSanity 
{	
	/** Out Put 
	 *  script verifies navigation issues at left menu of Sales Module
	 *  script Identified navigation(404) issues 
	 *  Script  verifies Left Menu access to user
	 */	
	
	@BeforeTest
	public void isSkip()
	{
			
		if(!TestUtil.isExecutable("FinanceSanity"))
		{
			Page.logs.debug("skiping Finance scripr ");
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
	Page.findelement("emailId_x").sendKeys(Page.config.getProperty("F_account_email"));
	Page.findelement("signin_x").click();
	Page.findelement("password_x").sendKeys(Page.config.getProperty("F_account_pwd"));
	Page.findelement("loginbutton_x").click();
	System.out.println("Login functionality verified sucessfully");
	Page.logs.debug("Login sucessfully");
	}
	catch(Exception e)
	{
		TestUtil.CaptureScreenshot();
		System.out.println("Login Functionality fails due to exception = " + e );
		Page.logs.debug("issue at Login functionality");
		Assert.fail();
	}
	
}

//Finance Dashboard
@Test (priority=2)
public void FinanceDashboard() throws IOException
{
	try{
		System.out.println("\nTest_case 2: Finance Dashboard sanity Begins ");
		Page.findelement("F_FinanceDashboard_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("F_FinanceDashboard_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String LeadLabel= Page.findelement("F_FinanceDashboard_Label_x").getText();
		
		if(LeadLabel.equals(Page.or.getProperty("F_FinanceDashboard_Label")))
		{
			System.out.println("Finance Dashboard URL verified sucessfully");
			Page.logs.debug("Finance Dashboard URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("F_FinanceDashboard_Label"));
			Page.logs.debug("UI/CSS issue");
			Assert.fail();
		}
	}
	
	else
	{
		TestUtil.CaptureScreenshot();
		System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl() );
		Page.logs.debug("Invalid Page URL");
		Assert.fail();
	}
	
	//More Lead dashboard verification
	}
	catch(Exception e)
	{
		TestUtil.CaptureScreenshot();
		System.out.println("Finance Dashboard menu Functionality fails due to exception = " + e);
		Page.logs.debug("Finance Dashboard menu Functionality fails");
		Assert.fail();

	}
}


//Create Lead 
@Test (priority=3)
public void CreateAccout() throws IOException
{
	try{
		System.out.println("\nTest_case 3: Create Account sanity Begins ");
		Page.findelement("F_CreateAccount_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("F_CreateAccount_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String CreateLead= Page.findelement("F_CreateAccount_Label_x").getText();
		
		if(CreateLead.equals(Page.or.getProperty("F_CreateAccount_Label")))
		{
			System.out.println("Create Account URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("F_CreateAccount_Label"));
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
		System.out.println("Create Account menu Functionality fails due to exception = " + e);
		Assert.fail();
	}
}


//Create Account
@Test (priority=4)
public void RecordSale() throws IOException
{
	try{
		System.out.println("\nTest_case 4: Record Sales sanity Begins ");
		Page.findelement("F_RecordSales_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("F_RecordSales_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String CreateAccount= Page.findelement("F_RecordSales_Label_x").getText();
		
		if(CreateAccount.equals(Page.or.getProperty("F_RecordSales_Label")))
		{
			System.out.println("Record Sales  URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("F_RecordSales_Label"));
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
		System.out.println(" Record Sales menu Functionality fails due to exception = " + e);
		Assert.fail();
	}
}



//Sales Dashboard



//Manage Product 
@Test (priority=5)
public void ManageProduct() throws IOException
{
	try{
		System.out.println("\nTest_case 5: Manage Product sanity Begins ");
		Page.findelement("F_ManageProduct_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("F_ManageProduct_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String ManageProduct= Page.findelement("F_ManageProduct_Label_x").getText();
		
		if(ManageProduct.equals(Page.or.getProperty("F_ManageProduct_Label")))
		{
			System.out.println("Manage Product URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("F_ManageProduct_Label"));
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
		System.out.println("Manage Product Functionality fails due to exception = " + e);
		Assert.fail();
	}
}


//Create Account
@Test (priority=6)
public void Invoices() throws IOException
{
	try{
		System.out.println("\nTest_case 6: Invoices sanity Begins ");
		Page.findelement("F_Invoices_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("F_Invoices_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String Invoices= Page.findelement("F_Invoices_Label_x").getText();
		
		if(Invoices.equals(Page.or.getProperty("F_Invoices_Label")))
		{
			System.out.println("Invoices URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("F_Invoices_Label"));
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
		System.out.println("Invoices Functionality fails due to exception = " + e);
		Assert.fail();
	}
}

//Create Account
@Test (priority=7)
public void RevenueReports() throws IOException
{
	try{
		System.out.println("\nTest_case 7: Revenue Reports sanity Begins ");
		Page.findelement("F_RevenueReports_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("F_RevenueReports_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String ExecutiveDashboard= Page.findelement("F_RevenueReports_Label_x").getText();
		
		if(ExecutiveDashboard.equals(Page.or.getProperty("F_RevenueReports_Label")))
		{
			System.out.println("Revenue Reports URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("F_RevenueReports_Label"));
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
		System.out.println("Revenue Reports Functionality fails due to exception = " + e);
		Assert.fail();
	}
}



//Create Account
@Test (priority=8)
public void ExecutiveDashboard() throws IOException
{
	try{
		System.out.println("\nTest_case : Executive Dashboard sanity Begins ");
		Page.findelement("F_ExecutiveDashboard_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("F_ExecutiveDashboard_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String ExecutiveDashboard= Page.findelement("F_ExecutiveDashboard_Labelx").getText();
		
		if(ExecutiveDashboard.equals(Page.or.getProperty("F_ExecutiveDashboard_Label")))
		{
			System.out.println("Executive Dashboard URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("F_ExecutiveDashboard_Label"));
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



@Test(priority=9)	
public void CreateExecutive() throws IOException
{
	try{
		System.out.println("\nTest_case 9: Create Executive Submenu sanity Begins ");
		
		Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("F_CreateExecutive_menux")))) ;
		Page.P_element.click();
		
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("F_CreateExecutive_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String CreateExecutiveLabel= Page.findelement("F_CreateExecutive_Label_x").getText();
		
		if(CreateExecutiveLabel.equals(Page.or.getProperty("F_CreateExecutive_Label")))
		{
			System.out.println("Create Executive  URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at: " + Page.or.getProperty("F_CreateExecutive_Label"));
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
		System.out.println("\nTest_case 10: Logout method");
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