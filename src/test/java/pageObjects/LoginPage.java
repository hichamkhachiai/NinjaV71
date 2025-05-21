package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends  BasePage{
	

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	//Locators
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email_input;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password_input;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement login_btn;

	
	
	
	//Action Methods
	
		public void setEmail(String email){email_input.sendKeys(email);}
		
		public void setPwd(String pwd){password_input.sendKeys(pwd);}
		
		public void clickLogin(){login_btn.click();}


}
