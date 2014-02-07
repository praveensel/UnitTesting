package com.Annectos.Webdriver.PageObjects;

/**
 * Created with IntelliJ IDEA.
 * User: QA-002
 * Date: 12/27/13
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
import com.Annectos.Webdriver.Common.Assertion;
import com.Annectos.Webdriver.Common.CommonMethods;
import com.Annectos.Webdriver.Helper.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObjects extends CommonMethods {

    @FindBy(xpath = "//*[@id='ng-app']/body/div[2]/div/div/div/div/div/div/div/span[1]/input")
    public WebElement email;


    @FindBy(xpath = "//*[@id=\"ng-app\"]/body/div[2]/div/div/div/div/div/div/div/span[1]/label")
    public WebElement emaillabel;

    @FindBy(xpath = "//*[@id='ng-app']/body/div[2]/div/div/div/div/div/div/div/span[2]/input")
    public WebElement Password;

    @FindBy(xpath = "//*[@id='ng-app']/body/div[2]/div/div/div/div/div/div/div/span[2]/label")
    public WebElement passwordlabel;

    @FindBy(xpath = "//input[@type='submit' and @value='Login']")
    public WebElement LoginButton;

    @FindBy(linkText = "Forgot Password?")
    public WebElement forgotPassword;

    //-------------------- ELEMENTS -----------------------

    //-------------------- CONSTRUCTOR --------------------
    public LoginPageObjects(WebDriver adriver) {
        super(adriver);
        driver = adriver;
        wait = new WebDriverWait(driver, timeOut);
        driver.manage().window().maximize();

    }
    //-------------------- CONSTRUCTOR --------------------

    //-------------------- USER ACTIONS -------------------
    public void typeInUserName(String username) {

        sendtext(email,username);
        Logger.Log(LOG_FILE, "typeInUserName", "Inputting << " + username + " >> in the username field... " + email.getAttribute("name"), driver, true);

    }

    public void typeInPassword(String password) {

        sendtext(Password,password);
        Logger.Log(LOG_FILE, "typeInPassword", "Inputting << " + password + " >> in the password field... "+Password.getAttribute("name"), driver, true);
    }

    public void Assert()
    {

    }

    public void clickLoginButton() {

        Logger.Log(LOG_FILE, "clickLoginButton", "Clicking "+LoginButton.getAttribute("name")+" button... ", driver, true);
        WaitforElementToLoadAndClick(LoginButton);

    }

    public void assertEmailLabel()
    {
      waitforElementtoLoad(emaillabel);
      Assertion.assertEquals(emaillabel.getText(),"Company E-mail Address");
    }

    public void assertPasswordLabel()
    {
        waitforElementtoLoad(passwordlabel);
        Assertion.assertEquals(passwordlabel.getText(),"Password");
    }

    public void OpenURl()
    {
        driver.navigate().to(baseURL);
    }

    //Login method for logging into both usa and india portal
    public void login(String name, String pass) {

        assertEmailLabel();
        typeInUserName(name);
        typeInPassword(pass);
        clickLoginButton();
        waitForAlertAndAccept("Log In Successfully");
        System.out.println(driver.getTitle());

    }

    public void loginwithoutPassword(String name)
    {
        typeInUserName(name);
        clickLoginButton();
        waitForAlertAndAccept("Please enter password to login");
    }

    public void loginwithoutEmail(String password )
    {
        typeInPassword(password);
        clickLoginButton();
        waitForAlertAndAccept("Please enter email address to login");
    }
    public void loginwithoutdata( )
    {

        clickLoginButton();
        waitForAlertAndAccept("Please enter email address to login");
    }

}