import java.io.*;

public class Write {
	
	public Write() {
		
	}
	
	public void writetoFile(String a){
	     
	    try {
	        //String content = "²âÊÔÊ¹ÓÃ×Ö·û´®";
	        File file = new File("YourResults.txt");
	        
	        if(!file.exists()){
	            file.createNewFile();
	        }
	            FileWriter fw = new FileWriter(file,true);
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.write(a);
	            bw.newLine();
	            bw.close(); 
	            fw.close();
 
	    }
	    catch (Exception e) {
	        // TODO: handle exception
	    }
	}

}
