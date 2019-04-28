package class1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Infix {

	   
		private String infix = "";//输入串
		private String pro = "";//返回的错误信息
		private String post = "";//后缀表达式
		private Deque<String> stack= new LinkedList<String>();//保存操作符的栈

		public Infix(String infix){	//构造函数，重复使用
			this.infix = infix;
		}
		 
		public String getInfix(){//得到初始输入
			return this.infix;
		}
		public void setInfix(String infix){//处理算式里的空格
			this.infix = infix;
		}
		public String getPro(){//得到错误信息
			return this.pro;
		}
		
		//输入校验:空字符串、运算符连续（++）、空括号、括号不配对、(后是运算符
       //)前面是运算符、 (前面不是运算符、  )后面不是运算符、表达式内含非法字符等。
		public boolean ConInfix(String infix){//降低圈复杂度，把definfix拆开
			if (infix.matches("[-][\\S]*") == true){
				pro = "ERROR\r\n#No negative numbers!";
				return false;
			}
			if(infix.matches("[\\S]*[\\+\\-\\*\\/]{2,}[\\S]*") == true){//运算符连续
				pro = "ERROR\r\n#Duplicate symbols!" ;
			    return false;
			   }
		    if ( infix.matches("[\\S]*[\\(][\\)][\\S]*") == true){//空括号//不能使用\S
				pro = "ERROR\r\n#Empty parentheses!" ;
			    return false;
		    }
            if (infix.matches("[\\S]*[\\+\\-\\*\\/]") == true){
            	pro = "ERROR\r\n#End with symbols!";
            	return false;
            }
		     if ( infix.matches("[\\S]*[\\(][\\+\\-\\*\\/][\\S]*") == true){//(后是运算符
			   pro = "ERROR\r\n#The operator is behind the left parentheses!" ;
			    return false;
		   }
   
		     if ( infix.matches("[\\S]*[\\+\\-\\*\\/][\\)][\\S]*") == true){//)前面是运算符
			   pro = "ERROR\r\n#The operator is before the right parentheses!" ;
			    return false;
		   }
		     if(infix.matches("[\\S]*[^\\+\\-\\*\\/][\\(][\\S]*") == true){//(前面不是运算符
			   pro = "ERROR\r\n#The operator is not before the left parentheses!" ;
			    return false;
		  }
		     if(infix.matches("[\\S]*[\\)][^\\+\\-\\*\\/][\\S]*") == true){//)后面不是运算符
			  pro = "ERROR\r\n#The operator is not after the right parentheses!" ;
			    return false;
		  }
			
	
			return true;
		}
		public boolean defInfix(String infix){
			

			//int flag = 0;//判断是否有非法字符的标记
			
			if (infix.matches("(\\s)*")){//空串
				pro = "ERROR\r\n#Empty String!" ;

				return false;
			}
			
		    if (infix.matches("[\\d\\+\\-\\*\\/\\(\\)\\s]*") == true){//判断是否有非法字符
				//flag = 1;
		    	if (ConInfix(infix) == true){
		    		
		    		int leftcount = 0,rightcount = 0;//括号不匹配的情况
					  for (int i = 0 ;i < infix.length() ;i ++ ){
						  if (infix.charAt(i) == '(')
							  leftcount ++;
						  if (infix.charAt(i) == ')')
							  rightcount ++;
					  }
					  if (leftcount != rightcount){
						  pro = "ERROR\r\n#The parentheses is not match!" ;
						    return false;
		    	}
		      }
		    	else{
		    		return false ;
		    	}
		    }
		   else{
		    	pro = "ERROR\r\n#Illegal character!" ;
				return false;
		       }
			
		return true;
		
		}
		
		
	    public boolean isDigital (char ch){//判断每个字符是否为数字
	    	if ( ch >= '0' && ch <='9')
	    		return true;
	    	else
	    		return false;
	    }
		
		
		public String PreDealInfix(String infix){//中缀处理式,防止多位数和单位数被混淆
//	    System.out.println(infix);
//		System.out.println(infix.length());
			String dealedInfix = "";//处理之后的中缀式 不能用null
            for (int i = 0; i < infix.length() - 1; i ++ ){
            	char first = infix.charAt(i);
            	char next = infix.charAt(i + 1);
            	if (isDigital(first) && isDigital(next)){
            		 dealedInfix += first;
            	}
            	else{
            		dealedInfix += first + " ";
            	}
            	
            }
            dealedInfix += infix.charAt(infix.length() - 1);
            
		    return dealedInfix;
		}
		
	
	     public int defPrior(String my){  //判断优先级

		  int a = 0;
//		  if (my == "+" ){
//			  a = 0;
//		  }
//		  if (my == "-"){
//			  a = 0;
//		  }
//		  if (my == "*" ){
//			  a = 1;
//		  }
//		  if (my == "/" ){
//			  a = 1;
//		  }
		  if (my.equals("+")||my.equals("-"))
			  a = 0;
		  else
			  a = 1;
		  return a;
	  }
	
         public void process(String str,int prior){//*  //处理符号
//			  String top = stack.pop();
//			  int a = defPrior(top);
			 //获得栈顶元素的优先级
//			    while (defPrior(stack.pop()) > prior){
//			    	post += " " + ;
//			    
//			    }
        //	 System.out.println(str + ":");
      
        	  while (!stack.isEmpty()){
      			
    	       String top = stack.pop();
    		   if (top.equals("(")){
    				  stack.push(top);
    			      break;
        	  } 
    		   else{
    				  int toppri = defPrior(top);
    				  if (toppri >= prior){
    					  post += " " + top;
    					  //System.out.println(post);
    				  }
    				  else{
    					  stack.push(top);
    					  break;
    			  }
    			  }
    				  
    		  }
        	  stack.push(str);//将第一个数直接放入栈
          }
       
 	
	  
	 
	     public void pairing(String str){ //匹配右大括号
//		  while (stack.pop() != "("){
//			  
//		  }
	    
	    
	    		while (!stack.isEmpty()){
	  			  String top = stack.pop();
	  			  if (top.equals("(")){
	  				  break;
	  			  }
	  			  else{
	  				  post += " " + top;
	  			  }
	  		  }
	    	}
	    		 
		  
	  
	 
	  
	    public void toTheSuffix(String infix){//中缀转化为后缀

		  String[] arr = PreDealInfix(infix).split(" ");//按空格分开

		  for (int i = 0;i < arr.length;i ++){
			  String str = ""; 
			 str = arr[i];
			  switch (str){
			     case "+" :
			    	    process(str,0);
			    	    break;
			     case "-" :
			    	    process(str,0);
			    	    break;
			     case "*":
			    	    process(str,1);
		    	        break;
			     case "/":
			    	     process(str,1);
			    	     break;
			     case "(":
			    	     stack.push(str);
			    	     break;
			     case ")":
			    	     pairing(str);
			    	     break;
			     default :
			    	     post +=" " +str;
			    	     break;
			  } 
		  }
		  while (!stack.isEmpty()){//当表达式扫描完后还有栈内的运算符没输出
			  post += " "+ stack.pop();
		  }
	  }
	  
	  
         public String getPost(){//把转化出来的后缀返回
		  return post.trim();
	  }

	    
	  
}
