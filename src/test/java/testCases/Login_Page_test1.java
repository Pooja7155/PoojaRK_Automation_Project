package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Login_Page1;
import utility.ReadData;
import utility.Screenshot_Capture;

public class Login_Page_test1 extends TestBase

{
	Login_Page1 login;
	@BeforeMethod(alwaysRun = true)
 public void setup() throws  IOException, InterruptedException
 {
	 initialization();
	 login=new Login_Page1();
 }
 @Test(priority=3,enabled=true,groups = "Sanity")
 
 public void titleofswaglabsTest() throws EncryptedDocumentException, IOException
 {
	 String exptit=ReadData.readExcelFile(0, 0);//"Swag Labs"(0,0)
     String acttit=login.titleofswaglabs();
     Assert.assertEquals(exptit, acttit);
     Reporter.log("Title of Page ="+acttit);
 }
 
 @Test(priority=2,enabled=true,groups = {"Sanity","Retesting"})
 public void currentURLTest() throws EncryptedDocumentException, IOException
 {
	 String expURL=ReadData.readExcelFile(0, 1);//"https://www.saucedemo.com/"(0,1)
	 String actURL=login.currentURL();
	 Assert.assertEquals(expURL, actURL);
	 Reporter.log("Current URL of page = " +actURL);
 }
 @Test(priority=1,enabled=true,groups = "Sanity")
 public void logintoapplicationTest() throws IOException
 {//ExtentReport TestCase
	 String expURL=ReadData.readExcelFile(0, 2);//"https://www.saucedemo.com/inventory.html"(0,2)
	 String actURL=login.logintoapplication();
	 Assert.assertEquals(expURL, actURL);
	 Reporter.log("URL after Login to App =" +actURL);
 }
 
 
 @AfterMethod(alwaysRun = true)
 public void closebrowser(ITestResult it) throws IOException
 {
	 if(it.FAILURE==it.getStatus())
		{
			Screenshot_Capture.screenshot(it.getName());
		}
		report.flush();//ExtentReport
        driver.close();
 }
}
