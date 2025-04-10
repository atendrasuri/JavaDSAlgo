package com.suri.common;

public class ListNodeWithRandom {
    public int val;
    public ListNodeWithRandom next;
    public ListNodeWithRandom random;

    public ListNodeWithRandom(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}