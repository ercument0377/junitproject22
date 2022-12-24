package com.arcane.test;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day08_C23_FileDowloadTest extends TestBase {
    /*
    FileDownloadTest() olustur
    1- https://the-internet.herokuapp.com/download adresine git
    2- Screenshot (6).png download et
    3- Dosyanin download edildigini verify et
     */
    @Test
    public void FileDownloadTest() throws InterruptedException {
//        1- https://the-internet.herokuapp.com/download adresine git
        driver.get("https://the-internet.herokuapp.com/download");

//        2- Screenshot (6).png download et
        driver.findElement(By.linkText("Screenshot (6).png")).click();
   //     driver.findElement(By.linkText("Foto2.jpg")).click();

        //dowload da mutlaka hard wait eklenmeli cunku indirilmesi zaman alabilir
        // implicitly veya explicitly wait bekleme problemimizi çözmez çünkü biz selenium kullanmıyoruz javanın kendisini kullanıyoruz
        //dowlaoad bilgisayar aplicationudur onun için selenium çözmez
        Thread.sleep(2000);

//        3- Dosyanin download edildigini verify et
        String homePath = System.getProperty("user.home");  //"C:\Users\Asus\Downloads\Screenshot (6).png"
      String fotoPath =  homePath + "\"\\Downloads\\Screenshot (6).png\"";
      boolean dowloadEttiMi = Files.exists(Paths.get(fotoPath));

        Assert.assertTrue(dowloadEttiMi);

    }
}
