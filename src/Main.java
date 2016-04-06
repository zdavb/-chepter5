import com.dacas.converter.*;


/**
 * Created by dave on 2016/4/6.
 */
//���ݽṹ���㷨������4��
public class Main {
    public static void main(String[] args) {
        performConvertPostExpressionToTree();
    }
    private static void performConvertPostExpressionToTree(){
        /***********��׺���ʽת��***********/
        String postfix = "ab+cde+**";
        IConverter postConverter = new ConvertPostExpressionToTree();
        TreeNode postNode = postConverter.convert(postfix);
        System.out.println(postNode);
        /************ǰ׺���ʽת��*****************/
        String prefix = "-*+3456";
        IConverter preConverter = new ConvertPrefixExpressionToTree();
        TreeNode preNode = preConverter.convert(prefix);
        System.out.println(preNode);
        /****************��׺���ʽת��׺���ʽ**********************/
        String midfix = "3*(4+5/2-2*3/8)/2";
        ConvertMiddleExpressionToPostExpression midConverter = new ConvertMiddleExpressionToPostExpression();
        String postfixExpression = midConverter.convert(midfix);
        System.out.println(postfixExpression);

        String[] strs = postfixExpression.split(",");
        String newString = "";
        for(String tmp:strs){
            newString+=tmp+"";
        }
        TreeNode postNode2 = postConverter.convert(newString);
        System.out.println(postNode2);
    }
}
