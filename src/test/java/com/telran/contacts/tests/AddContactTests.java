package com.telran.contacts.tests;

import com.telran.contacts.models.Contact;
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

    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "1111111", "kan@gm.com", "Berlin", "goalkiper"});
        list.add(new Object[]{"Oliver1", "Kan", "2222222", "kan+1@gm.com", "Berlin", "goalkiper"});
        list.add(new Object[]{"Oliver2", "Kan", "3333333", "kan+2@gm.com", "Berlin", "goalkiper"});
        return list.iterator();
    }

    @Test(dataProvider = "addNewContact")
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

    @DataProvider
    public Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/UserDataContacts.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0])
                    .setLastname(split[1])
                    .setPhone(split[2])
                    .setAddress(split[3])
                    .setCity(split[4])
                    .setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
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
