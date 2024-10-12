package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_35_ShadowDOM {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_Shadow(){
       driver.get("https://automationfc.github.io/shadow-dom/");
       //Elemnt chua shodow host
        WebElement shadowHostParent = driver.findElement(By.cssSelector("div#shadow_host"));
        //Lay ra element shadowroot
       SearchContext  firstshadow= shadowHostParent.getShadowRoot();
        Assert.assertTrue(firstshadow.findElement(By.cssSelector("input[type='file']")).isDisplayed());
        Assert.assertEquals(firstshadow.findElement(By.cssSelector("span.wrapper")).getText(),"some text");

       WebElement  firstshadowHostParent =firstshadow.findElement(By.cssSelector("div#nested_shadow_host"));
       SearchContext secondShadow = firstshadowHostParent.getShadowRoot();
        Assert.assertEquals(secondShadow.findElement(By.cssSelector("div#nested_shadow_content>div")).getText(),"nested text");
    }
    @Test
    public void Tc_02_Shadow2() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");
        Thread.sleep(5000);
        WebElement firstshadowHostElement = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
        SearchContext firstShadowHost = firstshadowHostElement.getShadowRoot();
        WebElement secondshadowHostElement =firstShadowHost.findElement(By.cssSelector("book-input-decorator"));
        SearchContext secondShadowHost = secondshadowHostElement.getShadowRoot();
        firstShadowHost.findElement(By.cssSelector("input#input")).sendKeys("harry potter");
        secondShadowHost.findElement(By.cssSelector("div.icon")).click();
        Thread.sleep(300);
        WebElement thirdshadowHostElement= firstShadowHost.findElement(By.cssSelector("book-explore"));
        SearchContext thirdShadowHost = thirdshadowHostElement.getShadowRoot();
        Thread.sleep(3000);
        WebElement forthshadowHostElement= thirdShadowHost.findElement(By.cssSelector("ul>li:nth-of-type(1)>book-item"));
        SearchContext forthShadowHost = forthshadowHostElement.getShadowRoot();

        Assert.assertEquals(forthShadowHost.findElement(By.cssSelector("h2.title")).getText(),"Harry Potter and the Sorcerer's Stone");

    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
