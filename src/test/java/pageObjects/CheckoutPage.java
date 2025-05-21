package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends  BasePage{
WebDriver driver;
	


	//constructor
	public CheckoutPage(WebDriver driver){
	    super(driver);
	}
	
	
	//Locators
	
	// dropdown menu
	@FindBy(xpath ="//select[@id='input-shipping-address']" )
	        WebElement dropdownMenu;
	
	@FindBy(xpath ="//button[@id='button-shipping-methods']" )
	        WebElement shippin_Method_Btn;
	
	@FindBy(xpath = "//button[@id='button-shipping-method']")
	WebElement continueShip_Btn;
	
	@FindBy(xpath = "//button[@id='button-payment-methods']")
	        WebElement payment_Method_Btn;
	
	@FindBy(xpath = "//button[@id='button-payment-method']")
	        WebElement continuePayment_Btn;
	
	@FindBy(xpath = "//button[@id='button-confirm']")
	        WebElement confirm_btn;
	
	@FindBy(xpath = "//h1[normalize-space()='Your order has been placed!']")
    WebElement checkout_ConfirmationMsg;
	
	
	//Action Methods
	
	public  void  click_DropdownMenu(){
	    Select select = new Select(dropdownMenu);
	    select.selectByIndex(2);
	}
	
	public void click_Shipping_Method() {
	    shippin_Method_Btn.click();
	}
	
	public void click_ContinueShip_Btn(){
	    continueShip_Btn.click();
	}
	
	public void click_Payment_Method(){
	    payment_Method_Btn.click();
	}
	
	public void click_ContinuePayment_Btn(){
	    continuePayment_Btn.click();
	}
	public void click_ConfirmBtn() throws InterruptedException {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", confirm_btn);
	
	    //  Optional: slight delay to allow any animations or lazy-loading to complete
	    Thread.sleep(500);
	    confirm_btn.click();
	}
	
	public String getCheckout_ConfirmationMsg(){
        return checkout_ConfirmationMsg.getText();
    }
	
}
