import java.util.Scanner;
//����������
public class Main {
	private static Scanner input;

	public static void main(String[] args){
		//���������ɼ�
		int[] newsc = new int[4];
		//����������������ѧ��
		input = new Scanner(System.in);
		System.out.println("���֣�");
		String name = input.next();
		System.out.println("ѧ�ţ�");
		int id = input.nextInt();
		//���������ĳɼ�
		while(true){
			System.out.println("�ֱ��������ųɼ���");
			newsc[0] = input.nextInt();
			newsc[1] = input.nextInt();
			newsc[2] = input.nextInt();
			newsc[3] = input.nextInt();
			//�ж�����������ɼ��Ƿ�Խ��
			if(newsc[0] < 0||newsc[0] > 100||newsc[1] < 0||newsc[1] > 100||newsc[2] < 0||newsc[2] > 100||newsc[3] < 0||newsc[3] > 100){
				System.out.println("������ĳɼ��������������룡");
				continue;
			}
			break;
		}
		Student n = new Student(name,id,newsc);
		//����һ����ʮ��ѧ��������
		Student[] s = new Student[30];
		int i;
		//�������ѧ��������ѧ�ţ��ɼ���������������
		for(i=0;i<30;i++){
			int num = 3+(int)(Math.random()*4);
			String Name = "";
			int ID = 17201200+(int)(Math.random()*30);
			for(int j = 0;j<num;j++){
				char w = (char)('a'+Math.random()*('z'-'a'+1));
				Name = Name + w;
				if(j==num-1){
					int a = (int)(Math.random()*100);
					int b = (int)(Math.random()*100);
					int c = (int)(Math.random()*100);
					int d = (int)(Math.random()*100);
					int[] sc = {a,b,c,d};
					s[i] = new Student(Name,ID,sc);
				}
			}
		}
		//���ƽ���ɼ����ͬѧ���±�
		int xb = 0;
		double  max = 0;
		for(int k = 0;k < 30;k++){
			if(max < s[k].averageScore()){
				max = s[k].averageScore();
				xb = k;
			}
		}
		//���ȫ��ͬѧ��ƽ���ɼ�
		double sum = 0;
		for(int j = 0;j < 30;j ++){
			sum = sum + s[j].averageScore();
		}
		double ave = (sum + n.averageScore())/31;
		System.out.println(name+"(ID:"+id+") ƽ���֣�"+n.averageScore()+" ��߷֣�"+n.max());
		//��ͬѧ��ƽ���ַ�Ϊ�������������ȫ��ƽ���֣�����ȫ��ƽ���֣�ƽ����ȫ����ߣ�����������
		
		//�ж�����ƽ�����Ƿ�С��ȫ��ƽ��ֵ
		if (n.averageScore()<=ave){
			System.out.println(s[xb].studentName+"(ID:"+s[xb].studentID+") �����ƽ���֣�"+s[xb].averageScore()+" ��߷֣�"+s[xb].max());
			System.out.println(n.studentName+"��ƽ���ֵ���ȫ��ƽ����");
		}
		//�ж�����ƽ�����Ƿ����ȫ��ƽ���ֲ�����ȫ��ƽ������ߵ�ѧ��
		else if (n.averageScore()>ave&&n.averageScore()<s[xb].averageScore()){
			System.out.println(s[xb].studentName+"(ID:"+s[xb].studentID+") �����ƽ���֣�"+s[xb].averageScore()+" ��߷֣�"+s[xb].max());
		   System.out.println(n.studentName+"��ƽ���ָ���ȫ��ƽ����");
		   }
		//�����ĳɼ��Ƿ����
		else{
			System.out.println(n.studentName+"�ĳɼ���ȫ����õ�");
		 System.out.println(n.studentName+"��ƽ���ָ���ȫ��ƽ����");
		}
	}

}
