package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

    @Test
    public void Tc_02_Login(){

    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        //driver.quit();
    }


}
