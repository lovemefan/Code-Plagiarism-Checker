package Extra_1_Refactoring;

public class PopAndPush {
	PopAndPush(){
		
	}
		public void pop(String a[],int n){
				a[n]=a[n+1];
		}
		public String popAndReturn(String a[],int n){
			String str="";
			str=a[n];
			a[n]=a[n+1];
			n--;
			return str;
	}
}
