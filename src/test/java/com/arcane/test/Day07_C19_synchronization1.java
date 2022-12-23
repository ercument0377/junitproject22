package com.arcane.test;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day07_C19_synchronization1 extends TestBase {
    /*
    method olustur: synchronization1
    1- https://the-internet.herokuapp.com/dynamic_controls adresine git
    2- remove button'una tiklayin
    3- Mesajin “It's gone!” oldugunu verify edin
    4- Add button'una tiklayin
    5- Mesajin “It's back!” oldugunu verify edin
    */

    @Test
    public void synchronization1(){
//        1- https://the-internet.herokuapp.com/dynamic_controls adresine git
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        2- remove button'una tiklayin
        driver.findElement(By.xpath("//button[.='Remove']")).click();

//        3- Mesajin “It's gone!” oldugunu verify edin
        //1.yol
      WebElement goneElement = driver.findElement(By.id("message"));
        Assert.assertTrue(goneElement.getText().equals("It's gone!"));

        //2.yol
        /* Exiplicitly wait ekle
        1. WebDriverWait object olustur
           WebDriverWait wait = new WebDriverWait(driver, 10)
         2. wait object kullanarak element yuklemesı için bekleme ekle
         */
        WebDriverWait wait = new WebDriverWait(driver,10);

        //exptlicitly wait asağıdaki işlemleri yapar
        //1- driver.findElement(By.id("message")) elementi bulmak için 10 sn kadar bekle
        //2- eger 10 sn yede bulursa WebElement olarak doner
        //3- eger 10 sn yede bulamaz ise bu aşama  başarısız olur
     WebElement mesajBeklenen =   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

     Assert.assertTrue(goneElement.getText().equals("It's gone!"));


//        4- Add button'una tiklayin
        driver.findElement(By.xpath("//button[.='Add']")).click();
        WebElement backBeklenen =   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));


//        5- Mesajin “It's back!” oldugunu verify edin
        WebElement backElement = driver.findElement(By.id("message"));
        Assert.assertTrue(backElement.getText().equals("It's back!"));



    }

}
