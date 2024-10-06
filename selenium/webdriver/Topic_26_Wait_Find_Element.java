package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_26_Wait_Find_Element {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    @BeforeClass
    public void initalBrowser(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();

    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_FindElement(){
     //   driver.get("http://live.techpanda.org/");
        //1-Neu tim thay duy nhat 1 element
        //output: tra ve dung element do
        //Khong can cho het time cua implicit
       // driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
      // driver.findElement(By.cssSelector("input#email"));

        //2- Neu tim thay nhieu hon 1 element
        //Chi thao tac element dau tien
        //Luwuu y la khi lay locator nen check truoc
        //driver.findElement(By.cssSelector("input#email")).sendKeys("search");
    //s   driver.findElement(By.xpath("//input")).sendKeys("search");

        //3- Neu khong tim thay element nao
        //Tim lai ma thay element thi k can cho het tong tim con lai
        //Tim lai ma khong thay, het 13s thi danh fail testcase
        //Show loi noSuchELementExeption
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@id='firstname']")); //
        //driver.findElement(By.xpath("//input[@class='hien']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }
    @Test
    public void Tc_02_Login(){
       List<WebElement> elements=null;
    //1-Neu tim thay duy nhat 1 element
        elements= driver.findElements(By.cssSelector("input#email"));
        System.out.println(elements.size());
        //2-Neu tim thay nhieu hon elemnt
        //-TRa he toan bo
        elements=  driver.findElements(By.xpath("//input"));
        System.out.println(elements.size());
        //3-Neu khong tim thay element nao

        elements= driver.findElements(By.xpath("//input[@id='firstname']"));
        System.out.println(elements.size());
    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        //driver.quit();
    }


}
