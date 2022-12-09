package com.arcane;

import org.junit.*;

public class Day01_C2_FirstJUnitClass {

    //@Test : test case olustur. Bu test cases olusturma ve kosturmaya yardimci olur
    // @Before : Runs before each @Test annotation. tekrarlanan pre condition icin kullanilir
    // @After : Runs after each @Test annotation. tekrarlanan post conditions icin kullanilir
    // @AfterClass, @BeforeClass
     // @Ignore: test case atlatmak icin kullanilir


    @Before
    public void setUp(){
        System.out.println("Bu bir setUp Methodudur");
    }
    @Test
    public void test01(){
        System.out.println("Test case 1");
    }
    @Ignore
    @Test
    public void test02(){
        System.out.println("Test case 2");
    }

    @Test
    public void test03(){
        System.out.println("Test case 3");
    }
    @After
    public void tearDown(){
        System.out.println("Bu bir tearDown methodudur"); // tearDown kapatmak demek
    }
    /* Junit Assertion
          Expected = actual, ise assertion yapılır.

     */
    @Test
    public void assertion(){
       // System.out.println("assertion test calisti");

        //1. Assert.assertTrue()  ile yaparız
        Assert.assertTrue(3==3); // test gecer basarılı

        //2. Assert.assertFalse()  ile yaparız
        Assert.assertFalse(3==4); // ikiside false yani yanlış olduğu için test geçer

        Assert.assertFalse("Selenium".contains("a"));  // test başarılı seleniumda a harfi yoktu

        //3. Assert.assertEquals();  ile yaparız
        Assert.assertEquals("java","java"); // test basarılı
        Assert.assertEquals("Java","javascript"); // test basarısız


    }

}
