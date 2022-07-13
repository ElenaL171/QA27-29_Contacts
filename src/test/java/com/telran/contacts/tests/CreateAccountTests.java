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

    @DataProvider
    public Iterator<Object[]> negativeRegistrationTestWithInvalidEmail() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"jesse1+983@mail.r", "Jesse_12345"});
        list.add(new Object[]{".com", "Jesse_12345"});
        list.add(new Object[]{"jesse1+983mail.ru", "Jesse_12345"});
        return list.iterator();
    }

    @Test(dataProvider = "negativeRegistrationTestWithInvalidEmail")
    public void negativeRegistrationTestWithInvalidEmail(String email, String password) {
        app.getUser().registration();
        app.getContact().clickWithAction(By.xpath("//button[contains(text(),'Registration')]"));

    }
    @DataProvider
    public Iterator<Object[]> negativeRegistrationTestWithInvalidEmailFromCSV() throws IOException {
        List<Object[]> list1 = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Wrongpassword.csv")));
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");
                list1.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
                line = reader.readLine();
            }
            return list1.iterator();}

    @Test(dataProvider = "negativeRegistrationTestWithInvalidEmailFromCSV")
    public void negativeRegistrationTestWithInvalidEmailFromCSV(User user) {
        app.getUser().registration();
        app.getContact().clickWithAction(By.xpath("//button[contains(text(),'Registration')]"));
    }
}
