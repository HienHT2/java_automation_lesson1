package testng;

import org.checkerframework.checker.units.qual.A;
import org.testng.annotations.*;

public class Topic_01_Annotation {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }
    @BeforeClass
    public void before_Class(){
        System.out.println("before_Class");
    }

    @AfterClass
    public void after_Class(){
        System.out.println("after_Class");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }

    @Test
    public void TC_01(){
        System.out.println("TC_01");
    }
    @Test
    public void TC_02(){
        System.out.println("TC_02");
    }
    @Test
    public void TC_03(){
        System.out.println("TC_03");
    }
}
