package Text;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("������ѧ��������");
		String newName = input.nextLine();// ������ѧ��������
		System.out.println("������ѧ��ѧ�ţ�");
		String newID = input.nextLine();// ��ѧ����ѧ��
		System.out.println("���������ſεĳɼ����Կո�ָ���");
		int newScore1 = input.nextInt();
		int newScore2 = input.nextInt();
		int newScore3 = input.nextInt();
		int newScore4 = input.nextInt();//���������ɼ�
		Student[] stu = new Student[30];// ������������

		for (int i = 0; i < stu.length; i++) {
			stu[i] = new Student();// �����ʼ��
		}
		for (int i = 0; i < 30; i++) {
			stu[i].score();// ����ÿ��ѧ���ɼ�
		}

		double x = (newScore1 + newScore2 + newScore3 + newScore4) / 4;// ����ƽ���ɼ�
		int a = 0;
		if (a < newScore1) {
			a = newScore1;
		}
		if (a < newScore2) {
			a = newScore2;
		}
		if (a < newScore3) {
			a = newScore3;
		}
		if (a < newScore4) {
			a = newScore4;// �ҳ��������ɼ�aΪ���ɼ�
		}

		double ave = 0;
		for (int i = 0; i < 30; i++) {
			ave += (stu[i].score1 + stu[i].score2 + stu[i].score3 + stu[i].score4);
		}
		ave = ave / 4 / 30;// ѧ��ƽ���ɼ�ave

		double maxave = 0;
		int j = 0;
		for (int i = 0; i < 30; i++) {
			if (maxave < stu[i].averageScore()) {
				maxave = stu[i].averageScore();
				j = i;//������ѧ��
			} // �ҳ����ƽ���ɼ�maxave
		}
		if (newScore1 > 100 || newScore2 > 100 || newScore3 > 100 || newScore4 > 100) {
			System.out.println("�γ̳ɼ����ܸ���100�֣���");
		} else if (x < ave) {
			System.out.println(newName + "(ID:" + newID + ")  ƽ���� " + x + "��߷� " + a);
			System.out.println(stu[j].getName() + "(ID:" + stu[j].getID() + ")  ƽ���� " + stu[j].averageScore() + "��߷� "
					+ stu[j].max());
			if (x > ave)
				System.out.println(newName + "��ƽ���ɼ�����ȫ���ƽ����");
			if (x < ave)
				System.out.println(newName + "��ƽ���ɼ�����ȫ���ƽ����");
			if (a == ave)
				System.out.println(newName + "��ƽ���ɼ�����ȫ���ƽ����");
		} else if (ave >= maxave) {
			System.out.println(newName + "(ID:" + newID + ")  ƽ���� " + x + "��߷� " + a);
			System.out.println(newName + "�����ǰ��ϳɼ���õ�ѧ����");
			System.out.println(newName + "��ƽ���ɼ�����ȫ���ƽ����");//���
		}

	}
}
