package ʵ��һ;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		final int P = 30;   //ѧ����
		final int ID = 17201100;//ѧ�Ż���
		Scanner scan = new Scanner(System.in);
		Student[] stu = new Student[P];//30����������
		for(int i = 0;i < P;i ++) {//���г�ʼ��
			stu[i] = new Student();
		}
		boolean[] flags1 = new boolean[P];//��������
		for(int i = 0;i < P;i ++) {//�ų��ظ�ѧ��
			int t;
			do {
				t = (int)(Math.random()*P+ID);
			}while(flags1[t-ID] == true);
			stu[i].studentID = t;
			flags1[t-ID] = true;
		}
		char[][] name = new char[P][];//�ַ�
		for(int i = 0;i < P;i ++) {//���ȡ��������
			int t = (int)(Math.random()*5+3);
			name[i] = new char[t];
		}
		char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		for(int i = 0;i < P;i ++) {//���
			for(int j = 0;j < name[i].length;j ++) {
				int index = (int)(Math.random()*letters.length);//��ĸ�±�
				name[i][j] = letters[index];
			}
			stu[i].studentName = String.valueOf(name[i]);//�ѵ������ַ�ת�����ַ���
		}
		for(int i = 0;i < P;i ++) {//������ɷ���
			for(int j = 0;j < stu[i].scores.length;j ++) {
				stu[i].scores[j] = (int)(Math.random()*100+1);
			}
		}
			System.out.println("������ѧ��������");
			String newName = scan.nextLine();//������ѧ��������
			System.out.println("������ѧ��ѧ�ţ�");
			int newID = scan.nextInt();//��ѧ����ѧ��
			System.out.println("���������ſεĳɼ����Կո�ָ���");
			int[] newScores = new int[4];
			for(int i = 0;i < newScores.length;i ++) {//��ѧ���ĳɼ�
				newScores[i] = scan.nextInt();
			}
			Student newStudent = new Student(newID,newName,newScores[0],newScores[1],newScores[2],newScores[3]);//����������ݴ������
			int max = newStudent.max();//��ͬѧ����߳ɼ�
			double averageScore = newStudent.averageScore();//��ͬѧ��ƽ����
			int m = 0;//��߳ɼ��ߵ����
			double studentAverageScore = 0;//��߳ɼ��ߵ�ƽ���ɼ�
			for(int i = 0;i < P;i ++) {//Ѱ����߳ɼ��ߵ����
				if(studentAverageScore < stu[i].averageScore()) {
					studentAverageScore = stu[i].averageScore();
					m = i;
				}
			}
			int studentMax = stu[m].max();//��߳ɼ��ߵ���߳ɼ�
			double allAverageScore = 0;//ȫ�������˵�ƽ���ɼ��ܺ�
			for(int i = 0;i < P;i ++) {
				allAverageScore += stu[i].averageScore();
			}
			double classAverageScore = allAverageScore/P;//�༶��ƽ���ɼ�
			if(newScores[0] > 100 || newScores[0] < 0 || newScores[1] > 100 || newScores[1] < 0 || newScores[2] > 100 || newScores[2] < 0 || newScores[3] > 100 || newScores[3] < 0) {
				System.out.println("�γ̳ɼ����ܸ���100�֣�����С��0�֣���");
			}else if(averageScore < studentAverageScore){
				System.out.println(newName +"(ID:"+ newID +") ƽ���֣�"+ averageScore +" ��߷֣�"+ max);
				System.out.println(stu[m].studentName+"(ID:"+stu[m].studentID+") ƽ���֣�"+ studentAverageScore +" ��߷֣�"+ studentMax);
				if(averageScore < classAverageScore) {
					System.out.println(newName +"��ƽ���ɼ�����ȫ���ƽ���֡�");
				}else if(averageScore == classAverageScore) {
					System.out.println(newName +"��ƽ���ɼ�����ȫ���ƽ���֡�");
				}else {
					System.out.println(newName +"��ƽ���ɼ�����ȫ���ƽ���֡�");
				}
			}else if(averageScore >= studentAverageScore){
				System.out.println(newName +"(ID:"+ newID +") ƽ���֣�"+ averageScore +" ��߷֣�"+ max);
				System.out.println(newName +"�����ǰ��ϳɼ���õ�ѧ����");
				System.out.println(newName +"��ƽ���ɼ�����ȫ��ĵ�ƽ����");
			}
			scan.close();
	}
}

