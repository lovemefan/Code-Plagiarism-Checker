public class Zhan2 {
	
    private String hou;   //中缀表达式转换得到的后缀表达式
    private Stack<Integer> stack;   //用于得到计算结果的栈
    
    Zhan2(){
		
	}
    
    public Zhan2(String hou, Stack<Integer> stack) {
        this.hou = hou;
        this.stack = stack;
    }

    //由后缀表达式得到四则运算结果
    public void operate(){
        String[] strArr = hou.split(" ");
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

    private boolean isDigital(String str){
        char[] z = str.toCharArray();
        int len = z.length;
        int count = 0;
        for(int i = 0; i < len; i++){
            if(z[i] >= '0' && z[i] <= '9')
                count++;
        }
        return count == len;
    }

    public int getResult() {
        return stack.pop();
    }
}
