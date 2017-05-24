package bw_dd_testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bw_dd_util.TestUtil;

public class BrokenLinks {

	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("BrokenLinks"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	public static HttpURLConnection huc = null;
	public static List<WebElement> links=null;
	public static String url = null;
	public static int respCode = 200;
	public static Iterator<WebElement> itr=null;
	public static WebDriver driver=null;
	public static String homePage = "https://www.brandwire.in/";
	public static String pr_url="https://www.brandwire.in/press-releases.html";
	
	@Test (priority=1)
	public static void home_page_links_testing()
	{
		System.out.println("Verifying broken links at home page");
        
        links = driver.findElements(By.tagName("a"));
        
        itr = links.iterator();
        
        while(itr.hasNext()){
            
        url = itr.next().getAttribute("href");
            
        System.out.println(url);
        
        if(url == null || url.isEmpty()){
        System.out.println("URL is either not configured for anchor tag or it is empty");
        continue;
    }
            
        if(!url.startsWith(homePage))
        {
        System.out.println("URL belongs to another domain, skipping it.");
        continue;
        }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("GET");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
     
	}

	/*@Test (priority=2)
	public static void pr_links_testing() 
	{
		try{
		System.out.println("Verifying broken links at press releases page");
		
		driver.findElement(By.xpath(".//*[@id='press-releases']/a")).click();
		Thread.sleep(3000);
        
        links = driver.findElements(By.tagName("a"));
        
        itr = links.iterator();
        
        while(itr.hasNext()){
            
        url = itr.next().getAttribute("href");
            
        System.out.println(url);
        
        if(url == null || url.isEmpty()){
        System.out.println("URL is either not configured for anchor tag or it is empty");
        continue;
    }
            
        if(!url.startsWith(homePage))
        {
        System.out.println("URL belongs to another domain, skipping it.");
        continue;
        }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("GET");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        
       

    
	}*/
	
}
