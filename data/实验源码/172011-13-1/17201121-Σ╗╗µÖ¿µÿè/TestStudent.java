package TestStudent;

import java.util.Scanner;

public class TestStudent {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Student[] student = new Student[30];
		int Averange = 0;			//ȫ��ƽ��ֵ
		int sum = 0;				//����ȫ���ܷ�
		int max = 0;				//���ͬѧƽ��ֵ
		int temp = 0;				//�滻��ǰ���ƽ��ֵ
		int k = 0;					//���ȫ�����ƽ��ֵ��ͬѧ

		for (int n = 0;n < 30;n++) {
			student[n] = new Student();
			student[n].Grade = new int[4];//�����ʼ�����ܷ���ÿ��ͬѧ�����ųɼ����ѭ���з���Ὣ�ɼ���ʼ��
			for (int i = 0;i < 4;i++) {
				student[n].setName(student[n].getName());
				//System.out.println(""+ student[n].Name);�����������������

				student[n].setID("172011" + n);

				student[n].Grade[i] = (int)(Math.random() * 100);
				//System.out.println(+ student[n].Grade[i]);���������������

				temp += student[n].Grade[i];
				sum += student[n].Grade[i];
			}
			if (temp > max){
				max = temp;
				k = n;
				//System.out.println(+k);���ȽϹ������Ƿ��������
		}
		temp = 0;//ѭ������㣬��ֹ�谭�´αȽ�
		}
		Averange = sum/120;
		//System.out.println(+ Averange);���ȫ��ƽ�����Ƿ�����

		System.out.println("Enter the name of student:");
		String x = input.nextLine();//��������

		System.out.println("Enter the ID of student:");
		String y = input.nextLine();//����ѧ��

		System.out.println("Enter four grade of student:");
		int[] Grade= new int[4];//���ճɼ�
		for (int i = 0;i < 4;i++) {
			int z = input.nextInt();
			Grade[i] = z;
			
			if (Grade[i] >100){
				System.out.println("Grade cannot higher than 100!!!");
				System.exit(0);
			}
		}

		Student student1 = new Student(x,y,Grade);

		System.out.println(student1.getname() +"(ID: "+ student1.getID() +") averange: "
		+ student1.getAverange() +" highest: "+ student1.getHighest());

		System.out.println(student[k].getname() +"(ID: "+ student[k].getID() +") averange: "
				+ student[k].getAverange() +" highest: "+ student[k].getHighest());

		//System.out.println(+ student[k].Grade[0] +" "+ student[k].Grade[1] +" "+ student[k].Grade[2] +" "+ student[k].Grade[3]);


		if (student1.getAverange() > Averange) {//������ͬѧ��ƽ���ɼ���ȫ����бȽ�
			System.out.println(student1.getname() +"'s averange grade higher than class");
		}
		else {
			System.out.println(student1.getname() +"'s averange grade lower than class");
		}

		if (student1.getAverange() > student[k].getAverange()) {
			System.out.println(student1.getname() +"'s grade is the best of class");
		}
	}

}

