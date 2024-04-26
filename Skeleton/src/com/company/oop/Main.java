package com.company.oop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyListImpl<>();



        list.add(1);

        list.add(2);

        list.add(3);

        list.print(); // output: [1, 2, 3]
    }
}