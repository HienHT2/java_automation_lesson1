package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_25_UploadFile {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    String uploadFolderPath= System.getProperty("user.dir")+ File.separator +"uploadFiles"+File.separator;
    String hoiAn="HoiAn.jpg";
    String haGiang="HaGiang.jpg";
    String phuQuoc ="PhuQuoc.jpg";

    String hoiAnPath =uploadFolderPath +hoiAn;
    String haGiangPath =uploadFolderPath+haGiang;
    String phuQuocPath = uploadFolderPath+phuQuoc;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_Single_File() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By inputBy = By.xpath("//input[@type='file']");
        //Load file len
        driver.findElement(inputBy).sendKeys(hoiAnPath);
        Thread.sleep(2000);

        driver.findElement(inputBy).sendKeys(haGiangPath);
        Thread.sleep(2000);

        driver.findElement(inputBy).sendKeys(phuQuocPath);
        Thread.sleep(2000);

        //verify file duoc load len
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ hoiAn +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ haGiang +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ phuQuoc +"']")).isDisplayed());
        //Click upload cho tung file
        List<WebElement> startButtons= driver.findElements(By.cssSelector("table button.start"));
        for(WebElement startButton:startButtons){
            startButton.click();
            Thread.sleep(2000);
        }

        //verify cac file duoc upload thanh cong
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ hoiAn +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ haGiang +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ phuQuoc +"']")).isDisplayed());
    }
    @Test
    public void TC_02_Mutiple_Files() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By inputBy = By.xpath("//input[@type='file']");
        //Load file len 1 lan load nhieu file
        driver.findElement(inputBy).sendKeys(hoiAnPath +"\n"+ haGiangPath +"\n" +phuQuocPath);
        Thread.sleep(2000);

        //verify file duoc load len
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ hoiAn +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ haGiang +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ phuQuoc +"']")).isDisplayed());
        //Click upload cho tung file
        List<WebElement> startButtons= driver.findElements(By.cssSelector("table button.start"));
        for(WebElement startButton:startButtons){
            startButton.click();
            Thread.sleep(2000);
        }

        //verify cac file duoc upload thanh cong
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ hoiAn +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ haGiang +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ phuQuoc +"']")).isDisplayed());


    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
