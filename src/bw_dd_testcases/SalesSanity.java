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

public class SalesSanity {

	
	/** Out Put 
	 *  script verifies navigation issues at left menu of Sales Module
	 *  script Identified navigation(404) issues 
	 *  Script  verifies Left Menu access to user
	 */	
	
	@BeforeTest
	public void isSkip()
	{
			
		if(!TestUtil.isExecutable("SalesSanity"))
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
	Page.findelement("emailId_x").sendKeys(Page.config.getProperty("S_account_email"));
	Page.findelement("signin_x").click();
	Page.findelement("password_x").sendKeys(Page.config.getProperty("S_account_pwd"));
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
public void LeadDashboard() throws IOException
{
	try{
		System.out.println("\nTest_case 2: Lead Dashboard sanity Begins ");
		Page.findelement("S_LeadDashboard_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("S_LeadDashboard_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String LeadLabel= Page.findelement("S_LeadDashboard_Label_x").getText();
		
		if(LeadLabel.equals(Page.or.getProperty("S_LeadDashboard_Label")))
		{
			System.out.println("Lead Dashboard URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("S_LeadDashboard_Label"));
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
		System.out.println("Lead Dashboard menu Functionality fails due to exception = " + e);
		Assert.fail();
	}
}


//Create Lead 
@Test (priority=3)
public void CreateLead() throws IOException
{
	try{
		System.out.println("\nTest_case 3: Create Lead sanity Begins ");
		Page.findelement("S_CreateLead_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("S_CreateLead_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String CreateLead= Page.findelement("S_CreateLead_Label_x").getText();
		
		if(CreateLead.equals(Page.or.getProperty("S_CreateLead_Label")))
		{
			System.out.println("Create Lead URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("S_CreateLead_Label"));
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
		System.out.println("Create Lead menu Functionality fails due to exception = " + e);
		Assert.fail();
	}
}


//Create Account
@Test (priority=4)
public void CreateAccount() throws IOException
{
	try{
		System.out.println("\nTest_case 4: Create Account sanity Begins ");
		Page.findelement("S_CreateAccount_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("S_CreateAccount_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String CreateAccount= Page.findelement("S_CreateAccount_Label_x").getText();
		
		if(CreateAccount.equals(Page.or.getProperty("S_CreateAccount_Label")))
		{
			System.out.println("Create Account URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("S_CreateAccount_Label"));
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
		System.out.println(" Create Account menu Functionality fails due to exception = " + e);
		Assert.fail();
	}
}



//Sales Dashboard
@Test (priority=5)
public void SalesDashboard() throws IOException
{
	try{
		System.out.println("\nTest_case 5: Sales Dashboard sanity Begins ");
		Page.findelement("SalesDashboard_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("SalesDashboard_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String SalesDashboard= Page.findelement("SalesDashboard_Label_x").getText();
		
		if(SalesDashboard.equals(Page.or.getProperty("SalesDashboard_Label")))
		{
			System.out.println("Sales Dashboard URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("SalesDashboard_Label"));
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
		System.out.println("Sales Dashboardmenu Functionality fails due to exception = " + e);
		Assert.fail();
	}
}



//Record Sales
@Test (priority=6)
public void RecordSales() throws IOException
{
	try{
		System.out.println("\nTest_case 6: Record Sales sanity Begins ");
		Page.findelement("S_RecordSales_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("S_RecordSalesr_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String RecordSales= Page.findelement("S_RecordSales_Label_x").getText();
		
		if(RecordSales.equals(Page.or.getProperty("S_RecordSales_Label")))
		{
			System.out.println("Record Sales URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("S_RecordSales_Label"));
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
		System.out.println("Record Sales menu Functionality fails due to exception = " + e);
		Assert.fail();
	}
}


//Manage Product 
@Test (priority=7)
public void ManageProduct() throws IOException
{
	try{
		System.out.println("\nTest_case 7: Manage Product sanity Begins ");
		Page.findelement("S_ManageProduct_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("S_ManageProduct_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String ManageProduct= Page.findelement("ManageProduct_Label_x").getText();
		
		if(ManageProduct.equals(Page.or.getProperty("ManageProduct_Label")))
		{
			System.out.println("Manage Product URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("ManageProduct_Label"));
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
@Test (priority=8)
public void Invoices() throws IOException
{
	try{
		System.out.println("\nTest_case 8: Invoices sanity Begins ");
		Page.findelement("S_Invoices_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("S_Invoices_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String Invoices= Page.findelement("S_Invoices_Label_x").getText();
		
		if(Invoices.equals(Page.or.getProperty("S_Invoices_Label")))
		{
			System.out.println("Invoices URL verified sucessfully");
			
			//System.out.println("Total Invoice Record Found: " + Page.findelement(Page.or.getProperty("S_Invoice_result_x")).getText());
			
			/*String parenthandle=Page.driver.getWindowHandle();
			
			Page.findelement("S_Invoice_Pagination_x").click();
			
			
			Page.findelement("S_Invoice_11_x").click();
			
			for (String winHandle : Page.driver.getWindowHandles()) {
			    Page.driver.switchTo().window(winHandle);
			    System.out.println(Page.driver.getCurrentUrl());
				 Thread.sleep(5000);
				Page.driver.close();  
			}
			 
			Page.driver.switchTo().window(parenthandle);
			 Thread.sleep(5000);
			Page.driver.getCurrentUrl();
			*/
			
			
			
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("S_Invoices_Label"));
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
	}
}


//Create Account
@Test (priority=9)
public void ExecutiveDashboard() throws IOException
{
	try{
		System.out.println("\nTest_case 9: Executive Dashboard sanity Begins ");
		Page.findelement("S_ExecutiveDashboard_menux").click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("S_ExecutiveDashboard_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String ExecutiveDashboard= Page.findelement("S_ExecutiveDashboard_Label_x").getText();
		
		if(ExecutiveDashboard.equals(Page.or.getProperty("ExecutiveDashboard_Label")))
		{
			System.out.println("Executive Dashboard URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("ExecutiveDashboard_Label"));
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



@Test(priority=10)	
public void CreateExecutive() throws IOException
{
	try{
		System.out.println("\nTest_case 10: Create Executive Submenu sanity Begins ");
		
		Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("S_CreateExecutive_menux")))) ;
		Page.P_element.click();
		
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("S_CreateExecutive_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String CreateExecutiveLabel= Page.findelement("S_CreateExecutive_Label_x").getText();
		
		if(CreateExecutiveLabel.equals(Page.or.getProperty("S_CreateExecutive_Label")))
		{
			System.out.println("Create Executive  URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at: " + Page.or.getProperty("S_CreateExecutive_Label"));
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
