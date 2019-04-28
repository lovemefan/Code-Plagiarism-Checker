import java.util.Scanner;
public class Problem_3_15 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your lottery pick(three digits):");
        int num = input.nextInt();
        int a = num % 10;
        int b = num / 10 % 10;
        int c = num / 100;
        int lotteryNum = (int)(Math.random() * 1000);
        System.out.printf("The lottery number is %03d\n",lotteryNum);
        int p = lotteryNum % 10;
        int q = lotteryNum / 10 % 10;
        int r = lotteryNum / 100;
        if (a == p && b == q && c == r){
            System.out.println("You win 10000 dollars!");
        }
        else if ((a==p&&b==r&&c==q)||(a==r&&b==q&&c==p)||(a==q&&b==p&&c==r)){
            System.out.println("You win 3000 dollars!");
        }
        else if (a==p||b==p||c==p||a==q||b==q||c==q||a==r||b==r||c==r){
            System.out.println("You win 1000 dollars!");
        }
        else {
            System.out.println("You win nothing!");
        }
    }
}
