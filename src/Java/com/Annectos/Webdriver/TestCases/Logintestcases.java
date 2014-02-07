package com.Annectos.Webdriver.TestCases;

import com.Annectos.Webdriver.Common.Staticprovider;
import com.Annectos.Webdriver.Common.Testbase;
import com.Annectos.Webdriver.PageObjects.LoginPageObjects;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: QA-002
 * Date: 1/13/14
 * Time: 3:44 PM
 * To change this template use File | Settings | File Templates.
 */



  public class Logintestcases extends Testbase {



        @Test(dataProviderClass = Staticprovider.class, dataProvider = "WiproLogin")
        public void LoginPageAssert(String email, String Password) throws Exception {


            if(threadDriver!=null)
            {
                findRemoteip(threadDriver.get());
            }
            LoginPageObjects loginPageObjects = PageFactory.initElements(getDriver(), LoginPageObjects.class);
            loginPageObjects.OpenURl();
            loginPageObjects.assertEmailLabel();
            loginPageObjects.assertPasswordLabel();
            loginPageObjects.login(email,Password);

        }

        @Test(dataProviderClass = Staticprovider.class,dataProvider = "WiproLogin")
        public void LoginWithoutPassword(String email, String Password) throws Exception
        {
            if(threadDriver!=null)
            {
                findRemoteip(threadDriver.get());
            }

            LoginPageObjects loginPageObjects = PageFactory.initElements(getDriver(), LoginPageObjects.class);
            loginPageObjects.OpenURl();
            loginPageObjects.loginwithoutPassword(email);
        }

    @Test(dataProviderClass = Staticprovider.class,dataProvider = "WiproLogin")
    public void LoginWithoutEmail(String email, String Password) throws Exception
    {
        if(threadDriver!=null)
        {
            findRemoteip(threadDriver.get());
        }

        LoginPageObjects loginPageObjects = PageFactory.initElements(getDriver(), LoginPageObjects.class);
        loginPageObjects.OpenURl();
        loginPageObjects.loginwithoutEmail(Password);
    }

    @Test(dataProviderClass = Staticprovider.class,dataProvider = "WiproLogin")
    public void LoginWithoutdata(String email, String Password) throws Exception
    {
        if(threadDriver!=null)
        {
            findRemoteip(threadDriver.get());
        }

        LoginPageObjects loginPageObjects = PageFactory.initElements(getDriver(), LoginPageObjects.class);
        loginPageObjects.OpenURl();
        loginPageObjects.loginwithoutdata();
    }


}
