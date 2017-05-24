package bw_dd_testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

public class AgencyClient {
	@BeforeTest
	public void isSkip()
	{
			
		if(!TestUtil.isExecutable("AgencyClient"))
		{
				
			throw new SkipException("Skipping the test as the Run mode is No");
				
		}
			
	}
		
	//Login functioanlity
	@Test(priority=1)
	public void login() throws IOException
	{
		
		Page.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		try
		{
		System.out.println("\nTest_case 1: Login Functionality Sanity Begins ");
		
		Page.findelement("SubmitaRelease_x").click();
		Page.findelement("emailId_x").sendKeys(Page.config.getProperty("Ag_account_email"));
		Page.findelement("signin_x").click();
		Page.findelement("password_x").sendKeys(Page.config.getProperty("Ag_account_pwd"));
		Page.findelement("loginbutton_x").click();
		
		System.out.println("Login functionality verified sucessfully");
		}
		catch(Exception e)
		{
		
			System.out.println("Login Functionality fails due to exception = " + e );
			Assert.fail();
		}
		
	}

	// Media center verification 
	
		@Test(priority=2)
		public void Media_Center()
		{
			try{
				System.out.println("\nTest_case 2: Media Center Dashboard sanity Begins ");
				//Page.findelement("Ag_mediacenter_x").click();
				
				Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("Ag_mediacenter_x")))) ;
				Page.P_element.click();
				
			if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_mediacenter_url")))
			{
				System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
				String mcLabel= Page.findelement("Ag_MediaCenter_Label_x").getText();
				
				if(mcLabel.equals(Page.or.getProperty("Ag_MediaCenter_Label")))
				{
					System.out.println("Media Center Dashboard URL verified sucessfully");
				}
				else
				{
					System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_MediaCenter_Label"));
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
				
				System.out.println("Media Center Dashboard menu Functionality fails due to exception = " + e);
				Assert.fail();
			}
		}	
	
		// press release history verification
		
		@Test(priority=3)
		public void Press_Release_History()
		{
			try{
				System.out.println("\nTest_case 3: Press Release History Dashboard sanity Begins ");
				Page.findelement("Ag_pressrelease_x").click();
				
				/*Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("Ag_pressrelease_x")))) ;
				Page.P_element.click();*/
				
			if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_pressrelease_url")))
			{
				System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
				String prhLabel= Page.findelement("Ag_pressrelease_Label_x").getText();
				
				if(prhLabel.contains(Page.or.getProperty("Ag_pressrelease_Label")))
				{
					System.out.println("Press Release History Dashboard URL verified sucessfully");
				}
				else
				{
					System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_pressrelease_Label"));
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
				
				System.out.println("Press Release History Dashboard menu Functionality fails due to exception = " + e);
				Assert.fail();
			}	
		}

		// Brand Addendum History verification
		
			@Test(priority=4)
			public void Brand_Addendum_History ()
			{
				try{
					System.out.println("\nTest_case 4: Brand Addendum History Dashboard sanity Begins ");
					Page.findelement("Ag_BrandAddendumHistory_x").click();
					
					/*Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("Ag_pressrelease_x")))) ;
					Page.P_element.click();*/
					
				if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_BrandAddendumHistory_url")))
				{
					System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
					String brhLabel= Page.findelement("Ag_BrandAddendumHistory_Label_x").getText();
					
					if(brhLabel.contains(Page.or.getProperty("Ag_BrandAddendumHistory_Label")))
					{
						System.out.println("Press Release History Dashboard URL verified sucessfully");
					}
					else
					{
						System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_BrandAddendumHistory_Label"));
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
					
					System.out.println("Brand Addendum History Dashboard menu Functionality fails due to exception = " + e);
					Assert.fail();
				}		
		}
	
			// Brand Comment History verification
			
@Test(priority=5)
public void Brand_Comment_History ()
{
	try{
		System.out.println("\nTest_case 5: Brand Comment History Dashboard sanity Begins ");
		Page.findelement("Ag_BrandCommentHistory_x").click();
		
		/*Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("Ag_pressrelease_x")))) ;
		Page.P_element.click();*/
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_BrandCommentHistory_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String bchLabel= Page.findelement("Ag_BrandCommentHistory_Label_x").getText();
		
		if(bchLabel.contains(Page.or.getProperty("Ag_BrandCommentHistory_Label")))
		{
			System.out.println("Press Release History Dashboard URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_BrandCommentHistory_Label"));
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
		
		System.out.println("Brand Comment History Dashboard menu Functionality fails due to exception = " + e);
		Assert.fail();
	}							
}	
	
//Brand Comment History verification

@Test(priority=6)
public void Brand_Response_History()
{
	try{
		System.out.println("\nTest_case 6: Brand Response History Dashboard sanity Begins ");
		Page.findelement("Ag_BrandResponseHistory_x").click();
		
		/*Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("Ag_pressrelease_x")))) ;
		Page.P_element.click();*/
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_BrandResponseHistory_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String brhLabel= Page.findelement("Ag_BrandResponseHistory_Label_x").getText();
		
		if(brhLabel.contains(Page.or.getProperty("Ag_BrandResponseHistory_Label")))
		{
			System.out.println("Brand Response History Dashboard URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_BrandResponseHistory_Label"));
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
		
		System.out.println("Brand Comment History Dashboard menu Functionality fails due to exception = " + e);
		Assert.fail();
	}	
}	
	
//Q&A Dashboard verification

@Test(priority=7)
public void QnA_Dashboard()
{
	try{
		System.out.println("\nTest_case 7: Q&A Dashboard sanity Begins ");
		Page.findelement("Ag_Q&A_x").click();
		
		/*Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("Ag_pressrelease_x")))) ;
		Page.P_element.click();*/
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_Q&Ar_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String qnaLabel= Page.findelement("Ag_Q&A_Label_x").getText();
		
		if(qnaLabel.contains(Page.or.getProperty("Ag_Q&A_Label")))
		{
			System.out.println(" Q&A Dashboard URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_Q&A_Label"));
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
		
		System.out.println(" Q&A Dashboard menu Functionality fails due to exception = " + e);
		Assert.fail();
	}
	
}
	
//My Account--> My Profile verification

@Test(priority=8)
public void My_Profile()
{
	try{
		System.out.println("\nTest_case 8: My Profile sanity Begins ");
		Page.findelement("Ag_myprofile_x").click();
		
		/*Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("Ag_pressrelease_x")))) ;
		Page.P_element.click();*/
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_myprofile_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String qnaLabel= Page.findelement("Ag_myprofile_label_x").getText();
		
		if(qnaLabel.contains(Page.or.getProperty("Ag_myprofile_label")))
		{
			System.out.println("My Profile URL verified sucessfully");
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_myprofile_label"));
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
		
		System.out.println(" My Profile menu Functionality fails due to exception = " + e);
		Assert.fail();
	}	
}	
	
	
@Test(priority=9)
public void Company_Information()
{
	try{
		System.out.println("\nTest_case 9: Company Information sanity Begins ");
		Page.findelement("Ag_CompanyInformation_x").click();
		
		/*Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("Ag_pressrelease_x")))) ;
		Page.P_element.click();*/
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_CompanyInformation_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String CiLabel= Page.findelement("Ag_CompanyInformation_label_x").getText();
		
		if(CiLabel.contains(Page.or.getProperty("Ag_CompanyInformation_label")))
		{
			System.out.println("Company Information URL verified sucessfully");
			
		}
		/*else if(CbLabel.contains(Page.or.getProperty("Ag_CreateBrand_label"))){
			
		}*/
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_CompanyInformation_label"));
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
		
		System.out.println(" Company information Functionality fails due to exception = " + e);
		Assert.fail();
	}		
		
}
//My Account-->  Allocation verification
@Test (priority=10)
public void Client_info()
{
	try{
		System.out.println("\nTest_case 10: Create Brand sanity Begins ");
		Page.findelement("Ag_CreateBrand_x").click();
		
		/*Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("Ag_pressrelease_x")))) ;
		Page.P_element.click();*/
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_CreateBrand_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String CiLabel= Page.findelement("Ag_CreateBrand_label_nx").getText();
		
		if(CiLabel.contains(Page.or.getProperty("Ag_CreateBrand_label")))
		{
			System.out.println("Client Information URL verified sucessfully");
			
		}
		/*else if(CbLabel.contains(Page.or.getProperty("Ag_CreateBrand_label"))){
			
		}*/
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_CreateBrand_label"));
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
		
		System.out.println(" Client information Functionality fails due to exception = " + e);
		Assert.fail();
	}	
}

@Test(priority=11)
public void Manage_manager()
{
	try{
		System.out.println("\nTest_case 11: Manage Manager sanity Begins ");
		Page.findelement("Ag_ManageBrandManager_x").click();
		
		/*Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("Ag_pressrelease_x")))) ;
		Page.P_element.click();*/
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_ManageBrandManager_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String CiLabel= Page.findelement("Ag_ManageBrandManager_label_x").getText();
		
		if(CiLabel.contains(Page.or.getProperty("Ag_ManageBrandManager_label")))
		{
			System.out.println("Manage Manager URL verified sucessfully");
			
		}
		/*else if(CbLabel.contains(Page.or.getProperty("Ag_CreateBrand_label"))){
			
		}*/
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_ManageBrandManager_label"));
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
		
		System.out.println(" Manager Manager Functionality fails due to exception = " + e);
		Assert.fail();
	}
}

@Test(priority=12)
public void Manage_Product_Assign()
{
	try{
		System.out.println("\nTest_case 12: Assign Account sanity Begins ");
		//Page.findelement("Ag_AssignAccount_x").click();
		
		Page.P_element=Page.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Page.or.getProperty("Ag_AssignAccount_x")))) ;
		Page.P_element.click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_AssignAccount_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String MpaLabel= Page.findelement("Ag_AssignAccount_label_x").getText();
		
		if(MpaLabel.contains(Page.or.getProperty("Ag_AssignAccount_label")))
		{
			System.out.println("Assign Account URL verified sucessfully");
			
		}
		/*else if(CbLabel.contains(Page.or.getProperty("Ag_CreateBrand_label"))){
			
		}*/
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_AssignAccount_label"));
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
		
		System.out.println(" Assign Account Functionality fails due to exception = " + e);
		Assert.fail();
	}
}

//My sAccount-->  Allocation verification

@Test(priority=13)
public void Manage_Request()
{	
	try{
		System.out.println("\nTest_case 13: Manage Request sanity Begins ");
		//Page.findelement("Ag_ManageRequest_x").click();
	
		Thread.sleep(5000);
		Page.P_element=Page.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Page.or.getProperty("Ag_ManageRequest_x")))) ;
		Page.P_element.click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_ManageRequest_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String MrLabel= Page.findelement("Ag_ManageRequest_label_x").getText();
		
		if(MrLabel.contains(Page.or.getProperty("Ag_ManageRequest_label")))
		{
			System.out.println("Manage Request URL verified sucessfully");
			
		}
	
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_ManageRequest_label"));
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
		
		System.out.println(" Manage Request Functionality fails due to exception = " + e);
		Assert.fail();
	}
}

