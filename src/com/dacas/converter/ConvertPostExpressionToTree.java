package com.dacas.converter; /**
 * Created by dave on 2016/4/6.
 */
import java.util.Stack;
/**
 * 将后缀表达式转换成一个表达式树
 */
public class ConvertPostExpressionToTree implements IConverter{
    @Override
    public TreeNode convert(String expression) {
        Stack<TreeNode> nodes = new Stack<>();
        char[] chars = expression.toCharArray();

        for(char ch:chars){
            TreeNode root = new TreeNode(ch);
            if(!isValid(ch)) {
                TreeNode top1 = nodes.pop();
                TreeNode top2 = nodes.pop();

                root.setLeftNode(top2);
                root.setRightNode(top1);
            }
            nodes.push(root);
        }
        return nodes.size() == 1?nodes.pop():null;
    }
}
