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
					if(c.checking() == true){//���check��⵽�˸������Ͱ��޸ĺ�ĸ�ʽ��������
						System.out.println("" + b.Z1(c.str));//�����������ڲ���
						bw.write("" + b.Z1(c.str));//�ѽ����ӡ���ļ���
				        bw.newLine();//��ӡ�µ�һ��
				
					}
					else{//���checkû�м�⵽��������ֱ�Ӱ������������㣬��ʽ����ͱ���catch
						System.out.println("" + b.Z1(str));//�����������ڲ���
						bw.write("" + b.Z1(str));
				        bw.newLine();
					}
					
				}
				catch(Exception e){
					System.out.println("�Բ��𣬸ñ��ʽ����������޷�ʶ��");
					bw.write("�Բ��𣬸ñ��ʽ����������޷�ʶ��");
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
		
		
	
         
	
	

