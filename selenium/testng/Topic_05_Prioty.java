package testng;

import org.testng.annotations.Test;

public class Topic_05_Prioty {
    //CRUD
    //Flow
    @Test(priority = 1)
    public void ShouldBeCreateNewProduct(){
        System.out.println("ShouldBegisterFailWithInvalidEMail");
    }
    @Test(priority = 2)
    public void ShouldBeViewProduct(){
        System.out.println("ShouldBeLoginPass");
    }

    @Test(priority = 3)
    public void ShouldBeEditProduct(){
        System.out.println("ShouldBeLoginFail");
    }
    @Test(priority = 4)
    public void ShouldBeDeleteProduct(){
        System.out.println("ShouldBeLoginFail");
    }
}
