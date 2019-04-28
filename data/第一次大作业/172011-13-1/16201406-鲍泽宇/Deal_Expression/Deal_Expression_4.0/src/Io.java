import java.io.*;


public class Io{
	public Evaluate e;
	public Write w;
	public Regex r;
	
	public Io(Evaluate e,Write w,Regex r) {
		
		this.e = e;
		this.w = w;
		this.r = r;
	
	}
	


	public void reader(String name) {

		try {
					           
			FileReader fr = new FileReader(name);

			BufferedReader bf = new BufferedReader(fr);

			String str;

			// ���ж�ȡ�ַ�������������

			while ((str = bf.readLine()) != null) {				
				
				str = str.replace(" ", "");//ȥ�ո��Ա���
				
				if(str==null||str.length()==0) {
					w.writetoFile("ERROR");
					w.writetoFile("#���ַ���");
				}
				else {
					//System.out.println(str);					
					r.check(str);
					int x = r.getA();	
					//System.out.println(x);					
					switch(x){					
						case 1:							
							w.writetoFile("ERROR");
							w.writetoFile("#)ǰ���������");
							r.setA();
							break;
						case 2:
							w.writetoFile("ERROR");
						    w.writetoFile("#(ǰ�治�������");
						    r.setA();
						    break;					
						case 3:
							w.writetoFile("ERROR");
							w.writetoFile("#)���治�������");
							r.setA();
							break;
						case 4:
							w.writetoFile("ERROR");
							w.writetoFile("#������");
							r.setA();
							break;
						case 5:
							w.writetoFile("ERROR");
							w.writetoFile("#(�����������");
							r.setA();
							break;
						case 6:
							w.writetoFile("ERROR");
							w.writetoFile("#���������");
							r.setA();
							break;
						case 7:
							w.writetoFile("ERROR");
							w.writetoFile("#�Ƿ��ַ�");
							r.setA();
							break;
						case 8:
							w.writetoFile("ERROR");
							w.writetoFile("#��������Ϊ0");
							r.setA();
							break;
						case 9:
							str = str.replaceAll("\\(\\-", "(0-");//�м为������
							try {
								w.writetoFile(str+"="+e.evaluate(str));
								}catch(Exception e) {
									w.writetoFile("ERROR");
									w.writetoFile("#��Ч����");																
								}
							r.setA();
							break;	
						case 10:
							str ="0"+str;//ͷ��������
							try {
								w.writetoFile(str+"="+e.evaluate(str));
								}catch(Exception e) {
									w.writetoFile("ERROR");
									w.writetoFile("#��Ч����");																
								}
							r.setA();	
							break;
						case 11:
							w.writetoFile("ERROR");
							w.writetoFile("#���ֲ�����0��ͷ");
							r.setA();
							break;
						case 12:
							str ="0"+str;
							str = str.replaceAll("\\(\\-", "(0-");							
							try {
								w.writetoFile(str+"="+e.evaluate(str));
								}catch(Exception e) {
									w.writetoFile("ERROR");
									w.writetoFile("#��Ч����");																
								}
							r.setA();
							break;
						case 13:
							w.writetoFile("ERROR");
							w.writetoFile("#��β����");
							r.setA();
							break;
						case 14:
							w.writetoFile("ERROR");
							w.writetoFile("#���Ų����");
							r.setA();
							break;
						case 15:
							w.writetoFile("ERROR");
							w.writetoFile("#ͷ�ַ�����");
							r.setA();
							break;											
						default:
							try {
							w.writetoFile(str+"="+e.evaluate(str));
							}catch(Exception e) {
								w.writetoFile("ERROR");
								w.writetoFile("#��Ч����");																
							}
							r.setA();
							break;					
					        }				
				}
				
				}

			bf.close();

			fr.close();

		}
		
		
		catch(FileNotFoundException e) {

            e.printStackTrace();

      }
		catch (IOException e) {

			e.printStackTrace();

		}

	
	}
}
