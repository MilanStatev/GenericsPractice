package com.company.oop.tests.MyListImplTests;

import com.company.oop.MyListImpl;
import com.company.oop.MyList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwapTests {

    private MyList<Integer> myList;

    @BeforeEach
    public void before() {
        myList = new MyListImpl<>();
    }

    @Test
    public void swap_should_swap() {
        myList.add(1);
        myList.add(2);
        myList.add(3);

        myList.swap(0, 2);

        Assertions.assertAll(() -> {
            assertEquals(3, myList.get(0));
            assertEquals(1, myList.get(2));
        });
    }

}
