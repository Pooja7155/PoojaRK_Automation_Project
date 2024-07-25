package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.model.Test;

import base.TestBase;

public class CheckOut2_Page5 extends TestBase
{@FindBy(xpath= "//span[@class='title']")private WebElement checkoutpage2label;
@FindBy(xpath="//button[@name='finish']") private WebElement finishBtn;
//@FindBy(xpath="//button[@class='btn btn_secondary back btn_medium cart_cancel_link']") private WebElement cancelBtn;
public CheckOut2_Page5()
{
	  PageFactory.initElements(driver, this);
	  
}

public String verifyTitleOfApplication()
{
	
	  return checkoutpage2label.getText();
}
public String clickOnFinishBtn()
{
	 finishBtn.click();
	return driver.getCurrentUrl();
}



}
