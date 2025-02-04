package csc223.ec;
public class DNA {

    public static String countNucleotides(String dna) {
        // create array for storing count
        int[] dNArray = new int[4];
        // dNArray[0] = # of A's, dNArray[1] = # of C's, dNArray[2] = # of G's
        //dNArray[3] = # of T's

        //loop through all characters of the string and count for each charcter
        for (int i=0;i<dna.length();i++) {
            char character = dna.charAt(i);
            if (character == 'A') {
                dNArray[0]++;
            }

            else if (character == 'C') {
                dNArray[1]++;
            }

            else if (character == 'G') {
                dNArray[2]++;
            }

            else if (character == 'T') {
                dNArray[3]++;
            }
        }

        return (dNArray[0] + " " + dNArray[1] + " " + dNArray[2] + " " + dNArray[3]);
    }

    public static String transcribe(String dna) {
        //create new string for replacing Us
        String dNAUs = new String(); 
        //Loop and check for U's
        for (int i=0;i<dna.length();i++) {
            char character = dna.charAt(i);
            if (character == 'T') {
                dNAUs += "U";
            }

            else {
                dNAUs += character;
            }
        }

        return dNAUs;
    }

    public static String reverseComplement(String dna) {
        //Reverse the given dna and create a new string to store new letters
        String reversedDNA = "";

        for (int i = dna.length()-1; i>= 0; i--) {
            reversedDNA += dna.charAt(i);
        }

        String newDna = new String();

        //Loop through dna and check for pair of each letter
        for (int i=0;i<dna.length();i++) {
            char character = reversedDNA.charAt(i);
            if (character == 'A') {
                newDna += "T";
            }

            else if (character == 'C') {
                newDna += 'G';
            }

            else if (character == 'G') {
                newDna += "C";
            }

            else if (character == 'T') {
                newDna += "A";
            }
        }

        return newDna;

    }
}