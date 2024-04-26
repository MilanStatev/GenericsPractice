package com.company.oop.tests.MyListImplTests;

import com.company.oop.MyList;
import com.company.oop.MyListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddTests {

    private MyList<Integer> myList;

    @BeforeEach
    public void before() {
        myList = new MyListImpl<>();
    }

    @Test
    public void add_should_add() {
        myList.add(1);

        Assertions.assertEquals(myList.size(), 1);
    }

    @Test
    public void add_should_resize() {
        int initialSize = myList.size();
        myList = new MyListImpl<>(1);

        myList.add(1);
        myList.add(2);
        myList.add(3);

        Assertions.assertNotEquals(myList.size(), initialSize);
    }
}
