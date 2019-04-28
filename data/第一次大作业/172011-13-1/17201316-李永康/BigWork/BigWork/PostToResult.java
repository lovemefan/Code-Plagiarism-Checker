package BigWork;

public class PostToResult {
	private String post;//后缀表达式
	private Stacks<Double> stack = new Stacks();//创建一个栈为Double类型
	//构造函数
	public PostToResult(String post){
		this.post = post;
	}
	//后缀表达式得出结果
	public double result(String post){
        String[] strings = post.split(" ");  //将字符串转化为字符串数组
        double finalResult = 0;
        for (int i = 0; i < strings.length;i ++){
        	strings[i] = strings[i].trim();  //去掉字符串首尾的空格
        }
		for(int i = 0;i < strings.length;i ++){
			if(strings[i].equals(" "))
				continue;
			else if(judge(strings[i])){
				stack.push(Double.valueOf(strings[i]));
			}
			else if(judge(strings[i]) == false){
				finalResult = value(strings[i]);
				stack.push(finalResult);
			}
		}
		return finalResult;
	}
	//出栈，并按照运算符计算
	public double value(String s){
		s = s.trim();
		double values = 0;
		double m = stack.pop();
		double n = stack.pop();
		switch(s){
		case "+":
			values = n + m;
			break;
		case "-":
			values = n - m;
			break;
		case "*":
			values = n * m;
			break;
		case "/":
			values = n / m;
			break;
		default :
			break;
		}
		return values;
	}
	//String转Double类
	public double stringToInt(String s){
		s = s.trim();
		double num = Double.valueOf(s);
		return num;
	}
	//判断字符串是否为数字
	public boolean judge(String s){
		boolean flag = true;
		for(int k = 0;k < s.length();k ++){
			if(s.charAt(k) > '9' || s.charAt(k) < '0')
				flag = false;
		}
		return flag;
	}
}
