package webdriver;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v128.network.Network;
import org.openqa.selenium.devtools.v128.network.model.Headers;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Topic16_Authencation_Alert {
    //1-Set up : OS / Browser/Web/ Page/Data /Variable /Objcet...
    WebDriver driver;
    String username="admin";
    String password="admin";
    @BeforeClass
    public void initalBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    // 2 -Action/ execute: Tuong tac voi cac Element ,...
    public void TC_01_AuthencationUrl(){
       driver.get("https://"+username+":"+password + "@"+"the-internet.herokuapp.com/basic_auth");
        Assert.assertEquals( driver.findElement(By.cssSelector("div.example>p")).getText(),"Congratulations! You must have the proper credentials.");
    }
    @Test
    public void Tc_02_Login(){
    driver.get("https://the-internet.herokuapp.com/");
    String basicAulink= driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
    driver.get(getAuthencationUrl(basicAulink,username,password));
    Assert.assertEquals( driver.findElement(By.cssSelector("div.example>p")).getText(),"Congratulations! You must have the proper credentials.");

    }

    public String getAuthencationUrl(String link, String username, String password){
        String[] Linkarray = link.split(("//"));
       return link=Linkarray[0]+"//"+ username+":"+password+"@"+Linkarray[1];
    }

    @Test
    public void TC_03_Authencation_CDP(){
        // Get DevTool object
        DevTools devTools = ((HasDevTools) driver).getDevTools();

        // Start new session
        devTools.createSession();

        // Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Encode username/ password
        Map<String, Object> headers = new HashMap<String, Object>();
        String basicAuthen = "Basic " + new String(new Base64().encode(String.format("%s:%s", "admin", "admin").getBytes()));
        headers.put("Authorization", basicAuthen);

        // Set to Header
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        driver.get("https://the-internet.herokuapp.com/basic_auth");
        Assert.assertEquals( driver.findElement(By.cssSelector("div.example>p")).getText(),"Congratulations! You must have the proper credentials.");

    }
    @AfterClass
    //3 Clean : Delete Data/ account/ CLose Browser
    public void cleanBrowser(){
        driver.quit();
    }


}
