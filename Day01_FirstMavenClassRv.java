package com.techproed;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_FirstMavenClassRv {
    public static void main(String[] args) {
        // Driver i baslatmak icin bunu java projelerinde kullaniyoruz. System.setProperty("","");

        // Bunun yerine Maven projesinde WebDriverManager
        // Chrome driver icin ;

        WebDriverManager.chromedriver().setup();
        // WebDriverManager in kirmizi olmasinin sebebi eksik dependensy'lerin olmasindandir
        // Dependency ler nereden alinir ??  https://mvnrepository.com/ adresinden alabilriz.

        WebDriver driver = new ChromeDriver(); //https://mvnrepository.com/ a git ve selenium java ara
        driver.get("https://www.google.com");

        //Fake data nasil olusturulur ?
        // fake data olusturmak icin bizim "JavaFaker' denilen bir dependence
        // searchBox elementini locate edip, create edin

        WebElement searchBox = driver.findElement(By.name("q"));
        // Faker objesi olusturuldu
        Faker faker = new Faker();
        //searchBox a fake date gonder ve enter a bas
        searchBox.sendKeys(faker.country().capital()+ Keys.ENTER);

        //searchBox.sendKeys(faker.country().flag());
        //searchBox.submit();

        System.out.println(faker.animal().name());
    }
}
