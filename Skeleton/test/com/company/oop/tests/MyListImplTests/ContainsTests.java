package com.company.oop.tests.MyListImplTests;

import com.company.oop.MyList;
import com.company.oop.MyListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContainsTests {

    private MyList<Integer> myList;

    @BeforeEach
    public void before() {
        myList = new MyListImpl<>();
    }

    @Test
    public void contains_should_return_true() {
        myList.add(1);

        Assertions.assertTrue(myList.contains(1));
    }

    @Test
    public void contains_should_return_false() {
        Assertions.assertFalse(myList.contains(1));
    }
}
