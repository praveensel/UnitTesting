package com.Annectos.Webdriver.Helper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;


/**
 * Created with IntelliJ IDEA.
 * User: QA-002
 * Date: 1/28/14
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImageCompare {

    private void imageCompare(String file1, String file2) throws Exception {
        int width;
        int height;
        boolean imagesEqual = true;


        File f1 = new File(file1);
        // set permission to generated file
        f1.setReadable(true, true);
        f1.setExecutable(true);
        f1.setWritable(true,true);

        Image image = ImageIO.read(f1);


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
}
