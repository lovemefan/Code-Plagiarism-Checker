import java.io.*;


public class Io{
	public Evaluate e;
	public Write w;
	public Regex r;
	
	public Io(Evaluate e,Write w,Regex r) {
		
		this.e = e;
		this.w = w;
		this.r = r;
	
	}
	


	public void reader(String name) {

		try {
					           
			FileReader fr = new FileReader(name);

			BufferedReader bf = new BufferedReader(fr);

			String str;

			// 按行读取字符串，检测与输出

			while ((str = bf.readLine()) != null) {				
				
				str = str.replace(" ", "");//去空格，以便检测
				
				if(str==null||str.length()==0) {
					w.writetoFile("ERROR");
					w.writetoFile("#空字符串");
				}
				else {
					//System.out.println(str);					
					r.check(str);
					int x = r.getA();	
					//System.out.println(x);					
					switch(x){					
						case 1:							
							w.writetoFile("ERROR");
							w.writetoFile("#)前面是运算符");
							r.setA();
							break;
						case 2:
							w.writetoFile("ERROR");
						    w.writetoFile("#(前面不是运算符");
						    r.setA();
						    break;					
						case 3:
							w.writetoFile("ERROR");
							w.writetoFile("#)后面不是运算符");
							r.setA();
							break;
						case 4:
							w.writetoFile("ERROR");
							w.writetoFile("#空括号");
							r.setA();
							break;
						case 5:
							w.writetoFile("ERROR");
							w.writetoFile("#(后面是运算符");
							r.setA();
							break;
						case 6:
							w.writetoFile("ERROR");
							w.writetoFile("#运算符连续");
							r.setA();
							break;
						case 7:
							w.writetoFile("ERROR");
							w.writetoFile("#非法字符");
							r.setA();
							break;
						case 8:
							w.writetoFile("ERROR");
							w.writetoFile("#除数不能为0");
							r.setA();
							break;
						case 9:
							str = str.replaceAll("\\(\\-", "(0-");//中间负数处理
							try {
								w.writetoFile(str+"="+e.evaluate(str));
								}catch(Exception e) {
									w.writetoFile("ERROR");
									w.writetoFile("#无效输入");																
								}
							r.setA();
							break;	
						case 10:
							str ="0"+str;//头负数处理
							try {
								w.writetoFile(str+"="+e.evaluate(str));
								}catch(Exception e) {
									w.writetoFile("ERROR");
									w.writetoFile("#无效输入");																
								}
							r.setA();	
							break;
						case 11:
							w.writetoFile("ERROR");
							w.writetoFile("#数字不能以0开头");
							r.setA();
							break;
						case 12:
							str ="0"+str;
							str = str.replaceAll("\\(\\-", "(0-");							
							try {
								w.writetoFile(str+"="+e.evaluate(str));
								}catch(Exception e) {
									w.writetoFile("ERROR");
									w.writetoFile("#无效输入");																
								}
							r.setA();
							break;
						case 13:
							w.writetoFile("ERROR");
							w.writetoFile("#结尾错误");
							r.setA();
							break;
						case 14:
							w.writetoFile("ERROR");
							w.writetoFile("#括号不配对");
							r.setA();
							break;
						case 15:
							w.writetoFile("ERROR");
							w.writetoFile("#头字符错误");
							r.setA();
							break;											
						default:
							try {
							w.writetoFile(str+"="+e.evaluate(str));
							}catch(Exception e) {
								w.writetoFile("ERROR");
								w.writetoFile("#无效输入");																
							}
							r.setA();
							break;					
					        }				
				}
				
				}

			bf.close();

			fr.close();

		}
		
		
		catch(FileNotFoundException e) {

            e.printStackTrace();

      }
		catch (IOException e) {

			e.printStackTrace();

		}

	
	}
}
