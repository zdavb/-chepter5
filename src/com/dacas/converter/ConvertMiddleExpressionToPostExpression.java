package com.dacas.converter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by dave on 2016/4/6.
 * ����׺���ʽת���ɺ�׺���ʽ
 */
public class ConvertMiddleExpressionToPostExpression{
    static Map<Character,Integer> maps = new HashMap<>();
    static {
        maps.put('(',0);
        maps.put('+',1);
        maps.put('-',1);
        maps.put('*',2);
        maps.put('/',2);
    }
    public String convert(String midExpression){
        Stack<Character> operators = new Stack<>();//������
        Stack<String> operands = new Stack<>();//������

        char[] chars = midExpression.toCharArray();
        for(char ch:chars){
            if(ch>='0' && ch<='9'){
                operands.push(ch+"");
            }else if(ch == '(') {
                operators.push(ch);
            }else if(ch == ')'){
                char top;
                while((top = operators.pop())!='('){
                    String ch1 = operands.pop();
                    String ch2 = operands.pop();
                    operands.push(ch2 + "," + ch1 + "," + top);
                }
            }else{//������
                while (!operators.isEmpty() && comparePriority(operators.peek(), ch)) {//top >= ch,pop out
                    String ch1 = operands.pop();
                    String ch2 = operands.pop();
                    operands.push(ch2 + "," + ch1 + "," + operators.pop());
                }
                operators.push(ch);
            }
        }
        while(!operators.isEmpty()){
            String ch1 = operands.pop();
            String ch2 = operands.pop();
            operands.push(ch2+","+ch1+","+operators.pop());
        }
        return operands.pop();
    }
    private boolean comparePriority(char ch1,char ch2){
        int int1 = maps.get(ch1);
        int int2 = maps.get(ch2);
        return int1 >= int2;
    }
}
