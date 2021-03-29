
public class Test {

  public static void main(String[] args) {
    Color color = new Color(40, 60, 100, 150);
    ColorPlusChar test1 = new ColorPlusChar(color, 'O');
    ColorPlusChar test2 = new ColorPlusChar(color);
    char character = 'X';
    String bin = Integer.toBinaryString(character);
    String zeros = "";
    for(int i = 0; i < 8 - bin.length(); i ++) {
      zeros = zeros + "0";
    }
    String ascii = zeros + bin;
    System.out.println(ascii);
    int alpha = Integer.valueOf(ascii.substring(0, 2), 2);
    System.out.println(alpha);
    int red = Integer.valueOf(ascii.substring(2,4), 2);
    System.out.println(red);
    int green = Integer.valueOf(ascii.substring(4,6), 2);
    System.out.println(green);
    int blue = Integer.valueOf(ascii.substring(6,8), 2);
    System.out.println(blue);
    test2.setBits(2, 24, alpha);
    System.out.println(test2.getBits(2, 24));
    test2.setBits(2, 16, red);
    test2.setBits(2, 8, green);
    test2.setBits(2, 0, blue);

  }

}
