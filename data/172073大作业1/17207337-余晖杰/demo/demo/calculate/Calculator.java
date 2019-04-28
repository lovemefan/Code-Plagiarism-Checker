package calculate;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 计算器类
 */
public class Calculator {
    private String expression;//算术表达式
    private Map<String, Integer> map = new HashMap<>();
    public Calculator(String expression) {// 存储运算符优先级，value越大代表优先级越大
        map.put("+", 0);
        map.put("-", 0);
        map.put("*", 1);
        map.put("/", 1);
        map.put("(", -1);
        map.put(")", -1);
        map.put("#", -2);
        this.expression = expression;
    }
    /**
     * 表达式合法性检验
     */
    private void check() throws FormatException {
    	// 使用Stack变量来存储左右括号的出现
        Stack<Character> brackets = new Stack<>();
        // 上一个出现的字符，不含括号
        char lastChar = ' ';
        // 将算术表达式转换成字符数组
        char[] chars = expression.toCharArray();
        // 循环遍历整个字符数组
        if(containsIllegals(expression))throw new FormatException("ERROR\n"+"#表达式包含非法字符");
        if (chars.length == 0) throw new FormatException("ERROR\n"+"#表达式为空");
        	
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                	// 遇到`(`压入栈
                    brackets.push(chars[i]);
                    if(i==chars.length-1)throw new FormatException("ERROR\n"+"#括号不匹配");//括号不匹配
                    if(i!=0&&Character.isDigit(chars[i-1]))throw new FormatException("ERROR\n"+"#括号非第一个字符串且之前无运算符");//小括号前无运算符，括号非第一个字符                                  
                    if (chars[i + 1] == ')' )throw new FormatException("ERROR\n"+"#表达式中有空括号");
                    break;
                case ')':
                	 // 遇到`)`弹出栈，若栈空，则代表括号未成对出现，抛出异常
                	if(i!=chars.length - 1&&Character.isDigit(chars[i+1]))throw new FormatException("ERROR\n"+"#小括号后无运算符，括号非最后一个字符");//小括号后无运算符，括号非最后一个字符                                  
                    if (brackets.empty() || brackets.pop() != '(') throw new FormatException("ERROR\n"+"#括号不匹配");//括号不匹配
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                	// 如果运算符出现在开头或末尾，抛出异常                  
                	if(i==0||chars[i - 1] == '(')throw new FormatException("ERROR\n"+"#运算符前无运算数");//运算符前无运算数
                    if(i==chars.length - 1||chars[i - 1] == '）')throw new FormatException("ERROR\n"+"#运算符后无运算数");//运算符后无运算数
                    // 如果运算符的前一位是运算符或左括号，抛出异常
                    if (chars[i - 1] == '+' || chars[i - 1] == '-' || chars[i - 1] == '*' || chars[i - 1] == '/' ||chars[i + 1] == '+' || chars[i + 1] == '-' || chars[i + 1] == '*' || chars[i + 1] == '/' )
                        throw new FormatException("ERROR\n"+"#运算符连续");
                    // 如果运算符的后一位是运算符或右括号，抛出异常  
                    lastChar = chars[i];// 存储这次读取到的运算符
                    break;
                case '0':
                    if (lastChar == '/') throw new FormatException("除数不能为0");
                    break;
                default:
                	  // 存储这次读取到的运算符
                    lastChar = chars[i];
                    break;
            }
        }
        // 若遍历结束后，栈未空，则代表括号未成对出现，抛出异常
        if (!brackets.empty()) throw new FormatException("ERROR\n"+"#括号不匹配");//括号未成对出现
    }

    /**
     * 转化为逆波兰式
     *
     * @return 存储在Stack中的逆波兰表达式
     * @throws FormatException 
     */
    private Stack<String> convert2RPN() throws FormatException {
        Stack<String> s1 = new Stack<>();// 声明栈S1
        Stack<String> s2 = new Stack<>();// 声明栈S2
        s1.push("#"); // 将最低优先级的#符号放入S1栈，为了方便统一后续操作
        char[] chars = expression.toCharArray();   // 将算术表达式转换成字符数组
        // 循环遍历字符数组
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                	  // 读取到左括号，直接压入S1栈

                    s1.push(chars[i] + "");
                    break;
                case ')':
                	// 若取出的字符是“）”，则将距离S1栈栈顶最近的“（”之间的运算符，逐个出栈，依次送入S2栈，此时抛弃“（”。

                    do {
                        s2.push(s1.pop());
                      
                    } while (!s1.peek().equals("("));
                    s1.pop();
                    break;
               
                case '+':
                case '-':
                case '*':
                case '/':
                //  若取出的字符是运算符，则将该运算符与S1栈栈顶元素比较，
                    // 如果该运算符优先级(不包括括号运算符)大于S1栈栈顶运算符优先级，则将该运算符进S1栈，
                    // 否则，将S1栈的栈顶运算符弹出，送入S2栈中，直至S1栈栈顶运算符低于（不包括等于）该运算符优先级，
                    // 最后将该运算符送入S1栈。

                    if (map.get(String.valueOf(chars[i])) > map.get(s1.peek())) {
                        s1.push(chars[i] + "");
                    } else {
                        do {
                            s2.push(s1.pop());
                     
                        } while (!(map.get(chars[i] + "") > map.get(s1.peek())));
                        s1.push(chars[i] + "");
                    }
                    break;
                default:

                 StringBuilder sb = new StringBuilder();
                 // 处理俩位以上的数以及小数的读取
                    while (Character.isDigit(chars[i]) || chars[i] == '.') {// 若取出的字符是操作数，则分析出完整的运算数
                        sb.append(chars[i]);
                        if (i < chars.length - 1 && (Character.isDigit(chars[i + 1]) || chars[i + 1] == '.')) {
                            i++;
                        } else {
                            break;
                        }
                    }
                    // 该操作数直接送入S2栈
                    s2.push(sb.toString());
                    break;
            }
        }
        // 将S1栈内所有运算符（不包括“#”），逐个出栈，依次送入S2栈
        while (!s1.peek().equals("#")) {
            s2.push(s1.pop());
        }
        // S2应做一下逆序处理
        Stack<String> stack = new Stack<>();
        while (!s2.empty()) {
            stack.push(s2.pop());
        }
        // 返回S2的逆序栈
        return stack;
    }

    /**
     * 计算结果
     * @return 表达式计算结果
     */
    public double calculate() throws FormatException {
        check();
        double result;
        Stack<String> tmp = new Stack<>();//创建一个String类型的栈实例 
        Stack<String> stack = convert2RPN();
        while (!stack.empty()) {
            String s = stack.pop();
            if (Character.isDigit(s.charAt(0))) {
                tmp.push(s);
            } else {
                double a = Double.valueOf(tmp.pop());
                double b = Double.valueOf(tmp.pop());
                switch (s) {
                    case "+":
                        tmp.push(String.valueOf(add(a, b)));
                        break;
                    case "-":
                        tmp.push(String.valueOf(delete(b, a)));
                        break;
                    case "*":
                        tmp.push(String.valueOf(multiply(a, b)));
                        break;
                    case "/":
                        tmp.push(String.valueOf(divide(b, a)));
                        break;
                }
            }
        }
        result = Double.valueOf(tmp.pop());
        return result;
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double delete(double a, double b) {
        return a - b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double divide(double a, double b) {
        BigDecimal b1 = new BigDecimal(a);
        BigDecimal b2 = new BigDecimal(b);
        return b1.divide(b2, 3, BigDecimal.ROUND_HALF_UP).doubleValue();//ROUND_HALF_UP向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向上舍入, 1.55保留一位小数结果为1.6


    }
    
    
    
    public boolean containsIllegals(String toExamine) {//模式匹配检验输入不合法字符
        Pattern pattern = Pattern.compile("[~#@%$&，?？！abcdefghijklmnopqrstuvwxyz=ABCDEFGHIJKLMNOPQRSTUVWXYZ；{}（）<>|!\"_^;',。￥]");
        Matcher matcher = pattern.matcher(toExamine);
        return matcher.find();//find()对字符串进行匹配,匹配到的字符串可以在任何位置. 
    }
}

class FormatException extends Exception {	//自定义表达式不合法异常类
    public FormatException(String message) {
        super(message);
    }
}

