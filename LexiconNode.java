import structure5.*;
import java.util.Iterator;

/**
 * SHIVAM PATEL // WEDNESDAY PM
 *
 * LexiconNode.java
 *
 * Defines the behavior for a LexiconNode, the element that
 * composes the LexiconTrie.
 *
 */
class LexiconNode implements Comparable<LexiconNode> {
    Character letter;
    boolean isWord;
    OrderedVector<LexiconNode> children;
    
    /* Constructor */
    LexiconNode(Character letter, boolean isWord) {
	this.letter = Character.toLowerCase(letter);
	this.isWord = isWord;

	children = new OrderedVector<LexiconNode>();
    }

    LexiconNode(){
	LexiconNode(null, false);
    }

    /*
     * PRE:  'that' is not null
     * POST: Returns numerical comparison of the LexiconNodes' chars
     */
    public int compareTo(LexiconNode that) {
	if (that != null) {
	    return this.letter.compareTo(that.letter());
	} else {
	    System.out.println("Error: Invalid 'compareTo' call");
	    return Integer.MAX_VALUE;
	}
    }

    /* Return letter stored by this LexiconNode */
    public char letter() {
	return this.letter;
    }

    /* Return boolean determining whether the LexiconNode(combined w/ nodes before it) is a word or not  */
    public boolean isWord() {
	return isWord;
    }

    public void setIsWord(boolean newIsWord) {
	this.isWord = newIsWord;
    }
    
    /*
     * PRE:  'ln' is not null
     * POST: Adds LexiconNode child to correct position in child data structure
     */
    public void addChild(LexiconNode ln) {
	if (ln != null) {
	    children.add(ln);
	} else {
	    System.out.println("Error: Invalid 'addChild' call");
	}
    }

    /* Get LexiconNode child for 'ch' out of child data structure */
    public LexiconNode getChild(char ch) {
	Iterator it = children.iterator();
	while (it.hasNext()) {
	    LexiconNode next = (LexiconNode)it.next();
	    if (next.letter() == ch) {
		return next;
	    }
	}
	System.out.println("Error: 'getChild' returned null!");
	return null;
    }

    /* Remove LexiconNode child for 'ch' from child data structure */
    public void removeChild(char ch) {
	Iterator it = children.iterator();
	while (it.hasNext()) {
	    LexiconNode next = (LexiconNode)it.next();
	    if (next.letter() == ch) {
		children.remove(next);
		return;
	    }
	}
	System.out.println("Error: 'removeChild' cannot find param!");
    }

    /* Iterate over children */
    public Iterator<LexiconNode> iterator() {
	return children.iterator();
    }

    /*DEBUG TOOL*/
    public static void main(String args[]) {
	LexiconNode node = new LexiconNode('a', true);

	// Test addChild [Should return error]
	node.addChild(new LexiconNode('s', true));
	node.addChild(new LexiconNode('m', true));
	node.addChild(null);

	// Test getChild and compareTo [Should return 0]
	System.out.println(node.getChild('s').compareTo(new LexiconNode('s', true)));
	
	//Test removeChild [Should return error]
	node.removeChild('m');
	node.getChild('m');
    }
}

