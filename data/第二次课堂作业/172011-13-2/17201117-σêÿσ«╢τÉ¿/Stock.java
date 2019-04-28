package mayday001;

	public class Stock {
		private String symbol;
		private String name;
		private double previousClosingPrice;
		private double currentPrice;
	
		public Stock(String symbol, String name) {
			this.symbol = symbol;
			this.name = name;
		}
		
		public double getChangePercent() {
			return (currentPrice - previousClosingPrice) / previousClosingPrice;
		}
		public void setPreviousClosingPrice(double previousClosingPrice) {
			this.previousClosingPrice = previousClosingPrice;
		}
		public void setCurrentPrice(double currentPrice) {
			this.currentPrice = currentPrice;
		}
		public String getSymbol() {
			return symbol;
		}
		public String getName() {
			return name;
		}
		public static void main(String[] args) {
			Stock stock = new Stock("ORCL", "Oracle Corporation");
			stock.setCurrentPrice(34.35);
			stock.setPreviousClosingPrice(34.5);
			double d = stock.getChangePercent()*100; 	
			System.out.println("[" + stock.getSymbol() + "] " + stock.getName() + " ¼Û¸ñ¸¡¶¯£º" + d + "%");
		}
	}


