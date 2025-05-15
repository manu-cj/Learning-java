package org.manu;

import java.util.ArrayList;

public class Stack<T> {

    private final ArrayList<T> datas = new ArrayList<>();

    public void push(T data) {
        datas.add(data);
    }

    public T get() {
        return datas.get(datas.size() - 1);
    }

}
