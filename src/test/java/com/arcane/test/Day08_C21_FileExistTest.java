package com.arcane.test;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day08_C21_FileExistTest {
    /*
    Method: dosyaVarmi
    1- Masaustundeki bir dosyayi secin
    2- Bu dosyanin bilgisayarinizda bulunup bulunmadigini verify edin
    */
    @Test
    public void dosyaVarMi(){
        String homePath = System.getProperty(("user.home"));
        System.out.println(homePath);//C:\Users\Asus
           // "C:\Users\Asus\Desktop\images.jpg"

        String cicekPath = homePath + "\\Desktop\\images.jpg";

        System.out.println(cicekPath);

        boolean varMi = Files.exists(Paths.get(cicekPath));
        Assert.assertTrue(varMi);
    }





}
