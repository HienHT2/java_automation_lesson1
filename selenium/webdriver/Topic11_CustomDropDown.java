package webdriver;

import com.beust.ah.A;
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

public class Topic11_CustomDropDown {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    WebDriverWait expliciWait;
    @BeforeClass
    public void initalBrowser() {
        driver = new FirefoxDriver();
        expliciWait =new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_Handle_Jquery() throws InterruptedException{
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        //Hanh vi de thao tac tren Dropdown
        selectItemInCustomDropdown("span#speed-button","ul#speed-menu>li>div","Medium");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Medium");
        selectItemInCustomDropdown("span#number-button","ul#number-menu>li>div","19");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(),"19");
        selectItemInCustomDropdown("span#salutation-button","ul#salutation-menu>li>div","Dr.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(),"Dr.");
    }
    @Test
    public void TC_02_Handle_ReactJS() throws InterruptedException{
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        //Hanh vi de thao tac tren Dropdown
        selectItemInCustomDropdown("i.icon","span.text","Jenny Hess");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Jenny Hess");
        selectItemInCustomDropdown("i.icon","span.text","Justen Kitsune");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Justen Kitsune");

    }
    @Test
    public void TC_03_Handle_VueJS() throws InterruptedException{
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        //Hanh vi de thao tac tren Dropdown
        selectItemInCustomDropdown("li.dropdown-toggle","ul.dropdown-menu >li>a","First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"First Option");
        selectItemInCustomDropdown("li.dropdown-toggle","ul.dropdown-menu >li>a","Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Third Option");


    }
    @Test
    public void TC_04_HandleEdiable() throws  InterruptedException{
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        enterItemInCustomDropdown("input.search","div.item>span","Afghanistan");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Afghanistan");

        enterItemInCustomDropdown("input.search","div.item>span","American Samoa");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"American Samoa");

    }



    private void selectItemInCustomDropdown(String parentCss, String childCss,String textItem) throws InterruptedException {
        //1- Cho dropdown co the thao tac len duoc
        //2-Click vao Element de no xo Dropdown ra
        expliciWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss))).click();
        Thread.sleep(5000);
        //3-Cho tat ca cac element duoc load ra
        //4-Tim cai item nao dung voi mong doi
        List<WebElement> allItems= expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        for(WebElement item:allItems){
            //System.out.println(item.getText());
            if(item.getText().equals(textItem)){
                item.click();
                break;
            }
        }
        //5-Click len item do
    }
    private void enterItemInCustomDropdown(String parentCss, String childCss,String textItem) throws InterruptedException {
        //1- Cho dropdown co the nhap duoc(visible)
        //2-senkeyvao Element de no xo Dropdown ra
        WebElement dropdownTextbox = expliciWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parentCss)));
        dropdownTextbox.clear();
        dropdownTextbox.sendKeys(textItem);
        Thread.sleep(5000);
        //3-Cho tat ca cac element duoc load ra
        //4-Tim cai item nao dung voi mong doi
        List<WebElement> allItems= expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        for(WebElement item:allItems){
            //System.out.println(item.getText());
            if(item.getText().equals(textItem)){
                item.click();
                break;
            }
        }
        //5-Click len item do
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
