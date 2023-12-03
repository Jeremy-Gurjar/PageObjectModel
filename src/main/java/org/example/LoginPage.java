package org.example;

import org.openqa.selenium.By;

public class LoginPage extends Utils{

    public void enterLoginDetails(){

        System.out.println(email);
        typeText(By.id("Email"),email); // enter email
        typeText(By.id("Password"), password); // enter password
        clickOnElement(By.xpath("//button [contains(@class ,' login-button')]")); // click on login button

    }

}
