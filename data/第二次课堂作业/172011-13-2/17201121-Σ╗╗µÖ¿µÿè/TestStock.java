package TestStock;

public class TestStock {
	public static void main(String[] args){
		Stock stock1 = new Stock("ORCL", "Oracle Corporation");
		
		stock1.setPrice(34.5,34.35);
		System.out.printf("The change percent is " +stock1.getChangePercent() * 100);
	}

static class Stock {
		String symbol;
		String name;
		double previousClosingPrice;
		double currentPrice;
		
		Stock(String newSymbol, String newName){
			symbol = newSymbol;
			name = newName;
		}
		
		public double getChangePercent(){
			double changePercent = (currentPrice - previousClosingPrice) / previousClosingPrice;
			return changePercent;
		}
		
		public void setPrice(double newPreviousClosingPrice,double newCurrentPrice){
			currentPrice = newCurrentPrice;
			previousClosingPrice = newPreviousClosingPrice;
		}
	}
}
