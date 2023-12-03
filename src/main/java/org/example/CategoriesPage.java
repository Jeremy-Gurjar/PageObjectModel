package org.example;

import org.openqa.selenium.By;

public class CategoriesPage extends Utils

{

    public void selectCameraAndPhotoImage() // selecting camera and photo option from category page
    {
        clickOnElement(By.xpath("//img[@alt='Picture for category Camera & photo']"));// click on camera and photo

    }
    public void selectDigitalCameraPhoto() // selecting digital camera option
    {
        clickOnElement(By.xpath("//div[@class='picture']/a[@href='/leica-t-mirrorless-digital-camera']"));// click on digital camera photo

    }

    public void sendEmailToFriendForReferringProduct() //Referring product to friend method
    {
        clickOnElement(By.xpath("//div[@class='email-a-friend']/button"));// click on send email button
        typeText(By.id("FriendEmail"),"hello567@gmail.com");// type friend email
        typeText(By.id("PersonalMessage"),"Hello my friend check this product on demo ecommerce website it is at very affordable price");// enter message to a friend in textarea
        clickOnElement(By.xpath("//button[@name=\"send-email\"]")); // click on send email button
    }

}
