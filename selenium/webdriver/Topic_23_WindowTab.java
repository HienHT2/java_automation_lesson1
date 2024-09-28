package webdriver;

import com.beust.ah.A;
import org.bouncycastle.pqc.crypto.util.PQCOtherInfoGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_23_WindowTab {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_WindowTab_AutomationFC() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        System.out.println("Driver id ="+ driver.toString());
        //lay ra id tab/window maf driver dang active tai page do
        String githubWindowID= driver.getWindowHandle();

        //click vaof google
        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
      //  System.out.println(" 2Github Window ID = "+ githubWindowID);
    //Swith qua tab Google
        switchToWindowByID(githubWindowID);
        Thread.sleep(2000);
        String googleWindowID= driver.getWindowHandle();
        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("xin chao");
    //Switch ve tab Github
        switchToWindowByID(googleWindowID);
        Thread.sleep(2000);

        //Click vao fb link
        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        Thread.sleep(3000);

        switchByToWindowByTitle("Facebook - Login or sign up");
        System.out.println("Page Titel= "+ driver.getTitle());
        switchByToWindowByTitle("Selenium WebDriver");
        //Click vao TIKI
        driver.findElement(By.xpath("//a[text()='TIKI']")).click();
        Thread.sleep(2000);
        //Switch tai TIKI
        switchByToWindowByTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
        Thread.sleep(3000);

       closeAllWindowsWithoutParent(githubWindowID);
       System.out.println(driver.getCurrentUrl());
       System.out.println(driver.getTitle());
        //Sau khi chay het thi se dong het ca tab/window ngoai tru github
        //Driver dang active o tab nao
    }



    @Test
    public void TC_02_TechPanda() throws InterruptedException {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();

        //Click add to compare Sony
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"The product Sony Xperia has been added to comparison list.");

        //Click Add to compare samsung
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"The product Samsung Galaxy has been added to comparison list.");

        //Click vao compare
        driver.findElement(By.xpath("//button[@title='Compare']")).click();
        Thread.sleep(3000);
        switchByToWindowByTitle("Products Comparison List - Magento Commerce");
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/catalog/product_compare/index/");
        driver.findElement(By.cssSelector("button[title='Close Window']")).click();
        Thread.sleep(3000);
        switchByToWindowByTitle("Mobile");
        driver.findElement(By.xpath("//a[text()='Clear All']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.switchTo().alert().getText(),"Are you sure you would like to remove all products from your comparison?");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"The comparison list was cleared.");
    }
    @Test
    public void TC_03_Dictionnary_Cambridge() throws InterruptedException {
        driver.get("https://dictionary.cambridge.org/vi/");
        driver.findElement(By.cssSelector("span.cdo-login-button")).click();
        Thread.sleep(3000);
        switchByToWindowByTitle("Login");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='username']~span.gigya-error-msg-active")).getText(),"This field is required");
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='password']~span.gigya-error-msg-active")).getText(),"This field is required");
        driver.close();
        switchByToWindowByTitle("Cambridge Dictionary | Từ điển tiếng Anh, Bản dịch & Từ điển từ đồng nghĩa");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input#searchword")).sendKeys("hello");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[aria-label='Search']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#cald4-1~div span.headword>span")).getText(),"hello");

    }

    @Test
    public void TC_04_Selenium_4x() throws InterruptedException {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        Thread.sleep(3000);

        System.out.println("Driver ID =" +driver.toString());
        System.out.println("Window ID= "+driver.getWindowHandle());
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.switchTo().newWindow(WindowType.TAB).get("http://live.techpanda.org/index.php/customer/account/login/");
        Thread.sleep(2000);

        System.out.println("Driver ID =" +driver.toString());
        System.out.println("Window ID= "+driver.getWindowHandle());
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),"This is a required field.");
        switchByToWindowByTitle("Mobile");
        Thread.sleep(3000);
        //Click add to compare Sony
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"The product Sony Xperia has been added to comparison list.");

        //Click Add to compare samsung
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"The product Samsung Galaxy has been added to comparison list.");


    }
    private void closeAllWindowsWithoutParent(String githubWindowID) throws InterruptedException {
        //dong tat ca cua so
        Set<String> allWindowIDs =driver.getWindowHandles();
        //dung vong lap de duyet qua tung ID mot
        for(String id:allWindowIDs){
            if(!id.equals(githubWindowID)){
                driver.switchTo().window(id);
                Thread.sleep(2000);
                driver.close();
            }

        }

        //Switch vao WIndow duy nhat con lai
        driver.switchTo().window(githubWindowID);
    }

    private void switchByToWindowByTitle(String expextedPageTitle) throws InterruptedException {
        //Lay het toan bo ra
        Set<String> allWindowIds =driver.getWindowHandles();

        //DUng vong lap duyet qua tung id
        for(String id:allWindowIds){
            //moi lan duyet se chi switch vao truoc
            driver.switchTo().window(id);
            Thread.sleep(3000);
            //het ra title cua window tab hien tai
            String pageTitle = driver.getTitle();
            if(pageTitle.equals(expextedPageTitle)){
                break;
            }
        }
    }

    //chi dung voi 2 Window/Tab
    private void switchToWindowByID(String windowId) {
        //Lay ra het tat ca cac id window/tab hien tai
        Set<String> allWindows =driver.getWindowHandles();
        //dung vong lap de duyet qua tung ID mot
        for(String id:allWindows){
            //Kiem tra dieu kien: neu ID nao ma khac voi ID mong doi thi switch qua
            if(!id.equals(windowId)){
                driver.switchTo().window(id);
            }
        }
    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        //driver.quit();
    }


}
