public class Result{
    private String post;   //��׺���ʽת���õ��ĺ�׺���ʽ
    private Stack<Integer> stack;   //���ڵõ���������ջ
    
    
    public  Result(String post, Stack<Integer> stack_result) {
        this.post = post;
        this.stack = stack_result;
    }


	//�ɺ�׺���ʽ�õ�������������ʵ�ֹ���
    public void operate(){
        String[] strArr = post.split(" ");
        for(int i = 0; i < strArr.length; i++){
            String temp = strArr[i];
            if(isDigital(temp)){
                stack.push(Integer.valueOf(temp));
            }else{
                int result = compute(temp);
                stack.push(result);
            }
        }
    }

    //��������������
    private int compute(String str){
        int re = 0;
        int m = stack.pop();
        int n = stack.pop();
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

    //�ж������Ƿ�����
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

    //���������
    public int getResult() {
        return stack.pop();
    }
    
}
