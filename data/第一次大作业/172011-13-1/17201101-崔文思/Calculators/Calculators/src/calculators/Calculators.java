package calculators;

//import java.util.Stack;
//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.Collections;
//private Stack<Character>opStack=new Stack<Character>();  //
//private int [] operatPriority  = new int[] {0,3,2,1,-1,1,0,2};//���������ASCII��-40����������������ȼ�




public class Calculators {
 
    private String post;     //
    private LinkStack<Integer> stack;   //������ջ
    private int result = 0;
   
    public Calculators(){
    	
    }
    
    public Calculators(String post){
    	this.post=post;
    }
    
    public Calculators(String post,LinkStack<Integer> stack){    
    	this.post=post;
    	this.stack=stack;                 
    }
    
    public String  setPost(String post){
    	this.post=post;
    	return post;
    }
    
    public int compute(String str){      //����ջ����������
    	int re=0;
    	int m=stack.pop();
    	int n=stack.pop();
    	switch(str){
    	case"+":re=n+m;break;
    	case"-":re=n-m;break;
    	case"*":re=n*m;break;
    	case"/":re=n/m;break;
    	default:break;	
    	}
    	return re;
    }
    
    
    public boolean isDigital(String str){          //�ж��Ƿ�Ϊ����
    	char[] chArr=str.toCharArray();
    	int len =chArr.length;
    	int count =0;
    	for(int i=0;i<len;i++){
    		if(chArr[i]>='0'&&chArr[i]<='9')
    			count++;
    	}
    	return count == len;
    }
    
    
    public int grtResult(){
    	return stack.pop();
    }
    
	//�����׺���ʽ     Integer.valueOf(temp)
	public void calculate(String post){
		
		String[] strArr=post.split(" ");
		for(int i=0;i<strArr.length;i++){
			String temp =strArr[i];
		   if(isDigital(temp)){   
				stack.push(Integer.valueOf(temp));
			}
			else{
				int result =compute(temp);
				stack.push(result);
			}
		}
		result = stack.pop();
	}
	
	public int getResult(){
	
		return result;
	}
	
  
}
