package Calculator;

public class Calculate{
    private String post;   //中缀表达式转换得到的后缀表达式
    private Stack stack;   //用于得到计算结果的栈

    public Calculate(String post, Stack stack) {
        this.post = post;
        this.stack = stack;
    }

    //由后缀表达式得到四则运算结果的实现过程
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

