package com.clover;

import com.clover.model.BinarySearchTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreeSerializationTest {

    @Test
    public void testSerialization() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(20);
        String jsonOutput = bst.toJson();
        assertTrue(jsonOutput.contains("\"value\":10"));
        assertTrue(jsonOutput.contains("\"value\":20"));
    }
}

