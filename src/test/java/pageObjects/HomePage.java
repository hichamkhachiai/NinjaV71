package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends  BasePage{
	
	
	//constructor
    public HomePage(WebDriver driver){
		super(driver);
	}
	
	//Locators
	
		//Link - My Account
	
	@FindBy(xpath="//i[@class='fa-solid fa-user']")
	WebElement link_account;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement link_Login;
	
	// Laptops and NoteBooks
	@FindBy(xpath="//a[normalize-space()='Laptops & Notebooks']")
	WebElement link_Lap_notbook;
	
	
	
	//Click on Show all Laptops and NoteBooks
	@FindBy(xpath="//a[normalize-space()='Show All Laptops & Notebooks']")
	WebElement link_show_All;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/nav[1]/div[1]/div[1]/div[2]/ul[1]/li[5]/a[1]/span[1]")
	WebElement link_Checkout;
	
    
	
	//Action Methods
	
	public void clickMyAccount() {link_account.click();}
	public void click_linkLogin(){	link_Login.click();}
	//3. Click on Laptops and NoteBooks
	public void click_link_Lap_notbook() {link_Lap_notbook.click();}
	public void click_showAllLap() {link_show_All.click();}
	public void click_Checkout() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", link_Checkout);
		link_Checkout.click();}

}
