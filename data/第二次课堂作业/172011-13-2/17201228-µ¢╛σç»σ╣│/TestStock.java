package HelloWorld;

public class TestStock {
	public static void main(String[] args){
        Stock stock = new Stock("ORCL", "Oracle Corporation");
        stock.previousClosingPrice = 34.5;
        stock.currentPrice = 34.35;

        System.out.println("Change Percent: " + stock.getChangePercent() + "%");
    }

}

class Stock {

    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;

    public Stock(String symbol, String name) {
        this.name = name;
        this.symbol = symbol;
    }

    public double getChangePercent() {
        return (Math.max(previousClosingPrice, currentPrice) - Math.min(previousClosingPrice, currentPrice)) / previousClosingPrice * 100;
    }




}


