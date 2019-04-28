package mathCalculator;

public class Result {     //计算后缀表达式类
	private intStack stack;        //整形栈
	private String post;           //要计算的后缀表达式
	
	public Result(String post){       //构造方法，传入表达式
		this.post = post;
		stack = new intStack(post.length());
	}
	
	public boolean number(String str){     //判断是否为为数字
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) > '9' || str.charAt(i) < '0'){
                return false;
            }
        }
        return true;
    }
	
	public int calculate(String str){      //出栈、计算操作
		int ans = 0;
        int m = stack.pop();             //栈顶两个数字出栈
        int n = stack.pop();
        if (str.equals("+")){            //加法操作
        	ans = n + m;
        }
        else if (str.equals("-")){    //减法操作
        	ans = n - m;
        }
        else if (str.equals("*")){    //乘法操作
        	ans = n * m;
        }
        else if (str.equals("/")){    //除法操作
        	ans = n / m;
        }
        return ans;
	}
	
	public int process(){                //处理过程
        String[] s = post.split(" ");    //按空格分离
        for(int i = 0; i < s.length; i++){
            String str = s[i];     
            if(number(str)){             //如果是数字入栈
                stack.push(Integer.valueOf(str));
            }
            else  {                      //如果是操作符则计算栈内元素的相应操作结果
                int result = calculate(str);
                stack.push(result);      //结果入栈
            }
        }
        return stack.pop();
    }
}
