import java.util.*; 
public class task315 {

	public static void main(String[] args){
		//产生随机数 并考虑一位或两位的情况
		int lottery=(int)(Math.random()*1000);
		String lo ="0";
	    if (lottery>99){
	    	lo=lottery+"";
	    }
	    else if (lottery>9&&lottery<100) {
	    	lo="0"+lottery+"";
	    }
	    else if (lottery<10){
	    	lo="00"+lottery+"";
	    } 
	   
   //输入用户数 并确定每一位转化成字符串
		Scanner input=new Scanner(System.in);
		System.out.println("Enter your lottery pick(three digits): ");
		int guess=input.nextInt();

		String guessDigit1=(guess/100)+"";
		String guessDigit2=(guess/10%10)+"";
		String guessDigit3=(guess%10)+"";
		
		
		System.out.println("The lottery number is "+lottery);
		
		int pos=0,count=0;
	//利用字符串替换和查找
		StringBuffer str=new StringBuffer(lo);
		String[] num={guessDigit1,guessDigit2,guessDigit3};
		for (int i=0;i<3;i++){

			pos=str.indexOf(num[i]);
		
			if (pos>-1){
				count++;
				str.setCharAt(pos, '*');
			}
				
		}
		//判断结果
		if (guess==lottery){
			System.out.println("Exact match:you win$10,000");
		}
		else if (count==3){
			System.out.println("Match all digits:you win$3,000");
			
		}
		else if (count>=1){
			
			System.out.println("Match"+count+"digits:you win$1,000");
		}
		else{
			System.out.println("Sorry,no match.");
		}
			
	}
}
