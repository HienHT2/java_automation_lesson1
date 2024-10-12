package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Alway_Run {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
    driver=new FirefoxDriver();
    driver.get("https://www.google.com.vn/?hl=vi");
    //Mo den trang logi
        //login vao thanh cong
        //Khong thanh cong=> fail
        Assert.assertTrue(false);
    }

    @Test
    public void TC_01(){
        System.out.println("Run TC01");
    }
    @Test
    public void TC_02(){
        System.out.println("Run TC02");
    }

    @Test
    public void TC_03(){
        System.out.println("Run TC03");
    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
    driver.quit();
    }
}
