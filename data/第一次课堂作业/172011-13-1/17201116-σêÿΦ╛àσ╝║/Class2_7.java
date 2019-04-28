import  java.util.Scanner;
public class Class2_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        long  t;
        System.out.println("Enter the number of minutes:");
        Scanner input = new Scanner(System.in);
        t=input.nextLong();
        long day=t/(60*24);
        long year=day/365;
        day=day%365;
        System.out.println(t+" minuters is approximately " + year + " years and " + day + " days");
	}
}
