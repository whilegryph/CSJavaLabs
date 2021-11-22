// William Greiner, Jason Wild, Morgan Kramer
// 11/23/21
// CS 141
// Lab 6 - DNA

import java.util.*;
import java.io.*;

// This program reads an input file, processes its nucleotide sequences and outputs the mass percentage occupied by
// each nucleotide type, counts the occurrences of each of the 4 nucleotides, and outputs the amount of codons present
// in each sequence (as well sd whether the sequence is a protein-coding gene). Also outputs region name.
public class DNA {

    public static final double[] NUCL_MASS = {135.128, 111.103, 151.128, 125.107, 100.0}; /* A, C, G, T, -*/
    public static final int MIN_CODONS = 5;
    public static final int MIN_MASS_CG = 30;
    public static final int UNIQUE_NUCL = 4;
    public static final int NUCL_PER_CODON = 3;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner user = new Scanner(System.in);
        System.out.println("This program reports information about DNA" +
                        "nucleotide sequences that may encode proteins.\n");

        System.out.print("Input file name? ");
        Scanner inputRead = new Scanner(new File(user.next()));
        System.out.print("Output file name? ");
        File outputRead = new File(user.next());
        PrintStream out = new PrintStream(outputRead);

        String[] currentLines = new String[2];

        while (inputRead.hasNextLine()) {

            readFiles(inputRead, out, currentLines);
            nucleotideOutput(out, currentLines);
            out.println();

        }
    }

    // Reads the file and outputs everything to an output file.
    public static void nucleotideOutput(PrintStream out, String[] currentLines) {
        int[] nucleotides = new int[UNIQUE_NUCL];
        double[] mass = new double[UNIQUE_NUCL];
        String proteinYN = "NO";

        String[] zeCodons = new String[currentLines[1].length()/NUCL_PER_CODON];
        codonCalculator(currentLines[1], zeCodons);
        int garboge = nucleotideCounter(currentLines[1], nucleotides);
        double massTotal = massPercentage(mass, nucleotides, garboge);
        out.println("Nucleotides: " + currentLines[1].toUpperCase());
        out.println("Nuc. Counts: " + Arrays.toString(nucleotides));
        out.println("Total Mass%: " + Arrays.toString(mass) + " of " + massTotal);
        out.println("Codon List: " + Arrays.toString(zeCodons));
        boolean protein = proteinGeneCalculator(zeCodons, mass);
        if (protein) {
            proteinYN = "YES";
        }
        out.println("Is Protein? " + proteinYN);
    }

    public static void readFiles(Scanner input, PrintStream out, String[] currentLines) {
            String lineOne = input.nextLine();
            currentLines[0] = lineOne;
            out.println("Region Name: " + lineOne);
            if (input.hasNextLine()) {
                String lineTwo = input.nextLine();
                currentLines[1] = lineTwo;
            }
    }

    // Calculates how many codons are in a DNA sequence.
    public static void codonCalculator(String currentLine, String[] zeCodons) {
        for (int i = 0; i < currentLine.length()/NUCL_PER_CODON; i++) {
            zeCodons[i] = currentLine.toUpperCase().substring((i * NUCL_PER_CODON), (i * NUCL_PER_CODON) + NUCL_PER_CODON);
        }
    }

    // Calculates the mass percentage of each unique nucleotide in a DNA sequence as well as it's total mass.
    public static double massPercentage(double[] mass, int[] nucleotides, int garboge) {
        double massTotal = 0;

        for (int i = 0; i <= 3; i++) {
            mass[i] = nucleotides[i] * NUCL_MASS[i];
            massTotal += mass[i];
        }
        massTotal += garboge * 100.0;
        for (int i = 0; i <= 3; i++) {
            mass[i] = (mass[i]/massTotal)*100;
            mass[i] = Math.round(mass[i]*10.0)/10.0;
        }
        return Math.round(massTotal * 10.0)/10.0;
    }

    // Counts how many of each nucleotide are present in a nucleotide sequence.
    public static int nucleotideCounter(String currentLine, int[] nucleotides) {
        int garboge = 0;

        // used to have this as currentLine.length() + 1 with <=
        for (int i = 0; i < currentLine.length(); i++) {
            String caseCheck = currentLine.substring(i, i + 1);

            if (caseCheck.equalsIgnoreCase("A")) {
                nucleotides[0]++;
            } else if (caseCheck.equalsIgnoreCase("C")) {
                nucleotides[1]++;
            } else if (caseCheck.equalsIgnoreCase("G")) {
                nucleotides[2]++;
            } else if (caseCheck.equalsIgnoreCase("T")) {
                nucleotides[3]++;
            } else {
                garboge++;
            }
        }
        return garboge;
    }

    // Calculates if a DNA sequence is a protein.
    public static boolean proteinGeneCalculator(String[] zeCodons, double[] mass) {
        boolean protein = zeCodons.length >= MIN_CODONS && zeCodons[0].equals("ATG") && (zeCodons[zeCodons.length - 1].equals("TAA") ||
                (zeCodons[zeCodons.length - 1].equals("TAG") || (zeCodons[zeCodons.length - 1].equals("TGA"))));

        if (protein && !((mass[1] + mass[2]) > MIN_MASS_CG)) {
            protein = false;
        }

        return protein;
    }
}
