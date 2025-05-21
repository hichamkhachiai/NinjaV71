package testCases;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductsPage;
import pageObjects.hpLaptopePage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC03_AddToCart extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC03_AddToCart.class);

    @Test(groups = {"sanity", "regression"}, priority = 1, retryAnalyzer = utilities.RetryAnalyzer.class)
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

    @Test(priority = 2, retryAnalyzer =  utilities.RetryAnalyzer.class)
    void addToTheCart() throws InterruptedException {
        logger.debug("Starting test: addToTheCart");
        try {
            hpLaptopePage psp = new hpLaptopePage(getDriver());
            logger.debug("hpLaptopePage object created successfully");

            psp.setDeliveryDate();
            logger.debug("Set delivery date");

            psp.click_AddToCartBtn();
            logger.debug("Clicked Add to Cart button");

        } catch (Exception e) {
            logger.error("Exception in addToTheCart: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 3, retryAnalyzer =  utilities.RetryAnalyzer.class)
    void validation() {
        logger.debug("Starting test: validation");
        try {
            hpLaptopePage psp = new hpLaptopePage(getDriver());
            logger.debug("hpLaptopePage object created successfully");

            String validationText = psp.getSuccessMsg();
            logger.debug("Validation message: " + validationText);

            Assert.assertTrue(validationText.contains("Success"));
            logger.debug("Validation assertion passed");

        } catch (AssertionError e) {
            logger.error("Assertion error in validation: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception in validation: " + e.getMessage());
            throw e;
        }
    }
}
