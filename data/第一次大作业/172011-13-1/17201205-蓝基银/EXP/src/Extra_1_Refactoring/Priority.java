package Extra_1_Refactoring;

public class Priority {
		Priority(){
			
		}
		int pri(char a){
			switch (a){
			case '+':
			return 1;
			case '-':
			return 1;
			case '*':
			return 2;
			case '/':
			return 2;
			case '(':
				return 0;
			default:
			return 0;//正常情况这里不应该被触发
			}
		
		}
}
