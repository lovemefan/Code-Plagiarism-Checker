class PostToResult{
    private String post;   //��׺���ʽת���õ��ĺ�׺���ʽ
    private Stack<String> stack;   //���ڵõ���������ջ

    //�õ������ջ�Ĺ��캯��
    public PostToResult(String post, Stack<String> stack) {
        this.post = post;
        this.stack = stack;
    }
    
    public PostToResult(){
    	
    }

    //�ɺ�׺���ʽ�õ�������������ʵ�ֹ���
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

    //�жϷ��ţ�Ȼ�������Ӧ������
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
        		result = "\r\nERROR\r\n#��������Ϊ0";
        		break;
        	}
        	else result = n / m+"";
            break;
        default :
            break;
        }
        return result;
    }

    
    //�ж�һ���ַ����Ƿ�Ϊ����
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

    //�������ջ���õ����
    public String getResult() {
        return stack.pop();
    }
}