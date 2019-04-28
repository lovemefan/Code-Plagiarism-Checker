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
					if(c.checking() == true){//如果check检测到了负数，就把修改后的格式拿来运算
						System.out.println("" + b.Z1(c.str));//将结果输出便于测试
						bw.write("" + b.Z1(c.str));//把结果打印到文件里
				        bw.newLine();//打印新的一行
				
					}
					else{//如果check没有检测到负数，就直接把数据拿来运算，格式错误就报错到catch
						System.out.println("" + b.Z1(str));//将结果输出便于测试
						bw.write("" + b.Z1(str));
				        bw.newLine();
					}
					
				}
				catch(Exception e){
					System.out.println("对不起，该表达式错误或我们无法识别");
					bw.write("对不起，该表达式错误或我们无法识别");
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
		
		
	
         
	
	

