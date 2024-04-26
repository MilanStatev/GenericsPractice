package com.company.oop.tests.MyListImplTests;

import com.company.oop.MyList;
import com.company.oop.MyListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LastIndexOfTests {

    private MyList<Integer> myList;

    @BeforeEach
    public void before() {
        myList = new MyListImpl<>();
    }

    @Test
    public void lastIndexOf_should_return_index() {
        myList.add(1);
        myList.add(2);
        myList.add(1);
        myList.add(3);
        myList.add(1);

        Assertions.assertEquals(4, myList.lastIndexOf(1));
    }

    @Test
    public void lastIndexOf_should_return_minusOne() {
        myList.add(1);
        myList.add(2);
        myList.add(3);

        Assertions.assertEquals(-1, myList.lastIndexOf(4));
    }
}
