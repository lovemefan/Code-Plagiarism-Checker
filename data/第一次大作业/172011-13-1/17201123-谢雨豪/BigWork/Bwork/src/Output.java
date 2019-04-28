import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Output {
	private Check check = new Check();
	private dealMid dm = new dealMid();
	private midToLater mtl = new midToLater();
	private dealLaterList dll = new dealLaterList();
	
	public Output(){
		
	}
	
	public void writeFile(String s) throws IOException{
		File file = new File("准备写入的文件的路径 反斜杠请\\");
		Writer writer = new FileWriter(file,true);
		writer.write(s+"\r\n");//输出一个表达式  换行一次
		writer.close();
	}
	
	public void OutPutToFile(int time,String enterList[]) throws IOException{
		//List<String> Flag = new ArrayList<String>();

		for (int i = 1; i <= time; i++) {
			// System.out.println(enterList[i]);
			String mid = dm.deal(enterList[i]);
			
			if (check.check1(mid).equals("true") != true) {//按照错误类型或标准输出格式 将表达式一一输出
				String s="";
				s+="ERROR";
				s+="\r\n";
				System.out.println("ERROR");
				s+=("#" + check.check1(mid));
				System.out.println("#" + check.check1(mid));//输出check1的错误信息
				writeFile(s);
			} else if (check.check2(mid).equals("true") != true) {
				String s="";
				s+="ERROR";
				s+="\r\n";
				System.out.println("ERROR");
				s+=("#" + check.check2(mid));
				System.out.println("#" + check.check2(mid));//输出check2的错误信息
				writeFile(s);
			} else {
				/*
				dealMid dm = new dealMid();
				midToLater mtl = new midToLater();
				dealLaterList dll = new dealLaterList();
				for (int j = 0; j < Flag.size(); j++) {
					if (mid.equals(Flag.get(j))) {
						String s="表达式重复计算 直接进行下一个表达式运算";
						System.out.println("表达式重复计算 直接进行下一个表达式运算");
						writeFile(s);
						flag = 1;
						break;
					}
				}
				if (flag == 1)
					continue;*/
				
				if(check.check3(mid)==1){//输出check3的错误信息
					String s="表达式重复计算 直接进行下一个表达式运算";
					System.out.println("表达式重复计算 直接进行下一个表达式运算");
					writeFile(s);
					continue;
				}
				
				//Flag.add(mid);
				String s="";
				s=mid;
				s+="=";
				s += String.format("%.1f",
						dll.dealLaterList(mtl.midToLater(dm.dealMidList(dm.deal(enterList[i])))));
				System.out.println(s);
				
				writeFile(s);
			}

		}
	}
	

}
