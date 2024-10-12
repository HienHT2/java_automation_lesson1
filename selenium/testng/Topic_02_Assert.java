package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_02_Assert {
    WebDriver driver;
    @Test
    public void asserttion(){
        //AssertTrue: khi kiem tra 1 dk mong doi no se tra ve la Dung
        //Cac ham tra ve true/false
        //Selenium : isDisplayed, isEnable, isSelected, isMutiple
        //User Defined
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isDisplayed());

        //AssertFasle : khi kiem tra 1 dk mong doi no se tra ve la sai
        //Mong doi loginButton la disabled
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isEnabled());
        //AssertEquals: kiem tra mot dieu kien mong doi(expected) = dk thuc te(actual)

    }
}
