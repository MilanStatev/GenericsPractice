package com.company.oop.tests.MyListImplTests;

import com.company.oop.MyList;
import com.company.oop.MyListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IndexOfTests {

    private MyList<Integer> myList;

    @BeforeEach
    public void before() {
        myList = new MyListImpl<>();
    }

    @Test
    public void indexOf_should_return_index() {
        myList.add(1);
        myList.add(2);
        myList.add(3);

        Assertions.assertEquals(1, myList.indexOf(2));
    }

    @Test
    public void indexOf_should_return_minusOne() {
        myList.add(1);
        myList.add(2);
        myList.add(3);

        Assertions.assertEquals(-1, myList.indexOf(4));
    }
}
