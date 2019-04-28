import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
public class FileOperation {
	
	public FileOperation(){
		
	}
	
	public static void createFile(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			System.out.println("文件已存在");
		}
		else {
			try {
				 File fileParent = file.getParentFile();
				 if (fileParent != null) {
					 if (!fileParent.exists()) {
						 fileParent.mkdirs();
					 }
				 }
				 file.createNewFile();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String[] readToString(String filePath)
    {
        File file = new File(filePath);
        Long filelength = file.length(); // 获取文件长度
        byte[] filecontent = new byte[filelength.intValue()];
        try
        {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        
        String[] fileContentArr = new String(filecontent).split("\r\n");
        
        return fileContentArr;// 返回文件内容,默认编码
    }
	
	 public static void writeFile(String filePath, String conent) {
		 BufferedWriter out = null;
		  try {
			  out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true)));
			  out.write(conent);
			  out.newLine();
		  }
		  catch (Exception e) {
			  e.printStackTrace();
		  }
		  finally {
			  try {
				  if (out != null) {
					  out.close();
				  }
			  }
			  catch (IOException e) {
				  e.printStackTrace();
			  }
		  }
	 }

}
