package com.dacas.converter;

/**
 * Created by dave on 2016/4/6.
 */
//����ת���ӿ�
public interface IConverter {
    public TreeNode convert(String expression);
    default boolean isValid(char ch){
        return ch>='a' && ch<='z' || ch>='0' && ch<='9';
    }
}
