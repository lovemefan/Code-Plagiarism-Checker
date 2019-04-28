import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsLegal {
    //判断是否是四则运算符
    private boolean isOperator(Character character) {
        return character == '+' || character == '-' || character == '*'
                || character == '/';
    }
    //1.判断表达式是否为空
    private boolean isTrue1(String str) {
        if(str.matches(""))
            return true;
        else
            return false;
    }
    //2.判断括号是否有非法字符
    private boolean isTrue2(String str) {
        if(str.matches("[\\+\\-\\*\\d\\.\\/\\(\\)]*"))
            return false;
        else
            return true;

    }
    //3.判断表达式中括号的配对是否成功
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
    //4.判断字符串中有没有空括号
    private boolean isTrue4(String str) {
        Pattern p = Pattern.compile("\\(\\)");
        Matcher m = p.matcher(str);
        return m.find();

    }
    //5.运算符无效（运算符前无运算数）
    private boolean isTrue5(String str){
        Pattern p = Pattern.compile("^[\\+\\-\\*\\/]");//运算符前无运算数
        Matcher m = p.matcher(str);
        return m.find();
    }
    //6.运算符无效（运算符后无运算数）
    private boolean isTrue6(String str){
        for (int i = 0; i < str.length(); i++) {
            if (isOperator(str.charAt(i))&& i< str.length()-1){//判断当前字符是否是运算符
                if (isOperator(str.charAt(i+1))||str.charAt(i+1) == ')'){
                    return true;
                }
            }
            if (isOperator(str.charAt(i))&&i==str.length()-1)
                return true;
        }
        return false;
    }
    //7.运算符连续
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
    //8.运算符无效（小括号前无运算符，括号非第一个字符）
    private boolean isTrue8(String str){
        String regex = ".*\\d\\(.*";
        return str.matches(regex);

    }
    //9.运算符无效（小括号后无运算符，括号非最后一个字符）
    private boolean isTrue9(String str){
        String regex = ".*\\)\\d.*";
        return str.matches(regex);
    }
    private int test(String str){
        /* 五大前提,四个条件并行 */
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
    //将所有处理结果存入list中,并返回
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
                    list.add("#表达式为空");
                    break;
                case 2:
                    list.add("ERROR");
                    list.add("#表达式包含非法字符");
                    break;
                case 3:
                    list.add("ERROR");
                    list.add("#括号不匹配");
                    break;
                case 4:
                    list.add("ERROR");
                    list.add("#表达式中有空括号");
                    break;
                case 5:
                    list.add("ERROR");
                    list.add("#运算符前无运算数");
                    break;
                case 6:
                    list.add("ERROR");
                    list.add("#运算符后无运算数");
                    break;
                case 7:
                    list.add("ERROR");
                    list.add("#运算符连续");
                    break;
                case 8:
                    list.add("ERROR");
                    list.add("#括号非第一个字符且之前无运算符");
                    break;
                case 9:
                    list.add("ERROR");
                    list.add("#小括号后无运算符，括号非最后一个字符");
                    break;
                    default: break;
            }
        }
        return list;

    }


}
