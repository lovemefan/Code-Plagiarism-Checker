package calculate;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ��������
 */
public class Calculator {
    private String expression;//�������ʽ
    private Map<String, Integer> map = new HashMap<>();
    public Calculator(String expression) {// �洢��������ȼ���valueԽ��������ȼ�Խ��
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
     * ���ʽ�Ϸ��Լ���
     */
    private void check() throws FormatException {
    	// ʹ��Stack�������洢�������ŵĳ���
        Stack<Character> brackets = new Stack<>();
        // ��һ�����ֵ��ַ�����������
        char lastChar = ' ';
        // ���������ʽת�����ַ�����
        char[] chars = expression.toCharArray();
        // ѭ�����������ַ�����
        if(containsIllegals(expression))throw new FormatException("ERROR\n"+"#���ʽ�����Ƿ��ַ�");
        if (chars.length == 0) throw new FormatException("ERROR\n"+"#���ʽΪ��");
        	
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                	// ����`(`ѹ��ջ
                    brackets.push(chars[i]);
                    if(i==chars.length-1)throw new FormatException("ERROR\n"+"#���Ų�ƥ��");//���Ų�ƥ��
                    if(i!=0&&Character.isDigit(chars[i-1]))throw new FormatException("ERROR\n"+"#���ŷǵ�һ���ַ�����֮ǰ�������");//С����ǰ������������ŷǵ�һ���ַ�                                  
                    if (chars[i + 1] == ')' )throw new FormatException("ERROR\n"+"#���ʽ���п�����");
                    break;
                case ')':
                	 // ����`)`����ջ����ջ�գ����������δ�ɶԳ��֣��׳��쳣
                	if(i!=chars.length - 1&&Character.isDigit(chars[i+1]))throw new FormatException("ERROR\n"+"#С���ź�������������ŷ����һ���ַ�");//С���ź�������������ŷ����һ���ַ�                                  
                    if (brackets.empty() || brackets.pop() != '(') throw new FormatException("ERROR\n"+"#���Ų�ƥ��");//���Ų�ƥ��
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                	// �������������ڿ�ͷ��ĩβ���׳��쳣                  
                	if(i==0||chars[i - 1] == '(')throw new FormatException("ERROR\n"+"#�����ǰ��������");//�����ǰ��������
                    if(i==chars.length - 1||chars[i - 1] == '��')throw new FormatException("ERROR\n"+"#���������������");//���������������
                    // ����������ǰһλ��������������ţ��׳��쳣
                    if (chars[i - 1] == '+' || chars[i - 1] == '-' || chars[i - 1] == '*' || chars[i - 1] == '/' ||chars[i + 1] == '+' || chars[i + 1] == '-' || chars[i + 1] == '*' || chars[i + 1] == '/' )
                        throw new FormatException("ERROR\n"+"#���������");
                    // ���������ĺ�һλ��������������ţ��׳��쳣  
                    lastChar = chars[i];// �洢��ζ�ȡ���������
                    break;
                case '0':
                    if (lastChar == '/') throw new FormatException("��������Ϊ0");
                    break;
                default:
                	  // �洢��ζ�ȡ���������
                    lastChar = chars[i];
                    break;
            }
        }
        // ������������ջδ�գ����������δ�ɶԳ��֣��׳��쳣
        if (!brackets.empty()) throw new FormatException("ERROR\n"+"#���Ų�ƥ��");//����δ�ɶԳ���
    }

    /**
     * ת��Ϊ�沨��ʽ
     *
     * @return �洢��Stack�е��沨�����ʽ
     * @throws FormatException 
     */
    private Stack<String> convert2RPN() throws FormatException {
        Stack<String> s1 = new Stack<>();// ����ջS1
        Stack<String> s2 = new Stack<>();// ����ջS2
        s1.push("#"); // ��������ȼ���#���ŷ���S1ջ��Ϊ�˷���ͳһ��������
        char[] chars = expression.toCharArray();   // ���������ʽת�����ַ�����
        // ѭ�������ַ�����
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                	  // ��ȡ�������ţ�ֱ��ѹ��S1ջ

                    s1.push(chars[i] + "");
                    break;
                case ')':
                	// ��ȡ�����ַ��ǡ��������򽫾���S1ջջ������ġ�����֮���������������ջ����������S2ջ����ʱ������������

                    do {
                        s2.push(s1.pop());
                      
                    } while (!s1.peek().equals("("));
                    s1.pop();
                    break;
               
                case '+':
                case '-':
                case '*':
                case '/':
                //  ��ȡ�����ַ�����������򽫸��������S1ջջ��Ԫ�رȽϣ�
                    // �������������ȼ�(���������������)����S1ջջ����������ȼ����򽫸��������S1ջ��
                    // ���򣬽�S1ջ��ջ�����������������S2ջ�У�ֱ��S1ջջ����������ڣ����������ڣ�����������ȼ���
                    // ��󽫸����������S1ջ��

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
                 // ������λ���ϵ����Լ�С���Ķ�ȡ
                    while (Character.isDigit(chars[i]) || chars[i] == '.') {// ��ȡ�����ַ��ǲ��������������������������
                        sb.append(chars[i]);
                        if (i < chars.length - 1 && (Character.isDigit(chars[i + 1]) || chars[i + 1] == '.')) {
                            i++;
                        } else {
                            break;
                        }
                    }
                    // �ò�����ֱ������S2ջ
                    s2.push(sb.toString());
                    break;
            }
        }
        // ��S1ջ���������������������#�����������ջ����������S2ջ
        while (!s1.peek().equals("#")) {
            s2.push(s1.pop());
        }
        // S2Ӧ��һ��������
        Stack<String> stack = new Stack<>();
        while (!s2.empty()) {
            stack.push(s2.pop());
        }
        // ����S2������ջ
        return stack;
    }

    /**
     * ������
     * @return ���ʽ������
     */
    public double calculate() throws FormatException {
        check();
        double result;
        Stack<String> tmp = new Stack<>();//����һ��String���͵�ջʵ�� 
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
        return b1.divide(b2, 3, BigDecimal.ROUND_HALF_UP).doubleValue();//ROUND_HALF_UP�򣨾��룩�����һ�����룬�������ߣ��ľ��룩�����,�������������������, 1.55����һλС�����Ϊ1.6


    }
    
    
    
    public boolean containsIllegals(String toExamine) {//ģʽƥ��������벻�Ϸ��ַ�
        Pattern pattern = Pattern.compile("[~#@%$&��?����abcdefghijklmnopqrstuvwxyz=ABCDEFGHIJKLMNOPQRSTUVWXYZ��{}����<>|!\"_^;',����]");
        Matcher matcher = pattern.matcher(toExamine);
        return matcher.find();//find()���ַ�������ƥ��,ƥ�䵽���ַ����������κ�λ��. 
    }
}

class FormatException extends Exception {	//�Զ�����ʽ���Ϸ��쳣��
    public FormatException(String message) {
        super(message);
    }
}

