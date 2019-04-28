package Lesson_2;

public class Stock//股票类
{
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	
	public Stock() {
		this.symbol="110";
		this.name="tengxun";
	}//有初始化的构造函数
	
	public double getChangePercent() {
		double ChangePercent;
		ChangePercent=currentPrice-previousClosingPrice;
		return ChangePercent;
	}//返回两天的价格差方法
	
}
