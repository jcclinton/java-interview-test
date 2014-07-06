package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Util {

	public static List<String> readTextFromFile(String file) throws IOException {		
		BufferedReader r = new BufferedReader(new FileReader(file));
		String line;
		List<String> result = new ArrayList<String>();
		while ((line = r.readLine()) != null) {
			BreakIterator wordIterator = BreakIterator.getWordInstance();
		    wordIterator.setText(line);
		    int start = wordIterator.first();
		    int end = wordIterator.next();
		 
		    while (end != BreakIterator.DONE) {
		    	String word = line.substring(start, end);
		        if (Character.isLetterOrDigit(word.charAt(0))) {
		        	result.add(word);
		        }
		        start = end;
		        end = wordIterator.next();
		    }		
		}
		r.close();		
		System.out.println("Text size: " + result.size());
		return Collections.unmodifiableList(result);
	}
		

	public static void main(String[] args) throws IOException {
		System.out.println(readTextFromFile("test.txt"));
	}
}

