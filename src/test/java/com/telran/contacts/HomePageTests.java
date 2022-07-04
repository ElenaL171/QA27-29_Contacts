package com.telran.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class HomePageTests extends TestBase{

    @Test
    public void openHomePageTest() {
        System.out.println("Site opened!");
        //verifly to displayed Home Component form
        // isComponentFormPresent();
        // System.out.println("Component Form: "+ isComponentFormPresent());
        isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
        isElementPresent2(By.cssSelector("div:nth-child(2)>div>div"));

    }

}
