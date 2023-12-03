package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterResultPage extends Utils{

        String expectedRegistrationMessage = "Your registration completed";

        //verify is user is registered successfully
        public void verifyUserRegisteredSuccessFully(){

            String actualRegistrationMessage = getTextFromElement(By.className("result"));
            Assert.assertEquals(actualRegistrationMessage,expectedRegistrationMessage,"Your registration is not completed");
        }


}
