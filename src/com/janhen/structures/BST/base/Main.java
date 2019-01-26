package com.janhen.structures.BST.base;

public class Main {

    public static void main(String[] args) {
        Integer[] nums = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        BST<Integer> bst = new BST<>(nums);

        bst.printTree();
        System.out.println(bst);
        bst.levelOrder();
        bst.preOrder();
        bst.inOrder();
        bst.postOrder();

        bst.removeMin();
        bst.printTree();
        bst.removeMax();
        bst.printTree();

        bst.remove(4);
        bst.printTree();

        bst.remove(111111111);
        bst.printTree();

    }
}
