
public class Check {
	public Check(){
		
	}

	
	//ÅĞ¶Ï×óÓÒÀ¨ºÅÊÇ·ñÅä¶Ô
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

	  //ÅĞ¶Ïa[b-1]ÊÇ·ñÎªÔËËã·û
  public int check2(String a , int b){
	  char[] arr = a.toCharArray();
	  if(arr[b-1] == '+' || arr[b-1] == '-' || arr[b-1] == '*' || arr[b-1] == '/' || arr[b-1] == '(')
	    return 0;
	  return 1;
  }
}