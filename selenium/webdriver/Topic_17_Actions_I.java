package webdriver;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Actions_I {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    Actions action;
    @BeforeClass
    public void initalBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        action = new Actions(driver);


    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_hover() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        WebElement ageTextbox=driver.findElement(By.cssSelector("input#age"));
        //hover
        action.moveToElement(ageTextbox).perform();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.cssSelector("div.ui-tooltip-content")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),"We ask for your age only for statistical purposes.");
       
    }
    @Test
    public void Tc_02_Hover_To_Element() throws InterruptedException {
        driver.get("https://www.myntra.com/");
        WebElement menukids= driver.findElement(By.xpath("//a[@class='desktop-main' and text()='Kids']"));
        action.moveToElement(menukids).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Home & Bath']")).click();
        //action.click(driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Home & Bath']"))).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("span.breadcrumbs-crumb")).getText(),"Kids Home Bath");


    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
