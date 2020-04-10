package ru.netology.domain;

import java.util.Comparator;

public class OfferComparator implements Comparator<OfferToFly> {
    public int compare(OfferToFly o1, OfferToFly o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}
