package com.telran.contacts.utils;

import com.telran.contacts.models.Contact;
import com.telran.contacts.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class DataProviders {
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
    @DataProvider
    public Iterator<Object[]> negativeRegistrationTestWithInvalidEmail() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"jesse1+983@mail.r", "Jesse_12345"});
        list.add(new Object[]{".com", "Jesse_12345"});
        list.add(new Object[]{"jesse1+983mail.ru", "Jesse_12345"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "1111111", "kan@gm.com", "Berlin", "goalkiper"});
        list.add(new Object[]{"Oliver1", "Kan", "2222222", "kan+1@gm.com", "Berlin", "goalkiper"});
        list.add(new Object[]{"Oliver2", "Kan", "3333333", "kan+2@gm.com", "Berlin", "goalkiper"});
        return list.iterator();
    }
}
