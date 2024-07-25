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
import pages.Inventory_Page_2;
import pages.Login_Page1;
import utility.ReadData;
import utility.Screenshot_Capture;


public class CheckOut1_Page_test4 extends TestBase
{
	
	Login_Page1 login;
	Inventory_Page_2 Inventory;
	Cart_Page_3 cart;
	CheckOut1_Page_4 Check1;
   @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException, InterruptedException
     {
	initialization();
	login =new Login_Page1();
	Inventory= new Inventory_Page_2();
	cart = new Cart_Page_3();
	Check1=new CheckOut1_Page_4(); 
	login.logintoapplication();
	Inventory.add6items();
	Inventory.clicktocart();
	cart.verifyUrlCheckout();

	 }
@Test(priority=4,enabled=true)
public void checkoutTextTest() throws EncryptedDocumentException, IOException
{
String expText=ReadData.readExcelFile(3, 0);//span(3,0)
String actText=Check1.verifycheckoutText();
Assert.assertEquals(expText, actText);
Reporter.log("Actual Text of Checkout is  "+ actText);

}
@Test(priority=3,enabled=true)
public void currentURLTest() throws EncryptedDocumentException, IOException
    {
	String expURL=ReadData.readExcelFile(3, 1);//https://www.saucedemo.com/checkout-step-one.html(3,1)
	String actURL=Check1.currentURL();
	Assert.assertEquals(expURL, actURL);
	Reporter.log("Actual Current URL of Checkout1 is  "+ actURL);

	
	}
@Test(priority=1,enabled=true)
public void EnterCustDetailsTest() throws EncryptedDocumentException, IOException 
{
String expURL=ReadData.readExcelFile(3, 2);//https://www.saucedemo.com/checkout-step-two.html(3,2)
String actURL=Check1.EnterCustDetails();
Assert.assertEquals(expURL, actURL);
Reporter.log("After entering customers details URL is  "+ actURL);
}
@Test(priority=2,enabled=true)
public void CancelTest() throws EncryptedDocumentException, IOException
{
	String expURL=ReadData.readExcelFile(3, 3);//https://www.saucedemo.com/cart.html(3,3)
	String actURL=Check1.Cancel();
	Assert.assertEquals(expURL, actURL);
	Reporter.log("Clickon cancelbtn of checkout page1 "+ actURL);
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
