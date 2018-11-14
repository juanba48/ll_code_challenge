package com.tests;

import com.pages.FormPage;
import com.pages.TablePage;
import com.setup.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddUserTC extends DriverSetup {

    @Test
    @Parameters({"firstName", "lastName", "userName", "password", "roleId", "email", "mobilePhone","customer"})
    public void addUserTC(String firstName, String lastName, String userName, String password, String roleId, String email, String mobilePhone, String customer) {
        TablePage tablePage = new TablePage(bot);
        FormPage formPage = tablePage.clickOnAddUserButton();
        formPage.fillUserData(firstName, lastName, userName, password, roleId, email, mobilePhone, customer);
        tablePage = formPage.clickOnSaveButton();
        tablePage.searchUser(userName);
        Assert.assertTrue((tablePage.isUsernameInTheTable(userName)), "Error - Username: " + userName + " was not found in the table");
    }

}
