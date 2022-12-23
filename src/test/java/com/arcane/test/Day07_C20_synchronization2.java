package com.arcane.test;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Day07_C20_synchronization2 extends TestBase {
    /*
    Method olustur: isEnabled
    https://the-internet.herokuapp.com/dynamic_controls adresine git
    enable Button'una tikla
    Mesajin “It's enabled!” oldugunu verify et
    Textbox'in enabled oldugunu verify et (textbox'ta yazi yazilabilir)
    Disable button'una tikla
    Mesajin “It's disabled!” oldugunu verify et
    Textbox'in disabled oldugunu verify et (textbox'ta yazi yazilamaz)

    NOTE: .isEnabled(); bir elementin enabled olup olmadigini check eder
     */

    //Method olustur: isEnabled
    @Test
    public void isEnabled() {

//        1- https://the-internet.herokuapp.com/dynamic_controls adresine git
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        2- enable Button'una tikla
           driver.findElement(By.xpath("//button[.='Enable']")).click();
//        3- Mesajin “It's enabled!” oldugunu verify et
        WebElement goneElement = driver.findElement(By.id("message"));
        Assert.assertTrue(goneElement.getText().equals("It's enabled!"));

//     4-   Textbox'in enabled oldugunu verify et (textbox'ta yazi yazilabilir)
        driver.findElement(By.xpath("//input[@type='text']")).click();


//    5-    Disable button'una tikla
        driver.findElement(By.xpath("//button[.='Disable']")).click();

//     6-   Mesajin “It's disabled!” oldugunu verify et
        WebElement backElement = driver.findElement(By.id("message"));
        Assert.assertTrue(backElement.getText().equals("It's disabled!"));

//     7-   Textbox'in disabled oldugunu verify et (textbox'ta yazi yazilamaz)
        WebElement beklenenElement = driver.findElement(By.id("message"));
        Assert.assertTrue(beklenenElement.getText().equals("It's disabled!"));





    }
}