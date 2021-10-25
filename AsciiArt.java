// William Greiner & Jason Wild
// 10/6/21
// CS 141
// Lab #2 part 1

public class AsciiArt {

//  This program outputs a gorgeous ASCII plus sign of any size on your screen. 

  public static final int SIZE = 3;

  public static void main (String[] args) {

    plusTop();
    plusBody();
    plusBottom();
    
  }

//  This builds the top spoke of the plus sign.

  public static void plusTop() {

    for(int j = 1; j <= (2 * SIZE + 3); j++) {
      System.out.print(" ");
    }
    System.out.print("+");
    for(int j = 1; j <= (2 * SIZE + 2); j++) {
      System.out.print("=");
    }
    System.out.println("+");
    for (int i = 1; i <= SIZE; i++) {

      for(int j = 1; j <= (2 * SIZE + 3); j++) {
        System.out.print(" ");
      }
      System.out.print("|");
      for(int j = 1; j <= (2 * SIZE + 2); j++) {
        System.out.print(" ");
      }
      System.out.println("|");
      }
  }

//   This method builds the body/ side spokes of the plus sign.

  public static void plusBody() {

//    Top bars

    System.out.print("+");
    for(int j = 1; j <= (2 * SIZE +2); j++) {
      System.out.print("=");
    }
    System.out.print("+");

    for(int j =1; j <= (2 * SIZE + 2); j++) {
      System.out.print(" ");
    }

    System.out.print("+");
    for(int j = 1; j <= (2 * SIZE +2); j++) {
      System.out.print("=");
    }
    System.out.println("+");

//    Side walls

    for (int i = 1; i <= SIZE; i++) {

      System.out.print("|");
      for(int j =1; j <= (6 * SIZE + 8); j++) {
        System.out.print(" ");
      }
      System.out.println("|");
    }

//     Bottom bars

    System.out.print("+");
    for(int j = 1; j <= (2 * SIZE +2); j++) {
      System.out.print("=");
    }
    System.out.print("+");

    for(int j =1; j <= (2 * SIZE + 2); j++) {
      System.out.print(" ");
    }

    System.out.print("+");
    for(int j = 1; j <= (2 * SIZE +2); j++) {
      System.out.print("=");
    }
    System.out.println("+");

  }

//  This makes the bottom spoke of the plus

  public static void plusBottom() {

    for (int i = 1; i <= SIZE; i++) {

      for(int j =1; j <= (2 * SIZE + 3); j++) {
        System.out.print(" ");
      }
      System.out.print("|");
      for(int j =1; j <= (2 * SIZE + 2); j++) {
        System.out.print(" ");
      }
      System.out.println("|");
    }

    for(int j =1; j <= (2 * SIZE + 3); j++) {
      System.out.print(" ");
    }
    System.out.print("+");
    for(int j = 1; j <= (2 * SIZE +2); j++) {
      System.out.print("=");
    }
    System.out.println("+\n");

//    This tells the user what they have created

    System.out.println("BEHOLD, your PLUS SIGN of size " + SIZE + "!");
  }

}

