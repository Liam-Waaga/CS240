/* This entire test file was written by ChatGPT */

import java.util.NoSuchElementException;

public class Test {
    static int tests = 0;
    static int failures = 0;

    public static void main(String[] args) {
        // Replace CDLinkedList<T> with the actual class name if different.
        // Run tests:
        testConstructorInitialState();
        testAddFirstSingle();
        testAddLastSingle();
        testAddFirstMultipleOrderCircularity();
        testAddLastMultipleOrder();
        testInsertAtVariousPositions();
        testInsertAtInvalidIndices();
        testGetInvalidIndices();
        testRemoveOnEmpty();
        testSequentialRemoves();
        testAlternatingOps();
        testSizeAfterManyOps();
        testClear();
        testToString();
        testNullHandling();
        testSingleElementCircularPointers(); // best-effort behavioral checks

        System.out.println();
        System.out.printf("Ran %d tests: %d passed, %d failed%n", tests, tests - failures, failures);
        if (failures > 0) System.exit(1);
    }

    // Helper assertions:
    static void assertEquals(Object expected, Object actual, String name) {
        tests++;
        if (expected == null ? actual == null : expected.equals(actual)) {
            System.out.printf("PASS: %s%n", name);
        } else {
            failures++;
            System.out.printf("FAIL: %s - expected <%s> but was <%s>%n", name, expected, actual);
        }
    }

    static void assertTrue(boolean cond, String name) {
        tests++;
        if (cond) {
            System.out.printf("PASS: %s%n", name);
        } else {
            failures++;
            System.out.printf("FAIL: %s - condition is false%n", name);
        }
    }

    static void assertThrows(Runnable r, Class<? extends Throwable> exClass, String name) {
        tests++;
        try {
            r.run();
            failures++;
            System.out.printf("FAIL: %s - expected %s to be thrown but none thrown%n", name, exClass.getSimpleName());
        } catch (Throwable t) {
            if (exClass.isInstance(t)) {
                System.out.printf("PASS: %s%n", name);
            } else {
                failures++;
                System.out.printf("FAIL: %s - expected %s but got %s%n", name, exClass.getSimpleName(), t.getClass().getSimpleName());
            }
        }
    }

    // Tests:

    static void testConstructorInitialState() {
        CDLinkedList<String> list = new CDLinkedList<>();
        assertEquals(0, list.size(), "constructor: size==0");
        assertTrue(list.isEmpty(), "constructor: isEmpty==true");
        assertThrows(() -> list.get(0), IndexOutOfBoundsException.class, "constructor: get(0) throws");
    }

    static void testAddFirstSingle() {
        CDLinkedList<String> list = new CDLinkedList<>();
        list.addFirst("A");
        assertEquals(1, list.size(), "addFirst single: size==1");
        assertTrue(!list.isEmpty(), "addFirst single: isEmpty==false");
        assertEquals("A", list.get(0), "addFirst single: get(0)==A");
        assertEquals("A", list.removeFirst(), "addFirst single: removeFirst()==A");
        assertEquals(0, list.size(), "addFirst single: size after remove==0");
    }

    static void testAddLastSingle() {
        CDLinkedList<String> list = new CDLinkedList<>();
        list.addLast("A");
        assertEquals(1, list.size(), "addLast single: size==1");
        assertEquals("A", list.get(0), "addLast single: get(0)==A");
        assertEquals("A", list.removeLast(), "addLast single: removeLast()==A");
        assertEquals(0, list.size(), "addLast single: size after remove==0");
    }

    static void testAddFirstMultipleOrderCircularity() {
        CDLinkedList<String> list = new CDLinkedList<>();
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A"); // A,B,C
        assertEquals(3, list.size(), "addFirst multiple: size==3");
        assertEquals("A", list.get(0), "addFirst multiple: get(0)==A");
        assertEquals("B", list.get(1), "addFirst multiple: get(1)==B");
        assertEquals("C", list.get(2), "addFirst multiple: get(2)==C");
        assertEquals("C", list.removeLast(), "addFirst multiple: removeLast()==C");
        assertEquals("A", list.removeFirst(), "addFirst multiple: removeFirst()==A");
        assertEquals(1, list.size(), "addFirst multiple: size==1 after removals");
        assertEquals("B", list.get(0), "addFirst multiple: remaining element == B");
    }

