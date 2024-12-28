package testCases;

import org.testng.annotations.Test;

import TestBase.BaseClass;
import junit.framework.Assert;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	

	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class, groups="Datadriven")
	public void verify_LoginDDT(String email, String psw, String exp)
	{
		
		logger.info("******** Starting TC_003 DDTLogin Test.... ***********");		
		
		
		// Home Page...
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		// Login Page...
		LoginPage lp = new LoginPage(driver);
		lp.setEmailAddress(email);
		lp.setPassword(psw);
		lp.clickLogin();
		
		// My Account Page...
		/*
		 * add  condition and Check the validation part 
		 * 
		Data is valid  and 	login is successful --> Test Pass
		 					login is unsuccessful --> Test Fail
		Data is invalid  and login is successful --> Test Fail
			 				login is unsuccessful --> Pass
		*/
		try
		{
			MyAccountPage ap = new MyAccountPage(driver);
			boolean loginStatus = ap.isMyAccountPageExist();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(loginStatus == true)
				{
					ap.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
				
			}
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(loginStatus == true)
				{
					ap.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			Assert.fail();
		}		
		
		logger.info("******** Finished TC_003 DDTLogin Test.... ***********");		
	}
}
