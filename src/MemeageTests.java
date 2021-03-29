//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P05 Memeage 5000
// Files:           Color.java, ColorPlusChar.java, Memeage.java, MemeageTests.java
// Course:          CS300, fall, 2019
//
// Author:          Weihang Guo
// percentage:           wguo63@wisc.edu
// Lecturer's Name: Mouna Kacem
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Milks: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.io.File;
import java.io.IOException;

/**
 * This class tests different methods in the FourBytes, Color, ColorPlusChar and Memeage class.
 * 
 * @author Weihang Guo
 */
public class MemeageTests {
  
  /**
   * Test the getBits method in FourBytes class. 
   * @return true when the method runs correctly, false otherwise.
   */
  public static boolean testFourBytesGetBits() {
    FourBytes test = new FourBytes(13312);
    if (test.getBits(4,10) == 13) {
      return true;
    }
    return false;
    
  }
  
  /**
   * Test the setBits method in FourBytes class. 
   * @return true when the method runs correctly, false otherwise.
   */
  public static boolean testFourBytesSetBits() {
    FourBytes test = new FourBytes(0);
    test.setBits(3, 8, 13);
    if (test.getInt() == 1280) {
      return true;
    }
    return false;
  }
  
  /**
   * Test the constructor, setters and mutators of Color class. 
   * @return true when the method runs correctly, false otherwise.
   */
  public static boolean testColor() {
    Color test1 =  new Color(1200);//Construct a Color class using one single integer as input.
    Color test2 = new Color(100, 150, 250, 200);//Construct a Color class with the separate values
    //of argb.
    if (test1.getBlue() != 176)//test the getBlue method.
      return false;
    test1.setGreen(56);
    if (test1.getGreen() != 56)//test the setGreen and get Green method
      return false;
    if (test2.getAlpha() != 100)
      return false;
    test2.setRed(23);
    if (test2.getRed() != 23)//test the getRed and setRed method
      return false;
    return true;
    
  }
  
  /**
   * Test the getters in the Image class. 
   * @return true when the method runs correctly, false otherwise.
   */
  public static boolean testImage() {
    try {
      Image testImage = new Image(new File("testImage.png"));
      //Create a new Image with an existing and valid file.
      if (testImage.getHeight() != 3) 
        return false;
      if (testImage.getWidth() != 3) 
        return false;
      if (testImage.getColor(1, 1).getBlue() != 255)
        return false;
      if (testImage.getColor(1, 1).getGreen() != 255)
        return false;
      if (testImage.getColor(1, 1).getRed() != 0)
        return false;
      return true;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }
  
  /**
   * Test the hidCar and revealChar methods in ColorPlusChar class. 
   * @return true when the method runs correctly, false otherwise.
   */
  public static boolean testColorPlusChar() {
    Color color = new Color(40, 60, 100, 150);//Create a Color class. 
    ColorPlusChar test1 = new ColorPlusChar(color, 'O');
    //Construct a ColorPlusChar class with the original color and a character 'O' to hide.
    ColorPlusChar test2 = new ColorPlusChar(color);
    //Construct a ColorPlusChar with a existing Color.
    if (test1.revealChar() != 'O')
      return false;
    test2.hideChar('X');//Hide the character 'X' in test2.
    if (test2.revealChar() != 'X')
      return false;
    return true;
  }
  
  /**
   * Test the setMeme and getMeme method in Memeage class. Print out the meme hidden in each image.
   */
  public static void testMemeage() {
    try {
      //Create three Memeages with a single file as input.
      Memeage test1 = new Memeage(new File("image01.png"));
      Memeage test2 = new Memeage(new File("image02.png"));
      Memeage test3 = new Memeage(new File("image03.png"));
      //Create a Memeage with an original image and a meme to hide as input.
      Memeage test4 = new Memeage(new File("image03.png"), "This is a meme.");
      System.out.println(test1.getMeme());
      System.out.println(test2.getMeme());
      System.out.println(test3.getMeme());
      System.out.println(test4.getMeme());
      test4.setMeme("This is a new meme.");//Hide a new meme in Memeage test4.
      System.out.println(test4.getMeme());
    } catch (IllegalStateException e) {
      System.out.println(e.getMessage());
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
  }
  
  
  /**
   * Print out the results of each test methods.
   * @param args input arguments
   */
  public static void main(String[] args) {
    System.out.println(testFourBytesGetBits() + " " + testFourBytesSetBits() + " " +
        testColor() + " " + testImage() + " " + testColorPlusChar());
    testMemeage();

  }

}