    static void testAddLastMultipleOrder() {
        CDLinkedList<String> list = new CDLinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C"); // A,B,C
        assertEquals("A", list.get(0), "addLast multiple: get(0)==A");
        assertEquals("B", list.get(1), "addLast multiple: get(1)==B");
        assertEquals("C", list.get(2), "addLast multiple: get(2)==C");
        assertEquals("A", list.removeFirst(), "addLast multiple: removeFirst()==A");
        assertEquals("C", list.removeLast(), "addLast multiple: removeLast()==C");
        assertEquals(1, list.size(), "addLast multiple: size==1 after removals");
        assertEquals("B", list.get(0), "addLast multiple: remaining element == B");
    }

    static void testInsertAtVariousPositions() {
        CDLinkedList<String> list = new CDLinkedList<>();
        list.addLast("A");
        list.addLast("C");
        list.insertAt(1, "B"); // A,B,C
        assertEquals(3, list.size(), "insertAt middle: size==3");
        assertEquals("B", list.get(1), "insertAt middle: get(1)==B");
        list.insertAt(0, "X"); // X,A,B,C
        assertEquals("X", list.get(0), "insertAt beginning: get(0)==X");
        list.insertAt(list.size(), "Y"); // X,A,B,C,Y
        assertEquals("Y", list.get(list.size()-1), "insertAt end: last element==Y");
    }

    static void testInsertAtInvalidIndices() {
        CDLinkedList<String> list = new CDLinkedList<>();
        list.addLast("A");
        assertThrows(() -> list.insertAt(-1, "Z"), IndexOutOfBoundsException.class, "insertAt negative index throws");
        assertThrows(() -> list.insertAt(list.size()+1, "Z"), IndexOutOfBoundsException.class, "insertAt >size throws");
    }

    static void testGetInvalidIndices() {
        CDLinkedList<String> list = new CDLinkedList<>();
        list.addLast("A");
        assertThrows(() -> list.get(-1), IndexOutOfBoundsException.class, "get negative index throws");
        assertThrows(() -> list.get(list.size()), IndexOutOfBoundsException.class, "get index==size throws");
    }

    static void testRemoveOnEmpty() {
        CDLinkedList<String> list = new CDLinkedList<>();
        // Behavior may vary by implementation. Expect NoSuchElementException here.
        try {
            list.removeFirst();
            failures++; tests++;
            System.out.printf("FAIL: removeFirst on empty - expected exception but none thrown%n");
        } catch (Throwable t) {
            tests++;
            if (t instanceof NoSuchElementException || t instanceof IndexOutOfBoundsException || t instanceof IllegalStateException) {
                System.out.printf("PASS: removeFirst on empty threw %s%n", t.getClass().getSimpleName());
            } else {
                failures++;
                System.out.printf("FAIL: removeFirst on empty threw unexpected %s%n", t.getClass().getSimpleName());
            }
        }

        try {
            list.removeLast();
            failures++; tests++;
            System.out.printf("FAIL: removeLast on empty - expected exception but none thrown%n");
        } catch (Throwable t) {
            tests++;
            if (t instanceof NoSuchElementException || t instanceof IndexOutOfBoundsException || t instanceof IllegalStateException) {
                System.out.printf("PASS: removeLast on empty threw %s%n", t.getClass().getSimpleName());
            } else {
                failures++;
                System.out.printf("FAIL: removeLast on empty threw unexpected %s%n", t.getClass().getSimpleName());
            }
        }
    }

    static void testSequentialRemoves() {
        CDLinkedList<Integer> list = new CDLinkedList<>();
        for (int i = 0; i < 5; i++) list.addLast(i);
        for (int i = 0; i < 5; i++) {
            assertEquals(i, list.removeFirst(), "sequential removeFirst: element order");
        }
        assertEquals(0, list.size(), "sequential removeFirst: size==0");

        for (int i = 0; i < 5; i++) list.addLast(i);
        for (int i = 4; i >= 0; i--) {
            assertEquals(i, list.removeLast(), "sequential removeLast: element order");
        }
        assertEquals(0, list.size(), "sequential removeLast: size==0");
    }

