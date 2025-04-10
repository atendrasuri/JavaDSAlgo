package com.suri.common;

/*
Trie Node Structure
A Trie is a rooted tree where each node has the following attributes:

Up to R links to its children, with each link corresponding to one of R possible character values. In this article, we assume R=26 for lowercase Latin letters.
A boolean field indicating whether the node marks the end of a key or is just a prefix.
 */
public class TrieNode {

    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // Assuming only lowercase English letters
        isEndOfWord = false;
    }

    public boolean containsKey(char ch) {
        return children[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return children[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        children[ch -'a'] = node;
    }
    public void setEnd() {
        isEndOfWord = true;
    }
    public boolean isEnd() {
        return isEndOfWord;
    }

}
