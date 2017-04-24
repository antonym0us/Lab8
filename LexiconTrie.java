import structure5.*;
import java.util.Iterator;

public class LexiconTrie implements Lexicon {
    protected int numWords = 0;
    protected LexiconNode root;

    public LexiconTrie(){
	root = new LexiconNode();
    }

    public boolean addWord(String word) {
	return addWordHelper(word, root);
    }
    
    protected boolean addWordHelper(String word, LexiconNode parent) {
	if (word.length() == 0) {	    
	    // set parent isWord to true
	    parent.setIsWord(true);
	    ++numWords;
	    return true;
	} else if (parent.getChild(word.charAt(0)) == null) {
	    parent.addChild(new LexiconNode(word.charAt(0), false));
	    return addWordHelper (word.substring(1), parent.getChild(word.charAt(0)));
	} else {
	    return false;
	}
    }
    
    public int addWordsFromFile(String filename) {
	// Ay bruv check out the filestream doc
	int preNumWords = numWords;

	FileStream stream = new FileStream(filename);
	Scanner in = new Scanner(stream);
	while (in.hasNext()) {
	    addWord(in.next());
	}
	return numWords - preNumWords;
    }
    
    public boolean removeWord(String word) {
	if (word.length() == 0 && parent.isWord()) {
	    parent.setIsWord(false);
	    --numWords;
	    return true;
	} else if (parent.getChild(word.charAt(0)) != null) {
	    return removeWordHelper(word.substring(1), parent.getChild(word.charAt(0)));
	} else {
	    return false;
	}
	
	public int numWords() {
	return numWords;
    }
    
    public boolean containsWord(String word){
	return containsWordHelper(word, root);
    }

    private boolean containsWordHelper(String word, LexiconNode parent) {
	if (word.length() == 0 && parent.isWord()) {
	    return true;
	} else if (parent.getChild(word.charAt(0)) != null) {
	    return containsWordHelper(word.substring(1), parent.getChild(word.charAt(0)));
	} else {
	    return false;
	}
    }
    
    public boolean containsPrefix(String prefix){
	return containsPrefixHelper(prefix, root);
    }

    private booolean containsPrefixHelper(String prefix, LexiconNode parent) {
	if (prefix.length() == 0) {
	    return true;
	} else if (parent.getChild(word.charAt(0)) != null) {
	    return containsPrefixHelper(prefix.substring(1), parent.getChild(word.charAt(0)));
	} else {
	    return false;
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
