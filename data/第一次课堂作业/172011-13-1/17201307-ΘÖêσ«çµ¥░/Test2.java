import java.util.Scanner;
public class Test2 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Please input numbers of minutes");
		double m=input.nextDouble();
		int n=(int)(m/(60*24*365));
		int k=(int)(m%(60*24*365)/(60*24));
		System.out.println(m+" minutes is approximately "+n+" years"+" and "+k+" days");
		if(input!=null){
			input.close();
		}
	}
}
