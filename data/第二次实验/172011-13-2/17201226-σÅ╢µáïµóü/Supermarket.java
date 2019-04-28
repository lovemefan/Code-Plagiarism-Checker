package second;

import java.io.*;
public class Supermarket {
	public static void main(String[] args)throws Exception{
		Goods []goods;
		goods = creat();
		sale(goods);
	}
	
public static Goods[] creat(){
	Goods []goods = new Goods[10];
	for(int i = 0; i<10;i++){
		int num = 4 + (int)(Math.random()*10);
		int n = 2 + (int)(Math.random()*10);
		String name = "";
		for(int j=0;j<num;j++){
			char ch =  (char)('a' +  Math.random()*('z' - 'a' + 1));
		    name = name + ch;
		}
		if(n % 2 ==0){
			String barCode = "";
			for(int j=0;j<num;j++){
				char ch =  (char)('a' +  Math.random()*('z' - 'a' + 1));
			    barCode = barCode + ch;
			}
			 int price = 4 + (int)(Math.random()*20);
			 goods[i] = new Goods(name,barCode,price);
		}
		else{
	    int price = 2 + (int)(Math.random()*10);
	    goods[i] = new Goods(name,price);
	    }
	}
		return goods;
	}

public static void sale(Goods []goods) throws Exception{
	SalesRecord[] record = new SalesRecord[10];
	goods = creat();
	for(int i=0;i<10;i++){//初始化销售记录数组
		record[i] = new SalesRecord(goods[i]);
	}
	File file = new File("D:\\Supermarket.txt");//创建一个文件
	PrintWriter output = new PrintWriter(file);
	String a = "盒装商品";
	String b = "散装商品";
	int []m = new int[10];//用来存储每种商品的销售总额
	float sumheprice = 0 , sumsanprice = 0 , sumprice = 0;
	int salenum = 200 + (int)(Math.random()*51);//随机产生销售次数
	for(int i=0;i<salenum;i++){//模拟销售
		int j = (int)(Math.random()*10);//随机购买商品的种类
		int money = 0;
		record[j].recordID = 188880000 + (int)(Math.random()*2501);//随机产生商品ID
		record[j].amount = 1 + (int)(Math.random()*10);//随机购买数量
		money = record[j].amount * goods[j].getUnitPrice();
		if(goods[j].barCode != null){//判断是否为盒装商品
		output.println(a + record[j].recordID + "  \t  "+ goods[j].getGoodsName()
		+ "         \t       " + record[j].amount + "       \t         " + money);
		sumheprice += money;
		}
		else{
		output.println(b  + record[j].recordID + "    "+ goods[j].getGoodsName()
				+ "        \t        " + record[j].amount + "    \t          " + money);
		sumsanprice += money;
		}
		
		for(int k=0;k<10;k++){//将每种商品每次的销售价格写入数组
			if(goods[k].getGoodsName().equals(goods[j].getGoodsName())){
				m[k] = m[k] + money;
			}
		}
		
		sumprice = sumheprice + sumsanprice;
		}
	output.println("销售总金额    " + "    \t   " + "盒装商品销售金额    " + "    \t     " + "散装商品销售金额");
	output.println(sumprice + "      \t        " + sumheprice +"     \t     " + sumsanprice);
	for(int i=0;i<10;i++){
		output.println(goods[i].goodsName + "  销售总价为:       " + m[i]);
	}
		output.close();
	}

	
}