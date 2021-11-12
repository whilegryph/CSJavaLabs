// William G. Greiner & Morgan Kramer & Jason Wild
// 11/14/21
// CS 141
// LAB 5 - Mad Libs

import java.io.*;
import java.util.*;

// This program takes an empty mad libs story and plays it with the user.
public class MadLibs {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to the game of Mad Libs.\n" +
                "I will ask you to provide various words\n" +
                "and phrases to fill in a story.\n" +
                "The result will be written to an output file.\n");
        String response = " ";
        while (!response.equalsIgnoreCase("Q")) {
            Scanner user = new Scanner(System.in);
            System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
            response = user.next();
            if (response.equalsIgnoreCase("C")) {
                outputFile(user);
            } else if (response.equalsIgnoreCase("V")) {
                readFiles(user);
            }
        }
    }

    // Grabs an input file from the user, and checks if it exists
    public static File inputPrompt(Scanner user) {
        System.out.print("Input file name: ");
        File inputName = new File(user.next());
        while (!inputName.canRead()) {
            System.out.print("File not found. Try again: ");
            inputName = new File(user.next());
        }
        return inputName;
    }

    // Takes the names of the input and output files from the user.
    public static void readFiles(Scanner user) throws FileNotFoundException {
        File inputName = inputPrompt(user);
        Scanner read = new Scanner(inputName);
        System.out.println();
        while (read.hasNextLine()) {
            System.out.println(read.nextLine());
        }
        System.out.println();
    }

    // Finds the placeholders in a file, fills them with the user's input, then outputs it to a
    // different file.
    public static void outputFile(Scanner user) throws FileNotFoundException {
        File inputName = inputPrompt(user);
        System.out.print("Output file name: ");
        File outputName = new File(user.next());
        System.out.println();
        Scanner inputFile = new Scanner(inputName);
        PrintStream out = new PrintStream(outputName);
        while (inputFile.hasNextLine()) {
            String output = inputFile.nextLine();
            output = placeholders(output);
            out.println(output);
        }
        System.out.println("Your mad-lib has been created!\n");
    }

    // Identifies if a line in a file has a filler space in it, prompts the user to fill that space,
    // and returns the newly created line.
    public static String placeholders(String output) {
        if (output.contains("<") && output.contains(">")) {
            String filler = output.substring(output.indexOf("<") + 1, output.indexOf(">"));

            // Checks for a hyphen in a filler word and replaces it with a space
            if (filler.contains("-")) {
                filler = filler.replace("-", " ");
            }

            // Accommodates for cases where the filler word begins with a vowel
            if (filler.charAt(0) == 'a' || filler.charAt(0) == 'e' || filler.charAt(0) == 'i' ||
                    filler.charAt(0) == 'o' || filler.charAt(0) == 'u') {
                System.out.print("Please type an " + filler + ": ");
            } else {
                System.out.print("Please type a " + filler + ": ");
            }
            Scanner userFill = new Scanner(System.in);

            // Prompts the user to fill the filler word
            String filled = userFill.nextLine();

            // Changes the file line to include the filled space
            output = output.replace(output.substring(output.indexOf("<"), output.indexOf(">") + 1),
                    filled);
        }
        return output;
    }
}
