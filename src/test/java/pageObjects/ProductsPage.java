package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends  BasePage{

	

	
	
	//constructor
	public ProductsPage(WebDriver driver){
		super(driver);
	}
	
	
	//Locators
	
	@FindBy(xpath="//img[@title='HP LP3065']")
	WebElement hp_laptop;
    

	
	
	//Action Methods
    public void click_hpLaptop() {
    	//Scroll into view
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hp_laptop); 
    	hp_laptop.click();
    	}
}
