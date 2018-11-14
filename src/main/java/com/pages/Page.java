package com.pages;

import com.setup.DriverBot;
import org.openqa.selenium.support.PageFactory;

public class Page {

    protected DriverBot bot;

    public Page(DriverBot bot) {
        PageFactory.initElements(bot.getDriver(),this);
        this.bot = bot;
    }
}
