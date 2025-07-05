package net.jirniy.pinkstuff.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum CrawlerVariant {
    DEFAULT(0),
    DIAMOND(1),
    EMERALD(2),
    QUARTZ(3),
    KUNZITE(4),
    THERMIUM(5);

    private static final CrawlerVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(CrawlerVariant::getId)).toArray(CrawlerVariant[]::new);
    private final int id;

    CrawlerVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static CrawlerVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}