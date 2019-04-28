
	import java.io.File;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.Scanner;

	
	public class main {
	    public static void main(String[] args) throws IOException{

	  //  	Scanner input = new Scanner(System.in);
	    	String expression = "";
	        
	        
	        File file1 = new File("F:\\学习\\JAVA\\Read.txt");
	        Scanner input1 = new Scanner(file1);
	        
	       
	        File file = new File("F:\\学习\\JAVA\\Write.txt");
	        
	        PrintWriter output = new PrintWriter(file);
	        
	        
	        while(input1.hasNext()){
	        	expression =  input1.nextLine();//从文件中读取数据
	        	
	        	Regular regular = new Regular(expression);
	       	    if(regular.deal()){
	       	    	
	       	    	expression = regular.getExpression();
	       	    	Stack<String> stack = new Stack<>();
	       	    	InfixToPost infix = new InfixToPost(stack, expression);
	       	    	infix.process();
	       	    	
	       	    	String post = infix.getPost();
	       	    	Stack<Integer> stack_result = new Stack<>();
	       	    	PostToResult ptr = new PostToResult(post, stack_result);
	       	    	ptr.operate();
	       	    	int result = ptr.getResult();
	       	    	System.out.println(result);
	       	    	
	       	    	output.print(expression);
	       	    	output.print("=");
	       	    	output.println(result);	
	       	    	}else{
	       	    		if(regular.IsEmpty()){
	       	    			output.println("ERROR");
	       	 				output.println("#空字符串");
	       	    		}else if(regular.EmptyParentheses()){
	       	    			output.println("ERROR");
	       	    			output.println("#空括号");
	       	    		}else if(regular.OperateContinue()){
	       	    			output.println("ERROR");
	       	 				output.println("#运算符连续");
	       	    		}else if(regular.FrongIsOperate()){
	       	    			output.println("ERROR");
	       	 				output.println("#)前是运算符");
	       	    		}else if(regular.BehindIsOperate()){
	       	    			output.println("ERROR");
	       	 				output.println("#(后是运算符");
	       	    		}else if(regular.FrontIsnotOperate()){
	       	    			output.println("ERROR");
	       	    			output.println("#(前面不是运算符");
	       	    		}else if(regular.BehingIsnotOperate()){
	       	    			output.println("ERROR");
	       	    			output.println("#)后面不是运算符");
	       	    		}else if(regular.IllegalityOperate()){
	       	    			output.println("ERROR");
	       	    			output.println("#表达式内含非法字符");
	       	    		}
	       	    	}
	       
	        }
	        input1.close();
 	        output.close();
	    }
	    
	}
