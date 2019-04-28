package Extra_1_Refactoring;

public class isWhat {
	public Boolean isOp (char a){
		if ((a=='+')||(a=='-')||(a=='*')||(a=='/')){
			return true;
		}
			else {
				return false;
			}
		
	}
	public Boolean isDi (char a){
		if ((a>='0')&&(a<='9')){
			return true;
		}
			else {
				return false;
			}
		
	}
	public int isBr (char a){
		if (a=='('){
			return 1;
		}
		if (a==')'){
			return -1;
		}else{
			return 0;
		}
		
	}
}
