package work;

public class Comper {
	//优先级比较
	char[][] symbol ={   
	    	{'>','>','<','<','<','>','>'},	//'+'
	    	{'>','>','<','<','<','>','>'},	//'-'
	        {'>','>','>','>','<','>','>'},	//'*'
	        {'>','>','>','>','<','>','>'},	//'/'
	        {'<','<','<','<','<','=','0'},	//'('
	        {'>','>','>','>','0','>','>'},	//')'
	        {'<','<','<','<','<','0','='}	//空栈
	    };
	public static int Symbol(char c)
	{
	    switch(c)
	    {
	        case '+': 
				return 0;
	        case '-': 
				return 1;
	        case '*': 
				return 2;
	        case '/': 
				return 3;
	        case '(': 
				return 4;
	        case ')':
				return 5;
	        default:  
				return -1;
	    }
	}
}
