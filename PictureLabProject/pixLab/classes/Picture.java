package classes;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }

    public void keepOnlyBlue(){
        Pixel[][] pixels = this.getPixels2D();
        for(int r = 0; r<pixels.length; r++){
            for(int c = 0; c<pixels[r].length; c++){
                pixels[r][c].setRed(0);
                pixels[r][c].setGreen(0);
            }
        }

    }

    public void negate(){
        Pixel[][] pixels = this.getPixels2D();
        for(int r = 0; r<pixels.length; r++){
            for(int c = 0; c<pixels[r].length; c++){
                pixels[r][c].setRed(255-(pixels[r][c].getRed()));
                pixels[r][c].setGreen(255-(pixels[r][c].getGreen()));
                pixels[r][c].setBlue(255-(pixels[r][c].getBlue()));
            }
        }

    }

    public void greyscale(){
        Pixel[][] pixels = this.getPixels2D();

        int colorAvg; 
        for(int r = 0; r<pixels.length; r++){
            for(int c = 0; c<pixels[r].length; c++){

                colorAvg = (pixels[r][c].getRed() + pixels[r][c].getGreen() + pixels[r][c].getBlue())/3;
                pixels[r][c].setRed(colorAvg);
                pixels[r][c].setGreen(colorAvg);
                pixels[r][c].setBlue(colorAvg);
            }
        } 
    }

    public void fixUnderwater(){
        Pixel[][] pixels = this.getPixels2D();

        int blueMid  = 155;
        int greenMid = 165;
        int redMid = 155;

        for(int r = 0; r<pixels.length; r++){
            for(int c = 0; c<pixels[r].length; c++){
                if(pixels[r][c].getBlue() > blueMid){
                    pixels[r][c].setBlue(255);
                } else if(pixels[r][c].getBlue()<blueMid){
                    pixels[r][c].setBlue(0);
                }

                if(pixels[r][c].getGreen() > greenMid){
                    pixels[r][c].setGreen(255);
                } else if(pixels[r][c].getGreen()<greenMid){
                    pixels[r][c].setGreen(0);
                }

                if(pixels[r][c].getRed() > redMid){
                    pixels[r][c].setRed(255);
                } else if(pixels[r][c].getRed()<redMid){
                    pixels[r][c].setRed(0);
                }

            }
        } 
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    //partial mirror vertical
    public void mirrorVertical(int startRow, int endRow, int startCol, int endCol)
    {
        int mirror = (startCol+endCol)/2; //middle of the columns
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows from start to end
        for (int row = startRow; row < endRow; row++)
        {
            // loop from start column to the midpoint
            for (int col = startCol; col < mirror; col++)
            {

                leftPixel = pixels[row][col];      
                rightPixel = pixels[row][mirror - col + mirror];
                rightPixel.setColor(leftPixel.getColor());

            }

        }
    }

    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        } 
    }

    public void mirrorHorizontal(){
        Pixel[][] pixels = this.getPixels2D();     
        Pixel topPixel = null;     
        Pixel bottomPixel = null;     
        int height = pixels.length;     
        for(int r = 0; r < height/2; r++){
            for(int c = 0; c < pixels[0].length; c++){
                topPixel = pixels[r][c];         
                bottomPixel = pixels[height-1-r][c];         
                bottomPixel.setColor(topPixel.getColor());       
            }     
        }     
    }

    //method to mirror picture horizontally from bottom to top
    public void mirrorHorizontalBotToTop(){
        Pixel[][] pixels = this.getPixels2D();     
        Pixel topPixel = null;     
        Pixel bottomPixel = null;     
        int height = pixels.length;     
        for(int r = height-1; r >=height/2; r--){
            for(int c = 0; c < pixels[0].length; c++){
                bottomPixel = pixels[r][c];         
                topPixel = pixels[height-1-r][c];         
                topPixel.setColor(bottomPixel.getColor());       
            }     
        }     
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {

                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());

                count++;
            }
        }

        System.out.print(count);

    }

    //mirror snowman arms
    public void mirrorArms(){
        int mirrorPoint = 190;
        int mirrorPoint2 = 195;

        Pixel[][] pixels = this.getPixels2D(); 

        Pixel topPixel = null;     
        Pixel bottomPixel = null;  

        for(int r = 158; r<mirrorPoint; r++){
            for(int c = 105; c < 170; c++){
                bottomPixel = pixels[mirrorPoint - r + mirrorPoint][c];         
                topPixel = pixels[r][c];         
                bottomPixel.setColor(topPixel.getColor());       
            }     
        }

        for(int r = 170; r<mirrorPoint2; r++){
            for(int c = 235; c < 293; c++){
                bottomPixel = pixels[mirrorPoint - r + mirrorPoint][c];         
                topPixel = pixels[r][c];         
                bottomPixel.setColor(topPixel.getColor());       
            }     
        }
    }

    public void mirrorGull(){
        int mirrorPoint = 343;     
        Pixel leftPixel = null;     
        Pixel rightPixel = null;    
        Pixel[][] pixels = this.getPixels2D();

        for (int row = 88; row < 324; row++)     {           
            for (int col = 239; col < mirrorPoint; col++)       {                  
                leftPixel = pixels[row][col];               
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];         
                rightPixel.setColor(leftPixel.getColor());      
            }
        } 
    }

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    //working
    public void copy(Picture fromPic, 
    int startRow, int startCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();

        for (int fromRow = 0, toRow = startRow; 
        fromRow < fromPixels.length &&
        toRow < toPixels.length; 
        fromRow++, toRow++)
        {
            for (int fromCol = 0, toCol = startCol; 
            fromCol < fromPixels[0].length &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    //second copy method that allows copying just one part of the fromPic

    public void copy(Picture fromPic, Picture toPic,
    int toStartRow, int fromStartRow, int fromEndRow,
    int toStartCol, int fromStartCol, int fromEndCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = toPic.getPixels2D(); //copy to parameter
        Pixel[][] fromPixels = fromPic.getPixels2D(); //copy from parameter
        for (int fromRow = fromStartRow, toRow = toStartRow; //increments the rows of the from pic and the to pic from start to finish
        fromRow < fromEndRow &&
        toRow < toPixels.length; //the entire toPixels array represents pat of the fromPixels array
        fromRow++, toRow++)
        {
            for (int fromCol = fromStartCol, toCol = toStartCol; //
            fromCol < fromEndCol &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];

                toPixel = toPixels[toRow][toCol];

                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    /** Method to create a collage of several pictures */
    public void createCollage()
    {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1,0,0);
        this.copy(flower2,100,0);
        this.copy(flower1,200,0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue,300,0);
        this.copy(flower1,400,0);
        this.copy(flower2,500,0);
        this.mirrorVertical();
        this.write("collage.jpg");
    }

    public void myCollage(Picture fromPic, Picture toPic){
        //Picture fromPic, Picture toPic, int toStartRow, int fromStartRow, int fromEndRow, int toStartCol, int fromStartCol, int fromEndCol
        copy(fromPic, toPic, 100, 0, 100, 0, 0, 200);

        fromPic.greyscale();

        //Picture fromPic, Picture toPic, int toStartRow, int fromStartRow, int fromEndRow, int toStartCol, int fromStartCol, int fromEndCol
        copy(fromPic, toPic, 100, 0, 100, 0, 0, 200);

        fromPic.zeroBlue();

        //int startRow, int endRow, int startCol, int endCol
        toPic.mirrorVertical(0, 100, 0, 150);

        copy(fromPic, toPic, 100, 0, 100, 0, 0, 200);
    }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    //compares pixels from left to right
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        // Pixel topPixel = null;
        // Pixel bottomPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        // Color bottomColor = null;

        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    //compares pixels from top to bottom
    public void edgeDetection2(int edgeDist)
    {
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color bottomColor = null;

        for (int row = 0; row < pixels.length-1; row++)
        {
            for (int col = 0; col < pixels[0].length-1; col++){

                topPixel = pixels[row][col];
                bottomPixel = pixels[row+1][col];
                bottomColor = bottomPixel.getColor();

                if (topPixel.colorDistance(bottomColor) > edgeDist){

                    topPixel.setColor(Color.BLACK);

                } else {
                    topPixel.setColor(Color.WHITE);
                }
            }
        }
    }

    //shows large color changes both horizontally and vertically
    public void edgeDetection3(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel nextPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color nextColor = null;

        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                if (col < pixels[row].length - 1) {
                    leftPixel = pixels[row][col];
                    nextPixel = pixels[row][col + 1];
                    nextColor = nextPixel.getColor();
                    if (leftPixel.colorDistance(nextColor) > edgeDist) {
                        leftPixel.setColor(Color.BLACK);
                        continue;
                    }
                }
                if (row < pixels.length - 1) {
                    nextPixel = pixels[row+1][col];
                    nextColor = nextPixel.getColor();
                    if (leftPixel.colorDistance(nextColor) > edgeDist) {
                        leftPixel.setColor(Color.BLACK);
                        continue;
                    }
                }
                leftPixel.setColor(Color.WHITE);
            }
        }
    }
    //edgeDetection with CoLoR
    public void edgeDetectionColor(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel nextPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color nextColor = null;

        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                if (col < pixels[row].length - 1) {
                    leftPixel = pixels[row][col];
                    nextPixel = pixels[row][col + 1];
                    nextColor = nextPixel.getColor();
                    if (leftPixel.colorDistance(nextColor) > edgeDist) {
                        leftPixel.setRed(50);
                        leftPixel.setGreen(168);
                        leftPixel.setBlue(82);
                        continue;
                    }
                }
                if (row < pixels.length - 1) {
                    nextPixel = pixels[row+1][col];
                    nextColor = nextPixel.getColor();
                    if (leftPixel.colorDistance(nextColor) > edgeDist) {
                        leftPixel.setRed(50);
                        leftPixel.setGreen(164);
                        leftPixel.setBlue(168);
                        continue;
                    }
                }
                leftPixel.setRed(84);
                leftPixel.setGreen(37);
                leftPixel.setBlue(89);
            }
        }
    }

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) 
    {
        // Picture beach = new Picture("beach.jpg");
        // beach.explore();
        // beach.zeroBlue();
        // beach.explore();

        Picture water = new Picture("water.jpg");

        water.explore();
    }

} // this } is the end of class Picture, put all new methods before this
