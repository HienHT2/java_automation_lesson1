package webdriver;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_33_Fluent_Wait {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;


    //T datatype
    FluentWait<WebDriver> driverFluentWait;
   // FluentWait<WebElement> elementFluentWait;
  //  FluentWait<String> stringFluentWait;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
      //  driverFluentWait = new FluentWait<>(driver);

    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_Dynamic_Loading(){
    driver.get("https://automationfc.github.io/dynamic-loading/");
    findElement(By.cssSelector("div#start>button")).click();
    Assert.assertEquals(getElementText(By.cssSelector("div#finish>h4")),"Hello World!");
    }
    @Test
    public void TC_02_Dynamic_Loading(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        findElement(By.cssSelector("div#start>button")).click();
        Assert.assertTrue(isElementDisplayed(By.xpath("//div[@id='finish']//h4[text()='Hello World!']")));

    }

    @Test
    public void TC_03_Coundown(){
        driver.get("https://automationfc.github.io/fluent-wait/");
        WebElement counDownTime = findElement(By.id("javascript_countdown_time"));
        Assert.assertTrue(isSeocondMatching(counDownTime));
    }


    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }
//VIet ham de tim element voi timeout va polling tu set
    //Dieu kien cua ham se la find element: kieu tra ve cua ham apply
    //findElement thi can co driver: tham so cua ham apply

   public WebElement findElement( By by){
        FluentWait<WebDriver> driverFluentWait = new FluentWait<>(driver);
        driverFluentWait.withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofMillis(100))
        .ignoring(NoSuchElementException.class);
       return  driverFluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
   }

   //KIem tra element hien thi
    //isDisplay
   public boolean isElementDisplayed( By by){
       FluentWait<WebDriver> driverFluentWait = new FluentWait<>(driver);
       driverFluentWait.withTimeout(Duration.ofSeconds(30))
               .pollingEvery(Duration.ofMillis(100))
               .ignoring(NoSuchElementException.class);
       return  driverFluentWait.until(new Function<WebDriver, Boolean>() {
           @Override
           public Boolean apply(WebDriver driver) {
               return driver.findElement(by).isDisplayed();
           }
       });
   }

    //Lay ra text cua 1 element
    //getText = string
    public String getElementText( By by){
        FluentWait<WebDriver> driverFluentWait = new FluentWait<>(driver);
        driverFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        return  driverFluentWait.until(new Function<WebDriver, String>() {
            @Override
            public String apply(WebDriver driver) {
                return driver.findElement(by).getText();
            }
        });
    }

    public boolean isElementDisplayed1( WebElement element){
        FluentWait<WebElement> driverFluentWait = new FluentWait<>(element);
        driverFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        return  driverFluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement element) {
                return element.isDisplayed();
            }
        });
    }
    public boolean isSeocondMatching( WebElement element){
        FluentWait<WebElement> driverFluentWait = new FluentWait<>(element);
        driverFluentWait.withTimeout(Duration.ofSeconds(13))
                .pollingEvery(Duration.ofMillis(50))//1s kiem tra 5 lan
                .ignoring(NoSuchElementException.class);
        return  driverFluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement element) {
                return element.getText().endsWith("00");
            }
        });
    }

}
