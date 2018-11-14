package com.pages;

import com.setup.DriverBot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class FormPage extends Page {

    public FormPage(DriverBot bot) {
        super(bot);
    }

    @FindBy(css = ".btn-success")
    private WebElement button_SaveUser;

    @FindBy(name = "FirstName")
    private WebElement input_FirstName;

    @FindBy(name = "LastName")
    private WebElement input_LastName;

    @FindBy(name = "UserName")
    private WebElement input_UserName;

    @FindBy(name = "Password")
    private WebElement input_Password;

    @FindBy(name = "RoleId")
    private WebElement select_RoleId;

    @FindBy(name = "Email")
    private WebElement input_Email;

    @FindBy(name = "Mobilephone")
    private WebElement input_MobilePhone;

    @FindBy(css = ".radio")
    private List<WebElement> radioButton_Customer;

    public void fillUserData(String firstName, String lastName, String userName, String password, String roleId, String email, String mobilePhone, String customer) {
        bot.type(input_FirstName, firstName);
        bot.type(input_LastName, lastName);
        bot.type(input_UserName, userName);
        bot.type(input_Password, password);
        bot.selectRadioButton(radioButton_Customer,customer);
        bot.selectFromDropdownByVisibleText(select_RoleId, roleId);
        bot.type(input_MobilePhone, mobilePhone);
        bot.type(input_Email, email);
    }

    public TablePage clickOnSaveButton() {
        bot.click(button_SaveUser);
        return new TablePage(bot);
    }
}
