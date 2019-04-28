import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//�ļ�������
public class FileOperation {
	//���ж�ȡ����
	//fileNameΪ����ȡ�ļ����ƣ��ɰ����ļ�·����
	public static void readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		String strResult = "";
		List list = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;	
			//����ļ������ڣ��򴴽�һ��������ļ����ڣ�������ļ�����
			clearInfoForFile("Output.txt");
			
			// һ�ζ���һ�У�ֱ������nullΪ�ļ�����
			while ((tempString = reader.readLine()) != null) {
				try {
					//������ʽ������
					CheckExpression chkExp = new CheckExpression(tempString);
					//���ʽ�Ϸ��Լ�飨����ȥ������Ŀո�
					chkExp.checkExpression();
					//��ȡ�����
					strResult = chkExp.getErrorMessage();
					//���û�г���
					if(strResult == null){		
						//��ȡɾ���ո��ı��ʽ
						tempString = chkExp.trimSpace();
						//�жϸñ��ʽ�Ƿ��Ѿ�����,�����򲻽��д���
						if(list.contains(tempString)){
							continue;
						}					
						else{
							list.add(tempString);
						}
						//���������ʽ����
						CalculateExpression calExp = new CalculateExpression(tempString);
						//������
						float result = calExp.evaluate();
						//�����ת�����ַ���
						strResult = "" + result;
						//д���ļ�
						appendToFileMethod("Output.txt", tempString + "=" + strResult);
					}
					else{//���ʽ�д��򽫳�����Ϣд���ļ�
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

	//д���ļ�����
	//fileName����д���ļ������ƣ��ɰ����ļ�·����
	//content��д������
	public static void appendToFileMethod(String fileName, String content) {
		try {			
			// ��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ���������ͬѧ��ѯ��append��ʽд��
			FileWriter writer = new FileWriter(fileName, true);
			writer.write(content + "\r\n");			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//����ļ����ݷ���
	//fileName����д���ļ������ƣ��ɰ����ļ�·����
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
