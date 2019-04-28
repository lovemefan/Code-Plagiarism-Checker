import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//文件处理类
public class FileOperation {
	//按行读取数据
	//fileName为待读取文件名称（可包含文件路径）
	public static void readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		String strResult = "";
		List list = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;	
			//如果文件不存在，则创建一个，如果文件存在，则清空文件内容
			clearInfoForFile("Output.txt");
			
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				try {
					//定义表达式检查对象
					CheckExpression chkExp = new CheckExpression(tempString);
					//表达式合法性检查（包含去除多余的空格）
					chkExp.checkExpression();
					//获取检查结果
					strResult = chkExp.getErrorMessage();
					//如果没有出错
					if(strResult == null){		
						//获取删除空格后的表达式
						tempString = chkExp.trimSpace();
						//判断该表达式是否已经存在,存在则不进行处理
						if(list.contains(tempString)){
							continue;
						}					
						else{
							list.add(tempString);
						}
						//定义计算表达式对象
						CalculateExpression calExp = new CalculateExpression(tempString);
						//计算结果
						float result = calExp.evaluate();
						//将结果转换成字符串
						strResult = "" + result;
						//写入文件
						appendToFileMethod("Output.txt", tempString + "=" + strResult);
					}
					else{//表达式有错，则将出错信息写入文件
						appendToFileMethod("Output.txt", strResult);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	//写入文件方法
	//fileName：待写入文件的名称（可包含文件路径）
	//content：写入内容
	public static void appendToFileMethod(String fileName, String content) {
		try {			
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件，即部分同学咨询的append方式写入
			FileWriter writer = new FileWriter(fileName, true);
			writer.write(content + "\r\n");			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//清空文件内容方法
	//fileName：待写入文件的名称（可包含文件路径）
	public static void clearInfoForFile(String fileName) {
        File file =new File(fileName);
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
