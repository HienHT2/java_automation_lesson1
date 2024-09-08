package javaSdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic03_Wait {
    WebDriver driver;
    WebDriverWait  expliciWait;
    FluentWait<WebDriver> fluentWait;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();

        //Explicit Wait
        expliciWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Fluent wait
        fluentWait = new FluentWait<WebDriver>(driver);
    }
    @Test
    public void TC_01_(){
            expliciWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));
            List<WebElement> allItems= driver.findElements(By.cssSelector(""));

        }


    @AfterClass
    public void closeBrowser(){
        driver.quit();

    }


}
