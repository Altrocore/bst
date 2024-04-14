package com.clover;

import com.clover.model.BinarySearchTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {

    @Test
    void testInsert() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        assertEquals(5, bst.getRoot().getValue(), "Root should be 5");

        assertEquals(3, bst.getRoot().getLeft().getValue(), "Left child should be 3");

        assertEquals(7, bst.getRoot().getRight().getValue(), "Right child should be 7");
    }
}


