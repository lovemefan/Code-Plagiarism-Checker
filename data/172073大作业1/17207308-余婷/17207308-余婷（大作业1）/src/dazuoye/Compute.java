package dazuoye;

import java.io.*;
import java.util.regex.Pattern;

	public class Compute {
		    public static void main(String[] args) throws IOException {
		    	//打开文件进行读取
		        File fp = new File("compute.txt");
		        File fp1 = new File("result.txt");

		        //文件的读写
		        FileReader fileReader = new FileReader(fp);
		        BufferedReader bufferedReader = new BufferedReader(fileReader);

		        FileOutputStream fileOutputStream = new FileOutputStream(fp1);
		        //格式化输入
		        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
		        PrintWriter printWriter = new PrintWriter(outputStreamWriter, true);

		        //把文件里的数据一行一行的读取到result里面
		        int i = 0,k;
		        String[] result = new String[100];
		        String[] Stemp = new String[100];
		        RePolish compute = new RePolish();

		        while ((Stemp[i] = bufferedReader.readLine()) != null) {
		            //从文件中读取表达式并进行计算
		            result[i]= "";
		            if (isRealExpression(Stemp[i])) {
		                result[i] += (Stemp[i].replaceAll("\\s+", "") + "=" + compute.computeResult(compute.transformToRePolish(Stemp[i])));
		            }
		            else {
		                result[i] += (Stemp[i] + "ERROR");
		            }
		            //判断是否有重复的
		            k = i-1;
		            while (k > 0) {
		                if (result[i].equals(result[k]))
		                    break;
		                k--;
		            }
		            //把结果输入到文件中
		            if(k == 0)
		                printWriter.println(result[i]);
		            i++;
		        }
		        fileReader.close();
		        bufferedReader.close();
		        fileOutputStream.close();
		    }

		    //判断表达式是否合法
		    public static boolean isRealExpression(String expression) {
		        //判断表达式的语法是否发生错误
		        if ((Pattern.matches("^.*\\(\\).*|.*\\)\\(.*|.*\\D\\).*|.*\\(\\D.*|[^-()+*/0-9]|.*[-+*/]{2,}$", expression))) {
		            return false;
		        } else {
		            //判断括号是否匹配
		            int flag1 = 0, flag2 = 0;
		            for (int i = 0; i < expression.length(); i++) {
		                if (expression.charAt(i) == '(')
		                    flag1++;
		                if (expression.charAt(i) == ')')
		                    flag2++;
		            }
		            if (flag1 == flag2)
		                return true;
		            else
		                return false;
		        }
		    }
		}