package calculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Calculator {

	private Stack<Character> SymStack = new Stack<Character>();// ���������ŵ�ջ
	private Stack<Integer> NumStack = new Stack<Integer>();;// ����������ֵ�ջ
	public String judge(String str) {//�ж���ʽ�ĸ�ʽ�Ƿ���ȷ
		 String str1 = str.substring(0,1);
		 String str2 = str.substring(str.length()-3,str.length()-2);
         String error = " ";
         String regEx = "[~!@$%^&����]";
         //�ж������ַ�
         String RegEx ="[a-zA-z]";
         //�ж��Ƿ�����ĸ
         Pattern p = Pattern.compile(regEx);
         Matcher m = p.matcher(str);
         Pattern a = Pattern.compile(RegEx);
         Matcher b = a.matcher(str);
         if(b.find()){ //���ʽ�г�����ĸ
        	 error =  "#���ʽ�г�����ĸ";      	 
         }
         if(m.find()){ //���ʽ�г��������ַ�
        	 error = "#���ʽ�г��������ַ�";
        	 
         }
      // �� ��������ֵ����
			if (str.matches("[\\S]*[0-9][(][\\S]*")) {
				error = "#���ʽ��(���������";
			}
			// �� �ұ���*/�����
			if (str.matches("[\\S]*[(][/*/][\\S]*")) {
				// System.out.println(s);
				error = "#���ʽ��(�ұ��������";
			}
      // ƥ�������
      			if (str.matches("[\\S]*[(][)][\\S]*")) {
      				error = "#���ʽ�д��ڿ�����";
      			}
      			// ���������������� 
      			if (str.matches("[\\S]*[+-/*/][+-/*/][+-/*/][\\S]*")) {
      				error = "#����������������";
      			}
      			// �����������������
      			if (str.matches("[\\S]*[+-/*/][+/*/][\\S]*")) {
      				error = "#�����������������";
      			}
      			// ���ұ������ֵ����
      			if (str.matches("[\\S]*[)][0-9][\\S]*")) {
      				error = "#���ʽ��)�ұ�������";
      			}
      			// ƥ�䣩�����+-*/�����
      			if (str.matches("[\\S]*[+-/*/][)][\\S]*")) {
      				error = "#���ʽ��)����������";
      			}
      			if (str.length()>1){
      				if (!str1.matches("[1-9]"))
      					error = "#���ʽ�������λ�ַ����Ϸ�";
      				if (!str2.matches("[1-9]"))
      					error = "#���ʽ�����ĩλ�ַ����Ϸ�";
      				}

         return error;
	}

    public int caculate(String str) {      
            
        String Dep;// ������ʱ��Ŷ�ȡ���ַ�      
        // �����ַ���   
        StringBuffer tempNum = new StringBuffer();// ������ʱ���   
        StringBuffer string = new StringBuffer().append(str);    
      
        while (string.length() != 0) {      
            Dep = string.substring(0, 1); 
            
            //public String substring(int beginIndex, int endIndex)
           // ��һ��intΪ��ʼ����������ӦString�����еĿ�ʼλ�ã�
           // �ڶ����ǽ�ֹ������λ�ã���ӦString�еĽ���λ��    
            
            string.delete(0, 1); //ɾ��    
            // �ж�temp����tempΪ������ʱ          
            if (!Num(Dep)) {      
                // ��ʱ��tempNumΪ��������ѹջ�����      
                if (!"".equals(tempNum.toString())) {      
                    // �����ʽ�ĵ�һ������Ϊ����      
                    int num = Integer.parseInt(tempNum.toString());   
                    //Integer.parseInt()�ǰ�()�������ת��������
                    NumStack.push(num);  
                    tempNum.delete(0, tempNum.length());      
                }      
                // �õ�ǰȡ�õ��������ջ��������Ƚ����ȼ��������ڣ�����Ϊ�������㣬����ջ���������ڣ���Ϊ�����ں��棬���Ի����㣬����ջ��Ԫ�س�ջ��ȡ�����������㣻      
                // ��С�ڣ���ͬ��ȡ��ջ��Ԫ�����㣬������������ջ��      
      
                // �жϵ�ǰ�������ջ��Ԫ�����ȼ���ȡ��Ԫ�أ����м���(��Ϊ���ȼ�����С��ջ��Ԫ�أ���С�ڵڶ���Ԫ�صȵȣ���Ҫ��ѭ���ж�)      
                while (!com(Dep.charAt(0)) && (!SymStack.empty())) {//charAt(x),xΪλ�� 
                    int a = (int) NumStack.pop();// �ڶ���������      
                    int b = (int) NumStack.pop();// ��һ��������      
                    char symbol = SymStack.pop();      
                    int result = 0;// ������      
                    switch (symbol) {      
                    // ����ǼӺŻ��߼��ţ���      
                    case '+':      
                        result = b + a;      
                        // ������������������ջ      
                        NumStack.push(result);      
                        break;      
                    case '-':      
                        result = b - a;      
                        // ������������������ջ      
                        NumStack.push(result);      
                        break;      
                    case '*':      
                        result = b * a;      
                        // ������������������ջ      
                        NumStack.push(result);      
                        break;      
                    case '/':      
                        result = b / a;// ������������������ջ      
                        NumStack.push(result);      
                        break;      
                    }      
      
                }      
                
                // �жϵ�ǰ�������ջ��Ԫ�����ȼ��� ����ߣ����ߵ���ƽ��������󣬽���ǰ�������ţ����������ջ      
                if (Dep.charAt(0) != ' ') {      
                    SymStack.push(new Character(Dep.charAt(0)));      
                    if (Dep.charAt(0) == ')') {// ��ջ��Ϊ'('������ǰԪ��Ϊ')'ʱ�����������������꣬ȥ������      
                        SymStack.pop();      
                        SymStack.pop();      
                    }      
                }      
            } else      
                // ��Ϊ�ǲ�����ʱ�����֣�      
                tempNum = tempNum.append(Dep);// ����������һλ���ӵ��Զ���������(�����Ǹ�λ����ʱ��)      
        }      
        return NumStack.pop();      
    }      
      
  //�ж�������Ƿ�Ϊ����
    private boolean Num(String temp) {      
        return temp.matches("[0-9]");      
    }      
  
    private boolean com(char str) {      
        if (SymStack.empty()) {      
            // ��Ϊ��ʱ����Ȼ ��ǰ���ȼ���ͣ����ظ�      
            return true;      
        }      
        char last = (char) SymStack.lastElement();      
        // ���ջ��Ϊ'('��Ȼ�����ȼ���ͣ�')'������Ϊջ����      
        if (last == '(') {      
            return true;      
        }
        switch (str) {      
        case '=':      
            return false;// ������      
        case '(':      
            // '('���ȼ����,��Ȼ����true      
            return true;      
        case ')':      
            // ')'���ȼ���ͣ�      
            return false;      
        case '*': {      
            // '*/'���ȼ�ֻ��'+-'��      
            if (last == '+' || last == '-')      
                return true;      
            else      
                return false;      
        }      
        case '/': {      
            if (last == '+' || last == '-')      
                return true;      
            else      
                return false;      
        }      
            // '+-'Ϊ��ͣ�һֱ����false      
        case '+':      
            return false;      
        case '-':      
            return false;      
        }
        return true;      
    }      
      
	public static void main(String args[]) throws IOException {
		try {
			File file1 = new File("out.txt");
			// ����ļ������ڣ����½�һ���ļ�
			if (!file1.exists()) {
				file1.createNewFile();
			}
			FileWriter fileWritter = new FileWriter(file1.getName(), true);
			File file = new File("equation.txt");
			BufferedReader reader = null;
			String temp = null;// ����ļ���ÿ�ж�ȡ����ʽ
			try {
				reader = new BufferedReader(new FileReader(file));
				while ((temp = reader.readLine()) != null) {
					// System.out.println(temp);
					Calculator equation = new Calculator();
					String t = equation.judge(temp);// ������ʽ��У��
					if (t == " ") {
						int a = equation.caculate(temp);// �������"�ո�"����˵����ʽ��ȷ��������
						System.out.println(temp + "" + a);
						fileWritter.write(temp + "" + a + "\r\n");
					} else {
						System.out.println("ERROR");
						System.out.println(t);// ���ش��󣬴�ӡ������Ϣ
						fileWritter.write("ERROR" + "\r\n");
						fileWritter.write(t + "\r\n");
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			fileWritter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
