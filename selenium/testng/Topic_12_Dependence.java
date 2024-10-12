package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_12_Dependence {
    @Test(groups = "create")
    public void TC_01_CreaNewProduct(){
        System.out.println("Run CreaNewProduct");
        Assert.assertTrue(false);
    }
    @Test(dependsOnMethods ="TC_01_CreaNewProduct",dependsOnGroups = "create")
    public void TC_02_ViewProduct(){
        System.out.println("Run ViewProduct");
    }

    @Test(dependsOnMethods ="TC_01_CreaNewProduct")
    public void TC_03_EditProduct(){

        System.out.println("Run EditProduct");
    }
    @Test(dependsOnMethods ="TC_01_CreaNewProduct")
    public void TC_04_MoveProduct(){

        System.out.println("Run MoveProduct");
    }
    @Test(dependsOnMethods ="TC_01_CreaNewProduct")
    public void TC_05_DeleteProduct(){

        System.out.println("Run TC03");
    }

}
