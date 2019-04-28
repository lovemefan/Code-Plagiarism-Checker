import java.util.*;

class Check {
	   String expression;
	    
	     // 检测表达式是否合法
	
	    public int checkit() {
	        int flag = 0;
	        if(this.expression.length() == 0)
	            flag = 1;
	        else if (this.expression.matches("^(\\+|\\-|\\*|\\/).*|.*(\\+|\\-|\\*|\\/)$"))//不能以运算符为开头或结尾
	            flag = 2;
	        else if (this.expression.matches(".*([^0-9\\+\\-\\*\\/\\)\\(]).*"))      //不能有其他字符出现
	            flag = 3;
	        else if (this.expression.matches(".*([\\+\\-\\*\\/]{2,}).*"))//不能有连续运算符出现
	            flag = 4;
	        else if(this.expression.matches(".*(\\d\\(|\\)\\d).*"))      //左括号前和右括号后不能有数字
	            flag = 5;
	        else if(this.expression.matches(".*(\\(\\+|\\(\\-|\\(\\*|\\(\\/|\\+\\)|\\-\\)|\\*\\)|\\/\\)).*"))//左括号后和右括号前不能出现运算符
	            flag = 6;
	        else if(this.expression.matches(".*(\\(\\))"))
	            flag = 7;
	        return flag;
	    }

	
	     // 判断括号是否匹配
	     
	    public boolean BracktMatcher() {
	        Stack<Character> Brackt = new Stack<Character>();
	        int flag = 0;
	        for (int i = 0; i < this.expression.length(); i++){
	            flag = judge(i, Brackt);
	            if(flag == 1)
	                return false;
	        }
	        return Result(Brackt.size());
	    }
	    private int judge(int i, Stack<Character> Brackt){
	        int flag = 0;
	        if (this.expression.charAt(i) == '(')
	            Brackt.push(this.expression.charAt(i));
	        else if (this.expression.charAt(i) == ')'){
	            if(Brackt.size() == 0)
	                flag = 1;
	            else
	            {
	                if(Brackt.peek() == '(')
	                    Brackt.pop();
	                else
	                    flag = 1;
	            }
	        }
	        return flag;
	    }
	    private boolean Result(int num){
	        if (num != 0)
	            return false;
	        else
	            return true;
	    }

	    
	     // 根据判断生成错误类型

	    String OutError() {
	        String str = "";
	        if(!this.BracktMatcher())
	            str = "表达式内括号不配对  ^o^";
	        else{
	            int c = this.checkit();
	            switch (c) {
	                case 1: str = "表达式不可为空字符串（请勿输入空行）  ^o^"; break;
	                case 2: str = "表达式不可以把运算符作为开头或结尾  ^o^"; break;
	                case 3: str = "表达式内含非法字符  ^o^"; break;
	                case 4: str = "表达式内出现连续运算符  ^o^"; break;
	                case 5: str = "表达式内左括号前和右括号后不可为数字  ^o^"; break;
	                case 6: str = "表达式内左括号后和右括号前不可为运算符  ^o^"; break;
	                case 7: str = "表达式内出现空括号  ^o^"; break;
	            }
	        }
	        return str;
	    }
	}
