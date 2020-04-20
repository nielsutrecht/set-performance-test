package com.nibado.fastcollections.matcher;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OfferOld {
    private final String category;
    private final State state;
    private final Set<String> groups;
    private final String brand;

    public OfferOld(String category, State state, Set<String> groups, String brand) {
        this.category = category;
        this.state = state;
        this.groups = groups;
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public State getState() {
        return state;
    }

    public boolean hasGroup(String group) {
        return groups.contains(group);
    }

    public String getBrand() {
        return brand;
    }

    public OfferNew toNew() {
        List<Integer> groups = this.groups.stream().map(Integer::parseInt).collect(Collectors.toList());

        return new OfferNew(Integer.parseInt(category), state, groups);
    }
}
