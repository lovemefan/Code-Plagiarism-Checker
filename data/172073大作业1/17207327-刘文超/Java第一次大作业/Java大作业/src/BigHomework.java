import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

public class BigHomework {
	static String[] expression =new String[20];
	public static void main(String[] args) throws IOException {
		

		BigHomework s = new BigHomework();//为了去除静态调用非静态的错误
		Stack<Integer> number = new Stack<Integer>();//整数栈
        Stack<Character> operator = new Stack<Character>();//操作符栈
		FileOperation fo = new FileOperation();//构造FileOperation类
		File f = new File("src\\Expression");//构造File类，查找符合相对文件名的地方
		File f2 = new File("src\\Result");//作为储存结果的文件
		
		Regex R = new Regex();

		PrintWriter p = new PrintWriter(new FileWriter(f2,true));
		expression = fo.readLine(f);

		for(int j=0;j<expression.length;j++) {
			if (expression[0] == null) {
				p.println("ERROR\n");
				p.println("#表达式为空");
				break;
				}
//			System.out.println(expression.length);
//		    expression[j] = fo.readLine(f)[j];
			Boolean J = true;
			R.Initialization();
			if(expression[j]!=null) {
				//////////////////////////////////////////写判断
				J = R.Judge(expression[j]);
				if (J == false) {
					p.println("ERROR");
					p.println(R.ErrorMassage(expression[j]));
					continue;
				}
				int T = s.DataProcessing(expression[j],operator,number);
				p.println(expression[j]+"="+T);
			}
		}
		p.close();
		//System.exit(0);

//        System.out.println(T);
        
	}
	
	public String Change(String s) {//将数和运算符分隔，以#号为界
		String F = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')'||s.charAt(i) == '+' || s.charAt(i) == '-'||s.charAt(i) == '*' || s.charAt(i) == '/') {
				F = F + "#"+s.charAt(i)+"#";
				}
			else
	            F =F + s.charAt(i);
		}
		return F;
	}
	
	public int DataProcessing(String s, Stack<Character> operatorStack, Stack<Integer> numberStack) {
		String message = Change(s);
		String[] n = message.split("#");
		for(String e:n) {
			if (e.length() == 0)
                continue;
			else if (e.charAt(0) == '+' || e.charAt(0) == '-') {
                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '-' || operatorStack.peek() == '+' || operatorStack.peek() == '/' || operatorStack.peek() == '*')) {
                    dataProcessing(numberStack, operatorStack);
                }
                operatorStack.push(e.charAt(0));
            }
            else if (e.charAt(0) == '*' || e.charAt(0) == '/') {
                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '/' || operatorStack.peek() == '*')) {
                    dataProcessing(numberStack, operatorStack);
                }
                operatorStack.push(e.charAt(0));
            }
            else if (e.charAt(0) == '(') 
                operatorStack.push('('); 
            else if (e.charAt(0) == ')') {
                while (operatorStack.peek() != '(') 
                    dataProcessing(numberStack, operatorStack);
                operatorStack.pop();
            }
            else 
                numberStack.push(Integer.parseInt(e));
        }
		
        while (!operatorStack.isEmpty()) {
            dataProcessing(numberStack, operatorStack);
        }
        return numberStack.pop();    //此时数据栈中的数据就是运算的结果
    }
	
	
    public void dataProcessing(Stack<Integer> numberStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();  //弹出一个操作符
        int op1 = numberStack.pop(),op2 = numberStack.pop();  //弹出两个数
        if (op == '+') 
            numberStack.push(op1 + op2);
        else if (op == '-')
            numberStack.push(op2 - op1);
        else if (op == '*')
            numberStack.push(op1 * op2);
        else if (op == '/')
            numberStack.push(op2 / op1);
    }
}
