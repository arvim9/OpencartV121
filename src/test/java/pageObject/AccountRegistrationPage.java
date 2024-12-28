package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{	
	// Constructor...
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//@FindBy(xpath="//input[@placeholder='First Name']") WebElement txtFirstname;
	@FindBy(xpath="//input[@placeholder='First Name']") @CacheLookup private WebElement txtFirstName;
	@FindBy(xpath="//input[@placeholder='Last Name']") @CacheLookup private WebElement txtLastName;
	
	@FindBy(xpath="//input[@placeholder='E-Mail']") @CacheLookup private WebElement txtEmail;
	@FindBy(xpath="//input[@placeholder='Telephone']") @CacheLookup private WebElement txtTelephone;
	@FindBy(xpath="//input[@placeholder='Password']") @CacheLookup private WebElement txtPassword;
	@FindBy(xpath="//input[@placeholder='Password Confirm']") @CacheLookup private WebElement txtConfirmPassword;
	//@FindBy(xpath="//body//div//div//div//form") @CacheLookup private WebElement yesNewsletter;
	//@FindBy(xpath="//input[@value='0']") @CacheLookup private WebElement NoNewsletter;
	@FindBy(xpath="//input[@type='checkbox']") @CacheLookup private WebElement chkPolicy;
	@FindBy(xpath="//input[@value='Continue']") @CacheLookup private WebElement btnContinue;	
	@FindBy(xpath="//body/div/div/div/h1[1]") @CacheLookup private WebElement msgConfirmation;
	
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String phone)
	{
		txtTelephone.sendKeys(phone);
	}
	
	public void setPassword(String psw)
	{
		txtPassword.sendKeys(psw);
	}
	
	public void setConfirmPassword(String psw)
	{
		txtConfirmPassword.sendKeys(psw);
	}
	
	public void setPolicy()
	{
		chkPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try
		{
			return msgConfirmation.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
}
