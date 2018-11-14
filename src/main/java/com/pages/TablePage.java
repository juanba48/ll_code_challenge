package com.pages;

import com.setup.DriverBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TablePage extends Page{

    public TablePage(DriverBot bot) {
        super(bot);
    }

    @FindBy(css = ".btn.pull-right")
    private WebElement button_AddUser;

    @FindBy(css = "[placeholder='Search']")
    private WebElement input_Search;

    private By userNameValues = By.xpath("//tr//td[3]");

    public FormPage clickOnAddUserButton(){
        bot.click(button_AddUser);
        return new FormPage(bot);
    }

    public void searchUser(String username){
        bot.type(input_Search,username);
    }

    public AlertPage deleteUser(String username)  {
        WebElement element = bot.getDriver().findElement(By.xpath("//td[3 and text() = '"+username+"']//../td//BUTTON[@class='btn btn-link']//I[@class='icon icon-remove']"));
        bot.click(element);
        return new AlertPage(bot);
    }

    public boolean isUsernameInTheTable(String userName) {
        List<WebElement> elements = bot.getDriver().findElements(userNameValues);
            for(WebElement element:elements){
                if(element.getText().equals(userName))
                    return true;
            }
            return false;
        }

}