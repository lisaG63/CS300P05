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

/**
 * This class stores a Color in four bytes of data, and provides
 * both accessor and mutator methods for changing certain value of the Color.
 * 
 * @author Weihang Guo
 */
public class Color extends FourBytes {
  
  /**
   * Constructor of Color class which takes in a single input
   * @param argb the value to set up the color
   */
  public Color(int argb) {
    super(argb);//call the constructor of the super class FourBytes
  }
  
  /**
   * Constructor of Color class which takes in the separate inputs of argb
   * @param alpha represent the transparency vs opacity
   * @param red represent the intensity of red
   * @param green represent the intensity of green
   * @param blue represent the intensity of blue color
   */
  public Color(int alpha, int red, int green, int blue) {
    super(0);//call the constructor of the super class FourBytes
    //Set the alpha and each base color to the input value
    setAlpha( alpha);
    setRed(red);
    setGreen(green);
    setBlue(blue);
  }
  
  
  /**
   * Constructor of Color class which directly copies another Color
   * @param other another Color type
   */
  public Color(Color other) {
    super(other.getInt());
  }
  
  
  /**
   * Get the value that is corresponding to the binary number represented by color.
   * @return the integer value of the Color
   */
  public int getARGB() {
    return getInt();
  }
  
  
  /**
   * Get the Alpha part of the Color.
   * @return the integer value corresponding to the binary number represented by the Alpha part.
   */
  public int getAlpha() {
    return getBits(8, 24);
  }
  
  /**
   * Get the Red part of the Color.
   * @return the integer value corresponding to the binary number represented by the Red part.
   */
  public int getRed() {
    return getBits(8, 16);
  }
  
  /**
   * Get the Green part of the Color.
   * @return the integer value corresponding to the binary number represented by the Green part.
   */
  public int getGreen() {
    return getBits(8, 8);
  }
  
  /**
   * Get the Blue part of the Color.
   * @return the integer value corresponding to the binary number represented by the Blue part.
   */
  public int getBlue() {
    return getBits(8, 0);
  }
  
  /**
   * Set the value of the total argb.
   * @param argb the total value of the color.
   */
  public void setARGB(int argb) {
    setInt(argb);
  }
  
  /**
   * Set the value of the Alpha part.
   * @param alpha the alpha value of the color.
   */
  public void setAlpha(int alpha) {
    setBits(8, 24, alpha);
  }
  
  /**
   * Set the value of the Red part.
   * @param red the Red value of the color.
   */
  public void setRed(int red) {
    setBits(8, 16, red);
  }
  
  /**
   * Set the value of the Green part.
   * @param green the Green value of the color.
   */
  public void setGreen(int green) {
    setBits(8, 8, green);
  }
  
  /**
   * Set the value of the Blue part.
   * @param blue the blue value of the color.
   */
  public void setBlue(int blue) {
    setBits(8, 0, blue);
  }

}
