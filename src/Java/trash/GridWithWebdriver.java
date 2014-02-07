package trash;

/**
 * Created with IntelliJ IDEA.
 * User: QA-002
 * Date: 2/7/14
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
/**
 * @author Gaurang Shah
 * To Demonstrate how to configure webdirver with Selenium Grid
 */
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class GridWithWebdriver {

    public WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void setup(@Optional("firefox")String browser)throws MalformedURLException {
        DesiredCapabilities capability=null;

        if(browser.equalsIgnoreCase("firefox")){
            System.out.println("firefox");
            capability= DesiredCapabilities.firefox();
            capability.setBrowserName("firefox");
            capability.setPlatform(org.openqa.selenium.Platform.ANY);
            //capability.setVersion("");
        }

        if(browser.equalsIgnoreCase("iexplore")){
            System.out.println("iexplore");
            capability= DesiredCapabilities.internetExplorer();
            capability.setBrowserName("iexplore");
            //capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
            capability.setVersion("11");
        }

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        driver.navigate().to("http://google.com");

    }

    @Test
    public void test_first() throws InterruptedException{
        Thread.sleep(3000);
        WebElement search_editbox	=	driver.findElement(By.name("q"));
        WebElement search_button	=	driver.findElement(By.name("btnG"));
        search_editbox.clear();
        search_editbox.sendKeys("first");
        search_button.click();
    }

    @Test
    public void test_second(){
        WebElement search_editbox	=	driver.findElement(By.name("q"));
        WebElement search_button	=	driver.findElement(By.name("btnG"));
        search_editbox.clear();
        search_editbox.sendKeys("second");
        search_button.click();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
