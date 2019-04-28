import java.util.*;
import java.io.*;
public class Test {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		File file=new File("sorce.txt");
		FileOperation fo=new FileOperation();
		String []s=new String[100];
		s=fo.readLine(file,s);
		int effective=0;
		for(int i=0;i<s.length;i++) {
			if(s[i]==null) {
				break;
			}
			effective++;
		}
		for(int i=0;i<effective;i++) {
			s[i]= s[i].replaceAll("\\s*","");
			Check ch=new Check(s[i]);
			if(ch.judge()) {
				Calculater cal=new Calculater(s[i]);
				String str=cal.getResult();
				fo.writeFile(str);
			}
		}
	}
}