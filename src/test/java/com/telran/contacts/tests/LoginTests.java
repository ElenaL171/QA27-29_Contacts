package com.telran.contacts.tests;

import com.telran.contacts.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test
    public void loginUserPositiveTest() {
        app.getUser().login();
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }
    @Test
    public void loginUserNegativeTest() {
        app.getUser().click(By.xpath("//a[contains(.,'LOGIN')]"));
        app.getUser().fillLoginRegistrationForm(new User().setEmail("jesse1+973@mail.ru"));
        Assert.assertTrue(app.getUser().isAlertPresent());
        Assert.assertTrue(app.getUser().istErrorPresent());
    }

}
