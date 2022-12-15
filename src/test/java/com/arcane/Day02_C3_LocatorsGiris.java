package com.arcane;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day02_C3_LocatorsGiris {
    /*  user story
    Bir class olustur : LocatorsGiris
Main method olustur ve asagidaki gorevi (task) yap.
Kullanici "https://www.testyou.in/Login.aspx" gider
username textbox, password textbox, and signin button icin locator bul
Kullanici adi and password'i gir ve sign in button click et
Username : aykut.arcanedata@gmail.com
Password : Aykut123!
Kullanici adini verify et (USE getText() method to get the text from the page)
Home and log out sekmelerinin sayfada gosterildigini dogrula/verify et
Sayfada bulunan toplam link sayisini bul
Sayfadan log out yapiniz
Logged out basarili oldugunu verify edin
   */
    WebDriver chrome;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();

    }

@Test
    public void locatorGiris(){
        chrome.get("https://www.testyou.in/Login.aspx");
    //1.yol  kullanıcı adı locate ettik ve kullanıcı adını gönderdik

        //    WebElement emailBox = chrome.findElement(By.id("ctl00_CPHContainer_txtUserLogin"));
       //     emailBox.sendKeys("aykut.arcanedata@gmail.com");

    //2.yol yukarısının aynısı
        chrome.
                findElement(By.id("ctl00_CPHContainer_txtUserLogin")).
                sendKeys("aykut.arcanedata@gmail.com");

        // password için yapalım
    chrome.findElement(By.name("ctl00$CPHContainer$txtPassword")).sendKeys("Aykut123!");

    //sing in butonu locate et ve tıkla (click yap)
    chrome.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();

    // kullanıcı adını verfy et (dogrula)
   WebElement kullaniciAdi = chrome.findElement(By.id("ctl00_headerTopStudent_username"));
     String kullaniciAdiText =   kullaniciAdi.getText();
    //getText() WebElement in kendisini String olarak dondurur
     System.out.println(kullaniciAdiText);
     String expectedKullaniciAdi = "Aykutsaglam ,";

     Assert.assertEquals(expectedKullaniciAdi,kullaniciAdiText);



   //Home  sekmelerinin sayfada gosterildigini dogrula/verify et
   WebElement homeElement = chrome.findElement(By.linkText("Home"));
 //   WebElement homeElement =    chrome.findElement(By.partialLinkText("Hom"));  //  home nin hom gibi bir kısmını yazmamaızda yeterlidir

    /*
    linkText() ile partialLinkText() arasındaki fark
      -linkText() MUTLAKA text veya metinin tamamı bosluk ve noktalamalar dahil hepsini yazmak lazım
      -partialLinkText()  metnin yada textin tamamını yazabildiğimiz gibi bir kısmınıda yazabiliriz
      -linkText() daha guvenilirdir cünkü bütün metni eklediğimizde yanlış yapma olasılıgı azalır
    */
    Assert.assertTrue(homeElement.isDisplayed());
    //isDisplayed()  bir elementin sayfada bulunup bulunmadıgını dogrular
    //Return tipi boolean => element sayfada bulunursa true bulunmassa false olur


    //Home and log out sekmelerinin sayfada gosterildigini dogrula/verify et
   WebElement logoutElement = chrome.findElement(By.className("signout"));
   Assert.assertTrue(logoutElement.isDisplayed());


   //Sayfada bulunan toplam link sayisini bul
    //linkler "a" tag ile oluşturulur dolayısıyla butun "a" tag ile oluşturulan elementleri bulursam butun linkleri bulmuş olurum
   List<WebElement> tumLinkler = chrome.findElements(By.tagName("a"));
    int linkSayisi =  tumLinkler.size();
    System.out.println("Tum linklerin sayisi "+linkSayisi);


    //Sayfadan log out yapiniz
    chrome.findElement(By.className("signout")).click();


    //Logged out basarili oldugunu verify edin

   Boolean loggedOut = chrome.getCurrentUrl().equals("http://testyou.in/Login.aspx?ReturnUrl=%2fStudent%2fStudentIndex.aspx%3faction%3dlogout&action=logout");
      Assert.assertTrue(loggedOut);


}
@After
    public void tearDown(){
        chrome.close();
}


}
