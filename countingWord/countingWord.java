package countingWord;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class countingWord {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./doc.txt"));
            String line;
            
            List<String> mots = new ArrayList<>();
            List<Integer> occurrences = new ArrayList<>();
            int maxCount = 0;
            String mostFrequentWord = null;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split(" ");
                for (String word : lineWords) {
                    if (mots.contains(word)) {
                        int index = mots.indexOf(word);
                        // Increment the occurrence count for the word
                        occurrences.set(index, occurrences.get(index) + 1);

                        if (occurrences.get(index) > maxCount) {
                            maxCount = occurrences.get(index); // Update the maximum count
                            mostFrequentWord = word; // Set the most frequent word
                        }
                    } else {
                        mots.add(word);
                        occurrences.add(1);
                    }
                }
                
            }
           

            //print best word
            System.out.println(occurrences);
            System.out.println("Le mot le plus fréquent est : " + mostFrequentWord + " avec " + maxCount + " occurrences.");
            // Close the reader             

           
            reader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

