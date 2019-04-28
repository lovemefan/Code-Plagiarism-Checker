package 大作业;
import java.util.Stack;
/**
 * 后缀表达式求值
 * @author 刘润石
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
		String []str = post.split(" ");//按照空格进行分割
		for(int i=0;i<str.length;i++){
			String temp = str[i];
			if(isDigital(temp)){//直接输出纯数字
                stack.push(Double.valueOf(temp));
            }else{//计算完后这步的结果压栈
                double result = compute(temp);
                stack.push(result);
            }
        }
    }
	double re = 0;
    double compute(String str){//进行计算
       
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
    String denominator(String str){//判断是否输出Infinity 是就转换为错误信息
    	if(str.equals(st)){
    		return "\r\nERROR\r\n#分母不能为0";
    	}else{
    		return String.valueOf(re);
    	}
    }
    
    boolean isDigital(String str){//如果是纯数字直接输出
        char[] ch = str.toCharArray();
        int len = ch.length;
        int count = 0;
        for(int i = 0; i < len; i++){
            if(ch[i] >= '0' && ch[i] <= '9')
                count++;
        }
        return count == len;
    }
    double getResult() {//把最后的结果出栈
        return stack.pop();
    }
}
