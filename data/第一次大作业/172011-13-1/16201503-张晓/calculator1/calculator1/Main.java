package calculator1;

import java.awt.GradientPaint;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.function.ObjDoubleConsumer;

import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.Media;


public class Main  {
	// 主函数
	static Agent agent=new Agent();
	public static void main(String[] args) {
		Main sum = new Main();
		Test test=new Test();
		
		
		FileReader fr;
		try {
			fr = new FileReader("/Users/apple/eclipse-workspace/summation/src/calculator1/test.txt");

			BufferedReader br=new BufferedReader(fr);
			String line="";
			try {
				while((line=br.readLine())!=null) {
					test.setTest(line);
					Agent agent=new Agent();
					System.out.println(result(line));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
     
    
    //计算结果
    public static String result(String a) { 
 
    	List<String> results = agent.results(a);
        while (results.size() > 1) 
        {
            for (int i = 0; i < results.size(); i++) 
            {
                if (one(results.get(i))) 
                {
                    results.add(i - 2, operat(results.get(i - 2), results.get(i - 1),	results.get(i)));//将指定的项目添加到指定位置
                    results.remove(i-1);//从列表中删除项目
                    results.remove(i-1);
                    results.remove(i-1);
                    break;
                }
            }
        }
        return results.get(0);
    }

   



	private static String operat(String s1, String s2, String n)// 数字加减
    {
        String result = "";
        double op1 = Double.parseDouble(s1);//将数字转化格式
        double op2 = Double.parseDouble(s2);
        double count = 0;
        if(n.equals("+"))
        {
            count=op1+op2;
        }
        else if(n.equals("-"))
        {
            count=op1-op2;
        }
        else if(n.equals("*"))
        {
            count=op1*op2;
        }
        else if(n.equals("/"))
        {
            count=op1*1.0/op2;
        }
        return result+count;
    }

     
    
    
    private static boolean one(String s)//判断是否是运算符
    {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }
    
    
   


}
