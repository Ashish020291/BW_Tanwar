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

public class AccountSanity {
		
	/*
	 * Out Put 
	 *  script verifies navigation issues at left menu of Sales Module
	 *  script Identified navigation(404) issues 
	 *  Script  verifies Left Menu access to user
	 */
@BeforeTest
public void isSkip()
{
		
	if(!TestUtil.isExecutable("AccountSanity"))
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
	Page.findelement("emailId_x").sendKeys(Page.config.getProperty("A_account_email"));
	Page.findelement("signin_x").click();
	Page.findelement("password_x").sendKeys(Page.config.getProperty("A_account_pwd"));
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
public void AccountDashboard() throws IOException
{
	try{
		System.out.println("\nTest_case 2: Account Dashboard sanity Begins ");
		Page.findelement("accountdashboard_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("accountdashboard_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String AccountLabel= Page.findelement("accountdashboard_label_x").getText();
		
		if(AccountLabel.equals(Page.or.getProperty("Accountdashboard_Label")))
		{
			System.out.println("Account Dashboard URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("Accountdashboard_Label"));
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
		
		System.out.println("Account Dashboard menu Functionality fails due to exception = " + e);
		Assert.fail();
	}
}

@Test(priority=3)
public void CreateAccount() throws IOException
{

	try{
		System.out.println("\nTest_case 3: Create Client Account sanity Begins ");
		Page.findelement("createaccount_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("createaccount_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String CreateaccountLabel= Page.findelement("CreateAccount_Label_x").getText();
		
		if(CreateaccountLabel.equals(Page.or.getProperty("CreateAccount_Label")))
		{
			System.out.println("Create Account  URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at: " + Page.or.getProperty("CreateAccount_Label"));
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
	
		System.out.println("Create Account menu Functionality fails due to exception = " + e);
		Assert.fail();
	}
	
}

@Test (priority=4)
public void createBrand() throws IOException
{
try{
	System.out.println("\nTest_case 4: Create Brand Submenu sanity Begins ");
	Page.findelement("addbrand_menux").click();
	
if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("createbrand_url")))
{
	System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
	String CreatebrandLabel= Page.findelement("createbrand_Label_x").getText();
	
	if(CreatebrandLabel.equals(Page.or.getProperty("createbrand_Label")))
	{
		System.out.println("create brand URL verified sucessfully");
	}
	else
	{
		System.out.println("UI/CSS issue at: " + Page.or.getProperty("createbrand_Label"));
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
	
	System.out.println("Create Brand menu fails due to exception = " + e);
	Assert.fail();
}
	
}	


@Test(priority=5)
public void manageBrand() throws IOException
{
	try{
		System.out.println("\nTest_case 5: Manage Brand Submenu sanity Begins ");
		Page.findelement("ManageBrands_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("ManageBrands_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String ManageBrandsLabel= Page.findelement("ManageBrands_Label_x").getText();
		
		if(ManageBrandsLabel.equals(Page.or.getProperty("ManageBrands_Label")))
		{
			System.out.println("Manage Brand URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at: " + Page.or.getProperty("ManageBrands_Label"));
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
		
		System.out.println("Manage Brand  menu fails due to exception = " + e);
		Assert.fail();
	}
}


@Test(priority=6)
public void createManager() throws IOException
{
	try{
		System.out.println("\nTest_case 6: Create Manager Submenu sanity Begins ");
		Page.findelement("AddManager_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("AddManager_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String AddManagerLabel= Page.findelement("AddManager_Label_x").getText();
		
		if(AddManagerLabel.equals(Page.or.getProperty("AddManager_Label")))
		{
			System.out.println("Create ManagerURL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at: " + Page.or.getProperty("AddManager_Label"));
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
		
		System.out.println("Add Manager menu fails due to exception = " + e);
		Assert.fail();
	}
}

@Test(priority=7)
public void manageManager() throws IOException
{
	try{
		System.out.println("\nTest_case 7: Manage Manager Submenu sanity Begins ");
		//Page.findelement("ManageManager_menux").click();
		
		Page.P_element=Page.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Page.or.getProperty("ManageManager_menux")))) ;
		Page.P_element.click();
		
		
	if (Page.driver.getCurrentUrl().contains(Page.or.getProperty("ManageManager_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String ManageManagerLabel= Page.findelement("ManageManager_Label_x").getText();
		
		if(ManageManagerLabel.equals(Page.or.getProperty("ManageManager_Label")))
		{
			System.out.println("Manage Manager verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at: " + Page.or.getProperty("ManageManager_Label"));
			Assert.fail();
		}
	}
	else
	{
		
		System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl());
		Assert.fail();
	}
	}
	catch(Exception e)
	{
		
		System.out.println("Manage Manager menu fails due to exception = " + e);
		Assert.fail();
	}
}
/*
@Test(priority=8)
public void ManageProduct() throws IOException
{
	try{
		System.out.println("\nTest_case 7: Manage Product Submenu sanity Begins ");
		Page.findelement("ManageProduct_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("ManageProduct_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String ManageProductLabel= Page.findelement("ManageProduct_Label_x").getText();
		
		if(ManageProductLabel.equals(Page.or.getProperty("ManageProduct_Label")))
		{
			System.out.println("Manage Product URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at: " + Page.or.getProperty("ManageProduct_Label"));
			Assert.fail();
		}
	}
	else
	{
		
		System.out.println( "Invalid Page URL: " + Page.driver.getCurrentUrl());
		Assert.fail();
	}
	}
	catch(Exception e)
	{
		
		System.out.println("Manage Product menu fails due to exception = " + e);
		Assert.fail();
	}
}	

*/
@Test(priority=9)	
public void ManagePublication() throws IOException
{
	try{
		System.out.println("\nTest_case 9: Manage Publication Submenu sanity Begins ");
		Page.findelement("ManagePublication_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("ManagePublication_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String ManagePublication_Label= Page.findelement("ManagePublication_Label_x").getText();
		
		if(ManagePublication_Label.equals(Page.or.getProperty("ManagePublication_Label")))
		{
			System.out.println("Manage Publication URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at: " + Page.or.getProperty("ManagePublication_Label"));
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
		
		System.out.println("Manage Publication menu fails due to exception = " + e);
		Assert.fail();
	}
}

@Test(priority=10)
public void ExecutiveDashboard() throws IOException
{
	try{
		System.out.println("\nTest_case 10: Executive Dashboard Submenu sanity Begins ");
		
		Thread.sleep(2000);
		Page.findelement("ExecutiveDashboard_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("ExecutiveDashboard_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String ExecutiveDashboardLabel= Page.findelement("ExecutiveDashboard_Label_x").getText();
		
		if(ExecutiveDashboardLabel.equals(Page.or.getProperty("ExecutiveDashboard_Label")))
		{
			System.out.println("Executive Dashboard URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at: " + Page.or.getProperty("ExecutiveDashboard_Label"));
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
		
		System.out.println("Executive Dashboard menu fails due to exception = " + e);
		Assert.fail();
	}
}


@Test(priority=11)	
public void CreateExecutive() throws IOException
{
	try{
		System.out.println("\nTest_case 11: Create Executive Submenu sanity Begins ");
		
		
		//Page.findelement(Page.or.getProperty("A_CreateExecutive_menu_x")).click();
		Page.P_element=Page.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Page.or.getProperty("A_CreateExecutive_menu_x")))) ;
		Page.P_element.click();
		
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("A_CreateExecutive_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String CreateExecutiveLabel= Page.findelement("A_CreateExecutive_Label_x").getText();
		
		if(CreateExecutiveLabel.equals(Page.or.getProperty("A_CreateExecutive_Label")))
		{
			System.out.println("Create Executive  URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at: " + Page.or.getProperty("CreateExecutive_Label"));
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
	public void logout() throws IOException
	{
	try
	{	
		System.out.println("\nTest_case 12: Logout method");
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















































