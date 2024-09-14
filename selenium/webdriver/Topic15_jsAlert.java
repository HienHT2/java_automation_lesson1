package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic15_jsAlert {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_AcceptAlert(){
       driver.get("https://automationfc.github.io/basic-form/index.html");
       driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked an alert successfully");

        //alert.getText();
       //Accept ALert
       // alert.accept();
       //Cancel alrt
       // alert.dismiss();
        //Get text ben trong alert
        //alert.getText();
        //Enter text vao alret
    //  alert.sendKeys("");

    }

    @Test
    public void TC_ConfirmAlert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        //Vua wait vua present
        Alert alert= explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked: Cancel");


    }
    @Test
    public void TC_03_PromAlert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt")).click();
        Alert alert= explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(),"I am a JS prompt");
        String value ="xin chao";
        alert.sendKeys(value);
        alert.accept();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked: "+value);
    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
