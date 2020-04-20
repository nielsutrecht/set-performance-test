package com.nibado.fastcollections.matcher;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;

import java.util.Collection;

public class OfferNew {
    private final int category;
    private final State state;
    private final IntOpenHashSet groups;

    public OfferNew(int category, State state, Collection<Integer> groups) {
        this.category = category;
        this.state = state;
        this.groups = new IntOpenHashSet(groups.size(), 0.25f);

        this.groups.addAll(groups);
    }

    public int getCategory() {
        return category;
    }

    public State getState() {
        return state;
    }

    public boolean hasGroup(int group) {
        return groups.contains(group);
    }
}
