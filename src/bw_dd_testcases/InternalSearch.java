package bw_dd_testcases;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import bw_dd_core.Page;
import bw_dd_util.TestUtil;

public class InternalSearch {
	
	

	@BeforeTest 
	public static void isSkip()
	{
		if(!TestUtil.isExecutable("InternalSearch"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(priority=1, dataProvider="getData" )
	public void PreLogin_internalsearch(String search) throws IOException 
	{
	
			try 
			{
				System.out.println("\nTest_case 1: PreLogin Internal Search Functionality Sanity Begins ");
				Page.findelement("searchmagnifier_x").click();
				WebElement input= Page.findelement("searchinput_x");
				input.clear();
				input.sendKeys(search);
				
				Page.findelement("searchbutton_x").click();
				
				if(Page.driver.getCurrentUrl().contains(Page.or.getProperty("search_url")))
				{
					System.out.println("Search Page url = " + Page.driver.getCurrentUrl());
					String Stringlabel= Page.findelement("brandwiretitle_label").getText();	
					
					if(Stringlabel.contains(Page.or.getProperty("search_label")))
							{
							System.out.println("Internal search working fine at Home page");
							}
					else
					{
						System.out.println("Search not working");
						Assert.fail();
					}
				}

				Thread.sleep(5000);
			}
			catch (IOException | InterruptedException e)
			{
				// TODO Auto-generated catch block
				TestUtil.CaptureScreenshot();
				e.printStackTrace();
				Assert.fail();
			}	
	
	}
	
	
	@Test (priority=2)
	public void login() throws IOException
	{
		
		try
		{
		System.out.println("\nTest_case 1: Login Functionality Sanity Begins ");
		
		Page.findelement("SubmitaRelease_x").click();
		Page.findelement("emailId_x").sendKeys(Page.config.getProperty("account_email"));
		Page.findelement("signin_x").click();
		Page.findelement("password_x").sendKeys(Page.config.getProperty("account_pwd"));
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

	@Test (priority=3,dataProvider="getData")
	public void Postlogin_internalsearch(String search) throws IOException
	{
		try 
		{
			System.out.println("\nTest_case 1: PreLogin Internal Search Functionality Sanity Begins ");
			Page.findelement("searchmagnifier_x").click();
			WebElement input= Page.findelement("searchinput_x");
			input.clear();
			input.sendKeys(search);
			
			Page.findelement("searchbutton_x").click();
			
			if(Page.driver.getCurrentUrl().contains(Page.or.getProperty("search_url")))
			{
				System.out.println("Search Page url = " + Page.driver.getCurrentUrl());
				String Stringlabel= Page.findelement("brandwiretitle_label").getText();	
				
				if(Stringlabel.contains(Page.or.getProperty("search_label")))
						{
						System.out.println("Internal search working fine at Home page");
						}
				else
				{
					System.out.println("Search not working");
					Assert.fail();
				}
			}

			Thread.sleep(5000);
		}
		catch (IOException | InterruptedException e)
		{
			// TODO Auto-generated catch block
			TestUtil.CaptureScreenshot();
			e.printStackTrace();
			Assert.fail();
		}	
	}
	
	//Logout functionality
	@Test(priority=4)	
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
			}
		}
		catch(Exception e)
		{
			TestUtil.CaptureScreenshot();
			System.out.println("Login Functionality fails due to exception = " + e );	
			Assert.fail();
		}
		}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("InternalSearch");
		
	}
	
}
