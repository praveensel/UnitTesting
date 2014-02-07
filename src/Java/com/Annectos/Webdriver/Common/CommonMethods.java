package com.Annectos.Webdriver.Common;

/**
 * Created with IntelliJ IDEA.
 * User: QA-002
 * Date: 12/27/13
 * Time: 5:18 PM
 * To change this template use File | Settings | File Templates.
 */

import com.Annectos.Webdriver.Helper.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;





public class CommonMethods extends Testbase {
    public static WebDriver driver;
    protected int timeOut = 30;
    public WebDriverWait wait;
    public static String LOG_FILE="E:\\AnnectosAutomatedTesting\\src\\Logs\\Report.log" ;

    public CommonMethods(WebDriver driver)
    {
        this.driver=driver;
        wait = new WebDriverWait(this.driver,timeOut);
    }



    public void Switchtodefaultcontetn() {
        driver.switchTo().defaultContent();
        Logger.Log(LOG_FILE, "Switchtodefaultcontetn", "Switching to default content", driver, true);
    }
    public void waitforElementtoLoad(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        Logger.Log(LOG_FILE,"waitforElementtoLoad","Waiting for " +element.getAttribute("id")+ " element to load",driver,true);

    }
    public void WaitforElementToLoadAndClick(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        Logger.Log(LOG_FILE,"waitandClick","Clicking element " +element.getAttribute("id"),driver,true);
        element.click();


    }
    //-------------------- SYNC ---------------------------
    public  void waitforFrametoLoad(String Framename)
    {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Framename));
        Logger.Log(LOG_FILE,"waitforFrametoLoad", "Switching to Frame " + Framename, driver,true);

    }

    public void waitForAlertAndAccept(String alertText) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String CurrentALertText = alert.getText();
        try {
            if (CurrentALertText.equals(alertText))
            {
            alert.accept();
            Logger.Log(LOG_FILE,"waitForAlertAndAccept", "detected and closed alert with text " + CurrentALertText,driver, true);
            }
            else {
               throw new Exception("");
            }
        } catch (Exception e) {

            alert.accept();
            Logger.Log(LOG_FILE,"waitForAlertAndAccept", "detected and closed alert with text differnt Text  " + CurrentALertText,driver, false);


        }


    }

    public void Mousehover(WebElement element)
    {
        Actions actions = new Actions(this.driver);
        WebElement menuHoverLink = element;
        actions.moveToElement(menuHoverLink);
        actions.click();
        actions.perform();

    }

    public void clickatPosistion()
    {
        Actions builder = new Actions(this.driver);
        Action Movetoxy=builder.moveByOffset(161, 410)

                .build();

        Movetoxy.perform();

        ;
    }

    public void getELocation(WebElement element)
    {
        Point loc= element.getLocation();
        Dimension Size=  element.getSize();
        System.out.println(loc);
        System.out.println(Size);

    }


    public void ScriptExecutor(WebElement element)
    {
        String script = "document.getElementById(fileClientArticle).value='" + "C:\\\\tmp\\\\file.txt" + "';";

        ((JavascriptExecutor)driver).executeScript(script);
    }

    public void VerifyTextPresent(String exp,String act)
    {
        if (!exp.contains(act)) {
            System.out.println("verifyTextPresent failed");
            System.out.println("Expected is" + exp  +"Actual is"+act);

        }


    }
    //----------------Click a button or a Link--------------------------
    public void ClickButtonOrLink(WebElement element)
    {
        waitforElementtoLoad(element);
        element.click();
    }


    //----------------Send text to a textbox--------------------------
    public void sendtext(WebElement element,String text)
    {
        waitforElementtoLoad(element);
        element.clear();
        element.sendKeys(text);
    }

    public void OpenWebPage(String URL)
    {
        driver.get(URL);
    }



    public void FramesetSwitch(String Framename1)
    {
        List<WebElement> frameset = driver.findElements(By.tagName("frame"));
        if(frameset.size()>0)
            for (WebElement framename : frameset)

            {
                String f = framename.getAttribute("id");
                System.out.println("frameid: " + f);
                //driver.switchTo().frame(f);
                if (f.equals(Framename1)) {
                    WebElement t=driver.findElement(By.id(f));
                    driver.switchTo().frame(t) ;
                    System.out.println("Switching to frame " + f);
                    break;
                }


            }

    }
    public void imageCompare(URL url, String file2) throws Exception {
        int width;
        int height;
        boolean imagesEqual = true;



        // set permission to generated file
        //f1.setReadable(true, true);
       // f1.setExecutable(true);
       // f1.setWritable(true,true);

        Image image = ImageIO.read(url);


        BufferedImage image1 = (BufferedImage) image;
        File f2 = new File(file2);
        //  f2.setReadable(true, true);
        //  f2.setExecutable(true);
        //  f2.setWritable(true,true);

        image = ImageIO.read(f2);
        BufferedImage image2 = (BufferedImage) image;


        if( image1.getWidth()  == ( width  = image2.getWidth() ) &&
                image1.getHeight() == ( height = image2.getHeight() ) ){

            outerloop:
            for(int x = 0;imagesEqual == true && x < width; x++){
                for(int y = 0;imagesEqual == true && y < height; y++) {
                    if( image1.getRGB(x, y) != image2.getRGB(x, y) ) {
                        System.out.println("image not same");
                        Logger.Log(LOG_FILE,"Comparing Image","Home Page Logo Comparison",driver,false);
                        // function is used to write coordinate in a file where image is not match
                        //  writeinfile("x:"+x+",y:"+y,file1);
                        break outerloop;
                    }
                }
            }
        }else{
            // writeinfile("dimension not correct",file1);
        }


    }
  /*  public static String[][] readExcelSheet(String destFile) throws IOException, BiffException {
        File excelSheet = null;
        Workbook workbook = null;

        String[][] email = null;


        Workbook wb = Workbook.getWorkbook(new File(destFile));
        System.out.println(wb.getNumberOfSheets());
        Sheet sheet = wb.getSheet("UserLogins");
        int sRow,sCol, eRow, eCol,ci,cj;
        int columns = sheet.getColumns();
        int rows = sheet.getRows();
        String[][] tabArray=null;
        sRow=1;
        sCol=0;
        // Cell tableEnd= sht.findCell(tbName, sCol+1,sRow+1, 100, 64000, false);
        eRow=19;
        eCol=3;
        System.out.println("startRow="+sRow+", endRow="+eRow+", " + "startCol="+sCol+", endCol="+eCol);
        tabArray=new String[eRow-sRow-1][eCol-sCol-1];
        ci=0;
        for (int i=sRow+1;i<eRow;i++,ci++){
            cj=0;
            for (int j=sCol+1;j<eCol;j++,cj++){
                tabArray[ci][cj]=sheet.getCell(j,i).getContents();
            }
        }
        return tabArray;}
    //----------------Open a WebPage--------------------------
    public void OpenWebPage(String URL)
    {
        driver.get(URL);
    }  */
}

