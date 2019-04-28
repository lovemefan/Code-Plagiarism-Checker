package Calculator01;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Fileoperation {

	public void readLineAndOpen(File f) throws IOException {
		File en= new File("result\\end");
		Fileoperation g = new Fileoperation();
		
		Calculator c=new Calculator();
		int result;
		String  r;
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {
				String s = input.nextLine();
				Regular x=new Regular(s);
				if(x.judgeAll()==true)
				{
				r=c.fuhao(s);
				c.cal(r);
				c.zhuan();
				result=c.js();
				g.writeFile(en,s,result);
				}
				else
				{
					g.writeEo(en,x.getErrorMessage(),s);
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public void writeFile(File f,String s,int re) throws IOException
	{
		
		FileWriter fw =new FileWriter(f,true);
		fw.write(s+" = "+re+"\r\n");
		fw.close();
	}
	public void writeEo(File f,String s,String q) throws IOException
	{
		
		FileWriter fw =new FileWriter(f,true);
		fw.write(q+"\r\n");
		fw.write("ERROR"+"\r\n");
		fw.write(s+"\r\n");
		fw.close();
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Fileoperation fo = new Fileoperation();
		File f = new File("Cal\\yun");	
		String r;
		r=fo.read(f);
		System.out.println(r);*/
	}

}
