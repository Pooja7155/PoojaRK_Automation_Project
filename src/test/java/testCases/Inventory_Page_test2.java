package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.ScreenCapture;

import base.TestBase;
import pages.Inventory_Page_2;
import pages.Login_Page1;
import utility.CaptureScreenshot;
import utility.ReadData;
import utility.Screenshot_Capture;

public class Inventory_Page_test2 extends TestBase
{
	Login_Page1 login;
	Inventory_Page_2 Inventory;
	
 @BeforeMethod(alwaysRun = true)
 
  public void setup() throws InterruptedException, IOException
  {
	 initialization();
	 login=new Login_Page1();
	 Inventory=new Inventory_Page_2();
	 login.logintoapplication();
  }

 
 @Test(priority=1,enabled=true,groups = "Sanity")
  public void productlableTest() throws EncryptedDocumentException, IOException
 {
	 String explable=ReadData.readExcelFile(1, 0);//Products(1,0)
     String actlable=Inventory.productlable();
     Assert.assertEquals(explable, actlable);
     Reporter.log("Lable of inventory page = " + actlable);
 }
 @Test(priority=9,enabled=true,groups = "Regression")
 public void FooterTest() throws EncryptedDocumentException, IOException
 {
	 String expFooter=ReadData.readExcelFile(1, 1);//© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy(1,1)
	 String actFooter=Inventory.footer();
	 Assert.assertEquals(expFooter, actFooter);
     Reporter.log("Footer of inventory page = " + actFooter);

 }
 @Test(priority=5,enabled=true,groups = "Regression")
 public void BtnMenuTest()
 {
	 boolean result=Inventory.BtnMenu();
	 Assert.assertEquals(result, true);
 }
 
 @Test(priority=6,enabled=true,groups = "Regression")
 public void fblogoTest()
 {
	 boolean result=Inventory.fblogo();
	 Assert.assertEquals(result, true);
 }
 
 @Test(priority=7,enabled=true,groups = "Regression")
 public void twitterTest()
 {
	 boolean result=Inventory.twitterlogo();
	 Assert.assertEquals(result, true);
 }
 @Test(priority=8,enabled=true,groups = "Regression")
 public void linkedinTest()
 {
	 boolean result=Inventory.linkedinlogo();
	 Assert.assertEquals(result, true);
 }

 
 @Test(priority=2,enabled=true,groups = {"Sanity","Retesting"})
 public void add6ProductsTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcelFile(1, 2);//6(1,2)
		String actCount=Inventory.add6items(); 
		Assert.assertEquals(expCount,actCount);
		Reporter.log("Total products added to cart = " + actCount);

	}
 @Test(priority=3,enabled=true,groups = {"Sanity","Retesting"})
 public void remove2itemsTest() throws InterruptedException, EncryptedDocumentException, IOException
 {
	 //Screenshot purpose
	 String expCount=ReadData.readExcelFile(1, 3);//4(1,3)
	 String actCount=Inventory.remove2items();
	 Assert.assertEquals(expCount, actCount);
	 Reporter.log("Total products after removed to cart = " + actCount);

 }
 @Test(priority=4,enabled=true,groups = {"Sanity","Retesting"})
 public void CartPageTest() throws EncryptedDocumentException, IOException
 {
	 String expUrl=ReadData.readExcelFile(1, 4);//https://www.saucedemo.com/cart.html(1,4)
	 String actUrl=Inventory.clicktocart();
	 Assert.assertEquals(expUrl, actUrl);
	 Reporter.log("Url of Current Page"+actUrl);
 }
 
 
 
 @AfterMethod(alwaysRun = true)
 
 public void closebrowser(ITestResult it) throws InterruptedException, IOException
 {
	 if(it.FAILURE==it.getStatus())
		{
			Screenshot_Capture.screenshot(it.getName());
		}
	 Thread.sleep(2000);
	 driver.close();
 }
}
