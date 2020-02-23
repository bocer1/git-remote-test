package com.bocer1.lib.dataStruc;

import java.util.ArrayList;
import java.util.Collection;

public class Node<T> {
    private T value;
    private Collection<Node<T>> children;

    public Node(T value, Collection<Node<T>> children) {
        this.value = value;
        this.children = children;
    }

    public Node(T value) {
        this(value, new ArrayList<>());
    }


}
