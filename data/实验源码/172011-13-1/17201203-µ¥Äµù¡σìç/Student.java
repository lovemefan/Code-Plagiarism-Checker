package Text;

import java.util.Scanner;

public class Student {
	int score1, score2, score3, score4;// ����ѧ���ɼ�
	int m = (int) (Math.random() * 31);
	String studentID = "17201200" + m;// ����ѧ��ѧ��
	String studentName = "marry" + m;// ����ѧ������

	public String getName() {
		return studentName;
	}// ���ѧ������

	public String getID() {
		return studentID;
	} // ���ѧ��ѧ��

	public void score() {
		score1 = (int) (Math.random() * 101);
		score2 = (int) (Math.random() * 101);
		score3 = (int) (Math.random() * 101);
		score4 = (int) (Math.random() * 101);// ���ͬѧ�ĳɼ�
	}

	public int max() {
		int a = 0;
		if (a < score1) {
			a = score1;
		}
		if (a < score2) {
			a = score2;
		}
		if (a < score3) {
			a = score3;
		}
		if (a < score4) {
			a = score4;//aΪ�ɼ����ֵ
		}
		return a;// ��ø�ͬѧ�ɼ��е����ɼ�
	}

	public double averageScore() {
		double b;
		b = (score1 + score2 + score3 + score4) / 4;// ��ȡ��ͬѧ��ƽ���ɼ�
		return b;//bΪƽ���ɼ�
	}

}
