package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tasks: 
 *   1. Find a weakness in the program that calculates word frequency in the given input.
 *   2. How to sort the program output in the alphabetical and word frequency order.
 *   3. Design the program that would calculates word frequency in multiple threads.  
 *    
 */
public class WordCounter {

    public static void countWords(List<String> text, boolean printResults) {
        List<String> words = new ArrayList<String>();
        List<Integer> counters = new ArrayList<Integer>();

        for (String word : text) {
            int pos = words.indexOf(word);
            if (pos != -1) {
                int counter = counters.get(pos);
                counters.set(pos, ++counter);
            } else {
                words.add(word);
                counters.add(1);
            }
        }
        
        
        // printing results       
        int count = 0;
        if (printResults) {
            for (int i = 0; i < words.size(); i++) {
                System.out.print(words.get(i) + "=" + counters.get(i) + " ");           
                count += counters.get(i);
            }
            System.out.println("\nTotal: " + count);
        }
           
    }
    
    @Override
    public String toString() {
        return "Simple";
    }
    
    public static void main(String[] args) throws IOException {
        long time = System.currentTimeMillis();
        List<String> text = Util.readTextFromFile("monte_cristo.txt");
        System.out.println("Initial reading: " + (System.currentTimeMillis() - time) + "ms");
        countWords(text, true);
        System.out.println("Time to process: " + (System.currentTimeMillis() - time) + "ms");
        
    }
    
}
