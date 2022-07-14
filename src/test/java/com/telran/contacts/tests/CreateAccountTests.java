package com.telran.contacts.tests;

import com.telran.contacts.models.Contact;
import com.telran.contacts.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {
    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test
    public void registrationPositiveTest() {
        //click on the link LOGIN
        app.getUser().registration();
        //assert the button Sign out displayed
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

    @Test(dataProvider = "negativeRegistrationTestWithInvalidEmail")
    public void negativeRegistrationTestWithInvalidEmail(String email, String password) {
        app.getUser().click(By.xpath("//a[contains(text(),'LOGIN')]"));
       // app.getUser().fillLoginRegistrationForm(user);
        app.getUser().click(By.xpath("//button[contains(text(),'Registration')]"));

    }
   @Test(dataProvider = "negativeRegistrationTestWithInvalidEmailFromCSV")
    public void negativeRegistrationTestWithInvalidEmailFromCSV(User user) {
        app.getUser().click(By.xpath("//a[contains(text(),'LOGIN')]"));
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().click(By.xpath("//button[contains(text(),'Registration')]"));

    }
}
