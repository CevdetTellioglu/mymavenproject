package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day04_02AssetionsRv {
       // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
       // titleTest => Sayfa başlığının “Google” oldugunu doğrulayın
       // imageTest => Google resminin görüntülenip görüntülenmediğini doğrulayın
       // gmailLinkTest => "Gmail" linkinin görüntülenip görüntülenmediğini doğrulayın
       // Her testten sonra tarayıcıyı kapatin
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        // Yavas web siteleri icin implicity wait kullanilabilir
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void titleTest(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        // Assert class i JUnit'ten gelir
        // assertEquals(); iki tane String alir ve birbirleerine esit olup olmadiklarini kontrol eder.
        // iki String birbirine esitse test Pass olur, degilse Fail olur
        Assert.assertEquals(expectedTitle,actualTitle);
        driver.close();
    }
    @Test
    public void imageTest(){
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"hplogo\"]/a/img"));
        //assertTrue() => googleImage.isDisplayed() true ise test Pass olur, false ise test Fail olur.
        //assertTrue() kullandigimizda neticenin True olmasini bekliyoruz.
    Assert.assertTrue(logo.isDisplayed());
     //   System.out.println(logo.isDisplayed());
        driver.close();
    }
    @Test
    public void gmailLinkTest(){
        WebElement gmailLink = driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a"));
        Assert.assertTrue(gmailLink.isDisplayed());
        driver.close();
    }
    //@After annotation'i genellikle tarayiciyi kapatmak icin kullanilir.
    //Bu metot her @Test den sonra calisir.

    @After
    public void tearDown(){
        driver.quit();
    }
}

