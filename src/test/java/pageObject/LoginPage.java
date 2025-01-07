package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
		
	@FindBy(xpath="//input[@placeholder='E-Mail Address']") WebElement txt_email;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement txt_password;
	@FindBy(xpath="//input[@value='Login']") WebElement btnLogin;
	 	
	
	public void setEmailAddress(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setPassword(String pass)
	{
		txt_password.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
}
