package com.arcane.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
     // TestBase class'ını abstract yaptık çünkü bu classtan nesne (object) olusturmayacağız
    // Bu sınıftaki obje ve methodlara extends ile erişim sağlarız
    // Abstract yaparak bazı dataları gizlemiş oluyoruz
    // abstract classlar override edilmesi lazım
   protected   WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
   //     driver.close();
    }
}
