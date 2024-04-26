package com.company.oop.tests.MyListImplTests;

import com.company.oop.MyList;
import com.company.oop.MyListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RemoveAtTests {

    private MyList<Integer> myList;

    @BeforeEach
    public void before() {
        myList = new MyListImpl<>();
    }

    @Test
    public void removeAt_removes_when_indexIsValid() {
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

        myList.removeAt(1);

        Assertions.assertEquals(3, myList.size());
        Assertions.assertNotEquals(2, myList.get(1));
    }

    @Test
    public void removeAt_throws_when_indexOutOfBounds() {
        myList.add(1);
        myList.add(2);
        myList.add(3);

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> myList.removeAt(4));
    }

}
