package test;

import java.lang.String;
import java.util.Collections;
import java.util.List;


public class Trie
{
    /**
     *  create a new Trie (characters a-z)
     */
    public Trie()
    {
			myLinks = new Trie[ALPH];
			count = 0;
			nodeWord = null;
    }

    public Trie(String chars)
    {
			myLinks = new Trie[ALPH];
			count = 0;
			nodeWord = chars;
    }

    /**
     * Add a string to the trie
     *
     * @param s The string added to Trie
     */
    public void addString(String s)
    {
			Trie t = this;
			int k;
			int limit = s.length();
			s = s.toLowerCase();
			for(k=0; k < limit; k++)
			{
					int index = s.charAt(k) - 'a';
					if( index < 0 || index > ALPH){ continue; }
					if (t.myLinks[index] == null)
					{
						t.myLinks[index] = new Trie( s.substring(0,k+1) );
					}
					t = t.myLinks[index];
			}
			t.inc();
    }

    /**
     * prints all words in all children of this trie
     * @param print
     */
    public void printAll(boolean print){
    	Trie t = this;
    	Trie child;
    	int i;
    	for(i=0; i < ALPH; i++){
    		if(t.myLinks[i] != null){
    			child = t.myLinks[i];
    			child.printAll(print);
    		}
    	}
		
			if(t.count > 0){
				if(print){
					System.out.print(t.nodeWord + "=" + t.count + " ");
				}
			}
    }

    public List<Trie> sortWordsByCount(boolean topLevel, List<Trie> words){
    	Trie t = this;
    	Trie child;
    	int i;
    	if(t.count > 0){
    		words.add(t);
    	}
    	for(i=0; i < ALPH; i++){
    		if(t.myLinks[i] != null){
    			child = t.myLinks[i];
    			words = child.sortWordsByCount(false, words);
    		}
    	}

    	if(topLevel){
    		Collections.sort(words, new CustomComparator());
    	}

    	return words;
    }

    public void inc(){
    	count++;
    }

    public int getCount(){
    	return count;
    }

    /**
     * prints word for this node
     */
    public void printCurrentWord(){
        System.out.print(this.nodeWord + "=" + this.count + " ");
    }



    private static final int ALPH = 26;
    private Trie[]  myLinks;
    private String nodeWord;
    private Integer count;
}
