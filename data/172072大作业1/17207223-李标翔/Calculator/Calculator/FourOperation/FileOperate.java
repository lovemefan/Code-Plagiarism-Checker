package FourOperation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 该类包含文件的读取，写入，清空
 */
public class FileOperate {
	//存放表达式的字符串列表
	private ArrayList<String> exp = new ArrayList<>();
	/**
	 * 无参构造函数
	 */
	FileOperate(){}
	/**
	 * 创建一个文件操作路径
	 */
	public void buildFile() {
		//创建一个FileOperate类的对象fo
		FileOperate fo = new FileOperate();
		//获取表达式读取的路径
		File expFile = new File("FourOperation\\expression.txt");
		//获取结果写入的路径
		File resultFile = new File("FourOperation\\result.txt");
		
		fo.deal(expFile,resultFile);
	}
	/**
	 * 在这个方法里执行文件的读取，清空和写入方法
	 * @param expFile
	 * @param resultFile
	 */
	private void deal(File expFile, File resultFile) {
		
		readExpression(expFile);
		
		clearInfoForFile(resultFile);
		
		writeResult(resultFile);
	}
	/**
     * 清空文件内容
     * @param resultFile
     */
    public void clearInfoForFile(File resultFile) {
        try {
            if(!resultFile.exists()) {
            	resultFile.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(resultFile);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	/**
	 * 读取表达式文件的内容，按行存放在FileOperate类的exp列表里
	 * @param expFile
	 */
	private void readExpression(File expFile) {
		try (Scanner input = new Scanner(expFile);){
			while(input.hasNextLine()) {
				/*
				 * Scanner.hasNextLine如果文件中还有下一行数据可以读取，返回true
				 */
				String expression = input.nextLine().replaceAll(" ","");//去空格

				//负数的处理
				// 处理负数，这里在-前面的位置加入一个0，如-4变为0-4，
				// 细节：注意-开头的地方前面一定不能是数字或者反括号，如9-0,(3-4)-5，这里地方是不能加0的
				// 它的后面可以是数字或者正括号，如-9=>0-9, -(3*3)=>0-(3*3)
				String s = expression.replaceAll("(?<![0-9)])(?=-[0-9(])", "0");
				
				exp.add(s);//将表达式全部存进列表里				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();//输出该错误的信息
		}
	}
	/**
	 * 将运算结果或者检测出的错误写入结果文件result中
	 * @param resultFile
	 */
	private void writeResult(File resultFile) {
		boolean mark = false;//重复标记
		try(FileOutputStream out = new FileOutputStream(resultFile);){			
			OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");
			BufferedWriter bufWrite = new BufferedWriter(outWriter);
			for(int i = 0;i < exp.size();i++) {
				
				MyException test = new MyException();
				//验证表达式正确性，正确则运算，错误输出错误
				if(test.expressionIsReasonable(bufWrite,exp.get(i))) {
					
					//检验表达式是否重复
					mark = test.isrepeat(exp.get(i), exp,i);
					//表达式重复忽略当前表达式的计算和检验，同时重复标记清零
					if(mark) {
						bufWrite.write("ERROR\n#表达式重复\n");
						mark =false;
						continue;
					}
					//当表达式无错无重复时，运算得到结果写入结果文件				
					Expression expr = new Expression();
		            double results = expr.getResult(exp.get(i));
		            if(String.valueOf(results).equals("Infinity")) {
		    			bufWrite.write("ERROR\n#出现了除数为0的情况\n");
		            }
		            else {
			           	//对负数进行的处理输出的时候要变回来
			           	bufWrite.write(exp.get(i).replaceAll("0-","-") +optimalResults(results) +'\n');
		            }          	
				}
			}
			//按先打开后关闭的顺序关闭数据流
			bufWrite.close();
			outWriter.close();
			System.out.println("计算结束！");
		}catch (IOException e) {
			e.printStackTrace();
		}			    
	}
	/**
	 * 进行结果的优化处理
	 * @param results
	 * @return String
	 */
	public String optimalResults(double results){
		String result = null;
		//如果结果是整数，那么小数部分可以丢弃
       	if((results-(int)results) == 0.0) {
       		DecimalFormat df0 = new DecimalFormat("#####");
       		result = "="+df0.format(results);
       	}
       	else
       		result = "="+results;
       	
       	return result;
	}
	
}
