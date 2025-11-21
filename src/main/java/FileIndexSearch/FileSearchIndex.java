package FileIndexSearch;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FileSearchIndex {
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();
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
        writeLock.lock();
        try {
            if (filePath == null || text == null) {
                return;
            }
            String[] words = text.toLowerCase().split("\\W+");
            for (String word : words) {
                if (word.isEmpty()) {
                    continue;
                }
                insertWord(word, filePath);
            }
        }
        finally {
            writeLock.unlock();
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
        readLock.lock();
        try {
            TrieNode node = traverse(word.toLowerCase());
            if (node == null) {
                return new ArrayList<>();
            }
            return new ArrayList<>(node.filePaths);
        }
        finally {
            readLock.unlock();
        }

    }
    public List<String> findWithPrefix(String prefix){
        readLock.lock();
        try {
            TrieNode prefixNode = traverse(prefix.toLowerCase());
            if (prefixNode == null) {
                return new ArrayList<>();
            }
            Set<String> result = new HashSet<>();
            collectAllFiles(prefixNode, result);

            return new ArrayList<>(result);
        }
        finally {
            readLock.unlock();
        }
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
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // 1. Inserts (You can run these async too, but let's keep them sync for setup)
        index.insert("/docs/A", "The cat drove the car");
        index.insert("/docs/B", "A cat is sleeping");
        index.insert("/docs/C", "I have a camera");
        index.insert("/docs/d", "Sarthak");

        // 2. Submit tasks to the pool
        CompletableFuture<List<String>> search1 = CompletableFuture.supplyAsync(
                () -> index.find("cat"), pool
        );

        CompletableFuture<List<String>> search2 = CompletableFuture.supplyAsync(
                () -> index.findWithPrefix("ca"), pool
        );

        CompletableFuture<List<String>> search3 = CompletableFuture.supplyAsync(
                () -> index.findWithPrefix("sa"), pool
        );

        // 3. Extract the results using .join()
        // .join() blocks the main thread until the specific task is done
        System.out.println("Search 'cat': " + search1.join());
        System.out.println("Prefix 'ca':  " + search2.join());
        System.out.println("Prefix 'sa':  " + search3.join());

        // 4. CRITICAL: Shutdown the pool to kill the threads and end the program
        pool.shutdown();
    }

}
