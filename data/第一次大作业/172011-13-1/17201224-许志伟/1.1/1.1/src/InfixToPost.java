public class InfixToPost {
    private Stack<String> stack;  //中缀表达式转换为后缀表达式所需要的栈
    private String infix;    //输入的中缀表达式
    private String post = "";     //存储得到的后缀表达式

    //初始化构造器
    public InfixToPost(Stack<String> stack, String infix) {
        this.stack = stack;
        this.infix = infix;
    }

    /**
     * 
     * @param infix 输入的中缀表达式
     * @return  返回处理过后的中缀表达式，主要是在输入的中缀表达式加空格
     * 例如：输入的中缀表达式为：9+(3-1)*3+10/2
     *     输出的中缀表达式为：9 + ( 3 - 1 ) * 3 + 10 / 2
     */
    private String processInfix(String infix) {
        String result = "";
        for (int i = 0; i < infix.length() - 1; i++) {
            char temp1 = infix.charAt(i);
            char temp2 = infix.charAt(i + 1);
            if (isDigital(temp1) && isDigital(temp2)) {
                result += temp1;
            } else {
                result += temp1 + " ";
            }
        }
        result += infix.charAt(infix.length() - 1); // 将最后一个元素添加进去
        return result;
    }

    private boolean isDigital(char ch) {
        if (ch >= '0' && ch <= '9')
            return true;
        else
            return false;
    }

    //将前缀表达式转换为后缀表达式的处理过程
    public void process() {
        String[] strArr = processInfix(infix).split(" ");
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            switch (str) {
            case "+":
            case "-":
                getOperation(str, 1);
                break;
            case "*":
            case "/":
                getOperation(str, 2);
                break;
            case "(":
                stack.push(str);
                break;
            case ")":
                getParent();
                break;
            default:
                post += " " + str;
                break;
            }
        }
        // 数字全部输出后，需要输出栈中剩余的符号
        while (!stack.isEmpty()) {
            post += " " + stack.pop();
        }
    }

    private void getParent() {
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("(")) {
                break;
            } else {
                post += " " + top;
            }
        }
    }

    private void getOperation(String str, int priority) {
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("(")) {
                stack.push(top);
                break;
            } else {
                int priTop = getPriority(top);
                if (priTop < priority) {
                    stack.push(top);
                    break;
                } else {
                    post += " " + top;
                }
            }
        }
        stack.push(str);
    }

    private int getPriority(String str) {
        int pri = 0;
        if (str.equals("+") || str.equals("-")) {
            pri = 1;
        } else {
            pri = 2;
        }
        return pri;
    }

    public String getPost() {
        return post.trim();
    }

 /*   public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        String input = "9+(3-1)*3+10/2";
        InfixToPost infix = new InfixToPost(stack, input);
        infix.process();

        String post = infix.getPost();
        Stack<Integer> stack_result = new Stack<>();
        PostToResult ptr = new PostToResult(post, stack_result);
        ptr.operate();
        System.out.println(ptr.getResult());
    }*/
}
