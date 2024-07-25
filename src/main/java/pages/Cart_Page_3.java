package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.model.Test;

import base.TestBase;

public class Cart_Page_3 extends TestBase
{
  //Object Repository
	@FindBy(xpath="	//span[@class=\"title\"]" ) private WebElement YourCartLabel;
	@FindBy(xpath="	//div[@class=\"cart_quantity_label\"]" ) private WebElement QTYLabel;
	@FindBy(xpath="	//div[@class=\"cart_desc_label\"]" ) private WebElement DescriptionLable;
	@FindBy(xpath="	//button[@name=\"continue-shopping\"]" ) private WebElement ContinueShopping;
	@FindBy(xpath="	//button[@name=\"checkout\"]" ) private WebElement CheckOut;
	
	//Constructor
	public Cart_Page_3()
	{
		PageFactory.initElements(driver, this);
	}
	public String YourCartLabel()
	{
		return YourCartLabel.getTagName();
		
	}
	public String QTYLabel()
	{
		return QTYLabel.getText();
	}
	
	public String DescriptionLable()
	{
		return DescriptionLable.getText();
	}
	public String verifyContinueShoppingCartUrl()
	{
		ContinueShopping.click();
		return driver.getCurrentUrl();
	}
	public String verifyUrlCheckout()
	{
		CheckOut.click();
		return driver.getCurrentUrl();
	}
	}
