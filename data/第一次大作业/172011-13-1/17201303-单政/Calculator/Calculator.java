
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
	    public static char[][] level = {

	        {'>','>','<','<','<','>','>'},

	        {'>','>','<','<','<','>','>'},

	        {'>','>','>','>','<','>','>'},

	        {'>','>','>','>','<','>','>'},

	        {'<','<','<','<','<','=','0'},

	        {'>','>','>','>','0','>','>'},

	        {'<','<','<','<','<','0','='},

	    };

	 

	    public static void main(String[] args) {

	 

	        Scanner in = new Scanner(System.in);

	        String str;

	        while ((str = in.next()) != "#") {

	            double sum = cal(str);

	            System.out.println(sum);

	        }

	    }

	 

	    public static char getLevel(char a,char b) {

	        int i = 0,j = 0;

	        switch(a)

	        {

	            case'+':i=0;break;

	            case'-':i=1;break;

	            case'*':i=2;break;

	            case'/':i=3;break;

	            case'(':i=4;break;

	            case')':i=5;break;

	            case'=':i=6;break;

	        }

	        switch(b)

	        {

	            case'+':j=0;break;

	            case'-':j=1;break;

	            case'*':j=2;break;

	            case'/':j=3;break;

	            case'(':j=4;break;

	            case')':j=5;break;

	            case'=':j=6;break;

	        }

	        return level[i][j];

	    }

	 

	    public static double cal(String str) {

	 

	        char[] chars = str.toCharArray();

	        int k = 0;

	        Stack<Double> numStack = new Stack<>();

	        Stack<Character> opStack = new Stack<>();

	        opStack.push('=');

	       
	        while (chars[k] != '=' || opStack.peek() != '=') {

	            if (chars[k] >= '0' && chars[k] <= '9') {

	                double sum = 0;

	                while (chars[k] >= '0' && chars[k] <= '9') {

	                    sum = sum * 10 + (chars[k] - '0');

	                    k++;

	                }

	                if (chars[k] == '.') {


	                    k++;

	                    double sum1 = 0;

	                    int total = 0;

	                    while (chars[k] >= '0' && chars[k] <= '9') {

	                        total++;

	                        sum1 = sum1 * 10 + (chars[k] - '0');

	                        k++;

	                    }

	                    sum += sum1 / Math.pow(10,total);

	                }

	                numStack.push(sum);

	            } else {

	                switch (getLevel(opStack.peek(),chars[k])) {

	                    case '<' :

	                        opStack.push(chars[k]);

	                        k++;

	                        break;

	                    case '=' :

	                        opStack.pop();

	                        k++;

	                        break;

	                    case '>' :

	                        double m = numStack.pop();

	                        double n = numStack.pop();

	                       
	                        numStack.push(operate(n,m,opStack.pop()));

	                }

	            }

	        }

	        return numStack.pop();

	    }

	 

	    public static double operate(double a,double b,char c) {

	        if (c == '+') {

	            return a + b;

	        } else if (c == '-') {

	            return  a - b;

	        } else if (c == '*') {

	            return a * b;

	        } else  {

	            return a / b;

	        }

	    }
}
