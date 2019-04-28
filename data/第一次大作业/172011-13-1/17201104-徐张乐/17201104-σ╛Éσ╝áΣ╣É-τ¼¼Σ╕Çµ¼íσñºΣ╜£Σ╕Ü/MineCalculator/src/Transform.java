//中缀表达式转后缀表达式
public class Transform {

    String[] stack = new String[2000];
    String str = "";
    String now = "";
    String result = "";

    int len = 0;        //栈的长度
    int num = 0;        //左括号的数量
    int flag = 0;       //括号是否配对成功

    public Transform (String s){
        //建立最初的表达式
        this.str = s;
    }

    private void addEmpty(String str){
        //为表达式的每一部分添加空格
        int i = 0;
        for (i=0;i<str.length()-1;i++){
            char temp1 = str.charAt(i);
            char temp2 = str.charAt(i+1);

            if (Character.isDigit(temp1) && Character.isDigit(temp2)){
                //连续的数字
                now += temp1;
            }
            else if (temp1 == '(' && temp2 == '-'){
                //负数的情况，负数的输入加入括号保护
                now += temp1 + " " + temp2;
                i++;
            }
            else {
                //其他情况则视为单独的块
                now += temp1 + " ";
            }
        }

        //添加最后一个元素
        if (str.length() - 1 == i){
            now += str.charAt(str.length() - 1);
        }

    }

    private int priority(String s){
        //判断运算符号的优先级，*/的优先级大于+-
        if (s.equals("+") || s.equals("-")){
            return 1;
        }
        else {
            return 2;
        }
    }

    private void stackToTop(String s){
        //判断当前符号与栈顶符号的优先级并修正顺序
        int m = priority(s);

        while (len != 0) {
            String temp = stack[len--]; //取栈顶元素

            if (temp.equals("(")){
                //遇到“（”则添加并退出循环
                stack[++len] = temp;
                break;
            }
            else {
                //修正栈顶元素
                int n = priority(temp);

                if (n < m){
                    stack[++len] = temp;
                    break;
                }
                else {
                    result += " " + temp;
                }
            }
        }
        stack[++len] = s;
    }

    private void handleRightBrackets(){
        //处理遇到右括号的情况
        while (len != 0){

            String temp = stack[len--];

            if (temp.equals("(")){
                break;
            }
            else {
                result += " " + temp;
            }
        }
        this.num --;
        if (this.num < 0){
            this.flag = 1;
        }
    }

    public String transf_MtoA(){
        //中缀到后缀的转换
        addEmpty(this.str);     //将now字符串变为加了空格的字符串
        String[] strArr = now.split(" ");   //按照空格将其分割许多块

        for (int i = 0;i<strArr.length;i++){
            String temp = strArr[i];

            switch (temp){
                //判断字符串类型并与进行栈顶比较等操作
                case "+":
                case "-":
                    stackToTop(temp);
                    break;
                case "*":
                case "/":
                    stackToTop(temp);
                    break;
                case "(":
                    stack[++len] = temp;
                    this.num++;
                    break;
                case ")":
                    handleRightBrackets();
                    break;
                default:
                    result += " " + temp;
                    break;
            }
        }

        if (this.num != 0){
            //左括号还有剩余
            this.flag = 1;
        }

        while (len != 0){
            //后缀表达式最终生成
            result += " " + stack[len--];
        }

        return  result;
    }

    public boolean isTrue(){
        //判断是否可用
        if (flag == 1){
            return true;
        }
        else {
            return false;
        }
    }

}
