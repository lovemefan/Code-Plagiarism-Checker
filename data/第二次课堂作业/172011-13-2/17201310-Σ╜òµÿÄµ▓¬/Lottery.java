import java.util.Scanner;

// 3.15
public class Lottery {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int lottery = (int) (Math.random() * 1000);
        
        int[] lotteryDigits = new int[10];
        int[] guessDigits = new int[10];
        for (int i = 0; i < 10; ++i) {
            lotteryDigits[i] = 0;
            guessDigits[i] = 0;
        }
        
        int tmp = lottery;
        for (int i = 0; i < 3; ++i) {
            int digit = tmp % 10;
            ++lotteryDigits[digit];
            tmp /= 10;
        }

        System.out.print("Please enter your lottery pick (three digits): ");

        int guess = input.nextInt();
        tmp = guess;
        for (int i = 0; i < 3; ++i) {
            int digit = tmp % 10;
            ++guessDigits[digit];
            tmp /= 10;
        }

        System.out.println("The lottery number is: " + String.format("%03d", lottery));
        if (lottery == guess)
            System.out.println("Exact match: you win $10,000");
        else {
            boolean third = false;
            boolean second = true;
            for (int i = 0; i < 10; ++i) {
                if (lotteryDigits[i] > 0 || guessDigits[i] > 0) {
                    if (lotteryDigits[i] > 0 && guessDigits[i] > 0)
                        third = true;
                    if(lotteryDigits[i] != guessDigits[i])
                        second = false;
                }
            }
            if (second)
                System.out.println("Match all digirs: you win $3,000");
            else if (third == true)
                System.out.println("Match one digit: you win $1,000");
            else
                System.out.println("Sorry, no match");
        }
        input.close();
    }
}