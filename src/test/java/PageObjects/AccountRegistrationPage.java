package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public  AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLasttname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTele;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtCnfpassword;
	
	
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement toggleAgree;
	
	@FindBy(xpath="//input[@value='Continue']") 
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") 
	WebElement confirmationMsg;
	
	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname)
	{
		txtLasttname.sendKeys(lname);
	}                                      
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String teleNum)
	{
		txtTele.sendKeys(teleNum);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void setCnfpassword(String password)
	{
		txtCnfpassword.sendKeys(password);
	}
	
	public void clickAgreetoggle()
	{
		toggleAgree.click();
	}
	
	public void clickContinue()
	{
		//sol1
       //btnContinue.click();
       
       //sol2
      // btnContinue.submit();
       
       //sol3
       //Actions act=new Actions(driver);
      // act.moveToElement(btnContinue).click().perform();
       
       WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(5));
       mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
       
       
       
       
	}
	
	public String getConfirmationmessage()
	{
		try
		{
			return (confirmationMsg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
			
		}
		
		
	}     
	   
}  
