package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountPage extends  BasePage  {

	//constructor

		public AccountPage(WebDriver driver) {
			super(driver);
		}


		//locators
		@FindBy(xpath = "//h1[normalize-space()='My Account']")
		WebElement confirmationText_MyAccount;

		@FindBy(xpath = "//a[normalize-space()='Edit your affiliate information']")
				WebElement link_Affiliate;

		@FindBy(xpath ="//input[@id='input-company']" )
				WebElement company_Input;
		@FindBy(xpath = "//input[@id='input-website']")
				WebElement website_Input;
		@FindBy(xpath = "//input[@id='input-tax']")
				WebElement taxId_Input;
		@FindBy(xpath = "//input[@id='input-payment-paypal']")
				WebElement paypal_RadioSelect;
		@FindBy(xpath = "//input[@id='input-paypal']")
				WebElement paypal_Input;
		@FindBy(xpath = "//button[normalize-space()='Continue']")
				WebElement continue_Btn;

		@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")
		WebElement Affiliate_Success_Msg;

		@FindBy(xpath = "//li[@class='list-inline-item']//i[@class='fa-solid fa-caret-down']")
		WebElement dropDown_MyAccount;

		@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
		WebElement link_Logout;
	        
		//action methods

		public WebElement getMyAccountConfirmation() {
			return confirmationText_MyAccount;
		}

		public void click_Link_Affiliate(){
			link_Affiliate.click();
		}

		public  void fillOutAffiliateForm(){
			company_Input.sendKeys("hicham Development services");
			website_Input.sendKeys("www.hmDev.com");
			taxId_Input.sendKeys("2154 231 5487563");
			paypal_RadioSelect.click();
			paypal_Input.clear();
			paypal_Input.sendKeys("hicham@gmail.com");
			continue_Btn.click();
		}
		
		public WebElement affiliateMsg() {
			return Affiliate_Success_Msg;
		}
		public void clickMyAccountDropDown() {
			dropDown_MyAccount.click();
		}

		public void clickLogout() {
			link_Logout.click();
		}
	
}
