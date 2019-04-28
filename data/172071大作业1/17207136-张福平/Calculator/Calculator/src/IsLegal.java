import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsLegal {
    //�ж��Ƿ������������
    private boolean isOperator(Character character) {
        return character == '+' || character == '-' || character == '*'
                || character == '/';
    }
    //1.�жϱ��ʽ�Ƿ�Ϊ��
    private boolean isTrue1(String str) {
        if(str.matches(""))
            return true;
        else
            return false;
    }
    //2.�ж������Ƿ��зǷ��ַ�
    private boolean isTrue2(String str) {
        if(str.matches("[\\+\\-\\*\\d\\.\\/\\(\\)]*"))
            return false;
        else
            return true;

    }
    //3.�жϱ��ʽ�����ŵ�����Ƿ�ɹ�
    private boolean isTrue3(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                stack.push(str.charAt(i));
            else if (str.charAt(i) == ')') {
                if (stack.empty())
                    return true;
                if (stack.peek() == '(')
                    stack.pop();
                else
                    return true;
            }
        }
        return !stack.empty() ? true : false;
    }
    //4.�ж��ַ�������û�п�����
    private boolean isTrue4(String str) {
        Pattern p = Pattern.compile("\\(\\)");
        Matcher m = p.matcher(str);
        return m.find();

    }
    //5.�������Ч�������ǰ����������
    private boolean isTrue5(String str){
        Pattern p = Pattern.compile("^[\\+\\-\\*\\/]");//�����ǰ��������
        Matcher m = p.matcher(str);
        return m.find();
    }
    //6.�������Ч�������������������
    private boolean isTrue6(String str){
        for (int i = 0; i < str.length(); i++) {
            if (isOperator(str.charAt(i))&& i< str.length()-1){//�жϵ�ǰ�ַ��Ƿ��������
                if (isOperator(str.charAt(i+1))||str.charAt(i+1) == ')'){
                    return true;
                }
            }
            if (isOperator(str.charAt(i))&&i==str.length()-1)
                return true;
        }
        return false;
    }
    //7.���������
    private boolean isTrue7(String str){
        Pattern p = Pattern.compile("[\\+\\-\\*\\/\\)]{2,}");
        Matcher m = p.matcher(str);
        if (m.find())
        {
            Pattern j = Pattern.compile("[\\+\\-\\*\\/]{2,}");
            Matcher matcher = j.matcher(str);
            return matcher.find();
        }
        return m.find();
    }
    //8.�������Ч��С����ǰ������������ŷǵ�һ���ַ���
    private boolean isTrue8(String str){
        String regex = ".*\\d\\(.*";
        return str.matches(regex);

    }
    //9.�������Ч��С���ź�������������ŷ����һ���ַ���
    private boolean isTrue9(String str){
        String regex = ".*\\)\\d.*";
        return str.matches(regex);
    }
    private int test(String str){
        /* ���ǰ��,�ĸ��������� */
        if (isTrue1(str))
                return 1;
        if (isTrue2(str))
                return 2;
        if (isTrue7(str))
            return 7;
        if (isTrue3(str))
                return 3;
        if (isTrue4(str))
                return 4;

        else{
            if (isTrue8(str))
                return 8;
            if (isTrue9(str))
                return 9;
            if (isTrue6(str))
                return 6;
            if (isTrue5(str))
                return 5;
        }

        return 0;
    }
    //�����д���������list��,������
    public ArrayList<String>judge(ArrayList<String> list1){
        ArrayList<String> list = new ArrayList<>();
        IsLegal legal = new IsLegal();
        Calc calc = new Calc();
        for (int i = 0; i <list1.size() ; i++) {
            switch (legal.test(list1.get(i))){
                case 0:
                    list.add(calc.test(list1.get(i)));
                    break;
                case 1:
                    list.add("ERROR");
                    list.add("#���ʽΪ��");
                    break;
                case 2:
                    list.add("ERROR");
                    list.add("#���ʽ�����Ƿ��ַ�");
                    break;
                case 3:
                    list.add("ERROR");
                    list.add("#���Ų�ƥ��");
                    break;
                case 4:
                    list.add("ERROR");
                    list.add("#���ʽ���п�����");
                    break;
                case 5:
                    list.add("ERROR");
                    list.add("#�����ǰ��������");
                    break;
                case 6:
                    list.add("ERROR");
                    list.add("#���������������");
                    break;
                case 7:
                    list.add("ERROR");
                    list.add("#���������");
                    break;
                case 8:
                    list.add("ERROR");
                    list.add("#���ŷǵ�һ���ַ���֮ǰ�������");
                    break;
                case 9:
                    list.add("ERROR");
                    list.add("#С���ź�������������ŷ����һ���ַ�");
                    break;
                    default: break;
            }
        }
        return list;

    }


}
