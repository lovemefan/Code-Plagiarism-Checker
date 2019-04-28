package BigHomeWork1;

import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException{
		File_ f = new File_("informations.txt");
		String[] st = new String[500];
		String[] st2 = new String[500];
		int spot = 0;
		double result = 0;
		
		st = f.readFile(f.file);
		while(st[spot] != null){
			st2[spot] = st[spot];// 记录未做变化的数据，用于输出错误信息
		    InputCheck a = new InputCheck(st[spot]);
			if (a.judgeAll()){// 如果表达式正确，则将结果加到表达式后面
		 	    String[] str = Counter.storeStr(a.getStr());
			    str = Counter.transform(str);
			    result = Counter.getResult(str);
			    a.setStr( a.getStr() + " = " + result);
			    System.out.println(a.getStr() + "\n");
			    st[spot] = a.getStr();
		    }
			else{
				System.out.println(a.getStr());
				System.out.println("\n");
			}
			spot ++;
		}
		f.writeFile(st,st2,"result.txt");// 把结果输入到文本中
	}
}

