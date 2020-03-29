package com.nibado.fastcollections.lookup.java;

import com.nibado.fastcollections.lookup.IntLookup;

import java.util.List;

//Basically a singleton set
public class EqualsIntLookup implements IntLookup {
    private final int value;

    public EqualsIntLookup(List<Integer> data) {
        value = data.get(0);
    }

    @Override
    public boolean contains(int value) {
        return value == this.value;
    }
}
