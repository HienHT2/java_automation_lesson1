package testng;

import listener.ScreenshotListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
@Listeners(ScreenshotListener.class)
public class Topic_13_Listener {
    public WebDriver getDriver() {
        return driver;
    }

    WebDriver driver;
    //String projectPath = System.getProperty("user.dir");
    By emailTextbox = By.xpath("//*[@id='email']");
    By passwordTextbox = By.xpath("//*[@id='pass']");
    By loginButton = By.xpath("//*[@id='send2']");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_LoginOnMultiple_Browser (){
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(emailTextbox).sendKeys("joebiden10529@gmail.com");
        driver.findElement(passwordTextbox).sendKeys("123456789");
        driver.findElement(loginButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("joeb1iden10529@gmail.com"));
        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();

    }



    @AfterClass(alwaysRun = true)
    public void afterClass(){
        driver.quit();
    }

}
