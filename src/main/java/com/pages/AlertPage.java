package com.pages;

import com.setup.DriverBot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends Page {

    @FindBy(css = ".btn-primary")
    private WebElement button_Ok;

    public AlertPage(DriverBot bot) {
        super(bot);
    }

    public TablePage clickOkButton() {
        bot.click(button_Ok);
        return new TablePage(bot);
    }
}
