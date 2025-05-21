package pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hpLaptopePage extends  BasePage {

	
	//constructor
	public hpLaptopePage(WebDriver driver){
		super(driver);
	}
	
	
	//Locators
    
	@FindBy(xpath="//input[@id='input-option-225']")
	WebElement deliveryDate_input;
	
	//add to cart Button
	@FindBy(xpath=("//button[@id='button-cart']"))
	WebElement addToCart_Btn;
	
	@FindBy(xpath = "\"/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/button[1]\"")
	WebElement wishlist_Btn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;
			

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]" )
	WebElement wishlist_successMsg;
	
	
	//Action Methods
    public String  deliveryDateFormat() throws InterruptedException {
    	//6. Set Delivery Date
        LocalDate date= LocalDate.now().plusDays(5);
        //LocalDate deliveryDate = currentDate.plusDays(5); //Add 5 days to current date
        String  formattedDate = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        //String formattedDeliveryDate = deliveryDate.format(formattedDate);
        Thread.sleep(500);
        
        
        return formattedDate;
    	}
    
    public void setDeliveryDate() throws InterruptedException {
    	scrollToView(deliveryDate_input);
    	Thread.sleep(500);
    	deliveryDate_input.clear();
    	deliveryDate_input.sendKeys(deliveryDateFormat());
    }
    
    public void click_AddToCartBtn() {
    	addToCart_Btn.click();
    }
    
    public void click_WishlistBtn() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wishlist_Btn);
		wishlist_Btn.click();
		Thread.sleep(2000);
	}
    
    public String getSuccessMsg() {
    	return successMsg.getText();
    }
    
    public String getWishlistSucceessMsg(){
		return wishlist_successMsg.getText();
	}
    
    private void scrollToView(WebElement element) {
    	((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView(true);",element);
    }
}
