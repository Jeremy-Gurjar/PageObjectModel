package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailResultPage extends Utils{


    String expectedEmailMessage = "Your message has been sent.";

    //verify confirmation about sent email

    public void verifyUserSuccessfullyReferredProduct () {

        String actualMessageForReferringProduct = getTextFromElement(By.className("result"));
        Assert.assertEquals(actualMessageForReferringProduct,expectedEmailMessage,"Product not referred");
    }

}
