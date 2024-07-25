package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class Login_Page1 extends TestBase
{
	//OBJECT REPOSITORY

	@FindBy(xpath="//input[@name='user-name']") private WebElement usertxtbox;
	@FindBy(xpath="//input[@name='password']") private WebElement passtxtbox;
	@FindBy(xpath="//input[@name='login-button']") private WebElement logintxtbox;

	//CONSTRUCTOR //PAGEFACTORY
	public Login_Page1() 
	{
		PageFactory.initElements(driver, this);
	}
     public String titleofswaglabs() 
    {
	 return driver.getTitle();
    }
     
    public String currentURL()
    {
	 return driver.getCurrentUrl();
    }
    
    public String logintoapplication() throws IOException
    {//Extent Report
     logger=report.createTest("Login to Sauce Lab Application");	
     usertxtbox.sendKeys(ReadData.readPropertyFile("Username"));
	 logger.log(Status.INFO,"User Name is entered");
     passtxtbox.sendKeys(ReadData.readPropertyFile("Password"));
	 logger.log(Status.INFO,"Password is entered"); 
     logintxtbox.click();
     logger.log(Status.INFO,"Login Button is clicked"); 
	 logger.log(Status.PASS,"Login is sucessful");
		
     return driver.getCurrentUrl();
    }
    
}
 