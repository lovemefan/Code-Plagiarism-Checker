
public class Check {
	public Check(){
		
	}

	
	//�ж����������Ƿ����
	public int check(String d){
		char[] arr = d.toCharArray();
		int n1 = 0;
		int n2 = 0;
		
		for(int i = 0 ; i < arr.length ; i++){
			if(arr[i] == '(')
				n1++;
			if(arr[i] == ')')
				n2++;
			if(n1 < n2)
				return 0;
		}
		if(n1 == n2)
			return 1;
		else
			return 0; 
	}

	  //�ж�a[b-1]�Ƿ�Ϊ�����
  public int check2(String a , int b){
	  char[] arr = a.toCharArray();
	  if(arr[b-1] == '+' || arr[b-1] == '-' || arr[b-1] == '*' || arr[b-1] == '/' || arr[b-1] == '(')
	    return 0;
	  return 1;
  }
}