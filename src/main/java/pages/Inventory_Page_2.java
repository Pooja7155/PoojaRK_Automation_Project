package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.TestBase;
import utility.DropdownHandle;

public class Inventory_Page_2 extends TestBase

{
    //object repository of all elements
	//@FindBy(xpath="//a[@class='shopping_cart_link']") private  WebElement addtocart;
	@FindBy(xpath="//a[@class=\"shopping_cart_link\"]" ) private WebElement CartPage;

	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement addtocart;	  
	@FindBy(xpath="//select[@class=\"product_sort_container\"]") private  WebElement dropDown;
	@FindBy(xpath="//button[@id=\"react-burger-menu-btn\"]") private  WebElement BtnMenu;
	@FindBy(xpath="//button[@id=\"react-burger-cross-btn\"]") private  WebElement CloseBtnMenu;

	@FindBy(xpath="//span[@class=\"title\"]") private  WebElement productLable;
	@FindBy(xpath="//a[text()='Twitter']") private  WebElement twitter;
	@FindBy(xpath="//a[text()='Facebook']") private  WebElement fb;
	@FindBy(xpath="//a[text()='LinkedIn']") private  WebElement linkedin;
	@FindBy(xpath="//div[@class=\"footer_copy\"]") private  WebElement Footer;
	
	// elements-addtocart
	@FindBy(xpath="//button[@id=\"add-to-cart-sauce-labs-backpack\"]") private  WebElement Bagpack;
	@FindBy(xpath="//button[@id=\"add-to-cart-sauce-labs-bike-light\"]") private  WebElement Bikelight;
	@FindBy(xpath="//button[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]") private  WebElement BlackTshirt;
	@FindBy(xpath="//button[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]") private  WebElement Jacket;
	@FindBy(xpath="//button[@id=\"add-to-cart-sauce-labs-onesie\"]") private  WebElement onesize;
	@FindBy(xpath="//button[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]") private  WebElement RedTshirt;
	
	//elements-removed from cart
	@FindBy(xpath="//button[@id=\"remove-sauce-labs-backpack\"]") private  WebElement NoBagpack;
	@FindBy(xpath="//button[@id=\"remove-sauce-labs-bike-light\"]") private  WebElement NoBikelight;
	@FindBy(xpath="//button[@id=\"remove-sauce-labs-bolt-t-shirt\"]") private  WebElement NoBlackTshirt;
	@FindBy(xpath="//button[@id=\"remove-sauce-labs-fleece-jacket\"]") private  WebElement NoJacket;
	@FindBy(xpath="//button[@id=\"remove-labs-onesie\"]") private  WebElement Noonesize;
	@FindBy(xpath="//button[@id=\"remove-test.allthethings()-t-shirt-(red)\"]") private  WebElement NoRedTshirt;
	
	//Constructor
	public Inventory_Page_2()
	{
		PageFactory.initElements(driver, this);
	}
    public String productlable()
      {
    	return productLable.getText();
      }

    public boolean BtnMenu()
    {
    	return BtnMenu.isEnabled();
    }
   
    public boolean fblogo()
    {
    	return fb.isDisplayed();

    }
    public boolean linkedinlogo()
    {
    	return linkedin.isDisplayed();
    }
    public boolean twitterlogo()
    {
    	return twitter.isDisplayed();

    }
    public String footer()
    {
    	return Footer.getText();

    }
    public String add6items()
    {
    	DropdownHandle.handleSelectClass(dropDown, "Price (low to high)");	
    	Bagpack.click();
    	Bikelight.click();
    	BlackTshirt.click();
    	Jacket.click();
    	onesize.click();
    	RedTshirt.click();
    	return addtocart.getText();
    }
    public String remove2items() throws InterruptedException
    {
    	add6items();
    	Thread.sleep(3000);
    	NoBagpack.click();
    	NoBikelight.click();
    	return addtocart.getText();
    	
    }
    public String clicktocart()
    {
    	CartPage.click();
 	   return driver.getCurrentUrl();
 		
    }

}
