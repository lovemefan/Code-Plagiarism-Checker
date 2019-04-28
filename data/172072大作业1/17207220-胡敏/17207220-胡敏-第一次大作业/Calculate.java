package ´ó×÷Òµ;//9,3,1,-,3,*,10,2,/,+,+

import java.util.Stack;

public class Calculate {
	public static String suffixtocal(String[] a) {
//		String[] a= {"9","3","1","-","3","*","10","2","/","+","+"};
		Stack<String> fig=new Stack<String>();
//		Stack<String> ope=new Stack<String>();
		for(int i=0;i<a.length;i++) {
			if(a[i].equals("-")||a[i].equals("+")||a[i].equals("*")||a[i].equals("/")) {
				if(!fig.isEmpty()) {
					String last=fig.pop();
					String first=fig.pop();
					Calcu(first,last,a[i],fig);
				}
			}
			else {
				fig.push(a[i]);
			}
		}
			String output=fig.pop();
	//		System.out.print("="+output+"\n\n");
			return "="+output;
	}

	private static void Calcu(String a, String b, String ope,Stack<String> fig) {
		double first=Double.parseDouble(a);
		double last=Double.parseDouble(b);
		if(ope.equals("+")) {
			String jia=String.valueOf(first+last);
			fig.push(jia);
		}
		
		if(ope.equals("-")) {
			String jia=String.valueOf(first-last);
			fig.push(jia);
		}
		
		if(ope.equals("*")) {
			String jia=String.valueOf(first*last);
			fig.push(jia);
		}
		
		if(ope.equals("/")) {
			String jia=String.valueOf(first/last);
			fig.push(jia);
		}
	}
}