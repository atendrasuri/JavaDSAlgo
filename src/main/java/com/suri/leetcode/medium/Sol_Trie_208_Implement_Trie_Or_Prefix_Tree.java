package com.suri.leetcode.medium;
import com.suri.common.TrieNode;
/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
https://leetcode.com/problems/implement-trie-prefix-tree/description/
 */



public class Sol_Trie_208_Implement_Trie_Or_Prefix_Tree {
    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));  // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));

    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode node = root;

        for(int i=0;i<word.length();i++){
            char currentChar = word.charAt(i);

            if(!node.containsKey(currentChar)){
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();

    }

    public boolean search(String word) {

        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char currentLetter = word.charAt(i);
            if(node.containsKey(currentLetter)){
                node = node.get(currentLetter);
            }else{
                return false;
            }
        }
        return node.isEnd();

    }

    public boolean startsWith(String prefix) {

        TrieNode node = root;
        for(int i=0;i<prefix.length();i++){
            char currentLetter = prefix.charAt(i);
            if(node.containsKey(currentLetter)){
                node = node.get(currentLetter);
            }else{
                return false;
            }
        }
        return true;
    }
}
