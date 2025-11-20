package Testcases;


import org.testng.Assert;

/*Data is valid=login sucess-test pass-logout
 * data is valid-login failed-test fail
 * 
 * data is not valid=login success-test fail-logout
 * data is not valid=login fail-test pass
 */

import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import Utilities.DataProviders;

public class TC03_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven") //getting the data provider from the diffrent class
	public void verify_login(String email,String pwd,String exp) 
	{
	  //logger.info("***Staring of TC03_LoginDDT**");
	  try
	  {
	    HomePage hp=new HomePage(driver);
	    hp.ClickMyaccount();
	    hp.ClickLogin();
	
	   //Login page
	   LoginPage lp=new LoginPage(driver);
	   lp.setEmail(p.getProperty("email"));
	   lp.setPasswordLogin(p.getProperty("password"));
	
	//My account page
	   MyAccountPage macc=new MyAccountPage(driver);
	   boolean targetPage=macc.isMyAccountPageExist();
	
	  if(exp.equalsIgnoreCase("Valid"))
	  {
		  if(targetPage==true)
		  {
			  
			  macc.clickLogout();
			  Assert.assertTrue(true);
		  }
		  else
		  {
			  Assert.assertTrue(false);
		  }
		  
	  }
	  
	  if(exp.equalsIgnoreCase("Invalid"))
	  {
		  if(targetPage==true)
		  {
			  
			  macc.clickLogout();
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
		Assert.fail();	
      }

	 //  logger.info("****Finished TC03-LoginDDT****");
	}
	
}

