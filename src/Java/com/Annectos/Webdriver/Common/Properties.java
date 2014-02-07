package com.Annectos.Webdriver.Common;

/**
 * Created with IntelliJ IDEA.
 * User: QA-002
 * Date: 1/13/14
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.io.File;




import java.io.File;

public class Properties extends Testbase{

    public static String userNamespan;
    public static String passwordspan;
    public static String userNamewipro;
    public static String passwordwipro;
    public static String wiproLogo;

    public static void setVariables() {

        userNamespan = XMLFunctions.getXMLConfiguration(CONFIG_FILE, "Span.email");
        passwordspan = XMLFunctions.getXMLConfiguration(CONFIG_FILE,"Span.password");
        userNamewipro = XMLFunctions.getXMLConfiguration(CONFIG_FILE,"Wipro.email");
        passwordwipro= XMLFunctions.getXMLConfiguration(CONFIG_FILE,"Wipro.password");
        wiproLogo= XMLFunctions.getXMLConfiguration(CONFIG_FILE,"Wipro.LogoLocation");
    }






}

