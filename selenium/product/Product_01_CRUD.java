package product;

import org.testng.annotations.Test;

public class Product_01_CRUD {
    @Test(groups = {"product","regression"})
    public void TC_01(){
        System.out.println("Product TC01");
    }
    @Test(groups = {"product","regression"})
    public void TC_02(){
        System.out.println("Product TC02");
    }

    @Test(groups = {"product"})
    public void TC_03(){
        System.out.println("Product TC03");
    }
}
