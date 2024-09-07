package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic10_Defautl_Dropdown {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    Select select;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();

    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_Facebook_SignUp(){
        driver.get("https://www.facebook.com/reg/");
        //Dropodown xuat hien
        select = new Select(driver.findElement(By.cssSelector("select#day")));
        //Chon 1 item
        select.selectByVisibleText("30");
        //Chon xong verify da chon thanh cong hay chua
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"30");
        //verify co phai la mutiple select k
        //neu la mutiple tra ve ->true
        //khong phai multiple tra ve -> false
        Assert.assertFalse(select.isMultiple());
        //verify tong so luong item
        Assert.assertEquals(select.getOptions().size(),31);
        select = new Select(driver.findElement(By.cssSelector("select#month")));
        select.selectByVisibleText("Aug");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Aug");

        select = new Select(driver.findElement(By.cssSelector("select#year")));
        select.selectByVisibleText("1994");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"1994");

       
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
