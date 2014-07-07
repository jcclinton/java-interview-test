package test;

import java.util.Comparator;

public class CustomComparator implements Comparator<Trie> {
	    @Override
	    public int compare(Trie o1, Trie o2) {
	    	int a = o1.getCount();
	    	int b = o2.getCount();
	    	// sorts largest first
	        int cmp = a > b ? -1 : a < b ? +1 : 0;
	        return cmp;
	    }
	}
