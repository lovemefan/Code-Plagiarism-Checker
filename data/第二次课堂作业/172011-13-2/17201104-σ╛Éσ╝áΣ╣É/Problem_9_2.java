import java.util.Scanner;
public class Problem_9_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Now you have two fans!");
        Stock stock1 = new Stock();
        stock1.setSymbol("ORCL");
        stock1.setName("Oracle Corporation");
        stock1.setPreviousClosingPrice(34.5);
        stock1.setCurrentPercent(34.35);
        System.out.println("The changed percent is " + stock1.getChangePercent() + "%");
    }
}

class Stock {
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPercent;

    public void Stock(){

    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPreviousClosingPrice(double previousClosingPrice){
        this.previousClosingPrice = previousClosingPrice;
    }

    public void setCurrentPercent(double currentPercent){
        this.currentPercent = currentPercent;
    }

    public double getChangePercent(){
        return  (currentPercent - previousClosingPrice) / previousClosingPrice * 100;

    }
}


