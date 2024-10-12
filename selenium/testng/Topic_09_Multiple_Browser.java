package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Topic_09_Multiple_Browser {
    WebDriver driver;
    //String projectPath = System.getProperty("user.dir");
    By emailTextbox = By.xpath("//*[@id='email']");
    By passwordTextbox = By.xpath("//*[@id='pass']");
    By loginButton = By.xpath("//*[@id='send2']");
    String userName="selenium_11_01@gmail.com";
    String password= "1111111a";
    String domainURl;
    @Parameters({"server","browser"})
    @BeforeClass
    public void beforeClass(String Servername,@Optional("Firefox") String browserName) {
        // If-else
        if(Servername.equalsIgnoreCase("Dev")){
            domainURl="http://dev.techpanda.org";
        }else if(Servername.equalsIgnoreCase("Testing")){
            domainURl="http://testing.techpanda.org";
        }else if(Servername.equalsIgnoreCase("Staging")){
            domainURl="http://Staging.techpanda.org";
        }else if(Servername.equalsIgnoreCase("Production")){
            domainURl="http://live.techpanda.org";
        }
        else {
            throw new RuntimeException("Sever name is not valid!!");
        }

        //Switch case
        switch (browserName){
            case "Chrome":
                driver=new ChromeDriver();
                break;
            case "Edge":
                driver =new EdgeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            default:
                new RuntimeException("Browser name is not valid!!");
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_LoginOnMultiple_Browser (){
        driver.get(domainURl + "/index.php/customer/account/login/");

        driver.findElement(emailTextbox).sendKeys(userName);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();
       Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains(userName));
       driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
       driver.findElement(By.xpath("//a[text()='Log Out']")).click();

    }



    @AfterClass(alwaysRun = true)
    public void afterClass(){
        driver.quit();
    }

}