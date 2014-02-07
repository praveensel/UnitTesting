package com.Annectos.Webdriver.Common;

/**
 * Created with IntelliJ IDEA.
 * User: QA-002
 * Date: 1/13/14
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;


import java.io.File;

public class XMLFunctions {


    public static String getXMLConfiguration(File file, String key)

    {
        XMLConfiguration xl = null;
        try {
            xl = new XMLConfiguration(file);
        } catch (org.apache.commons.configuration.ConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return xl.getString(key);
    }
}