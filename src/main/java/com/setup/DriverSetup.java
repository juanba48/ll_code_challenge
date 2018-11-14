package com.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class DriverSetup {

    private WebDriver driver;
    protected DriverBot bot;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void createDriver(String browser, String url) {

        switch (browser) {
            case "chrome":
                setupChrome(url);
                break;
            case "firefox":
                setupFirefox(url);
                break;
            default:
                setupChrome(url);
        }
    }

    private void setupFirefox(String url) {
        driver = new FirefoxDriver();
        driver.get(url);
        bot = new DriverBot(driver);
    }

    private void setupChrome(String url) {
        driver = new ChromeDriver();
        driver.get(url);
        bot = new DriverBot(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }

}
