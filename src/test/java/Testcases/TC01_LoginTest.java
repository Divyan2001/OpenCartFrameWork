package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;

public class TC01_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() 
	{
		//logger.info("***Started TC02_login***");
		try
		{
		//homepage
		HomePage hp=new HomePage(driver);
		hp.ClickMyaccount();
		hp.ClickLogin();
		
		//Login page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPasswordLogin(p.getProperty("password"));
		lp.clickLogin();
		
		
		//My account page
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExist();
		
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		//logger.info("**Finished TC01 execution***");
		
	}

}
