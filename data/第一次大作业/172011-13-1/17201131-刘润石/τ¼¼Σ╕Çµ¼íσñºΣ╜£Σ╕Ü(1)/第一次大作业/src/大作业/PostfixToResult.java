package ����ҵ;
import java.util.Stack;
/**
 * ��׺���ʽ��ֵ
 * @author ����ʯ
 *
 */
public class PostfixToResult {
	String post = "";
	Stack<Double> stack;
	
	public PostfixToResult(String post,Stack<Double> stack) {
		this.post = post;
		this.stack = stack;
	}
	
	void operate(){
		String []str = post.split(" ");//���տո���зָ�
		for(int i=0;i<str.length;i++){
			String temp = str[i];
			if(isDigital(temp)){//ֱ�����������
                stack.push(Double.valueOf(temp));
            }else{//��������ⲽ�Ľ��ѹջ
                double result = compute(temp);
                stack.push(result);
            }
        }
    }
	double re = 0;
    double compute(String str){//���м���
       
        double m = stack.pop();
        double n = stack.pop();
        switch(str){
        case "+" :
            re = n + m;
            break;
        case "-" :
            re = n - m;
            break;
        case "*" :
            re = n * m;
            break;
        case "/" :
        	re = n / m;
        	break;
        default :
            break;
        }
        return re;
    }
    String st = "Infinity";
    String denominator(String str){//�ж��Ƿ����Infinity �Ǿ�ת��Ϊ������Ϣ
    	if(str.equals(st)){
    		return "\r\nERROR\r\n#��ĸ����Ϊ0";
    	}else{
    		return String.valueOf(re);
    	}
    }
    
    boolean isDigital(String str){//����Ǵ�����ֱ�����
        char[] ch = str.toCharArray();
        int len = ch.length;
        int count = 0;
        for(int i = 0; i < len; i++){
            if(ch[i] >= '0' && ch[i] <= '9')
                count++;
        }
        return count == len;
    }
    double getResult() {//�����Ľ����ջ
        return stack.pop();
    }
}
