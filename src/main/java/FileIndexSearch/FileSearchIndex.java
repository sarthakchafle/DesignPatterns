package FileIndexSearch;

import java.util.*;

public class FileSearchIndex {
    private static class TrieNode {
        Map<Character,TrieNode> children;
        Set<String> filePaths;

        public TrieNode() {
            this.children = new HashMap<>();
            this.filePaths = new HashSet<>();
        }
    }
    TrieNode root;
    public FileSearchIndex() {
        this.root = new TrieNode();
    }



    public void insert(String filePath, String text) {
        if(filePath==null || text==null) {
            return;
        }
        String[] words = text.toLowerCase().split("\\W+");
        for(String word: words) {
            if(word.isEmpty()){
                continue;
            }
            insertWord(word,filePath);
        }
    }
    public void insertWord(String word, String filePath){
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            curr.children.putIfAbsent(c, new TrieNode());
            curr=curr.children.get(c);
        }
        curr.filePaths.add(filePath);
    }

    public List<String> find(String word){
        TrieNode node = traverse(word.toLowerCase());
        if(node == null){
            return new ArrayList<>();
        }
        return new ArrayList<>(node.filePaths);
    }
    public List<String> findWithPrefix(String prefix){
        TrieNode prefixNode = traverse(prefix.toLowerCase());
        if(prefixNode==null){
            return new ArrayList<>();
        }
        Set<String> result = new HashSet<>();
        collectAllFiles(prefixNode, result);

        return new ArrayList<>(result);
    }
    private void collectAllFiles(TrieNode node, Set<String> accumulator) {
        accumulator.addAll(node.filePaths);
        for (TrieNode child : node.children.values()) {
            collectAllFiles(child, accumulator);
        }
    }
    private TrieNode traverse(String word){
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(!curr.children.containsKey(c)){
                return null;
            }
            curr = curr.children.get(c);
        }
        return curr;
    }

    public static void main(String[] args) {
        FileSearchIndex index = new FileSearchIndex();

        index.insert("/docs/A", "The cat drove the car");
        index.insert("/docs/B", "A cat is sleeping");
        index.insert("/docs/C", "I have a camera");
        index.insert("/docs/d", "Sarthak");

        System.out.println("Search 'cat': " + index.find("cat"));
        System.out.println("Prefix 'ca':  " + index.findWithPrefix("ca"));
        System.out.println("Prefix 'sa':  " + index.findWithPrefix("sa"));
    }

}
