package com.janhen.structures.BST.order;

import org.junit.Assert;

public class OrderedSTTest {

    @org.junit.Test
    public void BinarySearchOrderedSTTest() {
        test(new BinarySearchOrderedST<Integer, String>(10));
    }


    @org.junit.Test
    public void BSTTest() {
        test(new BST<Integer, String>());
    }


    @org.junit.Test
    public void RedBlackBSTTest() {
        test(new RedBlackBST<Integer, String>());
    }


    private void test(OrderedST<Integer, String> st) {

        Integer key1 = 2, key2 = 1, key3 = 3;
        String value1 = "b", value2 = "a", value3 = "c";

        st.put(key1, value1);

        Assert.assertSame(st.get(key1), value1);
        Assert.assertNull(st.get(key2));

        st.put(key2, value2);
        st.put(key3, value3);

        Assert.assertSame(st.get(key2), value2);

        Assert.assertEquals(1, (int) st.min());
        Assert.assertEquals(3, (int) st.max());

        Assert.assertEquals(3, st.size());
        Assert.assertEquals(1, st.rank(2));

        Assert.assertArrayEquals(st.keys(1, 2).toArray(new Integer[2]), new Integer[]{1, 2});

        st.put(key2, value1);

        Assert.assertSame(st.get(key2), value1);
    }
}