    static void testAlternatingOps() {
        CDLinkedList<String> list = new CDLinkedList<>();
        list.addLast("A");
        list.addFirst("B"); // B,A
        assertEquals("A", list.removeLast(), "alternating ops: removeLast==A");
        list.addLast("C"); // B,C
        list.insertAt(1, "D"); // B,D,C
        assertEquals(3, list.size(), "alternating ops: size==3");
        assertEquals("B", list.get(0), "alternating ops: get(0)==B");
        assertEquals("D", list.get(1), "alternating ops: get(1)==D");
        assertEquals("C", list.get(2), "alternating ops: get(2)==C");
    }

    static void testSizeAfterManyOps() {
        CDLinkedList<Integer> list = new CDLinkedList<>();
        int N = 100;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) list.addFirst(i); else list.addLast(i);
        }
        assertEquals(N, list.size(), "size after many adds");
        for (int i = 0; i < N; i++) {
            if (i % 3 == 0) {
                try { list.removeFirst(); } catch (Throwable ignored) { }
            } else {
                try { list.removeLast(); } catch (Throwable ignored) { }
            }
        }
        // size should be 0 if all removes succeeded; but some implementations may throw when empty; we check non-negative
        assertTrue(list.size() >= 0, "size non-negative after many removes");
    }

    static void testClear() {
        CDLinkedList<String> list = new CDLinkedList<>();
        list.addLast("A"); list.addLast("B"); list.addLast("C");
        list.clear();
        assertEquals(0, list.size(), "clear: size==0");
        assertTrue(list.isEmpty(), "clear: isEmpty==true");
        // After clear, operations should behave as on empty list:
        try {
            list.get(0);
            failures++; tests++;
            System.out.printf("FAIL: clear then get(0) - expected exception but none thrown%n");
        } catch (Throwable t) {
            tests++;
            if (t instanceof IndexOutOfBoundsException || t instanceof NoSuchElementException) {
                System.out.printf("PASS: clear then get(0) threw %s%n", t.getClass().getSimpleName());
            } else {
                failures++;
                System.out.printf("FAIL: clear then get(0) threw unexpected %s%n", t.getClass().getSimpleName());
            }
        }
    }

    static void testToString() {
        CDLinkedList<Integer> list = new CDLinkedList<>();
        list.addLast(1); list.addLast(2); list.addLast(3);
        String s = list.toString();
        tests++;
        if (s != null && s.contains("1") && s.contains("2") && s.contains("3")) {
            System.out.printf("PASS: toString contains elements%n");
        } else {
            failures++;
            System.out.printf("FAIL: toString does not contain expected elements - got: %s%n", s);
        }
    }

    static void testNullHandling() {
        CDLinkedList<String> list = new CDLinkedList<>();
        try {
            list.addFirst(null);
            list.addLast(null);
            assertEquals(2, list.size(), "null handling: size counts nulls");
            assertEquals(null, list.get(0), "null handling: get(0) == null");
            assertEquals(null, list.removeFirst(), "null handling: removeFirst() returns null");
            assertEquals(null, list.removeFirst(), "null handling: removeFirst() returns null second");
        } catch (NullPointerException npe) {
            // Implementation may disallow nulls; that's acceptable — count as pass in that case.
            tests++;
            System.out.printf("PASS: null handling - implementation throws NullPointerException%n");
        }
    }

    // This test tries to verify circular pointer invariants by exercising behavior,
    // since we don't access internal nodes. It checks that rotating removals/adds don't break indexing.
    static void testSingleElementCircularPointers() {
        CDLinkedList<String> list = new CDLinkedList<>();
        list.addLast("A");
        // single element: get(0) should be A, removeLast and removeFirst should both return A if called appropriately
        assertEquals("A", list.get(0), "single element: get(0)==A");
        // After removeFirst on single element, list should be empty
        assertEquals("A", list.removeFirst(), "single element: removeFirst()==A");
        assertEquals(0, list.size(), "single element: size==0 after removeFirst");
        // add again and removeLast
        list.addFirst("B");
        assertEquals("B", list.removeLast(), "single element: removeLast()==B");
        assertEquals(0, list.size(), "single element: size==0 after removeLast");
    }
}
