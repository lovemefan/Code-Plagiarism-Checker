package calculat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class calculat {
    void read(File f,String[] exp) {  //读取文件中的表达式并保存到数组中
        int i=0;
        try (Scanner input = new Scanner(f);){
            while(input.hasNextLine()) {
                exp[i] = input.nextLine();//将式子写入
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
        
    
    boolean match(String exp) {// 如果括号不匹配，则返回 true;否则返回false
        int len = exp.length();
        LinkedList<Character> stack = new LinkedList<Character>();
        // 循环遍历字符串
        for (int i = 0; i < len; i++) {
            // 如果是左括号则入栈
            char  ch = (char) exp.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                // 如果是右括号
            } else if (ch == ')') {
                // 栈空，则右括号没有匹配的左括号，则返回false
                if (stack.isEmpty()) {
                    return true;
                    // 栈不空，则和栈顶比较
                } else if (stack.peek().equals(ch)) {
                    return true;
                } else {
                    stack.pop();
                }
            }
        }
        // 循环结束后，栈空表示匹配完了，不空表示多余左括号
        if (stack.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }
    
    boolean judge(String exp) { //通过正则表达式判断表达式是否符合规则
        String regex1 = " ";//空字符
        String regex2 = "\\(\\)";//空括号
        String regex3 = "[\\~!/@#$%^&*\\\\-_=+\\\\|[{}];:\\'\\\",<.>/?]+";//非法字符
        String regex4 = ".[\\/\\*\\-\\+]{2,}.";//运算符连续
        String regex5 = "^[\\+\\-\\*\\/\\)].*";//运算符前无运算数
        String regex6 = ".*[\\(\\+\\/\\*\\-]";//运算符后无运算数
        String regex7 = ".*\\d\\(.*";//括号前无运算符,且括号不是第一个
        String regex8 = ".*\\)\\d.*";//括号后无运算符
        if(exp!=null) {
        if (exp.matches(regex1) == true )
        {
            System.out.println("表达式为: 空"+exp);
            System.out.println( "#ERROR");
            System.out.println("非空字符错误");
            System.out.println("已跳过计算");
            System.out.println(" ");
            return false;
            
        }
        else if (exp.matches(regex2) == true ) {
            System.out.println("表达式为: "+exp);
            System.out.println("#ERROR");
            System.out.println("表达式中有空括号 ");
            System.out.println("已跳过计算");
            System.out.println(" ");
            return false;
        }
        else if ( exp.matches(regex3) == true ) {
            System.out.println("表达式为: "+exp);
            System.out.println("#ERROR ");
            System.out.println("表达式有非法字符 ");
            System.out.println("已跳过计算");
            System.out.println(" ");
            return false;
        }
        else if ( match(exp) == true ) {
            System.out.println("表达式为: "+exp);
            System.out.println("#ERROR ");
            System.out.println("括号不匹配 ");
            System.out.println("已跳过计算");
            System.out.println(" ");
            return false;
        }
        else if ( exp.matches(regex4) == true ) {
            System.out.println("表达式为: "+exp);
            System.out.println("#ERROR ");
            System.out.println("运算符连续");
            System.out.println("已跳过计算");
            System.out.println(" ");
            return false;
        }
        else if ( exp.matches(regex5) == true ) {
            System.out.println("表达式为: "+exp);
            System.out.println("#ERROR ");
            System.out.println("运算符前无运算数"); 
            System.out.println("已跳过计算");
            System.out.println(" ");
            return false;
        }
        else if ( exp.matches(regex6) == true ) {
            System.out.println("表达式为: "+exp);
            System.out.println("#ERROR ");
            System.out.println("运算符后无运算数");
            System.out.println("已跳过计算");
            System.out.println(" ");
            return false;
        }
        else if ( exp.matches(regex7) == true ) {
            System.out.println("表达式为: "+exp);
            System.out.println("#ERROR ");
            System.out.println("括号非第一个字符且之前无运算符");
            System.out.println("已跳过计算");
            System.out.println(" ");
            return false;

        }
        else if (exp.matches(regex8) == true ) {
            System.out.println("表达式为: "+exp);
            System.out.println("#ERROR ");
            System.out.println("小括号后无运算符，括号非最后一个字符");
            System.out.println("已跳过计算");
            System.out.println(" ");
            return false;
        }
        else 
        {
            return true;
        }
        }
        else
            return false;
    }
    
    public void write(File f,String[] exp) throws FileNotFoundException { //将结果写入文件
        int i=0;
      try(  PrintWriter output=new PrintWriter(f))
      {
        for(i=0;i<exp.length-1;i++){
            if(!judge(exp[i])) {
              System.out.println("");
            }
            else {
                output.print("表达式为: "+exp[i]+" = ");             
                nmsl x=new nmsl(exp[i]);     
                int re=x.jisuan();
                
                output.println(re);
            }
        }
      }
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
        String[] exp=new String[17];
        File f1=new File("src/input");
        File f2=new File("src/output");
        calculat x=new calculat();
        x.read(f1, exp);
        x.write(f2, exp);
        //x.output(f2);
    }
}
