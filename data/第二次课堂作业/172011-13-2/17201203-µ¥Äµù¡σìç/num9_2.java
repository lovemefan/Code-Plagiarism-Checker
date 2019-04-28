package 课堂作业;

public class num9_2 {
	public static void main(String[] args) {
		Stock a;
		a=new Stock("ORCL","Oracle Corporation");
		a.setPreviousClosingPrice(34.5);
		a.setCurrentPrice(34.35);
		System.out.println("The change percent is "+a.getChangePercent()*100);
		}
	}

	class Stock{
		String symbo1;
		String name;
		double previousClosingPrice;//前一日股票
		double currentPrice;   //当时股票值
	    public Stock (String newSymbo1,String newName){
			symbo1=newSymbo1;
			name=newName;
		}
		public double getChangePercent() {
			double changepercent=currentPrice-previousClosingPrice;
			return changepercent;
		}
		public void setPreviousClosingPrice(double newPreviousClosingPrice) {
			previousClosingPrice=newPreviousClosingPrice;
		}
		public void setCurrentPrice(double newCurrentPrice) {
			currentPrice=newCurrentPrice;
		}
	}

