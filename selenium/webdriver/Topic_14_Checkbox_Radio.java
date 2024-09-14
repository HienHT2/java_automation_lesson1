package webdriver;

import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Topic_14_Checkbox_Radio {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    JavascriptExecutor jsExcutor;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
        jsExcutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //kich thuoc cua browser
        driver.manage().window().maximize();
    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_telerik_Default_Checkbox_Or_Radio_Button(){
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        //scroll chuuọt
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        //verify checkbox/ radio is enable/disable
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isEnabled());
        //verify checkbox/radio is selected/deselected
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isSelected());

        //select
        ;
        By dualZoneAirBy = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        if(!driver.findElement(dualZoneAirBy).isSelected()){
            driver.findElement(dualZoneAirBy).click();
        }
        Assert.assertTrue(driver.findElement(dualZoneAirBy).isSelected());
        //deselect
        if(driver.findElement(dualZoneAirBy).isSelected()){
            driver.findElement(dualZoneAirBy).click();
        }
        Assert.assertFalse(driver.findElement(dualZoneAirBy).isSelected());


        // radio
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        By radiopetrol =By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        if(!driver.findElement(radiopetrol).isSelected()){
            driver.findElement(radiopetrol).click();
        }
        Assert.assertTrue(driver.findElement(radiopetrol).isSelected());

    }
    @Test
    public void TC_02_Multiple(){
        driver.get("https://automationfc.github.io/multiple-fields/");
        //select all checkboxes
       List<WebElement> checkboxes= driver.findElements(By.cssSelector("input.form-checkbox"));
       //Click all checkboxes
        for(WebElement checkbox:checkboxes){
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

        //verify tat ca duoc select
        for(WebElement checkbox:checkboxes){
            Assert.assertTrue(checkbox.isSelected());
        }

        //deselect all checkboxes
        for(WebElement checkbox:checkboxes){
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
        //verify all checkboxs
        for(WebElement checkbox:checkboxes){
            Assert.assertFalse(checkbox.isSelected());
        }

        //select 1 in all +verify

        driver.findElement(By.cssSelector("input[value='Emotional Disorder']")).click();
        driver.findElement(By.cssSelector("input[value='High Blood Pressure']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Emotional Disorder']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='High Blood Pressure")).isSelected());

        for(WebElement checkbox:checkboxes){
            if (!checkbox.isSelected() &&checkbox.getAttribute("value").equals("Kidney Disease")) {
                checkbox.click();
            }
        }
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Kidney Disease")).isSelected());
    }
    @Test
    public void TC_03_Ubuntu(){
        driver.get("https://login.ubuntu.com/");
        //Dung the input de click
        //Dung de verify: isSelected


        //1-Dung the input de click=> false
        //Dung the input de verify-> true
       // Assert.assertFalse(driver.findElement(newUserRadion).isSelected());
        //2-Dung 1 the khac input de click
        //dung the do verify-> false

        //3- Dung the khac input de click-> Pass
        //Dung the input nay de verify -> Pass
        By newUserRadio=By.cssSelector("input#id_new_user");
       // By newUserLabel= By.cssSelector("label.new-user");
        //driver.findElement(newUserLabel).click();
        //Assert.assertTrue(driver.findElement(newUserRadio).isSelected());
        //4
        jsExcutor.executeScript("arguments[0].click();",driver.findElement(newUserRadio));
        Assert.assertTrue(driver.findElement(newUserRadio).isSelected());

        By checkboxAgree= By.cssSelector("input#id_accept_tos");
        jsExcutor.executeScript("arguments[0].click();",driver.findElement(checkboxAgree));
        Assert.assertTrue(driver.findElement(checkboxAgree).isSelected());

    }
    @Test
    public void TC_04_Google_doc() throws InterruptedException{
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        By hcmRadio = By.xpath("//div[@aria-label='Hồ Chí Minh']");
        Thread.sleep(5000);
        driver.findElement(hcmRadio).click();
        //sau khi click có are-checked= true
        Assert.assertEquals(driver.findElement(hcmRadio).getAttribute("aria-checked"),"true");
        By quangNoodleCheclbox = By.xpath("//div[@aria-label='Mì Quảng']");
        if(driver.findElement(quangNoodleCheclbox).getAttribute("aria-checked").equals("false")){
            driver.findElement(quangNoodleCheclbox).click();
        }
        Assert.assertEquals(driver.findElement(quangNoodleCheclbox).getAttribute("aria-checked"),"true");

    }



    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
