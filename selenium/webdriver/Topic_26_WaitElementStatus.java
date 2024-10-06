package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_26_WaitElementStatus {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    WebDriverWait explicitWatit;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        explicitWatit =new WebDriverWait(driver,Duration.ofSeconds(15));

    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_Visible(){
       driver.get("https://www.facebook.com/");

       //1-element co tren ui va Html
        explicitWatit.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

    }
    @Test
    public void TC_02_inVisible(){
    //2-Khong co tren UI nhung van co tren HTML
        driver.get("https://www.facebook.com/");
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        explicitWatit.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input[name='reg_email_confirmation__']")));

        // 2-Khong co tren UI, khong co tren HTML

    }
    @Test
    public void TC_03_Present(){

    }
    @Test
    public void TC_04_Staleness(){

    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
