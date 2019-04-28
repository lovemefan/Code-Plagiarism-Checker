import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args)throws Exception{
		File formulaFile = new File("formula.txt");
		String[] Str = new String[1000];//���ڴ������Ĺ�ʽ
		String[] Str0 = new String[1000];//ȥ���ո�֮��Ĺ�ʽ
		String[] result = new String[1000];//��Ž�����ַ�������
		Scanner input = new Scanner(formulaFile);
			int i = 0;
			while(input.hasNext()){
				Str[i] = input.nextLine();
				i++;
			}
			input.close();
			int l = length(Str);//�жϽ�������ĳ���
			for(int j = 0;j<l;j++){
				Str0[j] = Str[j];
				Str0[j] = Str0[j].replaceAll(" ", "");
			}
			Regex r = new Regex();
			String[] Str1 = judgeIllegal(Str,l);//�ж��Ƿ��зǷ��ַ�
			String[] Str2 = judgeEqual(Str1,l);//�ж��Ƿ������ָͬ��
			String[] Str3 = r.judgeRegex(Str2, l);//������ʽ�ж�
			for(int j = 0;j<l;j++){
				if(!Str3[j].contains("ERROR")){
			        Stack<String> stack = new Stack<>();
			        InfixToPost infix = new InfixToPost(stack, Str3[j]);
			        infix.process();
			        String post = infix.getPost();
			        Stack<String> stack_result = new Stack<>();
			        PostToResult ptr = new PostToResult(post, stack_result);
			        ptr.operate();
			        result[j] = Str0[j]+"="+ptr.getResult()+"";
			        System.out.println(result[j]);
				}
				else
					result[j] = Str3[j];
			}
			File resultFile = new File("result.txt");
			PrintWriter output = new PrintWriter(resultFile);
			for(int j = 0;j<l;j++){
				output.println(result[j]);//�����д���ļ�
//				System.out.println(result[j]);
			}
			output.close();
	}
	
	//�ж����鳤��
	public static int length(String[] str) {
		int i = 0;
		while (str[i] != null)
			i++;
		return i;
	}
	
	//�ж��Ƿ��зǷ��ַ�
	public static String[] judgeIllegal(String[] s,int l){
		for(int i = 0;i<l;i++){
			s[i] = s[i].replaceAll("\\s","");
			Pattern  pattern = Pattern.compile("[^\\+\\-\\*\\/\\)\\(\\d]");
            Matcher matcher = pattern.matcher(s[i]);
            if(matcher.find())
            	s[i]+="\r\nERROR\r\n#���ַǷ��ַ���";
		}
		return s;
	}
	
	//�ж��Ƿ�����ָͬ��
	public static String[] judgeEqual(String[] s,int l){
		for(int i = 0;i<l-1;i ++){
				if(s[i].equals(s[i+1]))
					s[i+1]+="\r\nERROR\r\n#������ͬ��ָ��";
		}
		return s;
	}
	
}

