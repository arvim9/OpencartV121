package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage 
{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//a[@title='My Account']//span[1]") 	WebElement lnkMyaccount;
	@FindBy(xpath = "//a[normalize-space()='Register']") 	WebElement lnkRegister;
	@FindBy(xpath = "//nav//div//div//li//li[2]//a[1]")		WebElement lnkLogin;
 	
	
	public void clickMyAccount()
	{
		lnkMyaccount.click();
	}
	
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
}
