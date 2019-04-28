import java.util.Scanner;
public class Days {

	public Days() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		System.out.print("Enter a month and a year");
		int month = input.nextInt();
		int year = input.nextInt();
		int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		boolean isLeapyear =
			((year/400==0)||(year/4==0&&year/100!=0));
		if(isLeapyear)
			months[2]+=1;
		switch(month){
			case 1: System.out.println("January "+year+" has "+months[1]+" days");break;
			case 2: System.out.println("Februray "+year+" has "+months[2]+" days");break;
			case 3: System.out.println("March "+year+" has "+months[3]+" days");break;
			case 4: System.out.println("April "+year+" has "+months[4]+" days");break;
			case 5: System.out.println("May "+year+" has "+months[5]+" days");break;
			case 6: System.out.println("June "+year+" has "+months[6]+" days");break;
			case 7: System.out.println("July "+year+" has "+months[7]+" days");break;
			case 8: System.out.println("August "+year+" has "+months[8]+" days");break;
			case 9: System.out.println("September "+year+" has "+months[9]+" days");break;
			case 10: System.out.println("Octorber "+year+" has "+months[10]+" days");break;
			case 11: System.out.println("November "+year+" has "+months[11]+" days");break;
			case 12: System.out.println("December "+year+" has "+months[12]+" days");break;
			default :System.out.println("Error month!");
					 System.exit(1);
		}
	}

}
