import java.util.Scanner;

public class Test9_2 {
	public static void main (String[] args){
	Stock ORCL = new Stock();
	Scanner input = new Scanner(System.in);
	System.out.println("Enter previousClosingPrice and currentPrice of Oracle Corporatio");
	ORCL.setCurrent(input.nextDouble());
	ORCL.setPrevious(input.nextDouble()); 
	System.out.println("The change rate of stock market value is "+ORCL.getChangePerent()+"%");
}
}
class Stock{
	char symbol;
	char name;
	double previousClosingPrice;
	double currentPrice;
	Stock(){
		
	}
	void setPrevious(double newPrevious){
		previousClosingPrice = newPrevious;
		
	}
	void setCurrent(double newCurrent){
		currentPrice = newCurrent;
	}
	double getChangePerent(){
		return (currentPrice-previousClosingPrice)/previousClosingPrice*100;
	}
	
	
}