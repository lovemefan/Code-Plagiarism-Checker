import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculater {
	private String s;
	
	Calculater(String s){//构造方法
		this.s=s;
	}
	
	//两位数的四则运算
	public double doubleCal(double a1, double a2, char operator) throws Exception {
        switch (operator) {
        case '+':
            return a1 + a2;
        case '-':
            return a1 - a2;
        case '*':
            return a1 * a2;
        case '/':
            return a1 / a2;
        }
        throw new Exception("illegal operator!");
    }
	
	//运算符的优先级
	public int getPriority(String str)throws Exception   {
        if(str==null) return 0;
        switch(str) {
        case "(":return 1;
        case "+":
        case "-":return 2;
        case "*":
        case "/":return 3;
        }
        throw new Exception("illegal operator!");
    }
	
	//将中缀表达式转化成后缀表达式
	public String toSufExpr() throws Exception {
        StringBuffer sufExpr = new StringBuffer();
        Stack<String> operator = new Stack<String>();/*盛放运算符的栈*/
        operator.push(null);//在栈顶压人一个null，配合它的优先级，减少下面程序的判断
        /* 将表达式打散分散成运算数和运算符 */
        Pattern p = Pattern.compile("(?<!\\d)-?\\d+(\\.\\d+)?|[+\\-*/()]");//这个正则为匹配表达式中的数字或运算符
        Matcher m = p.matcher(s);
        while (m.find()) {
            String temp = m.group();
            if (temp.matches("[+\\-*/()]")) { //是运算符
                if (temp.equals("(")) { //遇到左括号，直接压栈
                    operator.push(temp);
                } else if (temp.equals(")")) { //遇到右括号，弹栈输出直到弹出左括号（左括号不输出）
                    String topItem = null;
                    while (!(topItem =operator.pop()).equals("(")) {
                        sufExpr.append(topItem+" ");
                    }
                } else {//遇到运算符，比较栈顶符号，若该运算符优先级大于栈顶，直接压栈；若小于栈顶，弹栈输出直到大于栈顶，然后将改运算符压栈。
                    while(getPriority(temp) <= getPriority(operator.peek())) {
                        sufExpr.append(operator.pop()+" ");
                    }
                    operator.push(temp);
                }
            }else {//遇到数字直接输出
                sufExpr.append(temp+" ");
            }
        }
        String topItem = null;//最后将符合栈弹栈并输出
        while(null != (topItem =operator.pop())) {
            sufExpr.append(topItem+" ");
        }
        return sufExpr.toString();
    }
	
	//根据后缀表达式计算结果
	public String getResult() throws Exception {
        String sufExpr = toSufExpr();// 转为后缀表达式
        Stack<Double> number = new Stack<Double>(); /* 盛放数字栈 */
        /* 这个正则匹配每个数字和符号 */
        Pattern p = Pattern.compile("-?\\d+(\\.\\d+)?|[+\\-*/]");
        Matcher m = p.matcher(sufExpr);
        while (m.find()) {
            String temp = m.group();
            if (temp.matches("[+\\-*/]")) {// 遇到运算符，将最后两个数字取出，进行该运算，将结果再放入容器
                double a1 = number.pop();
                double a2 = number.pop();
                double res = doubleCal(a2, a1, temp.charAt(0));
                number.push(res);
            } else {// 遇到数字直接放入容器
                number.push(Double.valueOf(temp));
            }
        }
       return s+"="+number.pop();
    }
	
}
