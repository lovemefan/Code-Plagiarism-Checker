package work;

import java.util.Scanner;

public class TestStudent {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//��������
		int[] scores = new int[4];//��������
		Student[] student = new Student[30];//ѧ����
		String studentname = "";//��ʼ��
		String studentid = "";//��ʼ��
		int temp = 0;//��ʼ���޹ر���
		double k = 0;//��ʼ��
		double classaverage = 0;//��ʼ��ƽ����
		
		for (int i = 0; i < 30; i++) {
			studentid = ((int) Math.random() * 30 + 13201101) + "";//ѧ��ID����
			for (int m = 0; m < scores.length; m++) {
				scores[m] = (int) (Math.random() * 100);//ѧ����������
				studentname = studentname + (char) (int) (Math.random() * 26 + 97) + "";//ѧ�����ֲ���
			}
			
			student[i] = new Student(studentname, studentid, scores);
			double maxaveragescore = student[0].averageScore();//�������ƽ����
			if (student[i].averageScore() > maxaveragescore) {
				maxaveragescore = student[i].averageScore();
				temp = i;
			}
			
			k = k + student[i].averageScore();
		}
		
		classaverage = k / 30;//����༶ƽ����
		System.out.println("Enter student name:");
		String name = input.nextLine();
		System.out.println("Enter student num:");
		String num = input.nextLine();
		System.out.println("Enter four scores:");
		int[] score1 = new int[4];
		
		for (int i = 0; i <= 3; i++) {
			score1[i] = input.nextInt();
		}
		
		Student student1 = new Student(name, num, score1);
		for (int i = 0; i < 4; i++) {
			if (score1[i] < 0 || score1[i] > 100) {
				System.out.println("score can not > 100");
				System.exit(0);
			}
			
		}
		System.out.println(student1.getName() + " ID: " + student1.getID() + " averageScore: " + student1.averageScore()
				+ " max: " + student1.max());
		
		if (student1.averageScore() > classaverage) {
			System.out.println(student1.getName() + "is higher than classaverage");
		} else {
			System.out.println(student1.getName() + "is lower than classaverage");
		}
		if (student1.averageScore() > student[temp].averageScore()) {
			System.out.println(student1.getName() + " is the best student");
		} else {
			System.out.println(student[temp].getName() + " ID: " + student[temp].getID() + " averageScore: "
					+ student[temp].averageScore() + " max: " + student[temp].max());
		}
	}
}
