package com.nibado.fastcollections.matcher;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;

import java.util.Collection;

public class MatcherNew {
    private final IntOpenHashSet category;
    private final State state;
    private final int group;

    public MatcherNew(Collection<Integer> category, State state, Integer group) {
        this.category = new IntOpenHashSet(category.size(), 0.25f);
        this.category.addAll(category);
        this.state = state;
        this.group = group;
    }

    public boolean matches(OfferNew offer) {
        return
                category.contains(offer.getCategory()) &&
                        state == offer.getState() &&
                        offer.hasGroup(group);
    }
}
