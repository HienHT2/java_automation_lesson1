package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Topic10_Excercise_DefaulDropdown {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    Select select;
    String firstname, lastname,email,password,prefixemail, postfixemail,company,day,month, year;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
        Random rand= new Random();
        firstname="Hien";
        lastname="Hoang";
        prefixemail="hienht";
        postfixemail="@gmail.com";
        email =prefixemail+rand.nextInt(9999)+postfixemail;
        password="123dfgg";
        company="vpbanks securities";
        day="30";
        month="August";
        year="1994";
    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_HTML_DropdownList() throws InterruptedException{
    driver.get("https://demo.nopcommerce.com/register");
    driver.findElement(By.xpath("//div[@class='header-links']//a[text()='Register']")).click();
    driver.findElement(By.cssSelector("input#gender-male")).click();
    driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstname);
    driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastname);

    new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"))).selectByVisibleText(day);
    new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"))).selectByVisibleText(month);
    new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"))).selectByVisibleText(year);

    driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
    driver.findElement(By.cssSelector("input#Company")).sendKeys(company);
    driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
    driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(password);
    driver.findElement(By.cssSelector("button#register-button")).click();
    Thread.sleep(5000);
    Assert.assertEquals(driver.findElement(By.cssSelector("div.registration-result-page div.result")).getText(),"Your registration completed");
    driver.findElement(By.cssSelector("a.ico-account")).click();

    //checka
        Assert.assertTrue(driver.findElement(By.cssSelector("input#gender-male")).isSelected());
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"),firstname);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),lastname);
        Assert.assertEquals(new Select (driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).getFirstSelectedOption().getText(),day);
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).getFirstSelectedOption().getText(),month);
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).getFirstSelectedOption().getText(),year);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"),email);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"),company);




    }
    @Test
    public void Tc_02_Rode(){
        driver.get("https://rode.com/en/support/where-to-buy");
        new Select(driver.findElement(By.cssSelector("select#country"))).selectByVisibleText("Vietnam");
        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys("Ho Chi Minh");
        driver.findElement(By.xpath("//button[text()='Search']")).click();
        List<WebElement> delerares =  driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div//h4"));
        Assert.assertEquals(delerares.size(),16);
        for(WebElement element:delerares){
            System.out.println(element.getText());

        }


    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
