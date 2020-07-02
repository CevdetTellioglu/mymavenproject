package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day04_01Tekrar_BeforeAfter_BestBuyRv {
    //Bir class oluşturun: Tekrar_BeforeAfter_BestBuy
    //Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun      https://www.bestbuy.com/
    // titleTest => Sayfa başlığının “Best” içerdiğini(contains) doğrulayın
    // logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
    // mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
    //Her testten sonra tarayıcıyı kapatin
    //@Before ve @After metotlarini kullanarak yapalim
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.bestbuy.com/");
    }
    @Test
    public void logoTest(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Best";
        if(actualTitle.contains(expectedTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }
    @Test
    public void titleTest(){
        WebElement bestBuyLogo = driver.findElement(By.xpath("//img[@class='logo']"));
        if(bestBuyLogo.isDisplayed()) System.out.println("PASS");
        else System.out.println("FAIL");
    }
    @Test
    public void mexicoLinkTest() {
        WebElement mexicoLink = driver.findElement(By.linkText("Mexico"));
        if(mexicoLink.isDisplayed()) System.out.println("PASS");
        else System.out.println("FAIL");
    }
    @After
    public void tearDown() {
        driver.close();
    }
}

