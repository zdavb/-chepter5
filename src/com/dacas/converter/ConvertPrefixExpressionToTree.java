package com.dacas.converter;

import java.util.Stack;

/**
 * Created by dave on 2016/4/6.
 */
public class ConvertPrefixExpressionToTree implements IConverter {
    @Override
    public TreeNode convert(String expression) {
        char[] chars = expression.toCharArray();
        Stack<TreeNode> nodes = new Stack<>();

        for(int i = chars.length-1;i>=0;i--){
            TreeNode root = new TreeNode(chars[i]);
            if(!isValid(chars[i])){
                TreeNode top1 = nodes.pop();
                TreeNode top2 = nodes.pop();

                root.setLeftNode(top1);
                root.setRightNode(top2);
            }
            nodes.push(root);
        }
        return nodes.size() == 1?nodes.pop():null;
    }
}
