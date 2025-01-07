package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy(xpath="//a[normalize-space()='Edit your account information']") WebElement myAccount;  	// My account page heading.
	
	@FindBy(xpath="//body//div//a[13]") WebElement lnklogout;	// Get logout element // added in step #6
	
	
	public boolean isMyAccountPageExist() throws InterruptedException
	{
		//Thread.sleep(3000);
		try
		{			
			return myAccount.isDisplayed();
		}
		catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public void clickLogout()
	{
		lnklogout.click();
	}
}
