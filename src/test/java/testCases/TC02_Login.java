package testCases;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.ITestResult;
import org.testng.IRetryAnalyzer;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

    
 

public class TC02_Login extends BaseClass {

	private static final Logger logger = LogManager.getLogger(TC02_Login.class);

    @Test(groups = {"sanity", "regression", "datadriven"}, dataProvider = "LoginData", dataProviderClass = DataProviders.class, retryAnalyzer = utilities.RetryAnalyzer.class)
    void login(String email, String pwd) {
        logger.debug("Starting test: login with email: " + email);
        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object created successfully");

            hp.clickMyAccount();
            logger.debug("Clicked My Account link");

            hp.click_linkLogin();
            logger.debug("Clicked Login link");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail(email);
            logger.debug("Entered email: " + email);

            lp.setPwd(pwd);
            logger.debug("Entered password");

            lp.clickLogin();
            logger.debug("Clicked Login button");

            AccountPage ap = new AccountPage(getDriver());
            boolean status = ap.getMyAccountConfirmation().isDisplayed();
            logger.debug("Login confirmation status: " + status);

            if (status) {
                ap.clickMyAccountDropDown();
                logger.debug("Clicked My Account Drop Down");

                ap.clickLogout();
                logger.debug("Clicked Logout");
            } else {
                logger.warn("Login failed, assertion will fail.");
                Assert.fail();
            }

        } catch (AssertionError e) {
            logger.error("Assertion error occurred: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception occurred in login test: " + e.getMessage());
            throw e;
        }
    }
}
