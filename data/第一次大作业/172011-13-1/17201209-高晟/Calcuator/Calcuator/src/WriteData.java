
public class WriteData {
	public WriteData(){
		
	}
	
	public void Write(String[] newexpression,int a) throws Exception{
		java.io.File file = new java.io.File("C:\\Users\\87912\\workspace\\Calcuator\\result.txt"); 
		if(file.exists()){
			System.out.println("File already exists");
			System.exit(1);
		}
		java.io.PrintWriter output = new java.io.PrintWriter(file); 
		for(int b = 0;b < a;b ++){
			if(newexpression[b].equals("s1")){
				output.print("ERROR\r\n");
				output.println("#���ʽ���зǷ��ַ�");
			}
			else if(newexpression[b].equals("s2")){
				output.print("ERROR\r\n");
				output.println("#����������������");
			}
			else if(newexpression[b].equals("s3")){
				output.print("ERROR\r\n");
				output.println("#��������Ϊ0");
			}
			else if(newexpression[b].equals("s4")){
				output.print("ERROR\r\n");
				output.println("#�����ʽ����");
			}else if(newexpression[b].equals("s5")){
				output.print("ERROR\r\n");
				output.println("#�����������������");
			}else if(newexpression[b].equals("s6")){
				output.print("ERROR\r\n");
				output.println("#�����˿���");
			}
			else{
				output.print(newexpression[b] + "\r\n");
			}
			
		}
		output.close();
	}

}
