package bw_dd_core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import bw_dd_util.TestUtil;
import bw_dd_util.Xls_Reader;

public class Page {
	
	//deaclraing common fields
	public static WebDriver driver=null;
	public static FileInputStream cf=null;
	public static FileInputStream of=null;
	public static Properties config=null;
	public static Properties or=null;
	public static WebDriverWait wait=null;
	public static WebElement P_element=null;
	public static Logger logs = Logger.getLogger("devpinoyLogger");
	
	
	
	//call methods customize methods created for excel using in utility class
	public static Xls_Reader excel= new Xls_Reader(System.getProperty("user.dir") + "\\src\\bw_dd_properties\\BW_testdata.xlsx");
	
	//initialize broser and connection to product url
	
	@BeforeSuite
	public void init() throws IOException
	{
		if(driver==null)
		{
			cf=new FileInputStream(System.getProperty("user.dir") + "\\src\\bw_dd_properties\\config.properties");
			config= new Properties();
			config.load(cf);
			logs.debug("loaded config file");
			
			of= new FileInputStream(System.getProperty("user.dir") + "\\src\\bw_dd_properties\\or.properties");
			or=new Properties();
			or.load(of);
			logs.debug("loaded object repositry file ");
			
			if(config.getProperty("browser").equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "F:\\jars\\chromedriver.exe");
				driver=new ChromeDriver();
				logs.debug("loaded chrome driver ");
			}
			else if(config.getProperty("browser").equals("Firefox"))
			{
				driver=new FirefoxDriver();
				logs.debug("loaded firefox driver ");
			}
			else if(config.getProperty("browser").equals("IE"))
			{
				System.setProperty("webdriver.ie.driver", "F:\\jars\\IEDriverServer.exe");
				driver= new InternetExplorerDriver();
				logs.debug("loaded IE driver ");
			}
			
			driver.get(config.getProperty("Live_server_url"));
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
			wait=new WebDriverWait(driver, 30);
			logs.debug("Hit test url ");
			System.out.println("\nBrandwire Home Page: "+ driver.getCurrentUrl());
		}
	}
	
	@AfterSuite
	public static void exit()
	{
		System.out.println("\n Test Suite Execution completes, Therefore closing all open sesssion ");
		logs.debug("closing all current session");
		driver.quit();
	}
	
	//method return xpath of webelemnt
	public static WebElement findelement(String key) throws IOException
	{
		try{
			logs.debug("return xpath" + key);
			return driver.findElement(By.xpath(or.getProperty(key)));
		
			}
		catch(Throwable t)
		{
			TestUtil.CaptureScreenshot();
			logs.debug("issue in returning element xpath");
			return null;
		}
	}
}
