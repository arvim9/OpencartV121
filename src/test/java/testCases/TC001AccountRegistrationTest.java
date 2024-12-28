package testCases;

import org.testng.annotations.Test;

import TestBase.BaseClass;
import junit.framework.Assert;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;


public class TC001AccountRegistrationTest extends BaseClass {
	
	//WebDriver driver;
	
	@Test(groups = {"Regression","Master"})
	public void verify_account_registration()
	{
		try
		{
			logger.info("***** Starting the test ****");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on my account link...");
			hp.clickRegister();
			logger.info("Clicked on register link...");
			AccountRegistrationPage reg = new AccountRegistrationPage(driver);
			logger.info("Providing user details...");
			reg.setFirstName(randomString().toUpperCase());
			reg.setLastName(randomString().toUpperCase());
			reg.setEmail(randomString()+"@yopmail.com");
			reg.setTelephone(randomNumber());
			String password = randomAlphaNumeric();
			reg.setPassword(password);
			reg.setConfirmPassword(password);
			reg.setPolicy();
				
			reg.clickContinue();
			logger.info("Validating expected message after registering...");
			String confmsg = reg.getConfirmationMsg();
			System.out.println(confmsg);
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test failed...");
			logger.debug("Debug log");
			Assert.fail();
			
		}
	}
	
	
	
}
