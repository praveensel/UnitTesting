package com.Annectos.Webdriver.Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Annectos.Webdriver.Common.CommonMethods;
import com.Annectos.Webdriver.Helper.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;



public class Assertion extends CommonMethods{

    public Assertion(WebDriver driver) {
        super(driver);
    }

    public static boolean assertStringContains(String bigger, String smaller){
        boolean isAssertPassed = true;
        try{
            if (bigger.contains(smaller)){
                Logger.Log(LOG_FILE, "assertStringContains", "assertion passed<br/>pattern: " + bigger + "<br/>current: " + smaller, driver, true);
                return true;
            }
            else{
                throw new AssertionError();
            }
        }
        catch(AssertionError ass){
            isAssertPassed = false;
            addVerificationFailure(ass);
            Logger.Log(LOG_FILE, "assertStringContains", "assertion failed<br/>pattern: " + bigger + "<br/>current: " + smaller, driver, false);
            return false;
        }
    }

    public static void assertEquals(String pattern, String current){
        boolean isAssertPassed = true;
        try{
            Assert.assertEquals(pattern, current);
            if (pattern.contains("<")||current.contains("<"))
            {
                String tmp1 = pattern.replaceAll("<", "&lt");
                tmp1 = tmp1.replaceAll(">", "&gt");
                String tmp2 = current.replaceAll("<", "&lt");
                tmp2 = tmp2.replaceAll(">", "&gt");
                pattern = tmp1;
                current = tmp2;
            }
            Logger.Log(LOG_FILE,"assertEquals", "assertion passed<br/>pattern: " + pattern + "<br/>current: " + current,driver, true);
        }
        catch(AssertionError ass){
            isAssertPassed = false;
            addVerificationFailure(ass);
            if (pattern.contains("<")||current.contains("<"))
            {
                String tmp1 = pattern.replaceAll("<", "&lt");
                tmp1 = tmp1.replaceAll(">", "&gt");
                String tmp2 = current.replaceAll("<", "&lt");
                tmp2 = tmp2.replaceAll(">", "&gt");
                pattern = tmp1;
                current = tmp2;
            }
            Logger.Log(LOG_FILE, "assertEquals", "assertion failed<br/>pattern: " + pattern + "<br/>current: " + current,driver, false);
        }
    }


    public static void assertNumber(Number expected, Number actual,
                                    String message) {
        boolean isAssertPassed = true;
        try {
            Assert.assertEquals(expected, actual);
            Logger.Log(LOG_FILE, "assertNumber", message + ", expected: "
                    + expected + ", got: " + actual, driver, true);
        } catch (AssertionError ass) {
            isAssertPassed = false;
            addVerificationFailure(ass);
            Logger.Log(LOG_FILE, "assertNumber", message + ", expected: "
                    + expected + ", got: " + actual, driver, false);
        }
    }

    private static Map<ITestResult, List> verificationFailuresMap = new HashMap<ITestResult, List>();

    private static void addVerificationFailure(Throwable e)
    {
        List verificationFailures = getVerificationFailures();
        verificationFailuresMap.put(Reporter.getCurrentTestResult(), verificationFailures);
        verificationFailures.add(e);
    }

    public static List getVerificationFailures()
    {
        List verificationFailures = verificationFailuresMap.get(Reporter.getCurrentTestResult());
        return verificationFailures == null ? new ArrayList() : verificationFailures;
    }

    public static List getVerificationFailures(ITestResult result)
    {
        List verificationFailures = verificationFailuresMap.get(result);
        return verificationFailures == null ? new ArrayList() : verificationFailures;
    }
}
