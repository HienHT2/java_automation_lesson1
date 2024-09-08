package javaSdet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic04_If_Else {
    public  static void main(String[] args){
        WebDriver driver;
        String osName = System.getProperty("os.name");
        String browserName="IE";

        //bieu thuc dieu kien

        //if
        if(browserName.equals("IE")){
            System.out.println("CLick to Submit button");
        }
        //if_else
        if(osName.contains("Windows")){
            System.out.println("Window OS");
        }else {
            System.out.println("Mac os Linus");
        }
        //if-else-if-else
        if(browserName.equals("Chrome")){
            driver=new ChromeDriver();
        }else if(browserName.equals("Firefox")){
            driver=new FirefoxDriver();
        }else {
            driver= new EdgeDriver();
        }

        //switch-case
        switch (browserName){
            case "Firefox":
                driver= new FirefoxDriver();
                break;
            case "Chrome":
                driver = new ChromeDriver();
                break;
            default:
                driver =new EdgeDriver();
                break;
        }
    }

}
