package com.company;

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
    beach.write("D:\\Shared\\GitHub\\java-projects\\PicLab\\images\\altered\\beach.jpg");
  }

  public static void keepOnlyBlue(){
    Picture water = new Picture("water.jpg");
    water.explore();
    water.keepOnlyBlue();
    water.explore();
    water.write("D:\\Shared\\GitHub\\java-projects\\PicLab\\images\\altered\\water.jpg");
  }

  public static void negate(){
    Picture water = new Picture("butterfly1.jpg");
    water.explore();
    water.negate();
    water.explore();
    water.write("D:\\Shared\\GitHub\\java-projects\\PicLab\\images\\altered\\butterfly1.jpg");
  }

  public static void grayscale(){
    Picture water = new Picture("flower1.jpg");
    water.explore();
    water.grayscale();
    water.explore();
    water.write("D:\\Shared\\GitHub\\java-projects\\PicLab\\images\\altered\\flower1.jpg");
  }

  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
    caterpillar.write("D:\\Shared\\GitHub\\java-projects\\PicLab\\images\\altered\\caterpillarVertical.jpg");
  }

  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
    caterpillar.write("D:\\Shared\\GitHub\\java-projects\\PicLab\\images\\altered\\caterpillarVerticalRightToLeft.jpg");
  }

  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("redMotorcycle.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
    caterpillar.write("D:\\Shared\\GitHub\\java-projects\\PicLab\\images\\altered\\redMotorcycleHorizontal.jpg");
  }

  public static void testMirrorHorizontalBotToTop()
  {
    Picture caterpillar = new Picture("redMotorcycle.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBotToTop();
    caterpillar.explore();
    caterpillar.write("D:\\Shared\\GitHub\\java-projects\\PicLab\\images\\altered\\redMotorcycleHorizontalButTop.jpg");
  }

  public static void testMirrorDiagonal()
  {
    Picture caterpillar = new Picture("beach.jpg");
    caterpillar.explore();
    caterpillar.mirrorDiagonal();
    caterpillar.explore();
    caterpillar.write("D:\\Shared\\GitHub\\java-projects\\PicLab\\images\\altered\\beachDiagonal.jpg");
  }

  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
    temple.write("D:\\Shared\\GitHub\\java-projects\\PicLab\\images\\altered\\temple.jpg");
  }

  public static void testMirrorArms()
  {
    Picture temple = new Picture("snowman.jpg");
    temple.explore();
    temple.mirrorArms();
    temple.explore();
    temple.write("D:\\Shared\\GitHub\\java-projects\\PicLab\\images\\altered\\snowman.jpg");
  }

  public static void testMirrorGull()
  {
    Picture temple = new Picture("seagull.jpg");
    temple.explore();
    temple.mirrorGull();
    temple.explore();
    temple.write("D:\\Shared\\GitHub\\java-projects\\PicLab\\images\\altered\\seagull.jpg");
  }


  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
    canvas.write("D:\\Shared\\GitHub\\java-projects\\PicLab\\images\\altered\\collage.jpg");
  }

  public static void testMyCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.myCollage();
    canvas.explore();
    canvas.write("D:\\Shared\\GitHub\\java-projects\\PicLab\\images\\altered\\myCollage.jpg");
  }

  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
    swan.write("D:\\Shared\\GitHub\\java-projects\\PicLab\\images\\altered\\swan.jpg");
  }

  /** Main method for testing.  Every class can have a main
   * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    testZeroBlue();
    keepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    negate();
    grayscale();
    //testFixUnderwater();
    testMirrorVertical();
    testMirrorVerticalRightToLeft();
    testMirrorHorizontal();
    testMirrorHorizontalBotToTop();
    testMirrorDiagonal();
    testMirrorTemple();
    testMirrorArms();
    testMirrorGull();
    testCollage();
    testMyCollage();
    //testCopy();
    testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}