/*//My Account-->  Allocation verification

@Test(priority=14)
public void  My_Orders ()
{	
	try{
		System.out.println("\nTest_case 14: My Order sanity Begins ");
		Page.findelement("Ag_MyOrders_x").click();
		
		Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("Ag_pressrelease_x")))) ;
		Page.P_element.click();
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_MyOrders_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String MoLabel= Page.findelement("Ag_MyOrders_label_x").getText();
		
		if(MoLabel.contains(Page.or.getProperty("Ag_MyOrders_label")))
		{
			System.out.println("My Order URL verified sucessfully");
			
		}
		else if(CbLabel.contains(Page.or.getProperty("Ag_CreateBrand_label"))){
			
		}
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_MyOrders_label"));
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
		
		System.out.println(" My Order Functionality fails due to exception = " + e);
		Assert.fail();
	}
		
}
*/
//My Account-->  Allocation verification

@Test(priority=15)
public void  Usage_History ()
{	
	try{
		System.out.println("\nTest_case 15: Account Usage History sanity Begins ");
		Page.findelement("Ag_Usage_History_x").click();
		
		/*Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("Ag_pressrelease_x")))) ;
		Page.P_element.click();*/
		
	if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_Usage_History_url")))
	{
		System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
		String uhLabel= Page.findelement("Ag_Usage_History_label_x").getText();
		
		if(uhLabel.contains(Page.or.getProperty("Ag_Usage_History_label")))
		{
			System.out.println("Account Usage History URL verified sucessfully");
			
		}
		/*else if(CbLabel.contains(Page.or.getProperty("Ag_CreateBrand_label"))){
			
		}*/
		else
		{
			System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_Usage_History_label"));
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
		
		System.out.println(" Account Usage History Functionality fails due to exception = " + e);
		Assert.fail();
	}	

}	

//verifying top menu

	@Test(priority=16)
	public void Offerings_PR()
	{
		try{
			System.out.println("\nTest_case 16: Offerings_Press_Release sanity Begins ");
			
			Page.findelement("Ag_Offerings_x").click();
			Page.P_element=Page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page.or.getProperty("Ag_Offerings_pr_x")))) ;
			Page.P_element.click();
			
		if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_Offerings_pr_url")))
		{
			System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
			String OPrLabel= Page.findelement("Ag_Offerings_pr_label_x").getText();
			
			if(OPrLabel.contains(Page.or.getProperty("Ag_Offerings_pr_label")))
			{
				System.out.println("Offerings_Press_ReleaseURL verified sucessfully");
				
			}
			/*else if(CbLabel.contains(Page.or.getProperty("Ag_CreateBrand_label"))){
				
			}*/
			else
			{
				System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_Offerings_pr_label"));
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
			
			System.out.println("Offerings_Press_Release Functionality fails due to exception = " + e);
			Assert.fail();
		}	
	
	}

	@Test(priority=17)
	public void Offerings_BC()
	{
		try{
			System.out.println("\nTest_case 17: Offerings_BC sanity Begins ");

			Page.findelement("Ag_Offerings_BRANDCOMMENT_x").click();
			
		if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_Offerings_BRANDCOMMENT_url")))
		{
			System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
			String OPrLabel= Page.findelement("Ag_Offerings_BRANDCOMMENT_label_x").getText();
			
			if(OPrLabel.contains(Page.or.getProperty("Ag_Offerings_BRANDCOMMENT_label")))
			{
				System.out.println("Offerings_BC URL verified sucessfully");
				
			}
			/*else if(CbLabel.contains(Page.or.getProperty("Ag_CreateBrand_label"))){
				
			}*/
			else
			{
				System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_Offerings_BRANDCOMMENT_label"));
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
			
			System.out.println("Offerings_BC Functionality fails due to exception = " + e);
			Assert.fail();
		}	
	
	}			
	
	@Test(priority=18)
	public void Offerings_BR()
	{
		try{
			System.out.println("\nTest_case 18: Offerings_BR sanity Begins ");

			Page.findelement("Ag_Offerings_Br_x").click();
			
		if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_Offerings_Br_url")))
		{
			System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
			String obrLabel= Page.findelement("Ag_Offerings_Br_label_x").getText();
			
			if(obrLabel.contains(Page.or.getProperty("Ag_Offerings_Br_label")))
			{
				System.out.println("Offerings_BR URL verified sucessfully");
				
			}
			/*else if(CbLabel.contains(Page.or.getProperty("Ag_CreateBrand_label"))){
				
			}*/
			else
			{
				System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_Offerings_Br_label"));
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
			
			System.out.println("Offerings_BR Functionality fails due to exception = " + e);
			Assert.fail();
		}	
	}			

	@Test(priority=19)
	public void Offerings_AF()
	{
		try{
			System.out.println("\nTest_case 19: Offerings_AF sanity Begins ");

			Page.findelement("Ag_Offerings_AF_x").click();
			
		if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_Offerings_AF_url")))
		{
			System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
			String AFLabel= Page.findelement("Ag_Offerings_AF_label_x").getText();
			
			if(AFLabel.contains(Page.or.getProperty("Ag_Offerings_AF_label")))
			{
				System.out.println("Offerings_AF URL verified sucessfully");
				
			}
			/*else if(CbLabel.contains(Page.or.getProperty("Ag_CreateBrand_label"))){
				
			}*/
			else
			{
				System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_Offerings_AF_label"));
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
			
			System.out.println("Offerings_AF Functionality fails due to exception = " + e);
			Assert.fail();
		}	
	}

	@Test(priority=20)
	public void Offerings_RQ()
	{
		try{
			System.out.println("\nTest_case 20: Offerings_RQ sanity Begins ");

			Page.findelement("Ag_Offerings_RQ_x").click();
			
		if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_Offerings_RQ_url")))
		{
			System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
			String RQLabel= Page.findelement("Ag_Offerings_RQ_label_x").getText();
			
			if(RQLabel.contains(Page.or.getProperty("Ag_Offerings_RQ_label")))
			{
				System.out.println("Offerings_RQ URL verified sucessfully");
				
			}
			/*else if(CbLabel.contains(Page.or.getProperty("Ag_CreateBrand_label"))){
				
			}*/
			else
			{
				System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_Offerings_RQ_label"));
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
			
			System.out.println("Offerings_RQ Functionality fails due to exception = " + e);
			Assert.fail();
		}	
	
	}
	
	@Test(priority=21)
	public void Offerings_Press_Release()
	{
		try{
			System.out.println("\nTest_case 21: Press Release Tab sanity Begins ");

			Page.findelement("Ag_pr_t_x").click();
			
		if (Page.driver.getCurrentUrl().equals(Page.or.getProperty("Ag_pr_t_url")))
		{
			System.out.println( "Page URL: " + Page.driver.getCurrentUrl());
			String prLabel= Page.findelement("Ag_pr_t_label_x").getText();
			
			if(prLabel.contains(Page.or.getProperty("Ag_pr_t_label")))
			{
				System.out.println("Press Release Tab URL verified sucessfully");
				
			}
			/*else if(CbLabel.contains(Page.or.getProperty("Ag_CreateBrand_label"))){
				
			}*/
			else
			{
				System.out.println("UI/CSS issue at " + Page.or.getProperty("Ag_pr_t_label"));
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
			
			System.out.println("Press Release Functionality fails due to exception = " + e);
			Assert.fail();
		}		
	}
	
/*	@Test(priority=21)
	public void Offerings_search()
	{
		try
		{
		System.out.println("-> Test Case: Search Verification \n");		
		driver.findElement(By.id("search-menu")).click();
		WebElement search=driver.findElement(By.id("s"));
		
		search.sendKeys("Citi Bank");
		driver.findElement(By.id("search-menu3")).click();
		
		Thread.sleep(3000);
		
		if(driver.getCurrentUrl().contains("http://stg.brandwire.in/registered/search?keyword="))
		{
			System.out.println("URL Verified Sucessfully : " + driver.getCurrentUrl());
			String keywordlabel= driver.findElement(By.xpath(".//*[@id='toi-title']")).getText();	
			
			if(keywordlabel.contains("Timesofindia Result(s)"))
			{
				System.out.println("Title of the page: " + keywordlabel);
				System.out.println(" Search sucessfull \n");
			}
			else
			{
				System.out.println("Some CSS/UI Issue at Search Page");
			}
			
			
		}
		else
		{
			System.out.println( " Invalid Page URL: " + driver.getCurrentUrl() + "Test Case Fail");	
		}
	
		
		for(int i=0;i<keyword.length;i++)
		{
			
			//search by click
			System.out.println("-> Test Case: Search Verification ");		
			driver.findElement(By.id("search-menu")).click();
			WebElement search=driver.findElement(By.id("s"));
			search.clear();
			
			search.sendKeys(keyword[i]);
			driver.findElement(By.id("search-menu3")).click();
			
			//search by enter
			WebElement internal_search=driver.findElement(By.cssSelector(".form-control.search-input.ng-pristine.ng-untouched.ng-valid.ng-valid-maxlength"));
			internal_search.clear();
			
			internal_search.sendKeys(keyword[i]);
			
			//now wanted to hit enter key
			//internal_search.sendKeys(Keys.RETURN);
			//internal_search.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			//selenium.keyPressNative("10"); // Enter   
			
			System.out.println("Search By: " + (i+1) + " " + keyword[i]);
			
			
			Thread.sleep(5000);
			
			if(driver.getCurrentUrl().contains("http://stg.brandwire.in/registered/search?keyword="))
			{
				System.out.println("URL Verified Sucessfully : " + driver.getCurrentUrl());
				String keywordlabel= driver.findElement(By.xpath(".//*[@id='toi-title']")).getText();	
				
				if(keywordlabel.contains("Timesofindia Result(s)"))
				{
					System.out.println("Title of the page: " + keywordlabel);
					System.out.println(" Search sucessfull \n");
				}
				else
				{
					System.out.println("Some CSS/UI Issue at Search Page");
				}
				
			}
			else
			{
				System.out.println( " Invalid Page URL: " + driver.getCurrentUrl() + "Test Case Fail");	
			}
		}
		}
		
		catch(Exception e)
		{
			System.out.println( "Exception: " + e);
		}
			
	}*/
	
	@Test(priority=22)
	public void Notification()
	{
		try{
			System.out.println("\nTest_case 22: Notification sanity Begins ");

			//Page.findelement("Ag_Noti_x").click();
			Thread.sleep(3000);
			Page.P_element=Page.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Page.or.getProperty("Ag_Noti_x")))) ;
			Page.P_element.click();
			
			
			String notification=Page.findelement("Ag_Noti_label_x").getText();
			
			if(notification.equals("Notification"))
			{
				System.out.println("Notification Verification pass");
			}
			else
			{
				System.out.println("Some CSS/UI Issue at Notification Page");
				Assert.fail();
			}
			}
		catch(Exception e)
		{
			System.out.println("Notification Functionality fails due to exception = " + e);
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
			WebElement Logoutdropdown=Page.findelement("c_Logoutdropdown_menux");
			WebElement logout= Page.findelement("c_Logout_x");
			
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
				System.out.println("Logout functionality verified sucessfully: " + Page.driver.getCurrentUrl());
				Thread.sleep(3000);	
			}
		}
		catch(Exception e)
		{
			
			System.out.println("Logout Functionality fails due to exception = " + e );
			Assert.fail();
		}

		}

}
