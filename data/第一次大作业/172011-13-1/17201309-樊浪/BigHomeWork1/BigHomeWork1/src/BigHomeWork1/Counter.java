package BigHomeWork1;
// 计算类，计算表达式的结果
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter {
	
	public Counter(){
		
	}
	// 将数据存入字符串数组
	public static String[] storeStr(String newStr){
		StackLine line = new StackLine();
		String s = "[\\+\\-\\*\\/\\(\\)]|\\d+";// 用正则表达式拆分数据
		
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(newStr);
		int i = 0;
		while (matcher.find()) {// 不断查找序列
			Node p = new Node();
			p.setData(matcher.group());
			p.setNext(line.getTop().getNext());
			line.getTop().setNext(p);
			i ++;  // 记录字符串数组的需要的长度
		}
		String[] expression = new String[i];
		
		for (int j = i - 1; j >= 0;j--){ // 将数据记录到字符串数组中
			expression[j] = line.getTop().getNext().getData();
			line.getTop().setNext(line.getTop().getNext().getNext());
			//System.out.println(expression[j]);
		}

		return expression;
	}
	// 将中缀表达式转化成后缀表达式并将其存入字符串数组
	public static String[] transform(String[] newExp){
		String[] postfix = new String[newExp.length];
		int spot1 = 0; // newExp中当前字符串的位置
		int spot2 = 0; // postfix中记录字符串的位置
		int bracket = 0; //记录newExp中括号的数量
		StackLine lineStr = new StackLine();
		
		while (spot1 < newExp.length){
			if (Character.isDigit(newExp[spot1].charAt(0))){// 如果是数字，直接进入字符串数组
				postfix[spot2] = newExp[spot1];
				spot2 ++;
			}
			else{
			    if (newExp[spot1].equals("+") || newExp[spot1].equals("-")){// 如果是 '+' 或者 '-'
			    	spot2 = isAddOrSubtract(postfix,spot2,lineStr);
			    }
			    if (newExp[spot1].equals("*") || newExp[spot1].equals("/")){// 如果是'*' 或者 '/'
			    	spot2 = isMultipleOrDivision(postfix,spot2,lineStr);
			    }
			    if (newExp[spot1].equals(")")){// 如果是')'
			    	spot2 = isRightBracket(postfix,spot2,lineStr);
			    	bracket += 2;
			    	spot1 ++;
			    	continue;
			    }
			    Node next = new Node(newExp[spot1]);
			    lineStr.push(next);
			}
			spot1 ++;
		}
		
		while (spot2 < postfix.length - bracket){
			postfix[spot2] = lineStr.getTop().getNext().getData();
			spot2 ++;
			lineStr.getTop().setNext(lineStr.getTop().getNext().getNext());
		}
		/*for (int k = 0;k < spot2 ;k ++){
			System.out.print(postfix[k]);
		}*/
		return postfix;
	}
	// 将数字存入栈
	public static void isNumber(String newStr,String[] newExp,int newSpot){ 
		newExp[newSpot] = newStr; 
	}
	// 如果是 +,-,(
	public static int isAddOrSubtract(String[] newExp,int newSpot,StackLine newLineStr){
		Node n = newLineStr.getTop().getNext();
	    while (n != null && !n.getData().equals("(")){
		    newExp[newSpot] = n.getData();
		    newSpot ++;
		    n = n .getNext();
		    newLineStr.pop();
	    }
	    return newSpot;
	}
	// 如果是 *,/
	public static int isMultipleOrDivision(String[] newExp,int newSpot,StackLine newLineStr){
		Node n = newLineStr.getTop().getNext();
	    if (n != null && (n.getData().equals("*") || n.getData().equals("/"))){
		    while (n != null && !n.getData().equals("(")){
		    	newExp[newSpot] = n.getData();
			    newSpot ++;
			    n = n .getNext();
			    newLineStr.pop();
		    }
	    }
	    return newSpot;
	}
	// 如果是 )
	public static int isRightBracket(String[] newExp,int newSpot,StackLine newLineStr){
		Node n = newLineStr.getTop().getNext();
    	while (!n.getData().equals("(")){
    		newExp[newSpot] = n.getData();
		    newSpot ++;
    		n = n.getNext();
    		newLineStr.pop();
    	}
    	newLineStr.pop();	
    	return newSpot;
	}
    // 计算后缀表达式
	public static double getResult(String[] newStr){
		double result = 0;
		int spot1 = 0;
		double[] number = new double[newStr.length];
		int spot2 = 0;
		
		while (spot1 < newStr.length && newStr[spot1] != null){
			if(Character.isDigit(newStr[spot1].charAt(0))){
				number[spot2] =Double.valueOf(newStr[spot1]);
				spot2 ++;
			}
			else{
				switch (newStr[spot1]){
				case "+":
					number[spot2 - 2] = number[spot2 - 2] + number[spot2 - 1];
					spot2 --;
					break;
				case "-":
					number[spot2 - 2] = number[spot2 - 2] - number[spot2 - 1];
					spot2 --;
					break;
				case "*":
					number[spot2 - 2] = number[spot2 - 2] * number[spot2 - 1];
					spot2 --;
					break;
				case "/":
					if (number[spot2 - 1] == 0){
						System.out.println("ERROR\n#除数不能为0");
						return (float)0.00001;
					}
					number[spot2 - 2] = number[spot2 - 2] / number[spot2 - 1];
					spot2 --;
					break;
				}
			}
			spot1 ++;
		}
		result = number[0];
		return result;
	}
}
