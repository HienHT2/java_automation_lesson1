package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic12_Button {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_Button(){
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        By loginButton = By.cssSelector("button.fhs-btn-login");
        //isEnable :neu element la enable tra ve true/ disable tra ve false
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());
        //verify color
      String loginbackgroundColor=  driver.findElement(loginButton).getCssValue("background-color");
      System.out.println(loginbackgroundColor);
      Color loginColor= Color.fromString(loginbackgroundColor);
      loginColor.asHex().toLowerCase();
      Assert.assertEquals(loginColor.asHex().toLowerCase(),"#000000");

      driver.findElement(By.cssSelector("input#login_username")).sendKeys("0389219826");
      driver.findElement(By.cssSelector("input#login_password")).sendKeys("1234467");

      Assert.assertTrue(driver.findElement(loginButton).isEnabled());
      Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(),"#C92127");
      driver.findElement(loginButton).click();
      Assert.assertEquals(driver.findElement(By.cssSelector("div.fhs-login-msg")).getText(),"Số điện thoại/Email hoặc Mật khẩu sai!");




       
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
