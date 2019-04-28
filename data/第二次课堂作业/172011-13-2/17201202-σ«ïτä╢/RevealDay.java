import java.util.Scanner;
public class RevealDay {
	public static void main(String[] agrs){
		System.out.println("please input a year and a mouth");
		Scanner input=new Scanner(System.in);
		int year=input.nextInt();
		int mouth=input.nextInt();
		int[] Mouth={31,29,31,30,31,30,31,31,30,31,30,31};
		if((year%4==0&&year%100!=0)||(year%400==0)){
			Mouth[1]=28;
		}
		String[] M={"January","February","March","Apil","May","June","July","Aguest","September","October","November","December"
	};
		System.out.println(M[mouth-1] + year+" has "+Mouth[mouth-1]+" days");
		
		
				

}
}
