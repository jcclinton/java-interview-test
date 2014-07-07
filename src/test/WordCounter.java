package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Calculates word frequency in the input text collection. Note: the Util class is out of 
 * the scope of this task.
 * 
 * Tasks: 
 *   1. Compile and execute the program.
 *   2. Assuming that the program generates the correct output, is there anything that can be improved?
 *   3. If so, how would you change the program to make it better?
 *   3. How would you sort the output in the alphabetical order? In the word frequency order?
 *   4. Design the program that would calculate word frequency in multiple threads.
 *    
 */
public class WordCounter {

    /**
     *  Countes the words in the input collection and prints the results,
     *  if printResults parameter is set.
     *  Every element in the collection contain is a word from the text.
     */
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
    
    
    public static void countWordsTrie(List<String> text, boolean printResults) {        
        Trie trie = new Trie();

        for (String word : text) {
        	trie.addString(word);
        }
        
        
        // printing results 
        trie.printWords(printResults);
        System.out.println("");
           
    }    
    
    public static void countWordsTrieByCount(List<String> text, boolean printResults) {        
        Trie trie = new Trie();

        for (String word : text) {
        	trie.addString(word);
        }
        

        if( printResults ){
	    	List<Trie> words = new ArrayList<Trie>();
	        words = trie.sortWordsByCount(true, words);
	        for (int i = 0; i < words.size(); i++) {
	        	trie = words.get(i);
	        	trie.printWord();
	        }
	        System.out.println("");
        }
           
    }
    
    
    public static void main(String[] args) throws IOException {
        long time = System.currentTimeMillis();
        boolean printResults = true;
        // The utility method - is the implementation details
        //List<String> text = Util.readTextFromFile("test.txt");
        List<String> text = Util.readTextFromFile("monte_cristo.txt");
        System.out.println("Initial reading: " + (System.currentTimeMillis() - time) + "ms");
        
        time = System.currentTimeMillis();
        countWords(text, printResults);
        System.out.println("Time to process: " + (System.currentTimeMillis() - time) + "ms");
        
        time = System.currentTimeMillis();
        countWordsTrie(text, printResults);
        System.out.println("Time to process alph-sorted trie: " + (System.currentTimeMillis() - time) + "ms");
        
        time = System.currentTimeMillis();
        countWordsTrieByCount(text, printResults);
        System.out.println("Time to process count-sorted trie: " + (System.currentTimeMillis() - time) + "ms");
        
    }
    
}
