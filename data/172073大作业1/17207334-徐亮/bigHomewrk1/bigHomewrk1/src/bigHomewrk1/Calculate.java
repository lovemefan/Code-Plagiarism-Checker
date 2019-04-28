package bigHomewrk1;

import java.util.Stack;

class Calculate {
	private float calculationResults;
	private Stack<Float> nums = new Stack<>();//保存运算数字的栈
	private Stack<String> symbols = new Stack<>();//保存运算符号的栈
	private int anti = 0;			//得到antiPolish含有值的长度

	Calculate(String equation) {
		equation = equation + '#';	//方便进行最后字符的判断
		String[] antiPolish;
		antiPolish = setAntiPolish(equation);
		getAntiPolish(antiPolish);
	}
	
	//把数字与操作符分别存储在一个字符串数组，便于得到逆波兰表达式
	private String[] setAntiPolish(String equation) {
		int[] index = new int[equation.length()];
		String[] antiPolish = new String[equation.length()];
		
		int i = 0;
		int num = 0;
		int adress = 0;
		
		if(!Character.isDigit(i)) {
			index[adress] = i;	//记录符号下标
			num++; 				//记录符号个数
			adress++;
			i++;
		}

		
		//记录操作符所在的位置
		while(i != equation.length()-1) { // equation.charAt(i) != '#';
			if(!Character.isDigit(equation.charAt(i))) {
				if(equation.charAt(i) != '.') {			
					if(equation.charAt(i) == '-' && equation.charAt(i-1) == '(') {
						
					}else {
						index[adress] = i;	//记录符号下标
						num++; 				//记录符号个数
						adress++;
					}
				}
				/*
				 if()
				 */
			}
			i++;
		}
	
		//由记录下的操作符位置分理出操作数与操作符
		int j = 0;
		adress = 0;
		if(index[0] != 0) {			
			antiPolish[j] = equation.substring(0,index[adress]);
			j++;
		}	
		while(adress < num) {
			if(!Character.isDigit(equation.charAt(index[adress]+1)) && equation.charAt(index[adress]+1) != '-') {
				antiPolish[j] = equation.substring(index[adress], index[adress]+1);
			}else {
				antiPolish[j] = equation.substring(index[adress], index[adress]+1);
				j++;
				if(adress == num-1) {
					antiPolish[j] = equation.substring(index[adress]+1,equation.length()-1);
				}else
					antiPolish[j] = equation.substring(index[adress]+1,index[adress+1]);
			}
			adress++;
			j++;
		}
		anti = j;	//记录antiPolish有值的长度；
		return antiPolish;
	}
	
	//得到逆波兰表达式
	private void getAntiPolish(String[] antiPolish) {
		int adress = 0;
		
		for(int i=0; i<anti;i++) {
			switch(antiPolish[i]) {
				case "(":
					symbols.push(antiPolish[i]);
					break;
				case ")":
					while(!symbols.peek().equals("(") && !symbols.empty()) {
						antiPolish[adress] = symbols.pop();
						adress++;
					}
					symbols.pop();
					break;
					
				case "+":
				case "-":
					while(!symbols.empty() && !symbols.peek().equals("(")) {
						antiPolish[adress] = symbols.pop();
						adress++;
					}	
					symbols.push(antiPolish[i]);
					break;
					
				case "*":
					if(symbols.peek().equals("/") && !symbols.empty()) {
						antiPolish[adress] = symbols.pop();
						adress++;
					}
					symbols.push(antiPolish[i]);
					break;
				case "/":
					if(!symbols.empty() && symbols.peek().equals("*")) {
						antiPolish[adress] = symbols.pop();
						adress++;
					}
					symbols.push(antiPolish[i]);
					break;
				default:
					antiPolish[adress] = antiPolish[i];
					adress++;
					break;
			}
		
		}
		while(!symbols.empty()) {
			antiPolish[adress] = symbols.pop();
			adress++;
		}
		setCalculationResult(antiPolish,adress);
	}
	
	//运算逆波兰表达式
	private void setCalculationResult(String[] antiPolish,int adress) {
		int i = 0;
		float temp = 0;
		while(i < adress) {
			switch(antiPolish[i]) {
				case"+":
					temp = nums.pop();
					nums.push(nums.pop() + temp);
					break;
				case"-":
					temp = nums.pop();
					nums.push(nums.pop() - temp);
					break;
				case"*":
					temp = nums.pop();
					nums.push(nums.pop() * temp);
					break;
				case"/":
					temp = nums.pop();
					if(temp == 0) {		
						
					}
					nums.push(nums.pop() / temp);
					break;
				default:
					nums.push(Float.parseFloat(antiPolish[i]));
					break;
			}
			i++;
		}
		calculationResults = nums.peek();
	}
	public float getCalculationResults() {
		return calculationResults;
	}
}
