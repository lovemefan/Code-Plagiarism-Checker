import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

public class BigHomework {
	static String[] expression =new String[20];
	public static void main(String[] args) throws IOException {
		

		BigHomework s = new BigHomework();//Ϊ��ȥ����̬���÷Ǿ�̬�Ĵ���
		Stack<Integer> number = new Stack<Integer>();//����ջ
        Stack<Character> operator = new Stack<Character>();//������ջ
		FileOperation fo = new FileOperation();//����FileOperation��
		File f = new File("src\\Expression");//����File�࣬���ҷ�������ļ����ĵط�
		File f2 = new File("src\\Result");//��Ϊ���������ļ�
		
		Regex R = new Regex();

		PrintWriter p = new PrintWriter(new FileWriter(f2,true));
		expression = fo.readLine(f);

		for(int j=0;j<expression.length;j++) {
			if (expression[0] == null) {
				p.println("ERROR\n");
				p.println("#���ʽΪ��");
				break;
				}
//			System.out.println(expression.length);
//		    expression[j] = fo.readLine(f)[j];
			Boolean J = true;
			R.Initialization();
			if(expression[j]!=null) {
				//////////////////////////////////////////д�ж�
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
	
	public String Change(String s) {//������������ָ�����#��Ϊ��
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
        return numberStack.pop();    //��ʱ����ջ�е����ݾ�������Ľ��
    }
	
	
    public void dataProcessing(Stack<Integer> numberStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();  //����һ��������
        int op1 = numberStack.pop(),op2 = numberStack.pop();  //����������
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
