package com.nibado.fastcollections.matcher;

import java.util.Set;

public class MatcherOld {
    private final Set<String> category;
    private final State state;
    private final String group;

    public MatcherOld(Set<String> category, State state, String group) {
        this.category = category;
        this.state = state;
        this.group = group;
    }

    public boolean matches(OfferOld offer) {
        return
                category.contains(offer.getCategory()) &&
                        state == offer.getState() &&
                        offer.hasGroup(group);
    }
}
