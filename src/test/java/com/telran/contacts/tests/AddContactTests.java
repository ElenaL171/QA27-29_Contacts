package com.telran.contacts.tests;

import com.telran.contacts.models.Contact;
import com.telran.contacts.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getUser().login();
        }
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().addContact();
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
    }

    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProvider(String name, String lName, String phone, String address, String city, String des) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().fillContactForm(new Contact().setName(name)
                .setLastname(lName)
                .setPhone(phone)
                .setAddress(address)
                .setCity(city)
                .setDescription(des));
        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }

    @Test(dataProvider = "addNewContactFromCSV")
    public void addContactPositiveTestFromCSV(Contact contact) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().fillContactForm(contact);
        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }
}
