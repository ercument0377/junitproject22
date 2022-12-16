package com.arcane;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;



    /*
    Zorunlu tum alanlari doldurun ve Hesap olusturmanin basarili oldugunu verify edin
1. Create a class HesapOlusturma
2. Go to https://www.automationexercise.com/
3. Signup/Login link'ine click edin
4. Isim ve email adresinizi girin ardindan  Signup button"una click edin
5. Text'i Verify et : ENTER ACCOUNT INFORMATION
6. Text'i Verify et : ADDRESS INFORMATION
7. Text'i Verify et : Title
8. title'i secin
9. Name girin (var olani degistir)
10. Password girin
11. Date of Birth (dogum tarihi) girin
12. Sign up for our newsletter! click edin
13. Receive special offers from our partners! click edin
14. first name girin
15. last name girin
16. company girin
17. Address girin
18. Country secin
19. State girin
20. City girin
21. ZipCode girin
22. mobile phone girin
23. Create Account'u Click edin
24. Ardindan MY ACCOUNT'un sayfada bulundugunuzu verifey edin
     */
    public class odev {


        // 1. Create a class HesapOlusturma
        Faker faker = new Faker();
        WebDriver driver;

        @Before
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        // 2. Go to https://www.automationexercise.com/
        @Test
        public void radioButton() throws InterruptedException {
            driver.get("https://www.automationexercise.com/");

// 3. Signup/Login link'ine click edin
            Thread.sleep(3000);
            driver.findElement(By.linkText("Signup / Login")).click();

// 4. Isim ve email adresinizi girin ardindan  Signup button"una click edin
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@name='name']")).sendKeys(faker.name().firstName());
            driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(faker.internet().emailAddress());
            driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();


// 5. Text'i Verify et : ENTER ACCOUNT INFORMATION


// 6. Text'i Verify et : ADDRESS INFORMATION


// 7. Text'i Verify et : Title


// 8. title'i secin
            driver.findElement(By.xpath("//div[@id='uniform-id_gender1']")).click();

// 9. Name girin (var olani degistir)
            driver.findElement(By.xpath("//input[@name='name']")).sendKeys(faker.name().firstName());

//10. Password girin
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(faker.internet().password());

//11. Date of Birth (dogum tarihi) girin
            //gun
            WebElement gun = driver.findElement(By.xpath("//select[@name='days']"));
            Select gunDropDown = new Select(gun);
            gunDropDown.selectByValue("11");

            //ay
            WebElement ay = driver.findElement(By.xpath("//select[@name='months']"));
            Select ayDropDown = new Select(ay);
            ayDropDown.selectByValue("11");

            //yıl
            WebElement yil = driver.findElement(By.xpath("//select[@name='years']"));
            Select yilDropDown = new Select(yil);
            yilDropDown.selectByVisibleText("2011");

//12. Sign up for our newsletter! click edin
       /    WebElement checkBox1 = driver.findElement(By.xpath("//div[@id='uniform-newsletter']"));
            if (!checkBox1.isSelected()) {
                checkBox1.click();
            }
//13. Receive special offers from our partners! click edin
                WebElement checkBox2 = driver.findElement(By.xpath("//div[@id='uniform-optin']"));
                if (!checkBox2.isSelected()) {
                    checkBox2.click();
                }

//14. first name girin
                    driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(faker.name().firstName());


//15. last name girin
                    driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(faker.name().lastName());

//16. company girin
                    //   driver.findElement(By.xpath("//input[@name='company']")).sendKeys(faker.internet().????);


//17. Address girin
                    //    driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(faker.internet().????);

//18. Country secin
                    WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
                    Select countryDropDown = new Select(country);
                    ayDropDown.selectByValue("3");

//19. State girin
                    //    driver.findElement(By.xpath("//input[@id='state']")).sendKeys(faker.internet().????);


//20. City girin
                    //    driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.internet().????);

//21. ZipCode girin
                    //     driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(faker.internet().????);

//22. mobile phone girin
                    //    driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(faker.internet().?????);

//23. Create Account'u Click edin
                    driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();


//24. Ardindan MY ACCOUNT'un sayfada bulundugunuzu verifey edin

                    //   WebElement myAccountElement = chrome.findElement(By.className("MY ACCOUNT"));
                    //   Assert.assertTrue(myAccountElement.isDisplayed());


                }

            }

