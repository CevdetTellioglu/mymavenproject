package com.techproed;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class Day02_01JUnitAnnotations {
        //Bir JUnit projesinde testi calistirmak icin @Test annotation'i kullanilir.
        // "test1" adinda bir void method olusturunuz

    @Before
    public void runBeforeTest(){
        System.out.println("@Before ==> run before test");
    }


    @Test   // @Test test caseleri main method olmadan calistirmamizi saglar

    public void test1(){
        System.out.println("Test1'i yazdir.");
    }

    @Test
    @Ignore

    public void test2(){
        System.out.println("Test2'yi yazdir. " );
    }
    @Test

    public  void test3(){
        System.out.println("Test3'u yazdir.");
    }
    @After
    public void runAfterTest(){
        System.out.println("@After ==> run after test");
    }

}
