import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;


public class Maincal {
	public static void main(String[] args)  {
		
		count c = new count();
		
		judge judge = new judge();
		File fl = new File("word.txt");
		FileReader fr;

		Set<String> quchong = new TreeSet<>();
		quchong.clear();
		try {
			//读取文件
			fr = new FileReader(fl);
			BufferedReader br=new BufferedReader(fr);
			
			//写入文件

			String line = "";
			try {
				while ((line=br.readLine())!=null) {

					if(judge.j(line))
					{
						if(resolve.ceshi(line))
						{	
							if(quchong.contains(line))
								{
									//System.out.println("重复输入，已经对该式进行过运算");
								Writeinto.ww("重复输入，已经对该式进行过运算");
								}else {
									quchong.add(line);
									String ansString = ""+c.cal(line);
									//System.out.println(ansString);
									
									Writeinto.ww(ansString);
								}							
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (@SuppressWarnings("hiding") IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


        
	}
}
