package com.clover.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;
    private int height;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}
