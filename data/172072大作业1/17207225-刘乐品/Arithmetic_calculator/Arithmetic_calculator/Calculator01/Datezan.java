package Calculator01;

public class Datezan {
	
	public int priority(int a,char op)
	{
		
		int i,k=0;
		char[] fu=new char[]{'+','-','*','/','(',')','#'};
		int[]  re1=new int[]{3,3,5,5,1,6,0};
		int[]  re0=new int[]{2,2,4,4,6,1,0};
		for(i=0;i<fu.length;i++)
		{
			if(a==1&&op==fu[i])
			{
				k=re1[i];
			}
			if(a==0&&op==fu[i])
				k=re0[i];
		}
		return k;	
		
	   /* if(a==1)
	        switch(op){//Õ»ÄÚ 
	            case '+': return 3;
	            case '-': return 3;
	            case '*': return 5;
	            case '/': return 5;
	            case '(': return 1;
	            case ')': return 6;
	            case '#': return 0; 
	        }
	    
	    	if(a==0)
	        switch(op){//Õ»Íâ 
	            case '+': return 2;
	            case '-': return 2;
	            case '*': return 4;
	            case '/': return 4;
	            case '(': return 6;
	            case ')': return 1;
	        }
	    
	    	return 0;*/
	}

	public static void main(String[] args) {
		//Datezan ap=new Datezan();
		//System.out.println(ap.priority(1,')'));
		
		
		
		// TODO Auto-generated method stub

	}

}
