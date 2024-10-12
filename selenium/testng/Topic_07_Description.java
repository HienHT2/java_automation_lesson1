package testng;

import org.testng.annotations.Test;

public class Topic_07_Description {
    //Ten testcase =ham/function/method cua Java
    //Theo convention cua tung ngon ngu

    //Chu thich/dien giai/note
    @Test(description = "Jira#1368- User can create new product and verify created susscess")
    public void ShouldBeCreateNewProduct(){
        System.out.println("ShouldBegisterFailWithInvalidEMail");
    }
    @Test
    public void ShouldBeViewProduct(){
        System.out.println("ShouldBeLoginPass");
    }

    @Test(enabled = false)
    public void ShouldBeEditProduct(){
        System.out.println("ShouldBeLoginFail");
    }
    @Test
    public void ShouldBeDeleteProduct(){
        System.out.println("ShouldBeLoginFail");
    }
}
