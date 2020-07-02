package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day04_01HomeWork_BeforeAfterAirBnbRv {
    // Bir class oluşturun: Homework_BeforeAfterAirbnb
    // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    // titleTest => Sayfa başlığının "Airbnb" içerdiğini doğrulayın
    // logoTest => Airbnb logosunun görüntülenip görüntülenmediğini doğrulayın
    // helpLinkTest => "Help" linkinin görüntülenip görüntülenmediğini doğrulayın
    // Her testten sonra tarayıcıyı kapatin
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.airbnb.com/");

    }

    @Test
    public void titleTest(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Airbn";
        if(actualTitle.contains(expectedTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ACTUAL TITLE : "+ actualTitle);
        }
    }

    @Test
    public void logoTest() {
        WebElement logo = driver.findElement(By.xpath("//a[@class='_gpuobnr']"));
        if (logo.isDisplayed()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
    @Test
    public void helpLinktest() {
        WebElement helpLinkTest = driver.findElement(By.linkText("Help"));
       if (helpLinkTest.isDisplayed()){
           System.out.println("PASS");
       }else{
           System.out.println("FAIL");
       }
        }
        @After
    public void tearDown(){
        driver.close();
        }



}
