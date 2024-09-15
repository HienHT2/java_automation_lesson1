package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic02_Excersice_Xpatch_Css {
    WebDriver driver;
    @BeforeClass
    public void IntialBrowser(){
        driver = new FirefoxDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }
    @Test
    public void TC_01_Register_with_empty_data() throws InterruptedException{
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
        Thread.sleep(5000);
        //System.out.println(driver.findElement(By.xpath("//input[@id='txtFirstname']")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email");
       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Vui lòng nhập lại địa chỉ email");
       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Vui lòng nhập mật khẩu");
       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Vui lòng nhập lại mật khẩu");
       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Vui lòng nhập số điện thoại.");

    }
    @Test
    public void TC_02_Register_with_valid_email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Hoang Hien");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("123@gmail@123");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("123@gmail@123");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("@Hien12341");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("@Hien12341");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0389219826");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");

    }
    @Test
    public void TC_03_Register_with_incorect_Confirm_Email(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Hoang Hien");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("hienht@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("hienht@gmail.net");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("@Hien12341");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("@Hien12341");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0389219826");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");

    }
    @Test
    public void TC_04_Register_With_Password_less_6Character(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Hoang Hien");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("hienht@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("hienht@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0389219826");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
    }
    @Test
    public void TC_05_Register_with_incorrect_Confirm_Password(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Hoang Hien");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("hienht@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("hienht@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("1234543");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0389219826");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu bạn nhập không khớp");

    }
    @Test
    public void TC_06_Register_with_invalid_Phone_number(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Hoang Hien");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("hienht@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("hienht@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("03892198261");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại phải từ 10-11 số.");

    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }

}
