package com.telran.contacts.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignOutButton();
        } else {
            app.getUser().login();
            app.getContact().addContakt();
        }
    }

    @Test
    public void removeContactTest() {
        app.getContact().pause(1000);
        int sizeBefore = app.getContact().sizeOfContacts();
        System.out.println(sizeBefore);
        app.getContact().removeContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        System.out.println(sizeAfter);
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

}
