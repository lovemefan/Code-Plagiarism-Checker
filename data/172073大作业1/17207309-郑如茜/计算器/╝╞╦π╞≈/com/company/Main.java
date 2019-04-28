package com.company;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("user.dir"));
        java.io.File file = new java.io.File("com/company/input.txt");
        java.io.File file1 = new java.io.File("com/company/output.txt");
        java.io.PrintWriter output = new java.io.PrintWriter(file1);
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String s = "";
            s = input.nextLine();

            if (funcFalseType(s, output) == false)
                continue;
            MidToLater init = new MidToLater(s);
            String temp = "";
            temp = init.handleNow();
            Calc c = new Calc(temp);
            Double ans = c.calculation();
            output.println(s + "=" + ans);
        }
        output.close();
        input.close();
    }

    // 判断数学表达式正误
    static boolean funcFalseType(String str, java.io.PrintWriter output) throws Exception {
        if (check(str) == false) {
            output.println("ERROR #数学表达式括号不符合格式");
            return false;
        }
        if (checkNumber(str) == true) {
            output.println("ERROR #数学表达式中有运算符旁不存在数字");
            return false;
        }
        if (str == "") {
            output.println("ERROR #数学表达式为空或者不存在");
            return false;
        }
        if (str.matches("[^\\.]*[+\\-*/][+*/]+[^\\.]*") == true) {
            output.println("ERROR #数学表达式中有运算符连续");
            return false;
        }
        if (str.matches("[\\S]*[)][^+\\-*/)][\\S]*") == true) {
            output.println("ERROR #数学表达式中')'后面不是运算符");
            return false;
        }
        if (str.matches("[\\S]*[^+\\-*/(][(][\\S]*") == true) {
            output.println("ERROR #数学表达式中'('前面不是运算符");
            return false;
        }
        if (str.matches("[+\\-*/0-9.()]*") == false) {
            output.println("ERROR #数学表达式中有非法字符");
            return false;
        }
        return true;
    }

    // 判断括号配对
    static boolean check(String s) {
        // num1记录(数目,num2记录)数目
        int num1 = 0, num2 = 0;
        for (int i = 0; i != s.length(); ++i)
            if (s.charAt(i) == '(')
                ++num1;
            else if (s.charAt(i) == ')')
                ++num2;
        if (num1 != num2) {
            return false;
        } else
            return true;
    }

    // 判断数学表达式运算符旁有没有数字
    static boolean checkNumber(String s) {
        if (s.matches("[\\S]*[+\\-*/]") == true || s.matches("[+*/][\\S]*") == true) {
            return true;
        } else
            return false;
    }
}

// 计算数学表达式
class Calc {
    String s = ""; // 后缀表达式
    Double[] integer = new Double[1005];// 栈
    Integer len; // 栈的长度

    Calc(String s) {
        this.s = s;
        this.len = 0;

    }

    // 判断是否是数字
    private boolean isDigital(String str) {
        Integer len = str.length();// 字符串的长度
        // 长度为1时只判断第一位
        if (len == 1 && Character.isDigit(str.charAt(0)))
            return true;
            // 长度为2时判断第二位避开负数的情况
        else if (len > 1 && Character.isDigit(str.charAt(1)))
            return true;
        // 如果两个都不符合的话就返回false
        return false;

    }

    private Double calc(String str) {
        Double re = 0.0; // 计算结果的初始化
        Double m = integer[len--]; // 栈顶元素
        Double n = integer[len--]; // 栈顶的下一个元素
        // 不同的运算符
        switch (str) {
            case "+":
                re = n + m;
                break;
            case "-":
                re = n - m;
                break;
            case "*":
                re = n * m;
                break;
            case "/":
                re = n / m;
                break;
            default:
                break;
        }
        return re;
    }

    // 计算过过程
    public Double calculation() {
        String[] strArr = s.split(" "); // 以空格作为分隔做成字符串数组
        for (Integer i = 0; i < strArr.length; i++) {
            String temp = strArr[i];

            // 判断是否是数字，包括负数
            if (isDigital(temp)) {
                integer[++len] = (double) Integer.valueOf(temp);
            }
            // 不是数字则取出栈顶元素和栈顶下一个元素进行运算
            else {
                if (len >= 2) {
                    Double result = calc(temp);
                    integer[++len] = result; // 将所得结果放入栈顶

                }
            }
        }
        return integer[len--];
    }

}

