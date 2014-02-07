package trash;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class delete {
    private WebDriver driver;
    private String baseUrl;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://qa.aynax.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitled() throws Exception {
        driver.get(baseUrl + "/signup.php");
        driver.findElement(By.linkText("Sign Up")).click();
        driver.findElement(By.name("emailaddress")).clear();
        driver.findElement(By.name("emailaddress")).sendKeys("testingmember69@yopmail.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.id("submit")).click();
    }
}