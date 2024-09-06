package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic09_WebExcercise_Webelement_2 {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_Login_With_Empty_Email_And_Password() throws InterruptedException{
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("");
       driver.findElement(By.cssSelector("input#pass")).sendKeys("");
       driver.findElement(By.cssSelector("button#send2")).click();
        //driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
        //Thread.sleep(1000);
      Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(),"This is a required field.");

      Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(),"This is a required field.");

    }
    @Test
    public void Tc_02_LoginWithInvalidEmail() throws InterruptedException{
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("1234@123444");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");


    }
    @Test
    public void TC_03_LoginWithPassWordLess6Charater(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("hoanghienk49vcu@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");


    }
    @Test
    public void TC_04_LoginWithInvalidEmail() throws InterruptedException{
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("1234567");
        driver.findElement(By.cssSelector("button#send2")).click();
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(),"Invalid login or password.");

    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        //driver.quit();
    }


}
