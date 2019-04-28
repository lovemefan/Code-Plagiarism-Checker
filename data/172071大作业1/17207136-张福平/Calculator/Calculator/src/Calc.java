
import java.math.BigDecimal;
import java.util.Stack;

public class Calc{


    /* ���ʽ��ֵ ���ؼ���Ľ��*/

    public BigDecimal calc(String resExp){
        String[] exp = inExpToSuffixExp(resExp).split(",");
        //����һ����Ų�������ջ
        Stack<String> stack = new Stack<>();
        for(int i=0;i<exp.length;i++){
            if(!isOperator(exp[i])){
                //����ǲ�������ѹ�����ջ
                stack.push(exp[i]);
            }else{
                //����ǲ�����������ջ�п���ջ��������������
                BigDecimal num2 = new BigDecimal(stack.pop());
                BigDecimal num1 = new BigDecimal(stack.pop());
                if("+".equals(exp[i])){
                    //����+�ţ����������������,Ȼ�󽫽��ѹջ
                    stack.push(""+num1.add(num2));
                }else if("-".equals(exp[i])){
                    //����-�ţ����������������,Ȼ�󽫽��ѹջ
                    stack.push(""+num1.subtract(num2));
                }else if("*".equals(exp[i])){
                    //����*�ţ����������������,Ȼ�󽫽��ѹջ
                    stack.push(""+num1.multiply(num2));
                }else if("/".equals(exp[i])){
                    //����/�ţ����������������,Ȼ�󽫽��ѹջ
                    stack.push(""+num1.divide(num2));
                }
            }
        }
        //�����Ľ������������
        return new BigDecimal(stack.pop());
    }

    /*
     ����׺���ʽת���ɺ�׺���ʽ(��,��)
     */
    public String inExpToSuffixExp(String resExp) {
        String[] inExp = dealInExp(resExp).split(",");
        Stack<String> stack = new Stack<>();
        StringBuilder suffixExp = new StringBuilder();
        for (String s : inExp) {
            if (!isOperator(s)) {
                // �������֣�ֱ�����
                suffixExp.append(s + ",");
            } else if ("(".equals(s)) {
                // ����������,ֱ��ѹջ
                stack.push(s);
            } else if (")".equals(s)) {
                // ���������ţ���ջ��Ԫ�����ε�����ֱ������������
                while (!"(".equals(stack.get(stack.size() - 1))) {
                    suffixExp.append(stack.pop() + ",");
                }
                // ���������ŵ������
                stack.pop();
            } else if (isOperator(s)) {
                // ���������,��ǰ��������ȼ�С�ڵ���ջ����������ȼ�����ջ�����������
                // ��ǰ������������µ�ջ��������Ƚ�...
                while (!stack.isEmpty()
                        &&getPriority(s)<=getPriority(stack.get(stack.size()-1))){
                    suffixExp.append(stack.pop() + ",");
                }
                stack.push(s);
            }
        }
        // ���,��ջ�ڻ�û�е�������������ε���
        while (!stack.isEmpty()) {
            suffixExp.append(stack.pop() + ",");
        }
        // ȥ�����һ��,��
        suffixExp.delete(suffixExp.length() - 1, suffixExp.length());
        return suffixExp.toString();
    }

    /*
     ���ش�������׺���ʽ
     */
    private String dealInExp(String resExp) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resExp.length(); i++) {
            String tmp = resExp.substring(i, i + 1);
            if (!isOperator(tmp)||tmp.equals("-")) {
                sb.append(tmp);
            } else {
                if (sb.length() == 0) {
                    sb.append(tmp + ",");
                } else if (sb.charAt(sb.length() - 1) == ',') {
                    sb.append(tmp + ",");
                } else {
                    sb.append("," + tmp + ",");
                }
            }
        }
        return sb.toString();
    }

     /*�ж��ǲ��������*/

    private boolean isOperator(String str) {
        return "+-*/()".contains(str);
    }

    /*��ȡ����������ȼ�*/

    private int getPriority(String operator) {
        return "()+-*/".indexOf(operator)/2;
    }
    /*
    ���ؼ����ı��ʽ
     */
    public String test(String str){
        String resExp = str;
        String string = resExp + "=" + calc(resExp);
        return string;
    }

}
