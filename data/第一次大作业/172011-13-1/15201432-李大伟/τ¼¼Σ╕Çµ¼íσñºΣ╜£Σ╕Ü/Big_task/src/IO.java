import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
public class IO {
	public A1 b;//新属性A1类的b
	
	public IO(){
		
	}
	public IO(A1 a){
	
		this.b = a;//将a传递给b
	}
	
	
	


	public void reader(String name) throws IOException {//读取主函数给的文件名
		
		try{
			FileReader fr = new FileReader(name);//读取所需要调用的对象
			BufferedReader bf = new BufferedReader(fr);//读取所需要调用的对象
			String str;
			
			File fout = new File("out.txt");//创建一个新的文件out.txt
		    FileOutputStream fos = new FileOutputStream(fout);//写入所需要调用的对象
		    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));//写入所需要调用的对象

		          


			
			while ((str = bf.readLine()) != null) {//循环按行读取文件上的数据

				
				try{//因为check用正则只检验“（-”符号，所以其他格式错误是一定会有的，用try——catch强行让循环继续
					
					check c = new check(str);
					switch(c.checking()){
					case 0:{
						System.out.println("" + b.Z1(str));//将结果输出便于测试
						bw.write("" + b.Z1(str));
				        bw.newLine();
					}
						
					case 1:{
						System.out.println("" + b.Z1(c.str));//将结果输出便于测试
						bw.write("" + b.Z1(c.str));//把结果打印到文件里
					    bw.newLine();//打印新的一行
					}break;
					
					case 2:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# 有运算符和右括号相连");
					    bw.newLine();
					}break;
					
					case 3:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# 有右括号和运算符相连");	
					    bw.newLine();
					}break;
					
					case 4:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# 有左右括号相连");	
					    bw.newLine();
					}break;
					
					case 5:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# 有左括号和除了-号的运算符相连");	
					    bw.newLine();
					}break;
					
					case 6:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# 有重复的运算符或括号");	
					    bw.newLine();
					}break;
					
					case 7:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# 有除了运算符和数字的字符");	
					    bw.newLine();
					}break;
					
					case 8:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# 有除0的算式");	
					    bw.newLine();
					}break;
					
					case 9:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# 0在数字之前");	
					    bw.newLine();
					}break;
					
					case 10:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# 开头第一位有除了“-”的运算符或右括号");	
					    bw.newLine();
					}break;
					
					case 11:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# 结尾最后一位有算符或左括号");	
					    bw.newLine();
					}break;
					case 12:{
						System.out.println("" + b.Z1(c.str));//将结果输出便于测试
						bw.write("" + b.Z1(c.str));//把结果打印到文件里
					    bw.newLine();//打印新的一行
					}break;
					
	
					}

				}
				catch(Exception e){
					System.out.println("对不起，该表达式有错误但我们无法识别");
					bw.write("对不起，该表达式有错误但我们无法识别");
			        bw.newLine();
				}
				
			}
		
			bf.close();

			fr.close();
			
	        bw.close();
	        
		}
			catch (IOException e) {

				e.printStackTrace();

			}
			
			}
	}
		
		
	
         
	
	

