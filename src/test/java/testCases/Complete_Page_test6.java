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
import pages.Cart_Page_3;
import pages.CheckOut1_Page_4;
import pages.CheckOut2_Page5;
import pages.Complete_Page6;
import pages.Inventory_Page_2;
import pages.Login_Page1;
import utility.CaptureScreenshot;
import utility.ReadData;

public class Complete_Page_test6 extends TestBase
{
	Login_Page1 login;
	Inventory_Page_2 Inventory;
	Cart_Page_3 cart;
	CheckOut1_Page_4 Check1;
	CheckOut2_Page5 Check2;
	Complete_Page6 Complete;
	@BeforeMethod(alwaysRun = true)
	   
	   public void setup() throws InterruptedException, IOException
		{
		initialization();
		login =new Login_Page1();
		Inventory= new Inventory_Page_2();
		cart = new Cart_Page_3();
		Check1=new CheckOut1_Page_4();
		Check2=new CheckOut2_Page5();
		Complete= new Complete_Page6();
		login.logintoapplication();
		Inventory.add6items();
		Inventory.clicktocart();
		cart.verifyUrlCheckout();
		Check1.EnterCustDetails();
		Check2.clickOnFinishBtn();
		}			
  
  
  
  
  
  @Test(priority=4,enabled=true)
  public void verifycheckoutCompleteLableTest() throws EncryptedDocumentException, IOException
  {
  String expLable=ReadData.readExcelFile(5, 0);//Checkout: Complete!(5,0)
  String actLable=Complete.verifycheckoutCompleteLable();
  Assert.assertEquals(expLable, actLable);
  Reporter.log("Complete Level Page Lable "+actLable);
  }
  @Test(priority=2,enabled=true)
  public void verifyThankyouMessageTest() throws EncryptedDocumentException, IOException
  {
  String expText=ReadData.readExcelFile(5, 1);//Thank you for your order!(5,1)
  String actText=Complete.verifyThankyouMessage();
  Assert.assertEquals(expText, actText);
  Reporter.log("Text Message Thank You "+actText);
  }
  @Test(priority=3,enabled=true)
  public void verifyYourOrderMessageTest() throws EncryptedDocumentException, IOException
  {
  String expText=ReadData.readExcelFile(5, 2);//Your order has been dispatched, and will arrive just as fast as the pony can get there!(5,2)
  String actText=Complete.verifyYourOrderMessage();
  Assert.assertEquals(expText, actText);
  Reporter.log("Text Message You Order "+actText);
  }
  @Test(priority=1,enabled=true)
  public void verifyBackHomebtnTest() throws EncryptedDocumentException, IOException
  {
  String expUrl=ReadData.readExcelFile(5, 3);//https://www.saucedemo.com/inventory.html(5,3)
  String actUrl=Complete.verifyBackHomebtn();
  Assert.assertEquals(expUrl, actUrl);
  Reporter.log("Url of Page "+actUrl);
  }
  
  @AfterMethod(alwaysRun = true)
  public void closeBrowser(ITestResult it) throws IOException 
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.screenshot(it.getName());
		}
			driver.close();
}
}
