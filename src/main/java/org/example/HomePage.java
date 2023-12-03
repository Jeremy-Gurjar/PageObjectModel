package org.example;

import org.openqa.selenium.By;

public class HomePage extends Utils{

    public void clickOnRegisterButton(){

        clickOnElement(By.className("ico-register")); // click on register button

    }

    public void clickOnLoginButton() {
        clickOnElement(By.className("ico-login")); // click on login button


    }

    public void clickOnElectronicsButton() // click on electronics button
    {
        clickOnElement(By.xpath("//div[@class = 'header-menu']/ul[contains(@class,'notmobile')]/li/a[@href='/electronics']"));//click on electronics button

    }


}
