package classes;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
    /** Method to test zeroBlue */
    public static void testZeroBlue()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

    /** Method to test mirrorVertical */
    public static void testMirrorVertical()
    {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }

    /** Method to test mirrorTemple */
    public static void testMirrorTemple()
    {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }

    public static void testMirrorArms()
    {
        Picture snowman = new Picture("snowman.jpg");
        snowman.explore();
        snowman.mirrorArms();
        snowman.explore();
    }

    public static void testMirrorGull()
    {
        Picture seagull = new Picture("seagull.jpg");
        seagull.explore();
        seagull.mirrorGull();
        seagull.explore();
    }

    /** Method to test the collage method */
    public static void testCollage()
    {
        Picture canvas = new Picture("640x480.jpg");
        canvas.createCollage();
        canvas.explore();
    }

    /** Method to test edgeDetection */
    public static void testEdgeDetection()
    {
        Picture swan = new Picture("swan.jpg");
        swan.edgeDetection(10);
        swan.explore();
    }
    
    public static void testEdgeDetection2()
    {
        Picture swan = new Picture("swan.jpg");
        swan.edgeDetection2(10);
        swan.explore();
    }
    
    public static void testEdgeDetection3()
    {
        Picture swan = new Picture("swan.jpg");
        swan.edgeDetection2(10);
        swan.explore();
    }
    public static void testEdgeDetectionColor()
    {
        Picture swan = new Picture("me.jpg");
        swan.edgeDetectionColor(10);
        swan.explore();
    }

    public static void testKeepOnlyBlue(){
        Picture beach = new Picture("beach.jpg");

        beach.keepOnlyBlue();

        beach.explore();
    }

    public static void testNegate(){
        Picture beach = new Picture("beach.jpg");

        beach.negate();

        beach.explore();
    }

    public static void testGrayscale(){
        Picture beach = new Picture("beach.jpg");

        beach.greyscale();

        beach.explore();
    }

    public static void testFixUnderwater(){
        Picture water = new Picture("water.jpg");

        water.fixUnderwater();

        water.explore();
    }

    public static void testMirrorVerticalRightToLeft(){
        Picture beach = new Picture("beach.jpg");

        beach.mirrorVerticalRightToLeft();

        beach.explore();
    }

    public static void testMirrorHorizontal(){
        Picture beach = new Picture("beach.jpg");

        beach.mirrorHorizontal();

        beach.explore();
    }

    public static void testMirrorHorizontalBotToTop(){
        Picture beach = new Picture("beach.jpg");

        beach.mirrorHorizontalBotToTop();

        beach.explore();
    }
    //test original coy method
    public static void testCopy(){
        Picture beach = new Picture("beach.jpg");

        beach.copy(beach, 400, 400);

        beach.explore();
    }
    
    //test second copy method
    
    //Picture fromPic, Picture toPic, int toStartRow, int fromStartRow, int fromEndRow, int toStartCol, int fromStartCol, int fromEndCol
    
    //works
    
    public static void testCopy2(){
        Picture beach = new Picture("beach.jpg");

        beach.copy(beach, beach, 100, 0, 100, 0, 0, 200);

        beach.explore();
    }
    
    //works
    
    public static void testMyCollage(){
        Picture beach = new Picture("beach.jpg");

        beach.myCollage(beach, beach); 

        beach.explore();
    }

    /** Main method for testing.  Every class can have a main
     * method in Java */
    public static void main(String[] args)
    {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run
        //testZeroBlue();
        //testKeepOnlyBlue();
        //testKeepOnlyRed();
        //testKeepOnlyGreen();
        //testNegate();
        //testGrayscale();
        //testFixUnderwater();
        //testMirrorVertical();
        //testMirrorVerticalRightToLeft();
        //testMirrorTemple();
        //testMirrorArms();
        //testMirrorGull();
        //testMirrorDiagonal();
        //testCollage();
        //testCopy();
        //testCopy2();
        //testEdgeDetection();
        //testEdgeDetection2();
        //testEdgeDetection3();
        //testChromakey();
        //testEncodeAndDecode();
        //testGetCountRedOverValue(250);
        //testSetRedToHalfValueInTopHalf();
        //testClearBlueOverValue(200);
        //testGetAverageForColumn(0);
        //testMyCollage();
    }
}