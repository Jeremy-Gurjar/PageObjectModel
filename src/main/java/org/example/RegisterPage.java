package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterPage extends Utils{

     String email = "test" + timeStamp() + "@gmail.com";
    public void verifyUserIsOnRegisterPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains(("register"))); // confirm with correct url

    }

    public void enterRegistrationInfo(){
    // wait for button to appear
        waitForClickable(By.id("register-button"), 10); // wait for button to appear

        // enter first name
        typeText(By.id("FirstName"), "FirstName"); // enter first name
        typeText(By.id("LastName"), "Patel"); // enter last name

        selectByText(By.name("DateOfBirthDay"),"15");//select birthday
        selectByText(By.name("DateOfBirthMonth"),"July");//select birth month
        selectByText(By.name("DateOfBirthYear"),"2000"); // select birth year

        System.out.println(email);
        typeText(By.id("Email"),email ); // type email

        typeText(By.id("Company"), "Hello"); // company name
        typeText(By.name("Password"), password); // enter password
        typeText(By.id("ConfirmPassword"), password); // enter confirm password
        clickOnElement(By.name("register-button")); // click on register button
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
