package homeWork;

public class Priority {
	public String comparePriority(String ch,String topOprator) {//判断优先级
		String temp=ch;
		String [][] representPriority={{">",">","<","<","<",">",">"},
									   {">",">","<","<","<",">",">"},
									   {">",">",">",">","<",">",">"},
									   {">",">",">",">","<",">",">"},
									   {"<","<","<","<","<","=","?"},
									   {">",">",">",">","?",">",">"},
									   {"<","<","<","<","<","?","="}};
		int x=0,y=0;
		for(int i=0;i<=1;i++){
			switch(temp){
			case "+":
				x=0;
				break;
			case "-":
				x=1;
				break;
			case "*":
				x=2;
				break;
			case "/":
				x=3;
				break;
			case "(":
				x=4;
				break;
			case ")":
				x=5;
				break;
			case "#":
				x=6;
				break;
			}
			temp=topOprator;
			if(i==0)
			y=x;
		}
		/*
		 * for(int i=0;i<7;i++) for(int j=0;j<7;j++) {
		 * System.out.print(representPriority[i][j]+" "); if(j==6)
		 * System.out.print("\n"); }
		 */
				
		return temp=representPriority[x][y];
	}
}

