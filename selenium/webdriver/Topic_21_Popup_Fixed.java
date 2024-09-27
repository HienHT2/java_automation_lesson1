package webdriver;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import zmq.socket.pubsub.Pub;

import javax.swing.*;
import java.time.Duration;

public class Topic_21_Popup_Fixed {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    @BeforeClass
    public void initalBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_Ngoai_Ngu24() throws InterruptedException {
       driver.get("https://ngoaingu24h.vn/");
       driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
       //Kiem tra hien thi
        Assert.assertTrue(driver.findElement(By.cssSelector("div#custom-dialog")).isDisplayed());
        driver.findElement(By.cssSelector("input[placeholder='Tài khoản đăng nhập']")).sendKeys("hoanghienk49vcu@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Mật khẩu']")).sendKeys("123456");
        driver.findElement(By.xpath("//span[@class='dialog-link']/parent::div/preceding-sibling::button")).click();

        Thread.sleep(3000);
       //Assert.assertEquals(driver.findElement(By.cssSelector("div#notistack-snackbar")).getText(),"Bạn đã nhập sai tài khoản hoặc mật khẩu!");
        driver.findElement(By.xpath("//h2[text()='Đăng nhập']//button")).click();

        Thread.sleep(3000);
        Assert.assertFalse(driver.findElement(By.cssSelector("div#custom-dialog")).isDisplayed());
    }
    @Test
    public void Tc_02_KynaEnglish() throws InterruptedException {
    driver.get("https://skills.kynaenglish.vn/dang-nhap");
    Assert.assertTrue(driver.findElement(By.cssSelector("div.k-popup-account-mb-content")).isDisplayed());
    driver.findElement(By.cssSelector("input#user-login")).sendKeys("tktest 1234");
    driver.findElement(By.cssSelector("input#user-password")).sendKeys("1234");
    driver.findElement(By.cssSelector("button#btn-submit-login")).click();

    Thread.sleep(3000);
    Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(),"Sai tên đăng nhập hoặc mật khẩu");
    }
@Test
    public void TC_03_Tiki() throws InterruptedException {
        driver.get("https://tiki.vn/");
        driver.findElement(By.xpath("//span[text()='Tài khoản']")).click();
        Thread.sleep(3000);

        By popupmodal = By.cssSelector("div.ReactModal__Overlay");
        Assert.assertTrue(driver.findElement(popupmodal).isDisplayed());

        driver.findElement(By.cssSelector("p.login-with-email")).click();
       // driver.findElement(By.xpath("//input[@name='email']")).sendKeys("hoanghienk49vcu@gmmail.com");
      //  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234554");
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][1]")).getText(),"Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][1]")).getText(),"Mật khẩu không được để trống");
        driver.findElement(By.cssSelector("img.close-img")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElements(popupmodal).size(),0);

        //pop up khong hien thi, khong con trong DOM
    }
    @Test
    public void TC_04_facebook() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        By sigupPopup = By.xpath("//div[text()='Sign Up']/parent::div/parent::div");
        //Kiem tra hien thi
        Assert.assertTrue(driver.findElement(sigupPopup).isDisplayed());
        Thread.sleep(3000);
        //close ddi
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        Thread.sleep(3000);
        //kiem tra k hien thi
        Assert.assertEquals(driver.findElements(sigupPopup).size(),0);
    }

    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
