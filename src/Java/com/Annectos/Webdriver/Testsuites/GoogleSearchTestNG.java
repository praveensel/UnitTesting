package com.Annectos.Webdriver.Testsuites;

/**
 * Created with IntelliJ IDEA.
 * User: QA-002
 * Date: 1/14/14
 * Time: 11:19 AM
 * To change this template use File | Settings | File Templates.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchTestNG {

    WebDriver driver;

    @BeforeTest
    public void start(){
        driver = new FirefoxDriver();
    }

    @Test
    public void Test(){
        System.out.println("Loading Google search page");
        driver.get("http://google.com");
        System.out.println("Google search page loaded fine");
        Object className="passed";
        Object command="TEst";
        Reporter.log(
                "<tr class=\"" + className + "\">"
                        + "<td>" + command + "</td></tr>" );
    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}

