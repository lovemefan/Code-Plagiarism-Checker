import java.util.Scanner;

public class Lottery {
    private static Scanner input;

	public static void main(String[] args) {
	    int lottery=(int)(Math.random()*1000);
	    input = new Scanner(System.in);
	    System.out.print("Enter your lottery pick  (three digits):");
	    int guess=input.nextInt();
	    //a,b,c�ֱ�Ϊ����������Ĳ�Ʊ�����ֵİ�λ��ʮλ����λ
	    int a=lottery/100;
	    int b=(lottery/10)%10;
	    int c=lottery%10;
	    //d,e,f�ֱ�µ����ֵİ�λ��ʮλ����λ
	    int d=guess/100;
	    int e=(guess/10)%10;
	    int f=guess%10;
	    
	    System.out.println("The lottery number is " + lottery);
	    if(guess==lottery)
	    	System.out.println("Exact match: you win $10,000");
	    else if((a==d&&b==f&&c==e)||(a==e&&b==d&&c==f)||(a==e&&b==f&&c==d)||(a==f&&b==d&&c==e)||(a==f&&b==e&&c==d))
	    	System.out.println("Match all digits: you win $3,000");
	    else if(a==d||a==e||a==f||b==d||b==e||b==f||c==d||c==e||c==f)
	    	System.out.println("Match one digits: you win $1,000");
	    else
	    	System.out.println("sorry,no match");
  }
}