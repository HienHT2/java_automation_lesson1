package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic09_WebExcercise_WebElement_1 {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    @BeforeClass
    public void initalBrowser(){
        driver = new ChromeDriver();

    }
    @Test
    // 2 -Action/ execute: Tuong ta_c voi cac Element ,...
    public void TC_01_Check_Element_isDisplay(){
        //isDisplayed: kiem tra bat ky element nao hien thi
        //Hien thi: co the nhin thay, co kich thuoc cu the
       driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));
       if(emailTextbox.isDisplayed()){
           System.out.println("email Textbox is displayed");
           emailTextbox.sendKeys("Automation Testing");
       }else {
           System.out.println("email Textbox is not Displaued");
       }
       WebElement ageUnder18Radio =driver.findElement(By.cssSelector("input#under_18"));
       if(ageUnder18Radio.isDisplayed()){
           System.out.println("age under 18 Radio is Displayed");
           ageUnder18Radio.click();
       }else{
           System.out.println("age under 18 Radio is not Displayed");
       }
       WebElement textareaEducation= driver.findElement(By.cssSelector("textarea#edu"));
       if(textareaEducation.isDisplayed()){
           System.out.println("textarea Education is Displayed");
           textareaEducation.sendKeys("Automation Testing");
       }else {
           System.out.println("Textarea Education is not Displayed");
       }
       WebElement user05=driver.findElement(By.xpath("//h5[text()='Name: User5']"));
       if(user05.isDisplayed()){
           System.out.println(" user05 is Displayed");
       }
       else {
           System.out.println("User05 is not Displayed");
       }



    }
    @Test
    public void TC_02_Check_Element_Enable(){
        //isEnable: kiem tra bat ky emelent nao co the tuong tac len duoc
    driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));
        if(emailTextbox.isEnabled()){
            System.out.println("email Textbox is enable");
            emailTextbox.sendKeys("Automation Testing");
        }else {
            System.out.println("email Textbox is not disable");
        }
        WebElement ageUnder18Radio =driver.findElement(By.cssSelector("input#under_18"));
        if(ageUnder18Radio.isEnabled()){
            System.out.println("age under 18 Radio is Enable");

        }else{
            System.out.println("age under 18 Radio is disable");
        }
        WebElement password =driver.findElement(By.cssSelector("input#disable_password"));
        if(password.isEnabled()){
            System.out.println("password is Enable");
        }else{
            System.out.println("password is disable");
        }
        WebElement biography =driver.findElement(By.cssSelector("textarea#bio"));
        if(biography.isEnabled()){
            System.out.println("biography is Enable");
        }else{
            System.out.println("biography is disable");
        }


    }
    @Test
    public void TC_03_Check_Element_isSelected(){
        //isSelected: kiem tra element da duoc chon thanh cong(radio, checkbox, dropdown)
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement ageUnder18Radio =driver.findElement(By.cssSelector("input#under_18"));
        if(ageUnder18Radio.isSelected()){
            System.out.println("age under 18 Radio is Selected");

        }else{
            System.out.println("age under 18 Radio is disSelected");
        }
        WebElement javaLanguage =driver.findElement(By.cssSelector("input#java"));

        if(javaLanguage.isSelected()){
            System.out.println("Java language is Selected");

        }else{
            System.out.println("java language  is disSelected");
        }
        ageUnder18Radio.click();
        javaLanguage.click();
        if(ageUnder18Radio.isSelected()){
            System.out.println("age under 18 Radio is Selected");

        }else{
            System.out.println("age under 18 Radio is disSelected");
        }
        if(javaLanguage.isSelected()){
            System.out.println("Java language is Selected");

        }else{
            System.out.println("java language  is disSelected");
        }



    }
    @Test
    public void TC_04_Register_Function_MailChimp(){
    driver.get("https://login.mailchimp.com/signup/");
    driver.findElement(By.cssSelector("input#email")).sendKeys("hoanghienk49vcu@gmail.com");
    driver.findElement(By.cssSelector("input#email")).sendKeys(Keys.TAB);
    //only number
    driver.findElement(By.id("new_password")).sendKeys("12345");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

//only lower text
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("auto");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
//only upper text
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("AUTO");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        //only special text
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("@#$");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
    }

    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        //driver.quit();
    }


}
