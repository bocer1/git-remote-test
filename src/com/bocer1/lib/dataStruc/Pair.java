package com.bocer1.lib.dataStruc;

public class Pair<X, Y> {
    private X x;
    private Y y;

    public Pair(final X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getX() {
        return this.x;
    }

    public Y getY() {
        return this.y;
    }
}
