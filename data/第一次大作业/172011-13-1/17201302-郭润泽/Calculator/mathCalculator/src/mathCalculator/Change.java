package mathCalculator;

public class Change { //转后缀表达式类
	
	private stringStack stack;  //自定义字串类型栈
	private String infix;    //输入的中缀表达式
    private String post = "";     //存储得到的后缀表达式
    
    public Change(String infix){   //构造方法传入中缀表达式
    	this.infix = infix;
    	stack = new stringStack(infix.length());
    }
    
    public boolean number(char ch){    //判断数字
    	return (ch >= '0' && ch <= '9');
    }
    
    public String preProcess(){  //预处理，在数和符号间添加空格以便计算
    	String str = "";
    	for (int i = 0; i < infix.length() - 1; i ++){
    		if ( number( infix.charAt(i)) && number( infix.charAt(i + 1))){
    			str += infix.charAt(i);             //数字直接接
    		}
    		else {
    			str += infix.charAt(i) + " ";       //找到数字和符号之间添加空格
    		}
    	}
    	str += infix.charAt(infix.length() - 1);   //添加最后一个元素
    	return str;
    }
    
    public int getRank(String str){    //运算优先级
    	if (str.equals("+") || str.equals("-")){
          	return 1; 
        }
    	return 2;
    }
    
    
    public void getOp(String str,int rank){    //遇到操作符依据优先级入栈	或出栈
    	while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("(")) {          //遇到左括号直接入栈
                stack.push(top);
                break;
            } 
            else {
                int rank1 = getRank(top); 
                if (rank1 < rank) {       //如果栈顶元素优先级低当前元素入栈
                    stack.push(top);
                    break;
                } 
                else {
                    post += " " + top;   //如果栈顶元素优先级高出栈
                }
            }
        }
        stack.push(str);
    }
    
    private void getParent() {    //将栈内存出栈
    	while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("(")) {
                break;
            } 
            else {
                post += " " + top;
            }
        }
    }
    
    public String process(){   //处理过程
    	String[] s = preProcess().split(" ");   //依据空格分割

    	for (int i = 0; i < s.length; i++) { 
            String str = s[i];                 
            if (str.equals("+") || str.equals("-")){   //+、-优先级为1
            	getOp(str, 1);
            }
            else if(str.equals("*") || str.equals("/")){  //*、/优先级为2
            	getOp(str, 2);
            }
            else if(str.equals("(")){   //(直接入栈
            	stack.push(str);
            }
            else if (str.equals(")")){  //)出栈
            	getParent();
            }
            else {
                post += " " + str;    //数字直接输出
            }
        }
    	
    	while (!stack.isEmpty()) {   //将剩余元素加入post
            post += " " + stack.pop();
        }
    	
    	return post.trim();    //去除开头结尾空格
    }
    
}
