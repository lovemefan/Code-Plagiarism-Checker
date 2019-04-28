import java.util.*;
import java.io.*;

public class Calculator {

		   public static void main(String[] args) throws IOException{
			   
		        java.io.File FileRead = new java.io.File("input");
		        if(!FileRead.exists()){
		            System.out.println("File don't exists!");
		            System.exit(1); //�����˳�
		        }
		        Check str = new Check();
		        Scanner input = new Scanner(FileRead);
		        java.io.PrintWriter FileWrite = new java.io.PrintWriter(new File("output"));

		        Set<String> set = new HashSet<String>();
		        while(input.hasNext()){
		            str.expression = input.nextLine();
		            str.expression = str.expression.replaceAll("\\s", "");//���Կո�

		            double result = 0;
		            if(!set.add(str.expression))    //�����Ѿ����ֹ��ı��ʽ
		                continue;
		            if(str.checkit() == 0 && str.BracktMatcher()){
		                Stack<String> stack = operate(str.expression);
		                result = solve(stack);

		                FileWrite.println(str.expression + "=" + String.valueOf(result));

		                
		            }
		            else{
		                FileWrite.println("ERROR");
		                FileWrite.println("#" + str.OutError());

		            }
		        }
		        input.close();
		        FileWrite.close();
		    }

		   // �ļ������׼ΪUTF-8
		    public static BufferedWriter createFileWriter(String name) throws FileNotFoundException, UnsupportedEncodingException {
		        FileOutputStream outputStream = new FileOutputStream(name);
		        OutputStreamWriter outputWriter = new OutputStreamWriter(outputStream, "utf-8");
		        BufferedWriter writer = new BufferedWriter(outputWriter);
		        return writer;
		    }  

		    // �Ƚ����ȼ���С
		    public static boolean rank(char a, char b){	
		        boolean flag = false;
		        if((a == '+'||a == '-')&&(b == '*' || b == '/'))
		            flag = true;
		        else if(r(a, b))
		            flag = true;
		        return flag;
		    }
		    static boolean r(char a, char b){
		        if (a == b ||(a == '+' && b == '-')||(a == '-' && b == '+')||(a == '*' && b == '/')||(a == '/' && b == '*'))
		            return true;
		        else return false;
		    }

		  //��������
		    public static double solve(Stack<String> stack){
		        Stack<String> result = new Stack<String>();
		        Collections.reverse(stack);
		        String firstnum, secondnum, currentnum;
		        while(!stack.empty()){
		            currentnum = stack.pop();
		            if(!isOperator(currentnum.charAt(0))){
		                result.push(currentnum);
		            }
		            else
		            {
		                secondnum = result.pop();
		                firstnum = result.pop();
		                double temp = calculate(firstnum, secondnum, currentnum.charAt(0));
		                result.push(String.valueOf(temp));
		            }
		        }
		        return Double.valueOf(result.pop());
		    }

		    // ����׺���ʽתΪ��׺���ʽ�����غ�׺���ʽ
		    static Stack<String> stack1 = new Stack<String>();
		    static Stack<Character> stack2 = new Stack<Character>();
		    private static Stack<String> operate(String Expression){    //��׺ת��׺���ʽ
		        stack2.push('!');//�����ջ�׷���'!'��Ϊ������ȼ�����
		        char[] Array = Expression.toCharArray();
		        int index = 0, count = 0;//indexΪ��ǰλ�ã�countΪ�������ֳ��ֵĳ���
		        char current, top;//currentΪ��ǰ�ַ���topΪջ���ַ�
		        for(int j = 0; j < Array.length; j++){
		            current = Array[j];
		            if(isOperator(current))
		            {
		                if(count > 0)
		                {
		                    NewPUsh(Array, index, count);//��ǰһ������ѹ����ջ
		                }
		                top = stack2.peek();//ȡ������ջ��Ԫ��
		                operatorSolve(Array, index, count, current, top);
		                count = 0;
		                index = j+1;
		            }
		            else
		                count++;
		        }
		        if(count > 1 || (count == 1 && !isOperator(Array[index]))){
		            NewPUsh(Array, index, count);
		        }
		        while(stack2.peek()!='!'){
		            PUsh(Array, index, count);
		        }
		        return stack1;
		    }
		    private static void operatorSolve(char[] Array, int index, int count, char current, char top){
		        if(current == ')')//�����������������ջ��Ԫ���Ƶ����ջ�У�ֱ������������
		        {
		            while(stack2.peek() != '('){
		                PUsh(Array, index, count);
		            }
		            stack2.pop();
		        }
		        else
		        {
		            while(current != '(' && stack2.peek()!='!' && rank(current, top))
		            {
		                PUsh(Array, index, count);//�����ȼ��͵�ջ��Ԫ��ת�Ƶ����ջ��
		                top = stack2.peek();
		            }
		            stack2.push(current);
		        }
		    }
		    private static void PUsh(char[] Array, int index, int count){
		        String element = String.valueOf(stack2.pop());
		        stack1.push(element);
		    }
		    private static void NewPUsh(char[] Array, int index, int count){
		        String element = new String(Array, index, count);
		        stack1.push(element);
		    }

		    
		    // �ж��Ƿ�Ϊ�����

		    private static boolean isOperator(char c) {
		        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' ||c == ')';
		    }

		    
		    //�����������

		    private static double calculate(String firstnum, String secondnum, char ch){
		        double result;
		        switch (ch){
		            case '+':   result = Double.valueOf(firstnum) + Double.valueOf(secondnum); break;
		            case '-':   result = Double.valueOf(firstnum) - Double.valueOf(secondnum); break;
		            case '*':   result = Double.valueOf(firstnum) * Double.valueOf(secondnum); break;
		            case '/':   result = Double.valueOf(firstnum) / Double.valueOf(secondnum); break;
		            default:    result = 0;
		        }
		        return result;
		    }
		}
