import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Output {
	private Check check = new Check();
	private dealMid dm = new dealMid();
	private midToLater mtl = new midToLater();
	private dealLaterList dll = new dealLaterList();
	
	public Output(){
		
	}
	
	public void writeFile(String s) throws IOException{
		File file = new File("׼��д����ļ���·�� ��б����\\");
		Writer writer = new FileWriter(file,true);
		writer.write(s+"\r\n");//���һ�����ʽ  ����һ��
		writer.close();
	}
	
	public void OutPutToFile(int time,String enterList[]) throws IOException{
		//List<String> Flag = new ArrayList<String>();

		for (int i = 1; i <= time; i++) {
			// System.out.println(enterList[i]);
			String mid = dm.deal(enterList[i]);
			
			if (check.check1(mid).equals("true") != true) {//���մ������ͻ��׼�����ʽ �����ʽһһ���
				String s="";
				s+="ERROR";
				s+="\r\n";
				System.out.println("ERROR");
				s+=("#" + check.check1(mid));
				System.out.println("#" + check.check1(mid));//���check1�Ĵ�����Ϣ
				writeFile(s);
			} else if (check.check2(mid).equals("true") != true) {
				String s="";
				s+="ERROR";
				s+="\r\n";
				System.out.println("ERROR");
				s+=("#" + check.check2(mid));
				System.out.println("#" + check.check2(mid));//���check2�Ĵ�����Ϣ
				writeFile(s);
			} else {
				/*
				dealMid dm = new dealMid();
				midToLater mtl = new midToLater();
				dealLaterList dll = new dealLaterList();
				for (int j = 0; j < Flag.size(); j++) {
					if (mid.equals(Flag.get(j))) {
						String s="���ʽ�ظ����� ֱ�ӽ�����һ�����ʽ����";
						System.out.println("���ʽ�ظ����� ֱ�ӽ�����һ�����ʽ����");
						writeFile(s);
						flag = 1;
						break;
					}
				}
				if (flag == 1)
					continue;*/
				
				if(check.check3(mid)==1){//���check3�Ĵ�����Ϣ
					String s="���ʽ�ظ����� ֱ�ӽ�����һ�����ʽ����";
					System.out.println("���ʽ�ظ����� ֱ�ӽ�����һ�����ʽ����");
					writeFile(s);
					continue;
				}
				
				//Flag.add(mid);
				String s="";
				s=mid;
				s+="=";
				s += String.format("%.1f",
						dll.dealLaterList(mtl.midToLater(dm.dealMidList(dm.deal(enterList[i])))));
				System.out.println(s);
				
				writeFile(s);
			}

		}
	}
	

}
