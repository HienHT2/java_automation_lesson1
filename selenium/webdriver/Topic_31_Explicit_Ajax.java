package webdriver;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Topic_31_Explicit_Ajax {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    WebDriverWait explicitWait;
    String uploadFolderPath= System.getProperty("user.dir")+ File.separator +"uploadFiles"+File.separator;
    String hoiAn="HoiAn.jpg";
    String haGiang="HaGiang.jpg";
    String phuQuoc ="PhuQuoc.jpg";

    String hoiAnPath =uploadFolderPath +hoiAn;
    String haGiangPath =uploadFolderPath+haGiang;
    String phuQuocPath = uploadFolderPath+phuQuoc;
    @BeforeClass
    public void initalBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_Caledar(){
    driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

    //Wait and Verify Calendar Element Displayed
    Assert.assertTrue(explicitWait.until(ExpectedConditions.
            visibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1"))).isDisplayed());

    // Cach 1- Wait and verify text
    Assert.assertTrue(explicitWait.until(ExpectedConditions.
            textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"No Selected Dates to display.")));
        // Cach 2 -
        //WebElement selectedDate = driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"));
       // Assert.assertEquals(selectedDate.getText(),"No Selected Dates to display.");

    //Wait and click to Element
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td//a[text()='10']"))).click();
    //Wait and verify ajax loading invisible
       Assert.assertTrue(explicitWait.until(ExpectedConditions.
               invisibilityOfElementLocated(By.cssSelector("div[id$='RadCalendar1']>div.raDiv"))));

    //Wait and verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"Thursday, October 10, 2024")));
        //selectedDate = driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"));
        //Assert.assertEquals(selectedDate.getText(),"Thursday, October 10, 2024");
    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_02_Gofile(){
       explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://gofile.io/welcome");
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border"))));
        driver.findElement(By.cssSelector("button.btn-secondary")).click();
        By inputBy = By.xpath("//input[@type='file']");
        //Load file len 1 lan load nhieu file
        driver.findElement(inputBy).sendKeys(hoiAnPath +"\n"+ haGiangPath +"\n" +phuQuocPath);
        Assert.assertTrue(explicitWait.until(ExpectedConditions
                .invisibilityOfElementLocated(By.xpath("//div[@id='mainUpload']//div[@class='spinner-border']"))));
       // Assert.assertTrue(explicitWait.until(ExpectedConditions.
               // invisibilityOfElementLocated(By.xpath("//div[@class='row mt-2 mainUploadCancel']//button[text()='Cancel']"))));

        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.progress-bar"))));

        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='row justify-content-center mainUploadSuccess']//div[@class='alert alert-secondary border border-success text-white']"),"Your files have been successfully uploaded")));

        driver.findElement(By.cssSelector("div[class$='mainUploadSuccessLink']>div.text-center>a.ajaxLink")).click();
        Assert.assertTrue(explicitWait.until(ExpectedConditions.
                invisibilityOfElementLocated(By.xpath("//div[@id='filesLoading']//div[@class='spinner-border']"))));

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='contentName' and text()='"+ hoiAn +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='contentName' and text()='"+ haGiang +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='contentName' and text()='"+ phuQuoc +"']")).isDisplayed());








    }


    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
