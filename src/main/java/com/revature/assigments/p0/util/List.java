package com.revature.assigments.p0.util;

public interface List<T> {
    void add(T data);
    T pop();
    T get(int index);
    boolean constains(T data);
    int size();
    void sort(T data);
}
