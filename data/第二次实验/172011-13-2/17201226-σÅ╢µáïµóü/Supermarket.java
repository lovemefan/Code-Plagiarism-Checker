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
	for(int i=0;i<10;i++){//��ʼ�����ۼ�¼����
		record[i] = new SalesRecord(goods[i]);
	}
	File file = new File("D:\\Supermarket.txt");//����һ���ļ�
	PrintWriter output = new PrintWriter(file);
	String a = "��װ��Ʒ";
	String b = "ɢװ��Ʒ";
	int []m = new int[10];//�����洢ÿ����Ʒ�������ܶ�
	float sumheprice = 0 , sumsanprice = 0 , sumprice = 0;
	int salenum = 200 + (int)(Math.random()*51);//����������۴���
	for(int i=0;i<salenum;i++){//ģ������
		int j = (int)(Math.random()*10);//���������Ʒ������
		int money = 0;
		record[j].recordID = 188880000 + (int)(Math.random()*2501);//���������ƷID
		record[j].amount = 1 + (int)(Math.random()*10);//�����������
		money = record[j].amount * goods[j].getUnitPrice();
		if(goods[j].barCode != null){//�ж��Ƿ�Ϊ��װ��Ʒ
		output.println(a + record[j].recordID + "  \t  "+ goods[j].getGoodsName()
		+ "         \t       " + record[j].amount + "       \t         " + money);
		sumheprice += money;
		}
		else{
		output.println(b  + record[j].recordID + "    "+ goods[j].getGoodsName()
				+ "        \t        " + record[j].amount + "    \t          " + money);
		sumsanprice += money;
		}
		
		for(int k=0;k<10;k++){//��ÿ����Ʒÿ�ε����ۼ۸�д������
			if(goods[k].getGoodsName().equals(goods[j].getGoodsName())){
				m[k] = m[k] + money;
			}
		}
		
		sumprice = sumheprice + sumsanprice;
		}
	output.println("�����ܽ��    " + "    \t   " + "��װ��Ʒ���۽��    " + "    \t     " + "ɢװ��Ʒ���۽��");
	output.println(sumprice + "      \t        " + sumheprice +"     \t     " + sumsanprice);
	for(int i=0;i<10;i++){
		output.println(goods[i].goodsName + "  �����ܼ�Ϊ:       " + m[i]);
	}
		output.close();
	}

	
}