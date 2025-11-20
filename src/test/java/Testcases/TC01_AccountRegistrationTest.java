package Testcases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;

public class TC01_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		//logger.info("Starting TC01_AccountRegistrationTest ");
		try
		{
		
		HomePage hp=new HomePage(driver);
		hp.ClickMyaccount();
		//logger.info("Clicked on My account");
		
		hp.ClickRegister();
		//logger.info("Clicked on register");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		//logger.info("Providing user details");
		
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphanumeric();
		regpage.setPassword(password);
		regpage.setCnfpassword(password);
		
		regpage.clickAgreetoggle();
		regpage.clickContinue();
		
		//logger.info("Validating confirmation message");
		String confmsg=regpage.getConfirmationmessage();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		}
		catch(Exception e)
		{
			//logger.error("Test failed");
			//logger.debug("Debug logs....");
			Assert.fail();
		}
	}
		
		 
		
		
	}



