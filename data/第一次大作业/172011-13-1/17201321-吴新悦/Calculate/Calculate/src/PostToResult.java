class PostToResult{
    private String post;   //中缀表达式转换得到的后缀表达式
    private Stack<String> stack;   //用于得到计算结果的栈

    //得到结果的栈的构造函数
    public PostToResult(String post, Stack<String> stack) {
        this.post = post;
        this.stack = stack;
    }
    
    public PostToResult(){
    	
    }

    //由后缀表达式得到四则运算结果的实现过程
    public void operate(){
        String[] strArr = post.split(" ");
        for(int i = 0; i < strArr.length; i++){
            String Op = strArr[i];
            if(isDigital(Op)){
                stack.push(Op);
            }else{
                String result = compute(Op);
                stack.push(result);
            }
        }
    }

    //判断符号，然后进行相应的运算
    private String compute(String str){
        String result = "";
        int m = Integer.valueOf(stack.pop());
        int n = Integer.valueOf(stack.pop());
        switch(str){
        case "+" :
            result = n + m+"";
            break;
        case "-" :
            result = n - m+"";
            break;
        case "*" :
            result = n * m+"";
            break;
        case "/" :
        	if(m==0){
        		result = "\r\nERROR\r\n#除数不能为0";
        		break;
        	}
        	else result = n / m+"";
            break;
        default :
            break;
        }
        return result;
    }

    
    //判断一个字符串是否为数字
    private boolean isDigital(String str){
        char[] chArr = str.toCharArray();
        int len = chArr.length;
        int count = 0;
        for(int i = 0; i < len; i++){
            if(chArr[i] >= '0' && chArr[i] <= '9')
                count++;
        }
        return count == len;
    }

    //将结果出栈并得到结果
    public String getResult() {
        return stack.pop();
    }
}