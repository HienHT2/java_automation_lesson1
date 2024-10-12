package testng;

import org.testng.annotations.Test;

public class Topic_06_Skip {
    //CRUD
    //Flow
    @Test
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
