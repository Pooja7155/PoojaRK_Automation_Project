package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReportManager;
import utility.ReadData;

public class TestBase 
{
	public ExtentReports report=ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	
	public static WebDriver driver;
	public void initialization() throws InterruptedException, IOException
	{
		String browser=ReadData.readPropertyFile("Browser");
		if(browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver().clearDriverCache().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}	
	    
		driver.manage().window().maximize();
		driver.get(ReadData.readPropertyFile("URL"));
		driver.manage().deleteAllCookies();
		Thread.sleep(4000);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 /*  public static ChromeDriver driver;
   public void initialization() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
		--to run title / currentURL/ loginto app test cases
		*/
	
	}
	private void clear_cache(WebDriver driver2) {
		// TODO Auto-generated method stub
		
	}
}
