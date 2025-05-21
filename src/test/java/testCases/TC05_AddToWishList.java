package testCases;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;
import pageObjects.*;
import utilities.RetryAnalyzer;

public class TC05_AddToWishList extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC05_AddToWishList.class);

    @Test(groups = {"regression"}, priority = 1, retryAnalyzer = utilities.RetryAnalyzer.class)
    void login() throws InterruptedException {
        logger.debug("Starting test: login");
        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object created successfully");

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

            Thread.sleep(2000);

        } catch (Exception e) {
            logger.error("Exception in login: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 2, retryAnalyzer = utilities.RetryAnalyzer.class)
    public void findProduct() {
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
    public void addToWishList() throws InterruptedException {
        logger.debug("Starting test: addToWishList");
        try {
            hpLaptopePage hpp = new hpLaptopePage(getDriver());
            logger.debug("hpLaptopePage object created successfully");

            hpp.click_WishlistBtn();
            logger.debug("Clicked Add to Wishlist button");

        } catch (Exception e) {
            logger.error("Exception in addToWishList: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 4, retryAnalyzer = utilities.RetryAnalyzer.class)
    public void confirm() {
        logger.debug("Starting test: confirm");
        try {
            hpLaptopePage hpp = new hpLaptopePage(getDriver());
            logger.debug("hpLaptopePage object created successfully");

            String successMsg = hpp.getWishlistSucceessMsg();
            logger.debug("Wishlist success message: " + successMsg);

            Assert.assertTrue(successMsg.contains("Success"));
            logger.debug("Assertion for wishlist success message passed");

        } catch (AssertionError e) {
            logger.error("Assertion error in confirm: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception in confirm: " + e.getMessage());
            throw e;
        }
    }
}
