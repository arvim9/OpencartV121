package testCases;

import org.testng.annotations.Test;

import TestBase.BaseClass;
import junit.framework.Assert;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class TC002LoginTest extends BaseClass {
	
	@Test(groups = {"Sanity","Master"})
	public void verify_login()
	{
		logger.info("******* Startng TC_002 Login text ******");
		
		try
		{
			// Home Page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			
			// Login Page
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAddress(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
						
			// My Account Page 
			
			MyAccountPage map = new MyAccountPage(driver);
			boolean status = map.isMyAccountPageExist();
				
			System.out.println("Login Status: " +status);
			
			Assert.assertEquals(true, status);
			//Assert.assertTrue(status);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("******* Finished TC_002 Login text ******");
		
			
	}

}
