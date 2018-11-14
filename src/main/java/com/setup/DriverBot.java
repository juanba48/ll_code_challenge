package com.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DriverBot {

    private WebDriver driver;
    private final int waitTime;

    public DriverBot(WebDriver driver) {
        this.driver = driver;
        waitTime = 20;
    }

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Waiting for the element to be present before using it
     *
     * @param webElement
     * @param timeoutInSeconds timeout in seconds
     * @return return a webElement
     */
    public WebElement waitForElementPresent(WebElement webElement, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    /**
     * Type desired value, this method ensures that the element is present and cleans the field before sending the keys
     *
     * @param webElement Desired locator type by
     * @param text       Desired text
     */
    public void type(WebElement webElement, String text) {
        WebElement element = waitForElementPresent(webElement, waitTime);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Type desired value, this method ensures that the element is present and cleans the field before sending the keys
     *
     * @param webElement Desired locator type by
     * @param text       Desired text
     * @param timeOut    Wait time in seconds
     */
    public void type(WebElement webElement, String text, int timeOut) {
        WebElement element = waitForElementPresent(webElement, timeOut);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Click an element
     *
     * @param webElement Web element to perform operation
     */
    public void click(WebElement webElement) {
        WebElement element = waitForElementPresent(webElement, waitTime);
        element.click();
    }

    /**
     * Click an element
     *
     * @param webElement       Web element to perform operation
     * @param timeoutInSeconds Wait time in Seconds
     */
    public void click(WebElement webElement, int timeoutInSeconds) {
        WebElement element = waitForElementPresent(webElement, timeoutInSeconds);
        element.click();
    }

    /**
     * Select from Dropdown
     *
     * @param webElement       Web element to perform operation
     * @param text text in the dropdown
     */
    public void selectFromDropdownByVisibleText(WebElement webElement, String text) {
        Select select = new Select(webElement);
        select.selectByVisibleText(text);
    }

    /**
     * Select from RadioButton
     *
     * @param webElements       Web elements to perform operation
     * @param text radio button option
     */
    public void selectRadioButton(List<WebElement> webElements, String text) {
        for(WebElement element:webElements){
            if(element.getText().equals(text))
                element.click();
        }
    }

}
