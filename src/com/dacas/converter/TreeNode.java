package com.dacas.converter;

/**
 * Created by dave on 2016/4/6.
 */
public class TreeNode {
    private char val;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode(char val){
        this.val = val;
        leftNode = null;
        rightNode = null;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    //ÏÈÐò±éÀúÊ÷
    public String toString(){
        StringBuilder builder = new StringBuilder();
        printTree(builder,this);
        return builder.toString();
    }
    private void printTree(StringBuilder builder,TreeNode root){
        if(root == null)
            return;
        builder.append(root.val + ",");

        printTree(builder,root.leftNode);
        printTree(builder,root.rightNode);
    }
}
