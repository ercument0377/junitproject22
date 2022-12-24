package com.arcane.test;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Day08_C26_JavaScript_Executor extends TestBase {
    /*
    JAvaScript Execuptor ile bazı browser eventlerini otomate için  kullanırız
    -scroll up/down/right -- arrow up/down
    -elemente kadar kaydır
    -click
     -alert
     - renk değiştirebiliriz

     Not: scrollIntoView() istediğiniz elemente kadar aşağı/yukarı yada sağa/sola gider

     */
    /*
    Kullanici aplicasyonun Url (websayfasi)'ine gider
    Sayfada "Have a Questions?" text'ini verify et

    driver.get("http://www.carettahotel.com/);
     */

    @Test
    public void scrollIntoView() throws InterruptedException {
        driver.get("http://www.carettahotel.com/");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();


        // elementi asağı kaydır
        WebElement  question = driver.findElement(By.xpath("//*[.='Have a Questions?']"));

        Thread.sleep(3000);
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("arguments[0].scrollIntoView(true);", question);
        Thread.sleep(3000);
        Assert.assertEquals(question.getText(), "Have a Questions?");

    }

}
