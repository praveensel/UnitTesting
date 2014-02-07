package com.Annectos.Webdriver.PageObjects;

/**
 * Created with IntelliJ IDEA.
 * User: QA-002
 * Date: 1/22/14
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */


import com.Annectos.Webdriver.Common.CommonMethods;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class HomePageObjects extends CommonMethods {

    @FindBy(xpath = "//*[@id='ng-app']/body/header/div[1]/div/div[2]/div[1]/div[2]/input")
    public WebElement searchForItems;

    @FindBy(xpath= "//img[@src='Content/customer_images/logo.png']")
    public WebElement BannerLogoimg;

    @FindBy(xpath = "//*[@id=\"ng-app\"]/body/header/div[1]/div/div[2]/a[2]/span/img")
    public WebElement eselectimg;

    @FindBy(xpath = "//*[@id=\"ng-app\"]/body/header/div[1]/div/div[2]/div[1]/div[1]")
    public WebElement CustomerText;

    @FindBy(xpath = "//button[text()='Place Order']")
    public WebElement placeOrder;

    @FindBy(xpath = "//*[@id=\"ng-app\"]/body/header/div[1]/div/div[1]/a[2]")
    public WebElement WelcomeMessage;

    @FindBy(xpath = "//*[@id=\"ng-app\"]/body/header/div[1]/div/div[1]/a[1]")
    public WebElement SignOut;

    @FindBy(xpath = "//*[@id=\"ng-app\"]/body/header/div[1]/div/div[2]/div[2]/ul/li[1]/a/span[1]]")
    public WebElement Points;

    @FindBy(xpath = "//*[@id='ng-app']/body/header/div[1]/div/ul/li[4]")
    public WebElement pleaseAddName6;

    @FindBy(xpath = "//*[@id='ng-app']/body/header/div[1]/div/ul/li[5]")
    public WebElement pleaseAddName7;

    @FindBy(xpath = "//*[@id='ng-app']/body/header/div[1]/div/ul/li[6]")
    public WebElement pleaseAddName8;

    @FindBy(xpath = "//*[@id='ng-app']/body/header/div[1]/div/ul/li[7]")
    public WebElement pleaseAddName9;

    @FindBy(xpath = "//*[@id='ng-app']/body/header/div[1]/div/ul/li[8]")
    public WebElement pleaseAddName10;

    @FindBy(xpath = "//*[@id='ng-app']/body/header/div[1]/div/ul/li[9]")
    public WebElement pleaseAddName11;

    @FindBy(xpath = "//*[@id='ng-app']/body/header/div[1]/div/ul/li[10]")
    public WebElement pleaseAddName12;

    public HomePageObjects(WebDriver adriver) {
        super(adriver);
        driver = adriver;
        wait = new WebDriverWait(driver, timeOut);
        driver.manage().window().maximize();
    }

    public void verifyLogo(String LogoPath)
    {
        waitforElementtoLoad(BannerLogoimg);
        try {
            String LogoString= BannerLogoimg.getAttribute("src");
            URL LogoURL = new URL(LogoString);
            imageCompare(LogoURL,LogoPath);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }


}

