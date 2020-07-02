package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class Day02_02BeforeAfterMethodsRV {
    //// Bir class oluşturun: BeforeAfterMethods
    //    // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    //    // titleTest => Sayfa başlığının “Google” oldugunu doğrulayın
    //    // imageTest => Google resminin görüntülenip görüntülenmediğini doğrulayın
    //    // gmailLinkTest => "Gmail" linkinin görüntülenip görüntülenmediğini doğrulayın
    //    // Her testten sonra tarayıcıyı kapatin
    WebDriver driver;

    @Before
    public void setup() {
        //@Before annotation'i tekrarlanan kosullar icin kullanilir
        //@Before driver'i kurmak,browser'i acmak, URL'e gitmek icin kullanilir
        //@Before ve @After kullanarak tekrari engellemis oluruz
        //@Before her @Test methodundan once calisir
        //Eger internetiniz,web sitesi veya browser yavassa testiniz basarisiz olabilir.
        // bunu onlemek icin @Before icine wait ekleyebilirsiniz.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        //Yavas web siteleri icin implicitly wait kullanilabilir.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void titleTest() {

        String titleGoogle = driver.getTitle();
        if (titleGoogle.equals("Google")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        driver.close();

    }

    @Test
    public void imageTest() {

        WebElement logo = driver.findElement(By.id("hplogo"));
        System.out.println(logo.isDisplayed());
        driver.close();

    }

    @Test
    public void gmailLinkTest() {

        WebElement gmailLink = driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a"));
        System.out.println(gmailLink.isDisplayed());
        driver.close();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
