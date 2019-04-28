 class ComparePriority {
	 String CompareThePriority(String c1,String c2) {//比较操作符的优先级
		int a=0,b=0;
		 
 String [][] prio=	{   // +   -  *   /    (   )   #
		 	    /*  + */ {">",">","<","<","<",">",">"},
				/*  - */ {">",">","<","<","<",">",">"},
				/*  * */ {">",">",">",">","<",">",">"},
				/*  / */ {">",">",">",">","<",">",">"},
				/*  ( */ {"<","<","<","<","<","="," "},
				/*  ) */ {">",">",">",">"," ",">",">"},
				/*  # */ {"<","<","<","<","<"," ","="}
				   };
		 switch(c1){
				 case "+":  a=0;break;
 				 case "-":	a=1;break;
				 case "*":  a=2;break;
				 case "/":  a=3;break;
				 case "(":  a=4;break;
				 case ")":  a=5;break;
				 case "#":  a=6;break;
				 
		 		}
		 switch(c2){
				 case "+":  b=0;break;
				 case "-":	b=1;break;
				 case "*":  b=2;break;
				 case "/":  b=3;break;
				 case "(":  b=4;break;
				 case ")":  b=5;break;
				 case "#":  b=6;break;
 		}
		 return  prio[a][b];	
	 }
 }
