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

public class TC06_AddAffiliate extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC06_AddAffiliate.class);

    @Test(groups = {"regression"}, priority = 2, retryAnalyzer = utilities.RetryAnalyzer.class)
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

            Thread.sleep(1000);

        } catch (Exception e) {
            logger.error("Exception in login: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 3, retryAnalyzer = utilities.RetryAnalyzer.class)
    void completeAffiliateForm() {
        logger.debug("Starting test: completeAffiliateForm");
        try {
            AccountPage ap = new AccountPage(getDriver());
            logger.debug("AccountPage object created successfully");

            ap.click_Link_Affiliate();
            logger.debug("Clicked Affiliate link");

            ap.fillOutAffiliateForm();
            logger.debug("Filled out affiliate form");

        } catch (Exception e) {
            logger.error("Exception in completeAffiliateForm: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 4, retryAnalyzer = utilities.RetryAnalyzer.class)
    void confirm() {
        logger.debug("Starting test: confirm");
        try {
            AccountPage ap = new AccountPage(getDriver());
            logger.debug("AccountPage object created successfully");

            String successMsg = ap.affiliateMsg().getText();
            logger.debug("Affiliate success message: " + successMsg);

            Assert.assertTrue(successMsg.contains("success"));
            logger.debug("Assertion for affiliate success message passed");

        } catch (AssertionError e) {
            logger.error("Assertion error in confirm: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception in confirm: " + e.getMessage());
            throw e;
        }
    }
}
