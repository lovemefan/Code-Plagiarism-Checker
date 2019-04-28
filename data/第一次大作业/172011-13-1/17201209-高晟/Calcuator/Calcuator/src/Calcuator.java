
class Calcuator{
	public static void main(String[] args) throws Exception {
		WriteData write = new WriteData();
		String[] expression = new String[1024];
		ReadData read = new ReadData();
		expression = read.Read();
        Check check = new Check();
        String[] expression2 = new String[1024];
        int a = 0;
        for(int i = 0;expression[i] != null;i ++){
            expression[i] = check.RemoveBlank(expression[i]);//除去字符串中的空格
        	String expression1 = check.Judge(expression[i]);//判断字符串
        	if(expression1.equals("s1")){
        		expression2[i] = "s1";//非法字符
        		a ++;
        	}else if(expression1.equals("s4")){
        		expression2[i] = "s4";//输入格式错误
        		a ++;
        	}
        	else if(expression1.equals("s2")){
        		expression2[i] = "s2";//左右括号连续出现
        		a ++;
        	}
             else if(expression1.equals("s3")){
        		expression2[i] = "s3";//"除数不能为'0'";
        		a ++;
        	}else if(expression1.equals("s5")){
        		expression2[i] = "s5";//"左右括号数量不相等";
        		a ++;
        	}else if(expression.equals("s6")){
        		expression2[i] = "s6";//空行
        	}
        	else{
        		Stack<String> stack = new Stack<>();
                String input = expression1;
                InfixToPost infix = new InfixToPost(stack, input);
                infix.process();
                String post = infix.getPost();
                Stack<Integer> stack_result = new Stack<>();
                PostToResult ptr = new PostToResult(post, stack_result);
                ptr.operate();
        		int b =  ptr.getResult();
        		expression2[i] = expression1 + "=" + b;
        		a ++;
        	}
        	}
        write.Write(expression2,a);//结果，表达式的个数传入函数
        System.out.println("计算已经完成，请在文件中查看结果");
        
    }
}

