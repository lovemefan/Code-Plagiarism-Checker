
import java.util.Scanner;

//������
public class Proceed {
	//������Ĺ��췽��
	//ѧ������
	public Proceed(){

	}

	//��ʼ������
	//ѧ������
	public void initialize(Student[] student){
		// ����ѧ���ɼ�������ѧ����Ϣ
		int[] scores = new int[4];
		String[] Name = { "Jack", "Mark", "Sarah", "John", "Lucy", "Handson", "Bigman", "Wuyifan", "Yangyang",

				"Eryuehong", "Fouye", "Wuxie", "Wukong", "Bajie", "Shaseng", "Tangseng", "Bailongma", "Mangseng",

				"Lisangzuo", "Ruiwen", "Jiansheng", "Dema", "Anni", "Yan", "Qiling", "Liuchuang", "Leina", "TDME",

				"Mumu", "ASTN" };
		for (int i = 0; i < 30; i++) {
			int j;
			for (j = 0; j < 4; j++) {
				scores[j] = (int) (Math.random() * 100);
			}
			if (i + 1 < 10)
				student[i] = new Student("1720130" + (i + 1), Name[i], scores);
			else {
				student[i] = new Student("172013" + (i + 1), Name[i], scores);
			}
			for (j = 0;j < 4; j ++){
				if (student[i].max() < scores[j]){
					student[i].setMax(scores[j]);
				}
			}
			student[i].setAverage((scores[0] + scores[1] +scores[2] +scores[3])/4);
		}
	}
	
	//���뷽��
	public int  input(Student student){
		// �������֣�ѧ�źͷ���
		int[] scores = new int[4];
		int max = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the name of the student:");
		student.setName(input.nextLine());
		System.out.println("Please enter the ID of the student:");
		student.setID(input.nextLine());
		System.out.println("Please enter the scores of the student(like 100 99 98 97):");
		for (int i = 0; i < 4; i++) {
			scores[i] = input.nextInt();
			if (scores[i] > max){
				max = scores[i];
			}
		}
		student.setScores(scores);
		student.setAverage((scores[0] + scores[1]  +scores[2]  +scores[3])/4);
		student.setMax(max);
		if (student.max() > 100){
			System.out.println("�ɼ����ܳ���100��");
			return 1;
		}
		return 0;
	}
	
	//�������
	//ѧ��������ѧ��id��ѧ��ƽ���ɼ�����߷�
	public void output(Student student){
		System.out.println(student.getName() + "(" + student.getID() + ")ƽ����" + student.average + "��߷�" + student.max);
	}

	//�жϷ���
	//ѧ��������ѧ��id��ѧ��ƽ���ɼ���ѧ������
	public void judge(Student student1,Student[] student){
		int max = 0;
		for (int i = 0; i < 30; i ++){
			if (student[i].average() > student[max].average()){
				max = i;
			}
		}
		if (student1.average() > student[max].average()){
			System.out.println(student1.getName() + "������ȫ����õ�ѧ����");
		}else {
			System.out.println(student[max].getName() + "(" + student[max].getID() + ")ƽ���� " + student[max].average()
					+ "��߷� " + student[max].max());
			if (student1.average() < student[0].sumAverage(student)){
				System.out.println(student1.getName() + "��ƽ���ɼ�����ȫ��ƽ����");
			}else {
				System.out.println(student1.getName() + "��ƽ���ɼ�����ȫ��ƽ����");
			}
		}
	}
}
