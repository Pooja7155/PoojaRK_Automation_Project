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
import pages.Check_Out_Page1;
import pages.Inventory_Page_2;
import pages.Inventory_page_2;
import pages.LoginPage;
import pages.Login_Page1;
import pages.cartPage;
import pages.check_out_page_2;
import utility.CaptureScreenshot;
import utility.ReadData;

public class CheckOut2_Page_test5 extends TestBase
{
	Login_Page1 login;
	Inventory_Page_2 Inventory;
	Cart_Page_3 cart;
	CheckOut1_Page_4 Check1;
	CheckOut2_Page5 Check2;
	@BeforeMethod(alwaysRun = true)
	   
	   public void setup() throws InterruptedException, IOException
		{
		initialization();
		login =new Login_Page1();
		Inventory= new Inventory_Page_2();
		cart = new Cart_Page_3();
		Check1=new CheckOut1_Page_4();
		Check2=new CheckOut2_Page5();
		login.logintoapplication();
		Inventory.add6items();
		Inventory.clicktocart();
		cart.verifyUrlCheckout();
		Check1.EnterCustDetails();
					
        }
	
	@Test(priority=2,enabled=true)
	public void TitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expLable=ReadData.readExcelFile(4, 0);//Checkout: Overview(4,0)
		String actlable=Check2.verifyTitleOfApplication();
		Assert.assertEquals(expLable, actlable);
	}

	@Test(priority=1,enabled=true)
	public void clickOnFinishBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcelFile(4, 1);//https://www.saucedemo.com/checkout-complete.html(4,1)
		String actURL=Check2.clickOnFinishBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("finishBtn of check out page 2 "+ actURL);
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
