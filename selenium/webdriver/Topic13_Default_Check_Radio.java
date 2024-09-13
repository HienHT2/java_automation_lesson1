package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic13_Default_Check_Radio {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    @BeforeClass
    public void initalBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_Register(){
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        //select
        driver.findElement(By.cssSelector("input#eq5")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input#eq5")).isSelected());
        //deselect
        driver.findElement(By.cssSelector("input#eq5")).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("input#eq5")).isSelected());


    }
    @Test
    public void Tc_02_Login(){

    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
