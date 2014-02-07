package com.Annectos.Webdriver.Common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

/**
 * Created with IntelliJ IDEA.
 * User: QA-002
 * Date: 1/13/14
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */

public  class Staticprovider extends CommonMethods {

    public Staticprovider(WebDriver driver) {
        super(driver);
    }

    //This function will provide the parameter data
    @DataProvider(name = "SpanLogin")
    public static Object[][] spanloginprovider() {

        return new Object[][]{

                {Properties.userNamespan,Properties.passwordspan }
        };

    }
    @DataProvider(name = "WiproLogin")
    public static Object[][] WiproLoginProvider() {

        return new Object[][]{

                {Properties.userNamewipro  ,Properties.passwordwipro }
        };

    }
    @DataProvider(name = "WiproLogin+Logo")
    public static Object[][] WiproLoginplusLogProvider() {

        return new Object[][]{

                {Properties.userNamewipro  ,Properties.passwordwipro,Properties.wiproLogo }
        };

    }
}