package javaSdet;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic01_AndOr {
    @Test
    public  void verifyAnd() {
        String contactInformationText="Testing Automation\n"+
                "automationfc3334534@gmail.com\n" +
                "ChangePassword";
        Assert.assertTrue(
                contactInformationText.contains("Testing Automation") &&contactInformationText.contains("automationfc3334534@gmail.com"));
    }
}
