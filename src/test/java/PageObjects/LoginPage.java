package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPasswordLogin;
	
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	public void setEmail(String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPasswordLogin(String pwd)
	{
		txtPasswordLogin.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		//btnLogin.click();
		
		//btnLogin.submit();
		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(5));
	       mywait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
	}

	
	
	
}
