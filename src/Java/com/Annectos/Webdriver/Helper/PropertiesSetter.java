package com.Annectos.Webdriver.Helper;

import java.io.File;


/**
 * Created with IntelliJ IDEA.
 * User: QA-002
 * Date: 1/22/14
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */

public class PropertiesSetter

{
 public static void setPropertiesManually()

 {
        Global.BROWSER = "FF";
Global.DOMAIN = "http://mediawiki119.wikia.com/";
Global.LIVE_DOMAIN = "http://www.wikia.com/";
String seleniumConfigDir = "c:"+File.separator+"selenium-config";
Global.CONFIG_FILE = new File(seleniumConfigDir+File.separator+"config.xml");
Global.CAPTCHA_FILE = new File(seleniumConfigDir+File.separator+"captcha.txt");

Global.LOG_VERBOSE = 2;
if (Global.DOMAIN.contains("dev")||Global.DOMAIN.contains("sandbox"))
        {
        Global.LOGIN_BY_COOKIE = false;
}
        else {
        Global.LOGIN_BY_COOKIE = true;
}
        Global.LOG_ENABLED = true;
}
        }
