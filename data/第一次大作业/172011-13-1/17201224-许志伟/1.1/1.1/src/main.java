
	import java.io.File;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.Scanner;

	
	public class main {
	    public static void main(String[] args) throws IOException{

	  //  	Scanner input = new Scanner(System.in);
	    	String expression = "";
	        
	        
	        File file1 = new File("F:\\ѧϰ\\JAVA\\Read.txt");
	        Scanner input1 = new Scanner(file1);
	        
	       
	        File file = new File("F:\\ѧϰ\\JAVA\\Write.txt");
	        
	        PrintWriter output = new PrintWriter(file);
	        
	        
	        while(input1.hasNext()){
	        	expression =  input1.nextLine();//���ļ��ж�ȡ����
	        	
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
	       	 				output.println("#���ַ���");
	       	    		}else if(regular.EmptyParentheses()){
	       	    			output.println("ERROR");
	       	    			output.println("#������");
	       	    		}else if(regular.OperateContinue()){
	       	    			output.println("ERROR");
	       	 				output.println("#���������");
	       	    		}else if(regular.FrongIsOperate()){
	       	    			output.println("ERROR");
	       	 				output.println("#)ǰ�������");
	       	    		}else if(regular.BehindIsOperate()){
	       	    			output.println("ERROR");
	       	 				output.println("#(���������");
	       	    		}else if(regular.FrontIsnotOperate()){
	       	    			output.println("ERROR");
	       	    			output.println("#(ǰ�治�������");
	       	    		}else if(regular.BehingIsnotOperate()){
	       	    			output.println("ERROR");
	       	    			output.println("#)���治�������");
	       	    		}else if(regular.IllegalityOperate()){
	       	    			output.println("ERROR");
	       	    			output.println("#���ʽ�ں��Ƿ��ַ�");
	       	    		}
	       	    	}
	       
	        }
	        input1.close();
 	        output.close();
	    }
	    
	}
