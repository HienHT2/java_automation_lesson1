package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class Topic_22_RandomPopup {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_Register() throws InterruptedException {
       driver.get("https://www.javacodegeeks.com/");
       By newleeterPopupBy = By.xpath("//div[@data-title='Newsletter Free eBooks' " +
               "and not(contains(@style,'none'))]");
       //Hien thi thi close di roi action tiep


        if(driver.findElements(newleeterPopupBy).size()>0 && driver.findElements(newleeterPopupBy).get(0).isDisplayed() ) {
            System.out.println("------- GO TO IF -------");
            driver.findElement(By.xpath("//div[@data-title='Newsletter Free eBooks'and not(contains(@style,'none'))]//a[contains(@onclick, 'lepopup_close')]")).click();
            Thread.sleep(3000);
        }
        //Khong hien thi action tiep
            System.out.println("------IGNORE IF----");
            driver.findElement(By.cssSelector("input#search-input")).sendKeys("selenium");
            driver.findElement(By.cssSelector("button#search-submit")).click();
            Assert.assertTrue(driver.findElement(By.cssSelector("header>h1.page-title")).isDisplayed());
            Thread.sleep(3000);
          //  Assert.assertEquals(driver.findElement(By.xpath("//nav[@id='breadcrumb']/following-sibling::h1")).getText(),"Search Results for:"+" "+);

    }
    @Test
    public void TC_02_VNKedu() throws InterruptedException {
        driver.get("https://vnk.edu.vn/");
        Thread.sleep(15000);
        By marketingPopup = By.cssSelector("div.pum-container");
        if(driver.findElements(marketingPopup).size()>0 && driver.findElements(marketingPopup).get(0).isDisplayed() ) {
            System.out.println("------- GO TO IF -------");
            driver.findElement(By.cssSelector("button.popmake-close")).click();
            Thread.sleep(3000);
        }
        System.out.println("------IGNORE IF----");

        driver.findElement(By.xpath("//ul[@id='mega-menu-primary']//a[text()='Liên hệ']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.title-content>h1")).isDisplayed());


    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
