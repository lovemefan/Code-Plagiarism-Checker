package calculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Calculator {

	private Stack<Character> SymStack = new Stack<Character>();// 存放运算符号的栈
	private Stack<Integer> NumStack = new Stack<Integer>();;// 存放运算数字的栈
	public String judge(String str) {//判断算式的格式是否正确
		 String str1 = str.substring(0,1);
		 String str2 = str.substring(str.length()-3,str.length()-2);
         String error = " ";
         String regEx = "[~!@$%^&【】]";
         //判断特殊字符
         String RegEx ="[a-zA-z]";
         //判断是否含有字母
         Pattern p = Pattern.compile(regEx);
         Matcher m = p.matcher(str);
         Pattern a = Pattern.compile(RegEx);
         Matcher b = a.matcher(str);
         if(b.find()){ //表达式中出现字母
        	 error =  "#表达式中出现字母";      	 
         }
         if(m.find()){ //表达式中出现特殊字符
        	 error = "#表达式中出现特殊字符";
        	 
         }
      // （ 左边是数字的情况
			if (str.matches("[\\S]*[0-9][(][\\S]*")) {
				error = "#表达式中(左边是数字";
			}
			// （ 右边是*/的情况
			if (str.matches("[\\S]*[(][/*/][\\S]*")) {
				// System.out.println(s);
				error = "#表达式中(右边是运算符";
			}
      // 匹配空括号
      			if (str.matches("[\\S]*[(][)][\\S]*")) {
      				error = "#表达式中存在空括号";
      			}
      			// 多个运算符连续出现 
      			if (str.matches("[\\S]*[+-/*/][+-/*/][+-/*/][\\S]*")) {
      				error = "#多个运算符连续出现";
      			}
      			// 两个运算符连续出现
      			if (str.matches("[\\S]*[+-/*/][+/*/][\\S]*")) {
      				error = "#两个运算符连续出现";
      			}
      			// ）右边是数字的情况
      			if (str.matches("[\\S]*[)][0-9][\\S]*")) {
      				error = "#表达式中)右边是数字";
      			}
      			// 匹配）左边是+-*/的情况
      			if (str.matches("[\\S]*[+-/*/][)][\\S]*")) {
      				error = "#表达式中)左边是运算符";
      			}
      			if (str.length()>1){
      				if (!str1.matches("[1-9]"))
      					error = "#表达式运算符首位字符不合法";
      				if (!str2.matches("[1-9]"))
      					error = "#表达式运算符末位字符不合法";
      				}

         return error;
	}

    public int caculate(String str) {      
            
        String Dep;// 用来临时存放读取的字符      
        // 解析字符串   
        StringBuffer tempNum = new StringBuffer();// 用来临时存放   
        StringBuffer string = new StringBuffer().append(str);    
      
        while (string.length() != 0) {      
            Dep = string.substring(0, 1); 
            
            //public String substring(int beginIndex, int endIndex)
           // 第一个int为开始的索引，对应String数字中的开始位置，
           // 第二个是截止的索引位置，对应String中的结束位置    
            
            string.delete(0, 1); //删除    
            // 判断temp，当temp为操作符时          
            if (!Num(Dep)) {      
                // 此时的tempNum为操作数，压栈后清空      
                if (!"".equals(tempNum.toString())) {      
                    // 当表达式的第一个符号为括号      
                    int num = Integer.parseInt(tempNum.toString());   
                    //Integer.parseInt()是把()里的内容转换成整数
                    NumStack.push(num);  
                    tempNum.delete(0, tempNum.length());      
                }      
                // 用当前取得的运算符与栈顶运算符比较优先级：若高于，则因为会先运算，放入栈顶；若等于，因为出现在后面，所以会后计算，所以栈顶元素出栈，取出操作数运算；      
                // 若小于，则同理，取出栈顶元素运算，将结果入操作数栈。      
      
                // 判断当前运算符与栈顶元素优先级，取出元素，进行计算(因为优先级可能小于栈顶元素，还小于第二个元素等等，需要用循环判断)      
                while (!com(Dep.charAt(0)) && (!SymStack.empty())) {//charAt(x),x为位置 
                    int a = (int) NumStack.pop();// 第二个运算数      
                    int b = (int) NumStack.pop();// 第一个运算数      
                    char symbol = SymStack.pop();      
                    int result = 0;// 运算结果      
                    switch (symbol) {      
                    // 如果是加号或者减号，则      
                    case '+':      
                        result = b + a;      
                        // 将操作结果放入操作数栈      
                        NumStack.push(result);      
                        break;      
                    case '-':      
                        result = b - a;      
                        // 将操作结果放入操作数栈      
                        NumStack.push(result);      
                        break;      
                    case '*':      
                        result = b * a;      
                        // 将操作结果放入操作数栈      
                        NumStack.push(result);      
                        break;      
                    case '/':      
                        result = b / a;// 将操作结果放入操作数栈      
                        NumStack.push(result);      
                        break;      
                    }      
      
                }      
                
                // 判断当前运算符与栈顶元素优先级， 如果高，或者低于平，计算完后，将当前操作符号，放入操作符栈      
                if (Dep.charAt(0) != ' ') {      
                    SymStack.push(new Character(Dep.charAt(0)));      
                    if (Dep.charAt(0) == ')') {// 当栈顶为'('，而当前元素为')'时，则是括号内已算完，去掉括号      
                        SymStack.pop();      
                        SymStack.pop();      
                    }      
                }      
            } else      
                // 当为非操作符时（数字）      
                tempNum = tempNum.append(Dep);// 将读到的这一位数接到以读出的数后(当不是个位数的时候)      
        }      
        return NumStack.pop();      
    }      
      
  //判断输入的是否为数字
    private boolean Num(String temp) {      
        return temp.matches("[0-9]");      
    }      
  
    private boolean com(char str) {      
        if (SymStack.empty()) {      
            // 当为空时，显然 当前优先级最低，返回高      
            return true;      
        }      
        char last = (char) SymStack.lastElement();      
        // 如果栈顶为'('显然，优先级最低，')'不可能为栈顶。      
        if (last == '(') {      
            return true;      
        }
        switch (str) {      
        case '=':      
            return false;// 结束符      
        case '(':      
            // '('优先级最高,显然返回true      
            return true;      
        case ')':      
            // ')'优先级最低，      
            return false;      
        case '*': {      
            // '*/'优先级只比'+-'高      
            if (last == '+' || last == '-')      
                return true;      
            else      
                return false;      
        }      
        case '/': {      
            if (last == '+' || last == '-')      
                return true;      
            else      
                return false;      
        }      
            // '+-'为最低，一直返回false      
        case '+':      
            return false;      
        case '-':      
            return false;      
        }
        return true;      
    }      
      
	public static void main(String args[]) throws IOException {
		try {
			File file1 = new File("out.txt");
			// 如果文件不存在，则新建一个文件
			if (!file1.exists()) {
				file1.createNewFile();
			}
			FileWriter fileWritter = new FileWriter(file1.getName(), true);
			File file = new File("equation.txt");
			BufferedReader reader = null;
			String temp = null;// 存放文件中每行读取的算式
			try {
				reader = new BufferedReader(new FileReader(file));
				while ((temp = reader.readLine()) != null) {
					// System.out.println(temp);
					Calculator equation = new Calculator();
					String t = equation.judge(temp);// 进行算式的校验
					if (t == " ") {
						int a = equation.caculate(temp);// 如果返回"空格"，则说明算式正确，计算结果
						System.out.println(temp + "" + a);
						fileWritter.write(temp + "" + a + "\r\n");
					} else {
						System.out.println("ERROR");
						System.out.println(t);// 返回错误，打印错误信息
						fileWritter.write("ERROR" + "\r\n");
						fileWritter.write(t + "\r\n");
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			fileWritter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
