package webdriver;

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

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class Topic_29_ExplicitWaitFunction {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.manage().window().maximize();
      //  explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5),Duration.ofMillis(300)); //set time so tim lai
    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_(){
        //Wait cho Element khong hien thi , khong con trong HTML( truoc do co ton tai, sau bien mat)
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        //Wait cho element khong hien thi( con/khong con trong HTML)

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));
        //Wait cho Element duoc hien thi(bat buoc co trong HTML,UI)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
        //Wait cho element duoc phep click(button, link, radio, checkbox../
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("https://automationfc.github.io/dynamic-loading/")));

        //Wait cho Url cua Page tuong doi
        explicitWait.until(ExpectedConditions.urlContains("dynamic-loading"));

        //Wait cho Url thoa man bieu thuc (Regex)
        explicitWait.until(ExpectedConditions.urlMatches("@#$%^^"));

        //Wait cho doan JS tra ve kieu du lieu String
        explicitWait.until(ExpectedConditions.jsReturnsValue("return arguments[0].validationMessage;"));
        //Wait cho alert co xuat hien trong HTMl
        explicitWait.until(ExpectedConditions.alertIsPresent());

        //Wait cho title cua page tuyet doi
        explicitWait.until(ExpectedConditions.titleIs(""));

        //Wait cho title cua page tuong doi
        explicitWait.until(ExpectedConditions.titleContains(""));

        //Wait cho title thoa man ca 2 dieu kien
        explicitWait.until(ExpectedConditions.and
                (ExpectedConditions.urlContains(""),ExpectedConditions.titleIs("")));

        //Wait cho title thoa man 1 trong 2 dieu kien
        explicitWait.until(ExpectedConditions.or
                (ExpectedConditions.urlContains(""),ExpectedConditions.titleIs("")));

        //Wait cho ELement co xuat hien trong HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        //Wait cho 1 thuoc tinh chua 1 gia tri
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector(""),"class","email"));

        //Wait cho 1 thuoc tinh bang 1 gia tri
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector(""),"class","email"));

        //Wait cho 1 element co thuoc tinh khong duoc rong
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("")),"class"));

        //Wait cho 1 element co thuoc tinh o trong DOM bang gia tri nao do
        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("")),"innerText","Start"));

        //Wait cho 1 element co thuoc tinh o trong DOM bang gia tri nao do
        explicitWait.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.cssSelector("")),"innerText","Start"));

        //Wait cho element da duoc chon thanh cong: checkbox, radio, dropdown item
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));

        //Wait cho element da duoc chon thanh cong
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""),true));

        //Wait cho element chua duoc chon thanh cong
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""),false));

        //Wait cho frame /jframe xuat hien va switch vao
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("")));

        //Wait cho 1 doan lenh js duoc thuc thi khong tra ve bat cu exception nao het
        explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("return arguments[0].validationMessage;"));
        //Phu dinh lai dieu kien wait
        explicitWait.until(ExpectedConditions.not(ExpectedConditions.javaScriptThrowsNoExceptions("return arguments[0].validationMessage;")));


        //Wait cho 1 list element bang bao nhieu item
        List<WebElement> allNUmberSeleced= explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("ol#selectable>li.ui-selected"),5));
        //List<WebElement> allNUmberSeleced= driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(allNUmberSeleced.size(),5);

        explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector(""),5));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(""),9));

        //Wait cho so luong window tab bang bao nhieu
        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(3));

        //wait cho 1 doan text bang tuyet doi
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector(""),""));
        explicitWait.until(ExpectedConditions.textMatches(By.cssSelector(""),Pattern.compile("a*b")));

        //Wait cho 1 element hay bi change /refresh lai/updated lai
        explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions.numberOfWindowsToBe(3)));
    }
    @Test
    public void Tc_02_Login(){

    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
