package BigHomeWork1;
// �����࣬������ʽ�Ľ��
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter {
	
	public Counter(){
		
	}
	// �����ݴ����ַ�������
	public static String[] storeStr(String newStr){
		StackLine line = new StackLine();
		String s = "[\\+\\-\\*\\/\\(\\)]|\\d+";// ��������ʽ�������
		
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(newStr);
		int i = 0;
		while (matcher.find()) {// ���ϲ�������
			Node p = new Node();
			p.setData(matcher.group());
			p.setNext(line.getTop().getNext());
			line.getTop().setNext(p);
			i ++;  // ��¼�ַ����������Ҫ�ĳ���
		}
		String[] expression = new String[i];
		
		for (int j = i - 1; j >= 0;j--){ // �����ݼ�¼���ַ���������
			expression[j] = line.getTop().getNext().getData();
			line.getTop().setNext(line.getTop().getNext().getNext());
			//System.out.println(expression[j]);
		}

		return expression;
	}
	// ����׺���ʽת���ɺ�׺���ʽ����������ַ�������
	public static String[] transform(String[] newExp){
		String[] postfix = new String[newExp.length];
		int spot1 = 0; // newExp�е�ǰ�ַ�����λ��
		int spot2 = 0; // postfix�м�¼�ַ�����λ��
		int bracket = 0; //��¼newExp�����ŵ�����
		StackLine lineStr = new StackLine();
		
		while (spot1 < newExp.length){
			if (Character.isDigit(newExp[spot1].charAt(0))){// ��������֣�ֱ�ӽ����ַ�������
				postfix[spot2] = newExp[spot1];
				spot2 ++;
			}
			else{
			    if (newExp[spot1].equals("+") || newExp[spot1].equals("-")){// ����� '+' ���� '-'
			    	spot2 = isAddOrSubtract(postfix,spot2,lineStr);
			    }
			    if (newExp[spot1].equals("*") || newExp[spot1].equals("/")){// �����'*' ���� '/'
			    	spot2 = isMultipleOrDivision(postfix,spot2,lineStr);
			    }
			    if (newExp[spot1].equals(")")){// �����')'
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
	// �����ִ���ջ
	public static void isNumber(String newStr,String[] newExp,int newSpot){ 
		newExp[newSpot] = newStr; 
	}
	// ����� +,-,(
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
	// ����� *,/
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
	// ����� )
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
    // �����׺���ʽ
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
						System.out.println("ERROR\n#��������Ϊ0");
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
