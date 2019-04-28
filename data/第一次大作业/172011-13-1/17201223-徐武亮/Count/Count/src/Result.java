import java.util.*;    

public class  Result {    
	private String str;
    private Stack<Character> priStack = new Stack<Character>();// ������ջ      
    private Stack<Double> numStack = new Stack<Double>();// ������ջ      
    public Result(){
    	
    }
    public Result(String str){
    	this.str = str;
    }
    public double caculate() {      
        // 1.�ж�string������û�зǷ��ַ�      
        String temp;// ������ʱ��Ŷ�ȡ���ַ�      
        // 2.ѭ����ʼ�����ַ��������ַ��������꣬�ҷ���ջΪ��ʱ����������      
        StringBuffer tempNum = new StringBuffer();// ������ʱ��������ַ���(��Ϊ��λ��ʱ)      
        StringBuffer string = new StringBuffer().append(str);// �������棬���Ч��      
      
        while (string.length() != 0) {      
            temp = string.substring(0, 1);      
            string.delete(0, 1);      
            // �ж�temp����tempΪ������ʱ      
            if (!isNum(temp)) {      
                // 1.��ʱ��tempNum�ڼ�Ϊ��Ҫ����������ȡ������ѹջ���������tempNum      
                if (!"".equals(tempNum.toString())) {      
                    // �����ʽ�ĵ�һ������Ϊ����      
                    double num = Integer.parseInt(tempNum.toString());      
                    numStack.push(num);  
                    tempNum.delete(0, tempNum.length());      
                }      
                // �õ�ǰȡ�õ��������ջ��������Ƚ����ȼ��������ڣ�����Ϊ�������㣬����ջ���������ڣ���Ϊ�����ں��棬���Ի����㣬����ջ��Ԫ�س�ջ��ȡ�����������㣻      
                // ��С�ڣ���ͬ��ȡ��ջ��Ԫ�����㣬������������ջ��      
      
                // �жϵ�ǰ�������ջ��Ԫ�����ȼ���ȡ��Ԫ�أ����м���(��Ϊ���ȼ�����С��ջ��Ԫ�أ���С�ڵڶ���Ԫ�صȵȣ���Ҫ��ѭ���ж�)      
                while (!compare(temp.charAt(0)) && (!priStack.empty())) {   
                    double a = numStack.pop();// �ڶ���������      
                    double b =  numStack.pop();// ��һ��������      
                    char ope = priStack.pop();      
                    double result = 0;// ������      
                    switch (ope) {      
                    // ����ǼӺŻ��߼��ţ���      
                    case '+':      
                        result = b + a;      
                        // ������������������ջ      
                        numStack.push(result);      
                        break;      
                    case '-':      
                        result = b - a;      
                        // ������������������ջ      
                        numStack.push(result);      
                        break;      
                    case '*':      
                        result = b * a;      
                        // ������������������ջ      
                        numStack.push(result);      
                        break;      
                    case '/':      
                        result = b / a;// ������������������ջ      
                        numStack.push(result);      
                        break;      
                    }      
      
                }      
                // �жϵ�ǰ�������ջ��Ԫ�����ȼ��� ����ߣ����ߵ���ƽ��������󣬽���ǰ�������ţ����������ջ      
                if (temp.charAt(0) != '#') {      
                    priStack.push(new Character(temp.charAt(0)));      
                    if (temp.charAt(0) == ')') {// ��ջ��Ϊ'('������ǰԪ��Ϊ')'ʱ�����������������꣬ȥ������      
                        priStack.pop();      
                        priStack.pop();      
                    }      
                }      
            } else      
                // ��Ϊ�ǲ�����ʱ�����֣�      
                tempNum = tempNum.append(temp);// ����������һλ���ӵ��Զ���������(�����Ǹ�λ����ʱ��)      
        }      
        return numStack.pop();      
    }      
      
     
      //�жϴ�����ַ��ǲ���0-9������   
    
    private boolean isNum(String temp) {      
        return temp.matches("[0-9]");      
    }      
     
    private boolean compare(char str) {      
        if (priStack.empty()) {      
            // ��Ϊ��ʱ����Ȼ ��ǰ���ȼ���ͣ����ظ�      
            return true;      
        }      
        char last = (char) priStack.lastElement();      
        // ���ջ��Ϊ'('��Ȼ�����ȼ���ͣ�')'������Ϊջ����      
        if (last == '(') {      
            return true;      
        }      
        switch (str) {      
        case '#':      
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
}
      