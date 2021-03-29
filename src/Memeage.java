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
 * This class takes in a file of an image and provides the mutator to change some of the pixels of 
 * the image, and the getter to read hidden information from the image.
 * 
 * @author Weihang Guo
 */
public class Memeage extends Image {

  /**
   * Constructor of the Memeage which stores an image into separate color elements.
   * @param file image file to be loaded
   * @throws IOException is thrown when there is trouble reading data from the specified file
   */
  public Memeage(File file) throws IOException {
    super(file);
  }
  
  
  /**
   * @param file image file to be loaded
   * @param meme a line of String to be encoded into the image
   * @throws IOException is thrown when there is trouble reading data from the specified file
   * @throws IllegalArgumentException is thrown 1) when the number of characters in the String
   * meme is greater than or equal to the number of Colors/pixel locations within the image, and 
   * 2) when any character within the meme message has a character code that is greater than 127
   */
  public Memeage(File file, String meme) throws IOException, IllegalArgumentException {
    super(file);
    setMeme(meme);
  }
  
  /**
   * Hide the input meme into the provided image. Each character of the meme is stored in one pixel
   * of the image.
   * @param meme a line of String to be hidden in the image
   * @throws IllegalArgumentException is thrown 1) when the number of characters in the String
   * meme is greater than or equal to the number of Colors/pixel locations within the image, and 
   * 2) when any character within the meme message has a character code that is greater than 127
   */
  public void setMeme(String meme) throws IllegalArgumentException {
    if (meme.length() >= getWidth() * getHeight())
      throw new IllegalArgumentException("This meme is too long.");
    //throw IllegalArgumentException with a descriptive message when the number of characters in 
    //the String meme is greater than or equal to the number of pixel locations within the image.
    for (int i = 0; i < meme.length(); i ++) {
      if (meme.toCharArray()[i] > 127) {
        throw new IllegalArgumentException("This meme contains illegal character.");
        //Read every single character within the String meme and when there is a character has a 
        //code that is greater than 127, throw IllegalArgumentException with a descriptive message.
      }
    }
    for (int i = 0; i < getHeight(); i ++) {
      for(int j = 0; j < getWidth(); j ++ ) {
        if (getHeight() * i + j < meme.length()) {
          //ensure the color's position has a character to hide
          setColor(j, i, new ColorPlusChar(getColor(j, i), 
              meme.toCharArray()[getHeight() * i + j]));
          //Set the Color in the i, j position of the image to hide the corresponding character.
        }
        if (getHeight() * i + j == meme.length()) {
          setColor(j, i , new ColorPlusChar(getColor(j, i), '\0'));
          //when all of the characters in the string has been hidden in a pixel respectively, hide 
          //the ending sign of '\0' in the next pixel to mark the end of the meme.
        }
      }
    }
  }
  
  /**
   * Get the hidden meme from the given image. 
   * @return the String meme
   * @throws IllegalStateException is thrown when 1) a character with a character code that is 
   * greater than 127 is extracted from a Color within the memeage, or 2) none of the characters 
   * extracted from this image contain the null character that should exist to mark the end of the 
   * meme message: '\0'. 
   */
  public String getMeme() throws IllegalStateException{
    String meme = "";//stores the meme hidden in the image. 
    for (int i = 0; i < getHeight(); i ++) {
      for (int j = 0; j < getWidth(); j ++) {
        if (new ColorPlusChar(getColor(j, i)).revealChar() != '\0') {
          //Keep reading the binary number from each pixel when there is no ending sign.
          if (new ColorPlusChar(getColor(j, i)).revealChar() > 127) {
            throw new IllegalStateException("There is an illegal character.");
            //throw IllegalStateException when a character's code is greater than 127 with a 
            //descriptive message.
          }
          meme =  meme + new ColorPlusChar(getColor(j, i)).revealChar();
          //When there is no ending sign, add the one character retrieved from the pixel to meme.
        }
        else {
          return meme;//When there is a ending sign, return the whole meme String.
        }
      }
    }
    throw new IllegalStateException("There is no ending sign.");
    //When none of the pixels in the image contains an ending sign, throw new IllegalStateException.
  }
}
