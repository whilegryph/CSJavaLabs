// William Greiner & Jason Wild
// 10/6/21
// CS 141
// Lab #2 part B

public class DrawRocket {

// This program will produce rocket ships of any size. 
// It does not include launch functionality.

    public static final int SIZE = 5;
    public static void main(String[] args) {
        rocketCone();
        divider();
        bodyUp();
        bodyDown();
        divider();
        bodyDown();
        bodyUp();
        divider();
        rocketCone();
    }
// This method produces the cone shape at the top and bottom of the rocket.
    public static void rocketCone() {
        for(int i = 1; i <= (2* SIZE -1); i++ ) {
            for (int j = 1; j <= (2 * SIZE- i); j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++) {
                System.out.print("/");
            }
            System.out.print("**");
            for(int j = 1; j <= i; j++) {
                System.out.print("\\");
            }
            System.out.println();
        }
    }
// This method produces the dividing lines of variable length that separate
// the rocket components.
    public static void divider() {
        System.out.print("+");
        for(int i = 1; i <= (2 * SIZE); i++) {
            System.out.print("=*");
        }
        System.out.println("+");
    }
// This method produces the body components where the /\ face upwards.
    public static void bodyUp() {
        for(int i = 1; i <= SIZE; i++) {
            System.out.print("|");
            for (int j = 1; j <= 2; j++) {
               for(int k = 1; k <= (SIZE - i); k++) {
                  System.out.print(".");
               }
               for(int l = 1; l <= i; l++) {
                  System.out.print("/\\");
               }
               for(int m = 1; m <= (SIZE - i); m++) {
                  System.out.print(".");
               }
            }
            System.out.println("|");
        }
    }
// This method produces the body components where the \/ face downwards.
    public static void bodyDown() {
        for(int i = 1; i <= SIZE; i++) {
            System.out.print("|");
            for (int j = 1; j <= 2; j++) {
               for (int k = 1; k <= (i - 1); k++) {
                  System.out.print(".");
               }
               for (int l = 1; l <= (SIZE + 1 - i); l++) {
                  System.out.print("\\/");
               }
               for (int m = 1; m <= (i - 1); m++) {
                  System.out.print(".");
               }
            }
            System.out.println("|");
        }
    }
}