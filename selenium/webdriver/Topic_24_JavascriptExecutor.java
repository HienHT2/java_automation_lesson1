package webdriver;

import com.beust.ah.A;
import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_24_JavascriptExecutor {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    WebDriverWait explicitWait;
    Random random;
    String email;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
        jsExecutor = (JavascriptExecutor) driver;
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        email ="automation"+ new Random().nextInt(9999)+"@gmail.com";


    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_TechPanda() throws InterruptedException {
      //  System.out.println(jsExecutor.executeScript("return document.domain;"));
        //Lay ra 1 webElement
       //WebElement emailTextbox= (WebElement) jsExecutor.executeScript("return document.querySelector('input#Email');");
       //emailTextbox.sendKeys("hoanghienk49vcu@gmail.com");
        //cau get nay nhanh qua khong kip chay

        jsExecutor.executeScript("window.location = 'http://live.techpanda.org/'");
       Thread.sleep(3000);

        String techPandeDomain = (String) jsExecutor.executeScript("return document.domain;");
        Assert.assertEquals(techPandeDomain,"live.techpanda.org");

        String homePageURl= (String) jsExecutor.executeScript("return document.URL;");
        Assert.assertEquals(homePageURl,"http://live.techpanda.org/");

        Thread.sleep(3000);

        jsExecutor.executeScript("arguments[0].click();",
                driver.findElement(By.xpath("//a[text()='Mobile']")));
        Thread.sleep(3000);
       jsExecutor.executeScript("arguments[0].click();",
               driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//span[text()='Add to Cart']")));
       Thread.sleep(3000);
       String Samsungtest = (String) jsExecutor.executeScript("return document.documentElement.innerText;");
       Assert.assertTrue(Samsungtest.contains("Samsung Galaxy was added to your shopping cart."));

       jsExecutor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[text()='Customer Service']")));
       Thread.sleep(3000);


       jsExecutor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.cssSelector("input#newsletter")));
        Thread.sleep(3000);
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + email + "')",driver.findElement(By.cssSelector("input#newsletter")));

        jsExecutor.executeScript("arguments[0].click();",driver.findElement(By.cssSelector("button[title='Subscribe']")));

        Thread.sleep(3000);
        String verifytext = (String) jsExecutor.executeScript("return document.documentElement.innerText;");
        Assert.assertTrue(verifytext.contains("Thank you for your subscription."));

        jsExecutor.executeScript("window.location = 'https://facebook.com/'");
        Thread.sleep(3000);

        String facebookDomain = (String) jsExecutor.executeScript("return document.domain;");
        Assert.assertEquals(facebookDomain,"facebook.com");
    }
    @Test
    public void Tc_02_TechPanda_Function() throws InterruptedException {
        navigateToUrlByJS("http://live.techpanda.org/");
        Assert.assertEquals(gerDomain(),"live.techpanda.org");

        Assert.assertEquals(gerURL(),"http://live.techpanda.org/");

        clickToElementByJS("//a[text()='Mobile']");

        clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//span[text()='Add to Cart']");
        Thread.sleep(3000);
        Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));

        clickToElementByJS("//a[text()='Customer Service']");

        scrollToElementOnTop("//input[@id='newsletter']");

        setAttributeInDOM("//input[@id='newsletter']","value",email);

        clickToElementByJS("//button[@title='Subscribe']");

        Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));

        navigateToUrlByJS("https://facebook.com/");


    }
    @Test
    public void TC_03_Role(){
        driver.get("https://warranty.rode.com/login");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit"));
        //empty
        loginButton.click();
        String emptyEmailMessage = getElementValidationMessage("//input[@id='email']");
        Assert.assertEquals(emptyEmailMessage,"Please fill out this field.");

        //input email invalid
        String invalidEmailData ="aaaa";
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(invalidEmailData);
        loginButton.click();

        String invalidEMailMessage = getElementValidationMessage("//input[@id='email']");
        if(driver.toString().contains("ChromeDriver")){
            Assert.assertEquals(invalidEMailMessage,"Please include an '@' in the email address. '"+ invalidEmailData + "' is missing an '@'.");
        }else {
            Assert.assertEquals(invalidEMailMessage,"Please enter an email address.");
        }
        invalidEmailData ="aaaa@";
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(invalidEmailData);
        loginButton.click();

        invalidEMailMessage = getElementValidationMessage("//input[@id='email']");
        if(driver.toString().contains("ChromeDriver")){
            Assert.assertEquals(invalidEMailMessage,"Please enter a part following '@'. '" + invalidEmailData + "' is incomplete.");
        }else {
            Assert.assertEquals(invalidEMailMessage,"Please enter an email address.");
        }

        invalidEmailData ="aaaa@.";
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(invalidEmailData);
        loginButton.click();

        invalidEMailMessage = getElementValidationMessage("//input[@id='email']");
        if(driver.toString().contains("ChromeDriver")){
            Assert.assertEquals(invalidEMailMessage,"'.' is used at a wrong position in '.'.");
        }else {
            Assert.assertEquals(invalidEMailMessage,"Please enter an email address.");
        }
        //Email valid
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        loginButton.click();

        Assert.assertEquals(getElementValidationMessage("//input[@id='password']"),"Please fill out this field.");
    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }
    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }
    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }
    public String gerURL(){
        return (String) jsExecutor.executeScript("return document.URL;");
    }
    public String gerDomain(){
        return (String) jsExecutor.executeScript("return document.domain;");
    }
    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }


    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }



}
