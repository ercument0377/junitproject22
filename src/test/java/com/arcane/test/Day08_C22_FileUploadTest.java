package com.arcane.test;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_C22_FileUploadTest extends TestBase {
    /*
    1- Method : fileUploadTest
    2- https://the-internet.herokuapp.com/upload linkine git
    3- Kullanici masaustunden bir resim secer
    4- upload button'a tikla
    5- Ardindan "File Uploaded!" mesajinin gosterildigini (displayed) verify et
     */
    @Test
    public void fileUploadTest() throws InterruptedException {
//        2- https://the-internet.herokuapp.com/upload linkine git
        driver.get("https://the-internet.herokuapp.com/upload");

//        3- Kullanici masaustunden bir resim secer
        //home pathi al
        String homePath = System.getProperty(("user.home"));
        String cicekPath = homePath + "\\Desktop\\images.jpg";

        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        Thread.sleep(2000);
        fileUpload.sendKeys(cicekPath);

//        4- upload button'a tikla
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(2000);

//        5- Ardindan "File Uploaded!" mesajinin gosterildigini (displayed) verify et
         WebElement fileUploaded =   driver.findElement(By.xpath("//h3[.='File Uploaded!']"));
        Assert.assertTrue(fileUploaded.isDisplayed());
        Thread.sleep(2000);

    }


}
