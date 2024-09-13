package webdriver;

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
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
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
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
