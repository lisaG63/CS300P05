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
 * This class stores a ColorPlusChar which extends the Color class in four bytes of data, and 
 * provides both accessor and mutator methods to hide and reveal a single character. 
 * 
 * @author Weihang Guo
 */
public class ColorPlusChar extends Color{
  
  /**
   * Constructor of the ColorPlusChar which initializes a color with a hidden character
   * @param color the original Color
   * @param character the character to hiden 
   */
  public ColorPlusChar(Color color, char character) {
    super(color.getARGB());//call the constructor of the super class Color.
    hideChar(character);//call the hideChar method to hide the input character.
  }
  
  /**
   * Constructor of the ColorPlusChar which copies from another Color
   * @param color the original Color
   */
  public ColorPlusChar(Color color) {
    super(color.getARGB());
  }
  
  /**
   * Stores 8-bit character within the least significant bits of color components.
   * @param character the character to hiden
   */
  public void hideChar(char character) {
    Color meme = new Color(character);//Create a new Color which takes character as its value.
    setBits(2, 24, meme.getBits(2, 6));
    //Set the last two digits of the Alpha part to be the first two digits of the character.
    setBits(2, 16, meme.getBits(2, 4));
    //Set the last two digits of the Red part to be the third and fourth digits of the character.
    setBits(2, 8, meme.getBits(2, 2));
    //Set the last two digits of the Green part to be the fifth and sixth digits of the character.
    setBits(2, 0, meme.getBits(2, 0));
    //Set the last two digits of the Blue part to be the last two digits of the character.
  }

  /**
   * Retrieves 8-bit character from the least significant bits of color components.
   * @return the character hidden in the Color.
   */
  public char revealChar() {
    Color meme = new Color(0);//Create a new Color to store the character.
    //Set the first eight digits of the Color meme to each of the last two digits of Alpha, Red, 
    //Green and Blue.
    meme.setBits(2, 6, getAlpha());
    meme.setBits(2, 4, getRed());
    meme.setBits(2, 2, getGreen());
    meme.setBits(2, 0, getBlue());
    return meme.getChar();
  }
  

}
