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
import pages.Inventory_Page_2;
import pages.Inventory_page_2;
import pages.LoginPage;
import pages.Login_Page1;
import pages.cartPage;
import utility.ReadData;
import utility.Screenshot_Capture;

public class Cart_Page_test3  extends TestBase
{   
	Login_Page1 login;
	Inventory_Page_2 Inventory;
	Cart_Page_3 cart;
	
	
	
	@BeforeMethod(alwaysRun = true)
	 public void setup() throws InterruptedException, IOException
	  {
		initialization();
		login=new Login_Page1();
		Inventory=new Inventory_Page_2();
		cart=new Cart_Page_3();
		login.logintoapplication();
		Inventory.add6items();
		Inventory.clicktocart();
		
		
	  }
	@Test(priority=5,enabled=true)
	public void YourCartLabelTest() throws EncryptedDocumentException, IOException
	{
		 String explable=ReadData.readExcelFile(2, 0);//span(2,0)
		 String actlable=cart.YourCartLabel();
		 Assert.assertEquals(explable, actlable);
		 Reporter.log("Lable of Your Cart is = "+actlable);
	}
	@Test(priority=4,enabled=true)
	public void QTYLabelTest() throws EncryptedDocumentException, IOException
	{
		 String explable=ReadData.readExcelFile(2, 1);//QTY(2,1)
		 String actlable=cart.QTYLabel();
		 Assert.assertEquals(explable, actlable);
		 Reporter.log("Lable of QTY is = "+ actlable);
	}
	@Test(priority=3,enabled=true)
	public void DescriptionLableTest() throws EncryptedDocumentException, IOException
	{
		 String explable=ReadData.readExcelFile(2, 2);//Description(2,2)
		 String actlable=cart.DescriptionLable();
		 Assert.assertEquals(explable, actlable);
		 Reporter.log("Lable of Description is = "+actlable);
	}
	@Test(priority=2,enabled=true)
	public void ContinueShoppingTest() throws EncryptedDocumentException, IOException
	{
		String expurl=ReadData.readExcelFile(2, 3);//https://www.saucedemo.com/inventory.html(2,3)
		String acturl=cart.verifyContinueShoppingCartUrl();
		Assert.assertEquals(expurl, acturl);
		Reporter.log("current url after clicking continue shopping"+acturl);
	}
	
	@Test(priority=1,enabled=true)
	public void checkoutTest() throws EncryptedDocumentException, IOException
	{
		String expurl=ReadData.readExcelFile(2, 4);//https://www.saucedemo.com/checkout-step-one.html(2,4)
		String acturl=cart.verifyUrlCheckout();
		Assert.assertEquals(expurl, acturl);
		Reporter.log("current url after clicking checkout "+acturl);

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
