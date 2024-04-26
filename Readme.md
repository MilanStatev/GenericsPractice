# Generic List Implementation

## 1. Description

Your task is to implement your own version of a generic list. Feel free to draw ideas and inspiration from the built-in [ArrayList\<T\>](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html) and try to create your own generic list that behaves similarly.

To get started, remember the fact that the `ArrayList<T>` internally uses an **array** to store and manipulate items.

You have an interface (`MyList<T>`) and you need to provide implementation for it. There are also tests for you to make sure your implementation is correct. To run them, right click on the `tests` package and select `Run all tests`.

Following is the set of features your list should provide. **Please go through the whole document and read all requirements and tips carefully before writing any code.** After you've covered all the requirements, feel free to implement anything you think would be interesting and challenging.

> **Note:** You will need to indicate when something goes wrong by throwing an exception. We haven't talked about exceptions yet but all you need to know is that you can "throw" them by writing `throw new ArrayOutOfBoundsException();`.

## 2. Implement a constructor

### Description

Initializes a new instance of the `MyList<T>` class that is empty and has **default initial capacity of 4**. You can use an `int` constant to hold the capacity of the internal array if no value is passed. However, if a value is passed to the constructor its value should be used instead of the default capacity value. See this example:

```java
MyList<Integer> list = new MyListImpl<>();
// list.size() is 0
// list.capacity() is 4

MyList<Integer> list2 = new MyListImpl<>(8);
// list.size() is 0
// list.capacity() is 8
```

## 3. `size`

### Description

Gets the number of elements in the list.

```java
public int size();
```

## 4. `capacity`

### Description

Gets the total number of elements the internal data structure can hold without resizing.

```java
public int capacity();
```

## 5. `get`

### Description

Returns the element at the specified index.

```java
public T get(int index);
```

## 6. `add`

### Description

Adds an object to the end of the list.

```java
public void add(T element);
```

> **Note:** If the internal array of the list is full, you should *resize* in order to make room for future additions. If this seems complicated keep reading through this document, there are hints in regards to resizing an array towards the end.

### Example

```java
MyList<Integer> list = new MyListImpl<>();
list.add(3);
list.add(1);
list.add(4);
list.add(2); // list.capacity() is 4
list.add(5); // list.capacity() is 8
```

## 7. `contains`

### Description

Determines whether an element is in the list.

```java
public boolean contains(T element);
```

### Example

```java
list.аdd(1);
list.аdd(2);
list.аdd(3);
list.contains(2); // output: true
```

## 8. `indexOf`

### Description

Searches for the specified object and returns the index of the first occurrence within the entire list.

```java
public int indexOf(T element);
```

### Example

```java
list.add("Cat");
list.add("Dog");
list.add("Dog");
list.add("Mouse");
list.add("Cat");
list.indexOf("Dog"); // 1
```

## 9. `lastIndexOf`

### Description

Searches for the specified object and returns the index of the last occurrence within the entire list.

```java
public int lastIndexOf(T element);
```

### Example

```java
list.add("Cat");
list.add("Dog");
list.add("Dog");
list.add("Mouse");
list.add("Cat");
list.lastIndexOf("Cat"); // 4
```

## 10. `remove`

### Description

Removes the first occurrence of a specific object from the list.

```java
public boolean remove(T element);
```

> **Note:** Returns `true` if `element` was successfully removed; otherwise, `false`. This method also returns `false` if item was not found in the list.

### Example

```java
list.add("Cat");
list.add("Dog");
list.add("Dog");
list.add("Mouse");
list.add("Cat");
list.remove("Cat"); // output: true
```

## 11. `removeAt`

### Description

Removes the element at the specified index of the list.

```java
public void removeAt(int index);
```

### Example

```java
list.add("Cat");
list.add("Dog");
list.add("Dog");
list.add("Mouse");
list.add("Cat");
list.removeAt(3); // removes "Mouse"
```

## 12. `clear`

### Description

Removes all elements from the list.

```java
public void clear();
```

### Example

```java
list.add("New"); // list.size() is 1
list.add("Company"); // list.size() is 2
list.clear(); // list.size() is 0
```

## 13. `swap`

### Description

Swaps the position of two elements.

```java
public void swap(int from, int to);
```

### Example

```java
list.add("Dog");
list.add("Cat");
list.add("Mouse");
// Dog, Cat, Mouse

list.swap(0, 1); // Cat, Dog, Mouse
list.swap(0, 2); // Mouse, Dog, Cat
```

> **Hint**: Now that you have gone through the requirements of the task, here are some hint points to jump-start your development.

## 15. Iterator

You also need to implement an iterator for the list.

## 16. Print

Would be very useful for debugging.

```java
MyList<Integer> list = new MyListImpl<>();

list.add(1);
list.add(2);
list.add(3);
list.print(); // output: [1, 2, 3]
```

## 17. Resizing an Array

Implementing the `add(T)` and `remove(T)` methods *would require increasing or decreasing the size of the internal array many times*.

One commonly used approach is to use the **[`Arrays.copyOf()`](https://www.geeksforgeeks.org/arrays-copyof-in-java-with-examples/)** method.

This method *creates a new array*, then copies the elements from the old array to the new one. It takes 2 arguments - the array to copy and the length of the new array.

```java
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(arr.length);             // output: 3
        System.out.println(Arrays.toString(arr));   // output: [1, 2, 3]

        arr = Arrays.copyOf(arr, 6);
        System.out.println(arr.length);             // output: 6
        System.out.println(Arrays.toString(arr));   // output: [1, 2, 3, 0, 0, 0]
    }
}
```
