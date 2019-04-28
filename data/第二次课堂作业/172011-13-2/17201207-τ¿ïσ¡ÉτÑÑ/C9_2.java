package work;

public class C9_2 {
	public static void main(String[] args){
		Stock m1 = new Stock(34.5,34.35);
		System.out.println(m1.getChangePercent() + "%");
	}
}
		class Stock{
			String symbol ;
			String name;
			double prexiousClosingPrice;
			double currentPrice;
			Stock(){
				String symbol = "ORCL";
				String name = "Oracle Corporation";
				double prexiousClosingPrice = 34.5;
				double currentPrice = 34.35;
	}			
		Stock(double newPrexiousClosingPrice,double newCurrentPrice){
			this.prexiousClosingPrice = newPrexiousClosingPrice;
			this.currentPrice = newCurrentPrice;
		}
		double getChangePercent(){
			return (currentPrice / prexiousClosingPrice)*100;
		}
			void setPrexiousClosingPrice(double newPrexiousClosingPrice){
				prexiousClosingPrice = newPrexiousClosingPrice;
			}
			void setCurrentPrice(double  newCurrentPrice){
				currentPrice = newCurrentPrice;
			}
}
