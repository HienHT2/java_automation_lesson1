package javaSdet;

import org.testng.annotations.Test;

import java.util.Random;

public class Topic02_Random {
    String prefixEmail ="hient";
    String postfixEmail="@gmail.com";

    @Test
    public void testEmail(){
        Random rand = new Random();
        String fullEmail =prefixEmail + rand.nextInt(9999) + postfixEmail;
        System.out.println(fullEmail);
        
    }
}
