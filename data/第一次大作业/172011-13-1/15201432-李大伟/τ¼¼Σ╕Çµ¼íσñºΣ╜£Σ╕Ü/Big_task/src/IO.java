import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
public class IO {
	public A1 b;//������A1���b
	
	public IO(){
		
	}
	public IO(A1 a){
	
		this.b = a;//��a���ݸ�b
	}
	
	
	


	public void reader(String name) throws IOException {//��ȡ�����������ļ���
		
		try{
			FileReader fr = new FileReader(name);//��ȡ����Ҫ���õĶ���
			BufferedReader bf = new BufferedReader(fr);//��ȡ����Ҫ���õĶ���
			String str;
			
			File fout = new File("out.txt");//����һ���µ��ļ�out.txt
		    FileOutputStream fos = new FileOutputStream(fout);//д������Ҫ���õĶ���
		    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));//д������Ҫ���õĶ���

		          


			
			while ((str = bf.readLine()) != null) {//ѭ�����ж�ȡ�ļ��ϵ�����

				
				try{//��Ϊcheck������ֻ���顰��-�����ţ�����������ʽ������һ�����еģ���try����catchǿ����ѭ������
					
					check c = new check(str);
					switch(c.checking()){
					case 0:{
						System.out.println("" + b.Z1(str));//�����������ڲ���
						bw.write("" + b.Z1(str));
				        bw.newLine();
					}
						
					case 1:{
						System.out.println("" + b.Z1(c.str));//�����������ڲ���
						bw.write("" + b.Z1(c.str));//�ѽ����ӡ���ļ���
					    bw.newLine();//��ӡ�µ�һ��
					}break;
					
					case 2:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# �������������������");
					    bw.newLine();
					}break;
					
					case 3:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# �������ź����������");	
					    bw.newLine();
					}break;
					
					case 4:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# ��������������");	
					    bw.newLine();
					}break;
					
					case 5:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# �������źͳ���-�ŵ����������");	
					    bw.newLine();
					}break;
					
					case 6:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# ���ظ��������������");	
					    bw.newLine();
					}break;
					
					case 7:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# �г�������������ֵ��ַ�");	
					    bw.newLine();
					}break;
					
					case 8:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# �г�0����ʽ");	
					    bw.newLine();
					}break;
					
					case 9:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# 0������֮ǰ");	
					    bw.newLine();
					}break;
					
					case 10:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# ��ͷ��һλ�г��ˡ�-�����������������");	
					    bw.newLine();
					}break;
					
					case 11:{
						System.out.println("ERROR:#");
						bw.write("ERROR:");
					    bw.newLine();
						bw.write("# ��β���һλ�������������");	
					    bw.newLine();
					}break;
					case 12:{
						System.out.println("" + b.Z1(c.str));//�����������ڲ���
						bw.write("" + b.Z1(c.str));//�ѽ����ӡ���ļ���
					    bw.newLine();//��ӡ�µ�һ��
					}break;
					
	
					}

				}
				catch(Exception e){
					System.out.println("�Բ��𣬸ñ��ʽ�д��������޷�ʶ��");
					bw.write("�Բ��𣬸ñ��ʽ�д��������޷�ʶ��");
			        bw.newLine();
				}
				
			}
		
			bf.close();

			fr.close();
			
	        bw.close();
	        
		}
			catch (IOException e) {

				e.printStackTrace();

			}
			
			}
	}
		
		
	
         
	
	

