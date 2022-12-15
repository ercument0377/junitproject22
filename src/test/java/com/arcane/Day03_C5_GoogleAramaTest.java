package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_C5_GoogleAramaTest {
/*
Yeni class olustur : GoogleAramaTest
Test method'u  olustur ve asagidaki task'i tamamlayin.
Kullanici https://www.google.com gider
seorchbox ı locate et ve "porselen caydanlik" aransin
Bununla baglantili Google'da kac tane sonuc gosteriliyor test edin
*/

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
/*
implicitlyWait wait ekleme
- 30 saniye kadar bekle eger IHTIYAC duyarsan bekle demek == bu Java da Thread.sleap() gibi değildir
-Eger driver 1 saniyeye ihtiyac duyarsa sadece 1 saniye bekler (implicitlyWait - dinamik bir beklemedir) kullanırsak
   > neden beklemeye ihtiyac duyarız
   - internet yavaş olabilir
   - bilgisayar ozelliklerinden dolayı yavas olabilir
   -database yavas çalışabilir
   -uzerinde calıstıgımız web sayfadaki resim video veya iframelerden dolayı sayfa yavaş olabilir
 */
    }
        @Test
        public void caydanlikBul(){
        //Kullanici https://www.google.com gider
            driver.get("https://www.gogole.com");

           // seorchbox ı locate et ve "porselen caydanlik" aransin
         driver.findElement(By.xpath("//input[@name='q']")).sendKeys("porselen caydanlik" + Keys.ENTER);



          //  Bununla baglantili Google'da kac tane sonuc gosteriliyor test edin
         //  String sonucSayisi = driver.findElement(By.xpath("//div[@id=\'result-stats\']")).getText().substring(9,16);
         String [] sonucSayisi =   driver.findElement(By.xpath("//div[@id=\'result-stats\']")).getText().split(" ");


           System.out.println(sonucSayisi[1]);


    }
    @After
    public  void tearDown(){
        driver.close();
    }
}
