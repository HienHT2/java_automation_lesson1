package javaSdet;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.rmi.Remote;
import java.util.*;

public class Topic_09_List {
    public static void main(String[] args){
//        RemoteWebDriver driver;
//        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
//        driver = new EdgeDriver();
//
//        FirefoxDriver ffDriver = new FirefoxDriver();
//        ArrayList<String> adress = new ArrayList<>();
//        Vector<Float> studentPoint = new Vector<>();
//        LinkedList<Integer> studentAge = new LinkedList<>();
//        Stack<Boolean> status = new Stack<>();
//        List<String> studentName= new Stack<>();
        List<String> adress = new ArrayList<>();
        adress.add("Ho Chi Minh");
        adress.add("Ha Noi");
        adress.add("Hai Phong");
        adress.add("Yen Bai");
        adress.add("Vinh Phuc");
        adress.add("Nam Dinh");
        adress.add("Ha Giang");
        //laays ra 1 gia tri
        System.out.println(adress.get(0));
        //lay ra toan bo
        for(int i=0; i<adress.size(); i++){
            System.out.println(adress.get(i));
        }
        //lay ra toan bo
        for(String a:adress){
            System.out.println(a);
        }

    }
}
