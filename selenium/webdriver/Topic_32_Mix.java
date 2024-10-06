package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_32_Mix {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_Elemnt_Found(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait =new WebDriverWait(driver,Duration.ofSeconds(10));
       driver.get("http://live.techpanda.org/index.php/customer/account/login/");
       //Wait voi explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

        //Wait voi implicit
       driver.findElement(By.cssSelector("input#email"));

    }

    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_02_Elemnt_Not_Found_Only_Implicit(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        //Wait voi implicit
        driver.findElement(By.cssSelector("input#email11"));
        //- Neu khong tim thay element nao
        //Tim lai ma thay element thi k can cho het tong tim con lai
        //Tim lai ma khong thay, het 13s thi danh fail testcase
        //Show loi noSuchELementExeption

    }
    @Test
    public void TC_03_Elemnt_Not_Found_Only_Explicit_By(){
        explicitWait =new WebDriverWait(driver,Duration.ofSeconds(3));
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        //Wait voi explicit
        By emailTextboxBy =By.cssSelector("input#email111");
        //implcit =0
        //Explicit=3
        System.out.println("Start time "+getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(emailTextboxBy));
        } catch (Exception e) {
            System.out.println("Finish time "+getDateTimeNow());
            throw new RuntimeException(e);
        }
        //findelement co ham chay ngoai, khi k xet implict thi se bang 0, anh huowng implicit truoc
        //Show loi TimeoutException: Expected condition failed: waiting for visibility
    }

    @Test
    public void TC_03_Elemnt_Not_Found_Only_Explicit_Element(){
        explicitWait =new WebDriverWait(driver,Duration.ofSeconds(3));
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        //Wait voi explicit
        //implcit =0
        //Explicit=3
        System.out.println("Start time "+getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#email111"))));
        } catch (Exception e) {
            System.out.println("Finish time "+getDateTimeNow());
            throw new RuntimeException(e);
        }

        //Show loi RuntimeException: Expected condition failed: waiting for visibility
    }
    @Test
    public void TC_04_Elemnt_Not_Found_Mix(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        explicitWait =new WebDriverWait(driver,Duration.ofSeconds(4));
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        //Wait voi explicit
        System.out.println("Start time "+getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email111")));
        } catch (Exception e) {
            System.out.println("Finish time "+getDateTimeNow());
            throw new RuntimeException(e);
        }

        //Wait voi implicit
       // driver.findElement(By.cssSelector("input#email111"));

    }
    public String getDateTimeNow(){
        Date date =new Date();
        return date.toString();
    }

    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
