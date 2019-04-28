package class1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Infix {

	   
		private String infix = "";//���봮
		private String pro = "";//���صĴ�����Ϣ
		private String post = "";//��׺���ʽ
		private Deque<String> stack= new LinkedList<String>();//�����������ջ

		public Infix(String infix){	//���캯�����ظ�ʹ��
			this.infix = infix;
		}
		 
		public String getInfix(){//�õ���ʼ����
			return this.infix;
		}
		public void setInfix(String infix){//������ʽ��Ŀո�
			this.infix = infix;
		}
		public String getPro(){//�õ�������Ϣ
			return this.pro;
		}
		
		//����У��:���ַ����������������++���������š����Ų���ԡ�(���������
       //)ǰ����������� (ǰ�治���������  )���治������������ʽ�ں��Ƿ��ַ��ȡ�
		public boolean ConInfix(String infix){//����Ȧ���Ӷȣ���definfix��
			if (infix.matches("[-][\\S]*") == true){
				pro = "ERROR\r\n#No negative numbers!";
				return false;
			}
			if(infix.matches("[\\S]*[\\+\\-\\*\\/]{2,}[\\S]*") == true){//���������
				pro = "ERROR\r\n#Duplicate symbols!" ;
			    return false;
			   }
		    if ( infix.matches("[\\S]*[\\(][\\)][\\S]*") == true){//������//����ʹ��\S
				pro = "ERROR\r\n#Empty parentheses!" ;
			    return false;
		    }
            if (infix.matches("[\\S]*[\\+\\-\\*\\/]") == true){
            	pro = "ERROR\r\n#End with symbols!";
            	return false;
            }
		     if ( infix.matches("[\\S]*[\\(][\\+\\-\\*\\/][\\S]*") == true){//(���������
			   pro = "ERROR\r\n#The operator is behind the left parentheses!" ;
			    return false;
		   }
   
		     if ( infix.matches("[\\S]*[\\+\\-\\*\\/][\\)][\\S]*") == true){//)ǰ���������
			   pro = "ERROR\r\n#The operator is before the right parentheses!" ;
			    return false;
		   }
		     if(infix.matches("[\\S]*[^\\+\\-\\*\\/][\\(][\\S]*") == true){//(ǰ�治�������
			   pro = "ERROR\r\n#The operator is not before the left parentheses!" ;
			    return false;
		  }
		     if(infix.matches("[\\S]*[\\)][^\\+\\-\\*\\/][\\S]*") == true){//)���治�������
			  pro = "ERROR\r\n#The operator is not after the right parentheses!" ;
			    return false;
		  }
			
	
			return true;
		}
		public boolean defInfix(String infix){
			

			//int flag = 0;//�ж��Ƿ��зǷ��ַ��ı��
			
			if (infix.matches("(\\s)*")){//�մ�
				pro = "ERROR\r\n#Empty String!" ;

				return false;
			}
			
		    if (infix.matches("[\\d\\+\\-\\*\\/\\(\\)\\s]*") == true){//�ж��Ƿ��зǷ��ַ�
				//flag = 1;
		    	if (ConInfix(infix) == true){
		    		
		    		int leftcount = 0,rightcount = 0;//���Ų�ƥ������
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
		
		
	    public boolean isDigital (char ch){//�ж�ÿ���ַ��Ƿ�Ϊ����
	    	if ( ch >= '0' && ch <='9')
	    		return true;
	    	else
	    		return false;
	    }
		
		
		public String PreDealInfix(String infix){//��׺����ʽ,��ֹ��λ���͵�λ��������
//	    System.out.println(infix);
//		System.out.println(infix.length());
			String dealedInfix = "";//����֮�����׺ʽ ������null
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
		
	
	     public int defPrior(String my){  //�ж����ȼ�

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
	
         public void process(String str,int prior){//*  //�������
//			  String top = stack.pop();
//			  int a = defPrior(top);
			 //���ջ��Ԫ�ص����ȼ�
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
        	  stack.push(str);//����һ����ֱ�ӷ���ջ
          }
       
 	
	  
	 
	     public void pairing(String str){ //ƥ���Ҵ�����
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
	    		 
		  
	  
	 
	  
	    public void toTheSuffix(String infix){//��׺ת��Ϊ��׺

		  String[] arr = PreDealInfix(infix).split(" ");//���ո�ֿ�

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
		  while (!stack.isEmpty()){//�����ʽɨ�������ջ�ڵ������û���
			  post += " "+ stack.pop();
		  }
	  }
	  
	  
         public String getPost(){//��ת�������ĺ�׺����
		  return post.trim();
	  }

	    
	  
}
