package countingLetter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class countingLetter {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("./doc.txt"))) {
            String line;
            String[] letters = new String[26];
            
            char bestLetter = ' ';
            int countLetter = 0;


            while ((line = reader.readLine()) != null) {
                for(char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        c = Character.toLowerCase(c);
                        int index = c - 'a';
                        // Ensure the index is within the bounds of the alphabet (0 to 25)
                        if (index >= 0 && index < 26) {
                            // If the corresponding index in the letters array is null, initialize it as an empty string
                            if (letters[index] == null) {
                                letters[index] = "";
                            }

                            letters[index] += c;

                            // Count the occurrences of the letter
                            int count = letters[index].length();
                            if (count > countLetter) {
                                countLetter = count;
                                bestLetter = c;
                            }
                            
                         
                        }
                    }


                }
            }
            System.out.println("La lettre la plus fréquente est : " + bestLetter + " avec " + countLetter + " occurrences.");

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
    
}
