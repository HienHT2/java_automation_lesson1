package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import zmq.socket.pubsub.Pub;

import java.time.Duration;
import java.util.List;

public class Topic_18_Actions_II {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    Actions action;
    String osName = System.getProperty("os.name");
    Keys keys;
    @BeforeClass
    public void initalBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        action = new Actions(driver);
        if(osName.startsWith("Windows")){
            keys =Keys.CONTROL;
        }else {
            keys =Keys.COMMAND;
        }
        //keys = osName.startsWith("Windows")? Keys.CONTROL:Keys.COMMAND;
    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_Click_And_Hold_BLock() throws InterruptedException {
       driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allnumbers=  driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allnumbers.size(),20);
        action.clickAndHold(allnumbers.get(0))//click vao so 1 va giu chuot
                .moveToElement(allnumbers.get(3))//di chuot toi so 4
                .release()//nha chuot trai ra, ket thuc su kien clickAndHold
                .perform();//thuc thi cac cau lenh tren
        Thread.sleep(2000);
        List<WebElement> allNUmberSeleced= driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(allNUmberSeleced.size(),4);
    }

    @Test
    public void Tc_02_Click_And_Hold_BLock_Random()  {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allnumbers=  driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allnumbers.size(),20);
        //nhan phim ctrl xuong(chua nha)
        action.keyDown(keys).perform();
        //click vao tung so
        action.click(allnumbers.get(0))
                .click(allnumbers.get(3))
                .click(allnumbers.get(7))
                .click(allnumbers.get(9))
                .click(allnumbers.get(14))
                .pause(Duration.ofSeconds(3))
                .perform();
        //nha phim ctrl
        action.keyUp(keys).perform();
        List<WebElement> allNUmberSeleced= driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(allNUmberSeleced.size(),5);

    }
    @Test
    public  void TC_03_Double_Click() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        Thread.sleep(5000);
        action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");

    }
    @Test
    public void TC_04_Right_CLick_To_Element() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        Thread.sleep(3000);
        //Click chuot phai
        action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
        By quickcontextby = By.cssSelector("li.context-menu-icon-quit");
        Assert.assertTrue(driver.findElement(quickcontextby).isDisplayed());
        //hover mouse
        action.moveToElement(driver.findElement(quickcontextby)).perform();

        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-visible.context-menu-hover")).isDisplayed());
        action.click(driver.findElement(quickcontextby)).perform();
        driver.switchTo().alert().accept();
        Assert.assertFalse(driver.findElement(quickcontextby).isDisplayed());

    }
    @Test
    public void TC_05_ScrollELement() throws InterruptedException {
        driver.get("https://live.techpanda.org/index.php/about-magento-demo-store");
        Thread.sleep(3000);
        action.scrollToElement(driver.findElement(By.cssSelector("input#newsletter"))).perform();

    }


    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
