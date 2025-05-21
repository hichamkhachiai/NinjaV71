package testCases;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC04_CompletePurshase extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC04_CompletePurshase.class);

    @Test(groups = {"sanity", "regression"}, priority = 2, retryAnalyzer = utilities.RetryAnalyzer.class)
    void findProduct() {
        logger.debug("Starting test: findProduct");
        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object created successfully");

            hp.click_link_Lap_notbook();
            logger.debug("Clicked Laptops & Notebooks link");

            hp.click_showAllLap();
            logger.debug("Clicked Show All Laptops & Notebooks link");

            ProductsPage pp = new ProductsPage(getDriver());
            pp.click_hpLaptop();
            logger.debug("Clicked on HP Laptop");

        } catch (Exception e) {
            logger.error("Exception in findProduct: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 3, retryAnalyzer = utilities.RetryAnalyzer.class)
    void addToTheCart() throws InterruptedException {
        logger.debug("Starting test: addToTheCart");
        try {
            hpLaptopePage hpp = new hpLaptopePage(getDriver());
            logger.debug("hpLaptopePage object created successfully");

            hpp.setDeliveryDate();
            logger.debug("Set delivery date");

            hpp.click_AddToCartBtn();
            logger.debug("Clicked Add to Cart button");

            HomePage hp = new HomePage(getDriver());
            hp.click_Checkout();
            logger.debug("Clicked Checkout");

        } catch (Exception e) {
            logger.error("Exception in addToTheCart: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 4, retryAnalyzer =utilities.RetryAnalyzer.class)
    void login() {
        logger.debug("Starting test: login");
        try {
            HomePage hp = new HomePage(getDriver());
            hp.clickMyAccount();
            logger.debug("Clicked My Account link");

            hp.click_linkLogin();
            logger.debug("Clicked Login link");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("hichamkhachiai@gmail.com");
            logger.debug("Entered email");

            lp.setPwd("hicham123");
            logger.debug("Entered password");

            lp.clickLogin();
            logger.debug("Clicked Login button");

            hp.click_Checkout();
            logger.debug("Clicked Checkout");

        } catch (Exception e) {
            logger.error("Exception in login: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 5, retryAnalyzer = utilities.RetryAnalyzer.class)
    void checkout() throws InterruptedException {
        logger.debug("Starting test: checkout");
        try {
            HomePage hp = new HomePage(getDriver());
            hp.click_Checkout();
            logger.debug("Clicked Checkout");

            CheckoutPage chp = new CheckoutPage(getDriver());
            chp.click_DropdownMenu();
            logger.debug("Clicked Dropdown Menu");

            chp.click_Shipping_Method();
            logger.debug("Selected Shipping Method");

            chp.click_ContinueShip_Btn();
            logger.debug("Clicked Continue Shipping button");

            chp.click_Payment_Method();
            logger.debug("Selected Payment Method");

            chp.click_ContinuePayment_Btn();
            logger.debug("Clicked Continue Payment button");

            chp.click_ConfirmBtn();
            logger.debug("Clicked Confirm button");

        } catch (Exception e) {
            logger.error("Exception in checkout: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 6, retryAnalyzer = utilities.RetryAnalyzer.class)
    public void order_validation() {
        logger.debug("Starting test: order_validation");
        try {
            CheckoutPage chp = new CheckoutPage(getDriver());
            String confirmationMessage = chp.getCheckout_ConfirmationMsg();
            logger.debug("Order validation message: " + confirmationMessage);

            Assert.assertTrue(confirmationMessage.contains("Your order has been placed!"));
            logger.debug("Order validation assertion passed");

        } catch (AssertionError e) {
            logger.error("Assertion error in order_validation: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception in order_validation: " + e.getMessage());
            throw e;
        }
    }
}
