package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic02_Xpath_Css_01 {
    WebDriver driver;
    @BeforeClass
    public void inital_Browser(){
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register");

    }
    @Test
    public void TC_01_ID() throws InterruptedException{
        Thread.sleep(5000);
        driver.findElement(By.id("small-searchterms")).sendKeys("automation");
        Thread.sleep(3000);
        driver.findElement(By.id("FirstName")).sendKeys("name");
        Thread.sleep(3000);
    }
    @Test
    public void TC_02_Class() throws InterruptedException{
        driver.findElement(By.className("button-1 register-next-step-button")).click(); //class chỉ nhận 1 giá trị 1 phần nếu có khoảng trắng
        Thread.sleep(3000);
    }
    @Test
    public void TC_03_Name(){
        driver.findElement(By.name("DateOfBirthDay"));
        driver.findElement(By.name("DateOfBirthMonth"));
        driver.findElement(By.name("DateOfBirthYear"));
    }
    @Test
    public void TC_04_LinkText(){
        //chỉ làm việc với link
        //THẻ a và có thuoc tinh href
        //lấy toàn bộ text
        driver.findElement(By.linkText("Register"));
        driver.findElement(By.linkText("Log in"));

    }
    @Test
    public void TC_05_Partical_LinkText(){
        //chỉ làm việc với element là Link
        //có thể lấy toàn bộ text hoac 1 phan
        driver.findElement(By.partialLinkText("Digital "));
        driver.findElement(By.partialLinkText("downloads"));
    }
    @Test
    public void TC_06_Tagname(){
        //Tên thẻ html
        //Tìm tất cả các element giong nhau
        //Tim tat ca cac textbox, checkbox
        driver.findElements(By.tagName("button"));
        driver.findElements(By.tagName("input"));
        driver.findElements(By.tagName("lable"));
    }
    @Test
    public void TC_07_Css(){
        driver.findElement(By.cssSelector("input#Company"));
        driver.findElement(By.cssSelector("#Company"));
        driver.findElement(By.cssSelector("input[id='Company']"));
        driver.findElement(By.cssSelector(("button.register-next-step-button")));
        driver.findElement(By.cssSelector(("button[class='button-1 register-next-step-button']")));
        driver.findElement(By.cssSelector(("select[name='DateOfBirthDay']")));
        driver.findElement(By.cssSelector("a[href*='register?']"));
        driver.findElement(By.cssSelector("a[href='/register?returnUrl=%2Fregister']"));
        driver.findElement(By.cssSelector("a"));
        driver.findElement(By.cssSelector("button"));
    }
    @Test
    public void TC_08_Xpath(){
        driver.findElement(By.xpath("//input[@id='Company']"));
        driver.findElement(By.xpath("//button[@class='button-1 register-next-step-button']"));
        driver.findElement(By.xpath("//button[@class,'register-next-step-button']"));
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        driver.findElement(By.xpath("//a[text()='Register']"));
        driver.findElement(By.xpath("//a[contains(text(),'Register']"));
        driver.findElement(By.xpath("//a"));
        driver.findElement(By.xpath("//button"));
        driver.findElement(By.xpath("//input"));
    }
    @Test
    public void TC_09_Relative_Locator(){
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregister");
        //Element /By A
            By passwordcheckbox = By.cssSelector("input#Password");
            WebElement inputpasswordCheckbox =driver.findElement(By.cssSelector(("input#Password"))) ;
        // Element /By B
            By remembercheckbox = By.id("RememberMe");
        // Element /By C
            By forgerpassworbByLink = By.cssSelector("span.forgot-password");
        // Element /By D
            By LoginButtonBy = By.cssSelector("button.login-button");
        // Elemeny /By E
          WebElement rememberMeTextElement=  driver.findElement(RelativeLocator.with(By.tagName("label"))
                    .above(LoginButtonBy)
                    .below(passwordcheckbox)
                    .toRightOf(remembercheckbox)
                    .toLeftOf(forgerpassworbByLink));
          System.out.println(rememberMeTextElement.getText());


    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
       // driver.quit();
    }
}
