package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_C1_FirstMavenClass {
    public static void main(String[] args){
 //   System.setProperty("driver Type", "Deriver Path"); maven de artık bunu kullanmayacağız

        //1- crom driver'i set et
        WebDriverManager.chromedriver().setup();

        //2- driver objesi olustur
        WebDriver driver = new ChromeDriver();

        //3-Ekranı kapla
        driver.manage().window().maximize();

        //4- amazona gir get daha hızlı
        driver.get("https://www.amazon.com");

        //5-browseri kapar
        driver.close();


    }



}
