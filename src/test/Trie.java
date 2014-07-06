package test;

import java.lang.String;

/**
 * implements a trie for storing strings/string prefixes
 *
 * @author Owen Astrachan
 * @version $Id: Trie.java,v 1.1 1996/12/01 00:07:21 ola Exp ola $
 *
 */


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
		t.myLinks[index] = new Trie( s.substring(0,k+1));
	    }
	    t = t.myLinks[index];
	}
	t.inc();
    }
    
    public void printWords(boolean print){
    	Trie t = this;
    	Trie child;
    	int i;
    	for(i=0; i < ALPH; i++){
    		if(t.myLinks[i] != null){
    			child = t.myLinks[i];
    			child.printWords(print);
    		}
    	}
		
		if(t.count > 0){
			if(print){
				System.out.println(t.nodeWord + ": " + t.count);
			}
		}
    }
    
    
    public void inc(){
    	count++;
    }



    private static final int ALPH = 26;
    private Trie[]  myLinks;
    private String nodeWord;
    private Integer count;
}
