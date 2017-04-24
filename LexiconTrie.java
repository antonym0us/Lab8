import structure5.*;
import java.util.Iterator;
import java.util.Scanner;

public class LexiconTrie implements Lexicon {

    protected int numWords = 0;
    protected LexiconNode root;

    public LexiconTrie() {
	root = new LexiconNode(' ', true);
    }

    public boolean addWord(String word) {
	LexiconNode last = find(word);
	
	if (last == null) {
	    return addWordHelper(word, root);
	}
	return false;
    }

    public boolean addWordHelper(String word, LexiconNode parent) {
	if (word.length() == 0) {
	    // All added, stop!
	    parent.setIsWord(true);
	    ++numWords;
	    return true;
	} else {
	    // Need to add more

	    // Should skip?
	    if (parent.getChild(word.charAt(0)) == null) {
		parent.addChild(new LexiconNode(word.charAt(0), false));
	    }

	    // Keep going
	    return addWordHelper(word.substring(1), parent.getChild(word.charAt(0)));
	}
    }
    
    public int addWordsFromFile(String filename) {
	int preNumWords = numWords;
	
	Scanner in = new Scanner(new FileStream(filename));
	
	while (in.hasNext()) {
	    addWord(in.next());
	}
	
	return numWords - preNumWords;
    }

    // shivam's idea
    public boolean removeWord(String word) {
	LexiconNode last = find(word);

	if (last != null) {
	    last.setIsWord(false);
	    --numWords;
	    return true;
	}
	return false;
	
    }
	
    public int numWords() {
	return numWords;
    }
    
    public boolean containsWord(String word){
	return find(word) != null && find(word).isWord();
    }
    
    public boolean containsPrefix(String prefix){
	return find(prefix) != null;
    }

    /*
     * A method to do all of the tracing for us
     * 
     * Returns null if word is found
     * Returns the last letter of word found if word is not found
     */
    private LexiconNode find(String word) {
	return finder(word, root);
    }

    private LexiconNode finder(String word, LexiconNode parent) {
	if (word.length() == 0) {
	    // Word is empty; every letter was found
	    return parent;
	} else if (parent.getChild(word.charAt(0)) != null) {
	    // The next character was found in the trie; keep tracing
	    return finder(word.substring(1), parent.getChild(word.charAt(0)));
	} else {
	    // The word is NOT empty AND the next character was NOT found in the trie
	    return null;
	}
    }
    
    public Iterator<String> iterator() {
	return null;
    }
    public Set<String> suggestCorrections(String target, int maxDistance) {
	return null;
    }
    
    public Set<String> matchRegex(String pattern){
	return null;
    }
}
