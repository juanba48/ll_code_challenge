package com.tests;

import com.pages.AlertPage;
import com.pages.TablePage;
import com.setup.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DeleteUserTC extends DriverSetup {

    @Test
    @Parameters({"userName"})
    public void deleteUserTC(String userName) {
        TablePage tablePage = new TablePage(bot);
        AlertPage alertPage = tablePage.deleteUser(userName);
        tablePage = alertPage.clickOkButton();
        Assert.assertTrue(!tablePage.isUsernameInTheTable(userName),"Error - Username: " + userName + " is still show in the table");
    }
}