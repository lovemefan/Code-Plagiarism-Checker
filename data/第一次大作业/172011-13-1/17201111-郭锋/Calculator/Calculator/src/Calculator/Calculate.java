package Calculator;

public class Calculate{
    private String post;   //��׺���ʽת���õ��ĺ�׺���ʽ
    private Stack stack;   //���ڵõ���������ջ

    public Calculate(String post, Stack stack) {
        this.post = post;
        this.stack = stack;
    }

    //�ɺ�׺���ʽ�õ�������������ʵ�ֹ���
    public void operate(){
        String[] strArr = post.split(" ");
        for(int i = 0; i < strArr.length; i++){
            String temp = strArr[i];
            if(isDigital(temp)){
                stack.push(String.valueOf(temp));
            }else{
                String result =String.valueOf(compute(temp));
                stack.push(result);
            }
        }
    }

    public int compute(String str){
        int r = 0;
        int m =Integer.parseInt(stack.pop());
        int n =Integer.parseInt(stack.pop());
        switch(str){
        case "+" :
            r = n + m;
            break;
        case "-" :
            r = n - m;
            break;
        case "*" :
            r = n * m;
            break;
        case "/" :
            r = n / m;
            break;
        default :
            break;
        }
        return r;
    }

    public boolean isDigital(String str){
        char[] chArr = str.toCharArray();
        int length = chArr.length;
        int count = 0;
        for(int i = 0; i < length; i++){
            if(chArr[i] >= '0' && chArr[i] <= '9')
                count++;
        }
        return count == length;
    }

    public String getResult() {
        return stack.pop();
    }
}

