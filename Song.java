// William Greiner & Jason Wild
// 9/27/21
// CS 141
// Lab #1

// This program will display 7 verses from the cumulative, 
// song, "There Was An Old Lady Who Swallowed a Fly".

public class Song {
   
   public static void main(String[] args) {
      System.out.println("There was an old woman who swallowed a fly.");
      fly();
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      spider();
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      bird();
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      cat();
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      dog();
      bear();
      horse();
   }
   
   // Displays the second half of the first verse on the screen
   public static void fly() {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
      System.out.println();
   }
   
   
   // Displays a new line about swallowing a spider, then displays everything in the fly method
   public static void spider() {
      System.out.println("She swallowed the spider to catch the fly,");
      fly();
   }
   
   // Displays a new line about swallowing a bird, then displays everything in the spider method
   public static void bird() {
      System.out.println("She swallowed the bird to catch the spider,");
      spider();
   }
   
   // Displays a new line about swallowing a cat, then displays everything in the bird method 
   public static void cat() {
      System.out.println("She swallowed the cat to catch the bird,");
      bird();
   }
   
   // Displays a new line about swallowing a dog, then displays everything in the cat method
   public static void dog() {
      System.out.println("She swallowed the dog to catch the cat,");
      cat();
   }
   
   // Displays a new line about swallowing a panther, then displays everything in the dog method
   public static void bear() {
      System.out.println("There was an old woman who swallowed a bear,");
      System.out.println("Not sure how she fit it in there!");
      System.out.println("She swallowed the bear to catch the dog,");
      dog();
   }
   
   // Displays the seventh and final verse of the song
   public static void horse() {
      System.out.println("There was an old lady who swallowed a horse,");
      System.out.println("She died of course.");
   }
}