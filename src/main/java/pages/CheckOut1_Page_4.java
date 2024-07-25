package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOut1_Page_4 extends TestBase
{
	//object repository
	@FindBy(xpath="//span[text()=\"Checkout: Your Information\"]") private WebElement checkoutText;
	@FindBy(xpath="//input[@name=\"firstName\"]") private WebElement firsttxtBox;
	@FindBy(xpath="//input[@name=\"lastName\"]") private WebElement lasttextBox;
	@FindBy(xpath="//input[@name=\"postalCode\"]") private WebElement ziptxtBox;

	@FindBy(xpath="//button[@name=\"cancel\"]") private WebElement cancelBtn;
	@FindBy(xpath="//input[@name=\"continue\"]") private WebElement ContinueBtn;

	//Constructor
	public CheckOut1_Page_4()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifycheckoutText()
	{
		return checkoutText.getTagName();
	}
	public String currentURL ()
	{
		return driver.getCurrentUrl();
	}
	public String EnterCustDetails ()
	{
		firsttxtBox.sendKeys("Pooja");
		lasttextBox.sendKeys("Kulkarni");
		ziptxtBox.sendKeys("430125");
		ContinueBtn.click();
		return driver.getCurrentUrl();
	}
    public String Cancel()
    {
    	cancelBtn.click();
    	return driver.getCurrentUrl();
    }
}
