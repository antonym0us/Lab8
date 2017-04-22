import structure5.*;
import java.util.Iterator;

public class LexiconTrie implements Lexicon {

    protected int numWords = 0;

    protected LexiconNode root;

    /* The constructor */
    public LexiconTrie() {
        root = new LexiconNode(null, true);
    }

    public boolean addWord(String word) {
        return addWordHelper(word, root);
    }

    private boolean addWordHelper (String word, LexiconNode parent) {
        if (word.length() == 0) {
            ++numWords;
            return true;
        } else if (parent.getChild(word.charAt(0)) == null) {
            parent.addChild(word.charAt(0));
            return addWordHelper(word.substring(1), parent.getChild(word.charAt(0)));
        } else {
            return false;
        }
    }
    
    public int addWordsFromFile(String filename) {
        return 0;
    }
    
    public boolean removeWord(String word) {
        --numWords;
        return true;
    }
    
    public int numWords() {
        return numWords;
    }
    
    public boolean containsWord(String word) {
        return containsWordHelper(word, root);
    }

    private boolean containsHelper(String word, LexiconNode parent) {
        if (word.length() == 0) {
            return true;
        } else if (parent.getChild(word.charAt(0) != null)) {
            return containsWordHelper(word.substring(1), parent.getChild(word.charAt(0)));
        } else {
            return false;
        }
    }
    
    public boolean containsPrefix(String prefix) {
        return containsHelper(prefix, root);
    }    
    
    public Iterator<String> iterator() {
        return null;
    }
    
    public Set<String> suggestCorrections(String target, int maxDistance) {
        return null;
    }
    
    public Set<String> matchRegex(String pattern) {
        return null;
    }
}