// 中缀转后缀
class MidToLater {
    String[] stack = new String[1005];
    String post = "";// 输入的表达式，去掉啦所有的空格
    String now = "";// 加入空格之后的表达式
    String result = "";// 得到的后缀表达式
    int len = 0;// 栈的长的
    int num = 0;// 栈内左括号的数目
    int flag = 0; // 表达式括号是否配对
    // 判断运算符的优先级 +-为1级 */为2级
    // 处理）

    private void handleBrackets() {
        while (len != 0) {
            // 得到栈顶元素
            String temp = stack[len--];
            // 遇到（则退出循环否则将栈顶元素输出
            if (temp.equals("(")) {
                break;
            } else {
                result += " " + temp;
            }
        }
        this.num--;
        // 如果栈内的左括号减到负数说明括号不匹配
        if (this.num < 0)
            flag = 1;
    }

    private int check(String s) {
        if (s.equals("+") || s.equals("-"))
            return 1;
        else
            return 2;
    }

    // 与栈顶比较不小于则将栈顶元素弹出直到小于栈顶元素
    private void handleSymbol(String s) {
        int a = check(s); // 将要被加入的运算符
        while (len != 0) {
            // 栈顶元素
            String temp = stack[len--];
            // 遇到（则将（重新加入栈并退出循环
            if (temp.equals("(")) {
                stack[++len] = temp;
                break;
            }
            // 将栈顶元素弹出直到小于栈顶元素
            else {
                int b = check(temp);
                // 比较将要加入的运算符和栈顶元素的优先级
                if (b < a) {
                    stack[++len] = temp;// 大于则重新加入栈顶元素并退出
                    break;
                }
                // 小于则将栈顶元素输出
                else
                    result += " " + temp;
            }
        }
        // 将需要加入的运算符加入
        stack[++len] = s;
    }

    // 中缀转后缀
    public String handleNow() {
        handlePost(this.post); // 得到加入空格后的表达式now
        String[] nowArr = now.split(" "); // 以空格作为分隔做成字符串数组
        for (int i = 0; i < nowArr.length; i++) {
            String str = nowArr[i];
            // 判断字符串的类型
            switch (str) {
                // +-*/与栈顶比较不小于则将栈顶元素弹出直到小于栈顶元素
                case "+":
                case "-":
                    handleSymbol(str);
                    break;
                case "*":
                case "/":
                    handleSymbol(str);
                    break;
                // （直接入栈
                case "(":
                    stack[++len] = str;
                    this.num++; // 栈内左括号数目加一
                    break;
                // 清空栈顶元素直到遇见一个（
                case ")":
                    handleBrackets();
                    break;
                default:
                    result += " " + str;
                    break;
            }
        }
        // 栈内的左括号未完全消除
        if (this.num != 0)
            this.flag = 1;
        // 将栈中的符号清空
        while (len != 0) {
            result += " " + stack[len--];
            // 返回得到的后缀表达式
        }

        return result;
    }

    MidToLater(String s) {
        this.post = s;
        len = 0;
        this.flag = 0;
    }

    public boolean getTrue() {
        if (this.flag == 1)
            return true;
        else
            return false;
    }

    // 输入的表达式符号和数字之间加入空格
    private void handlePost(String post) {
        Integer i = 0;
        for (i = 0; i < post.length() - 1; i++) {

            char temp1 = post.charAt(i);// 当前位置
            char temp2 = post.charAt(i + 1);// 下一位
            // 判断当前位和下一位是否是数字
            if (Character.isDigit(temp1) && Character.isDigit(temp2)) {
                now += temp1;
            }
            // 判断负数
            else if (i == 0 && temp1 == '-') {
                now += temp1;
            } else if (temp2 == '-') {
                now += temp1 + " " + temp2;
                i++;
            }
            // 符号
            else {
                now += temp1 + " ";
            }
        }
        if (post.length() - 1 == i)
            now += post.charAt(post.length() - 1); // 将最后一个元素添加进去
    }

}
