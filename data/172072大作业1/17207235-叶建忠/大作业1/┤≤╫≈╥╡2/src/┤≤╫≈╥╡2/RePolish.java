package ����ҵ2;

import java.util.Stack;
import java.util.regex.Pattern;

class RePolish {
    public Stack<String> transformToRePolish(String express) {
        Stack<String> operator = new Stack<>();       //�洢������
        Stack<String> endRepolish = new Stack<>();       //�洢�沨��ʽ

        //ȥ���ַ����еĿո�
        String expression = express.replaceAll( "\\s+", "");

        //������ʽת��Ϊ�沨�����ʽ
        int k;//��¼�ַ������ֺ��һ���������ַ����±�
        for(int i = 0; i < expression.length(); i++){
            //�ж��Ƿ�Ϊ�����
            if(isOperator(String.valueOf(expression.charAt(i)))){
                //������������ţ�ֱ�Ӽ��뵽operator�У�
                if("(".equals(String.valueOf(expression.charAt(i))))
                    operator.push("(");
                //������������ţ���ô��operator�еĲ�������ջ���ϳ��沨�����ʽ�����뵽value�С�ֱ������operator�е������ţ������ջ��
                else if(")".equals(String.valueOf(expression.charAt(i)))){
                    while(!"(".equals(operator.peek()))
                        endRepolish.push(operator.pop());
                    //������ջ
                    operator.pop();
                }
                //�������-+*/������
                else {
                    //�����������ȼ�С�ڵ�ǰoperatorջ�������ȼ�����operatorջ���Ĳ�������ջ������endRePolish�еĲ��������кϳ��沨�����ʽ��ֱ��operatorջ���Ĳ�����Ϊ�ջ���opջ���Ĳ�����С�ڵ��ڲ�����
                    while(!operator.isEmpty()&&!isBigger(String.valueOf(expression.charAt(i)),operator.peek())){
                        endRepolish.push(operator.pop());
                    }
                    operator.push(String.valueOf(expression.charAt(i)));
                    /*�����������ȼ����ڵ�ǰoperatorջ�������ȼ�����operatorջΪ�գ��򽫸ò�������ջ
                    if(operator.isEmpty() || isBigger(String.valueOf(expression.charAt(i)),operator.peek()))
                        operator.push(String.valueOf(expression.charAt(i)));
                    �����������ȼ�С�ڵ�ǰoperatorջ�������ȼ�����operatorջ���Ĳ�������ջ������endRePolish�еĲ��������кϳ��沨�����ʽ��ֱ��operatorջ���Ĳ�����Ϊ�ջ���opջ���Ĳ�����С�ڵ��ڲ�����
                    else {
                        while(!operator.isEmpty()&&!isBigger(String.valueOf(expression.charAt(i)),operator.peek())){
                             endRepolish.push(operator.pop());
                    }
                          operator.push(String.valueOf(expression.charAt(i)));
                    }*/
                }
            }
            //����������ֻ��߱���,ֱ�Ӽ��뵽endRePolish�У�
            else {
                k = i;//�ж����ֺ����Ƿ�Ϊ�����
                while (k < expression.length() && !isOperator(String.valueOf(expression.charAt(k))))
                    k++;
                endRepolish.push(expression.substring(i,k));
                i = k-1;
            }
        }
        //���opջ����Ȼ���в����������䵯�������沨�����ʽ�ĺϳ�
        while(!operator.isEmpty()){
            endRepolish.push(operator.pop());
        }
        return endRepolish;
    }
    //�����沨�����ʽ��ֵ
    public String computeResult(Stack<String> expression){
        Stack<String> compute = new Stack<>();//�������ս��
        //��expression�е����ݽ��з�ת
        while (!expression.isEmpty()){
            compute.push(expression.pop());
        }
        String SOperator = "\\d+";//�����ж������Ƿ�Ϊ���ֵ�������ʽ
        while(!compute.isEmpty()) {
            //���������,ֱ����ջ
            if (Pattern.matches(SOperator,compute.peek())){
                expression.push(compute.pop());
            }
            //��������������ջ���ϲ��������������������������㣬�����ջ
            else {
                String s1 = expression.pop();
                String s2 = expression.pop();
                String op = compute.pop();
                expression.push(compute(s2,s1,op));
            }
        }
        return String.valueOf(expression.peek());
    }
    //��������
    public String compute(String s1, String s2, String op){
        int result;
        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);
        switch (op){
            case "-":
                result = num1 - num2;
                break;
            case "+":
                result = num1 + num2;
                break;
            case"*":
                result = num1 * num2;
                break;
            case"/":
                result = num1 / num2;
                break;
                default:
                    return null;
        }
        op = String.valueOf(result);
        return op;
    }

    //�ж��Ƿ�Ϊ�����
    public boolean isOperator(String c){
        return c.equals("-")||c.equals("+")||c.equals("*")||c.equals("/")||c.equals("(")||c.equals(")");
    }
    //�жϲ����������ȼ�;���ȼ��Ӹߵ��� ��  /*  -+  ��
    public boolean isBigger(String s1,String s2){
        boolean flag = false;
        switch (s1){
            case "+":
            case "-":
                if(s2.equals("("))
                    flag = true;
                break;
            case "*":
            case "/":
               flag = true;
               break;
            default:
        }
        return flag;
    }



}
