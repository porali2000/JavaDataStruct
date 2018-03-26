import java.util.HashMap;

public class TrieNode {
    private boolean isWord;
    private String text;
    private HashMap<Character, TrieNode> children;
}
