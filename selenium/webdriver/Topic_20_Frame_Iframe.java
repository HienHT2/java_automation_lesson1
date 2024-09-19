package webdriver;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class Topic_20_Frame_Iframe {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    JavascriptExecutor jsExcutor;
    @BeforeClass
    public void initalBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        jsExcutor = (JavascriptExecutor) driver;
    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_Iframe_FomrSite() throws InterruptedException {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        driver.findElement(By.xpath("//img[@alt='Campus Safety Survey']")).click();

        //Switch qua iframe
        //index trong truong hop page hien tai co nhieu iframe
       // driver.switchTo().frame(0);
        //id,name phu hop voi page co id
       // driver.switchTo().frame("frame-one85593366");
        //WebELement cover ca 2 cach tren
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Sophomore");
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-3"))).selectByVisibleText("East Dorm");
        jsExcutor.executeScript("arguments[0].click();",driver.findElement(By.cssSelector("input#RESULT_RadioButton-4_0")));

        Thread.sleep(3000);
        //tu iframe quay lại trang chinhs
        driver.switchTo().defaultContent();
        //tai trang chinh an logn

        driver.findElement(By.cssSelector("a.fs-btn--transparent-kashmir")).click();

        driver.findElement(By.cssSelector("button#login")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(),"Username and password are both required.");

    }
    @Test
    public void TC_02_Iframe_Toidicodedao(){
        driver.get("https://toidicodedao.com/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.fb_iframe_widget iframe")));
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Tôi đi code dạo']/parent::div/following-sibling::div")).getText(),"406,554 followers");

    }

    @Test
    public void TC_03_Frame() throws InterruptedException {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        driver.switchTo().frame("login_page");
        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("automationfc");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("a.login-btn")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("12334");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a#loginBtn")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("p.error-msg.ng-binding.ng-scope")).getText(),"Customer ID/IPIN (Password) is invalid. Please try again.");
    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){

      driver.quit();

    }


}
