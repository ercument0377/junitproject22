package com.arcane;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day04_C8_RadioBution {
    /*
    Test method olusturun ve asagidaki task'i tamamlayin.
    https://www.facebook.com/ adresine gidin
    Create an Account button'una click edin
    Radio button'larin elementlerini locate edin
    Ardindan eger cinsiyet secili degilse radio button'a click ederek secin
    Sing Up buttonuna click edip hesap olusturun
    */

    Faker faker = new Faker();
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void radioButton() throws InterruptedException {

//        https://www.facebook.com/ adresine gidin
        driver.get("https://www.facebook.com/");
//        Create an Account button'una click edin
        Thread.sleep(3000);
        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();
        // zorunlu alanlari girmem lazim
        // firstname ==> isim
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());
        //lastname => soyisim
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());
        //email adresi girin
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(faker.internet().emailAddress());
        //email dogrulama isterse
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(faker.internet().emailAddress());

        //sifre --> password
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(faker.internet().password());

        //doğumm tarihi olusturun
        //gun
      WebElement gun = driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select gunDropDown = new Select(gun);
        gunDropDown.selectByValue("21");

        //ay
        WebElement ay = driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Select ayDropDown = new Select(ay);
        ayDropDown.selectByValue("3");

        //yıl
        WebElement yil = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select yilDropDown = new Select(yil);
        yilDropDown.selectByVisibleText("1998");


//        Radio button'larin elementlerini locate edin
      WebElement maleSecenek =  driver.findElement(By.xpath("//input[@type='radio' and @value=2]"));
      WebElement femaleSecenek =  driver.findElement(By.xpath("//input[@type='radio' and @value=1]"));

//        Ardindan eger cinsiyet secili degilse radio button'a click ederek secin
        if(!maleSecenek.isSelected()){
            maleSecenek.click();
        }

//        Sing Up buttonuna click edip hesap olusturun
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }
/*
    @After
    public void tearDown(){
        driver.close();
    }
  */



}
