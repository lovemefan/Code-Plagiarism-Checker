package Zuoye;


import java.util.Scanner;

public class yaha1 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Stu[] stus = new Stu[30];

		for(int i=0;i<30;i++)
		{
			stus[i]=Stu.getStu();
		}

		Scanner in = new Scanner(System.in);
		System.out.println("������ѧ������: ");
		double sum = 0;
		double max = 0;
		double grades[] = new double[4];
		Stu newStu = new Stu();
		newStu.setName(in.nextLine());
		System.out.println("������ѧ��ѧ��: ");
		newStu.setId(in.nextLine());
		System.out.println("���������ſεĳɼ����Կո�ָ�: ");
		for(int i=0;i<4;i++)
		{
			grades[i] = in.nextInt();
			if(max<grades[i])
				max = grades[i];
			sum += grades[i];
		}
		newStu.setMax(max);
		newStu.setAverGrade(sum/4);
		newStu.setGrades(grades);
		System.out.println(newStu.getName()+"(ID:"+newStu.getId()+") ƽ���� "+newStu.getAverGrade()
		+" ��߷� "+newStu.getMax());
		double best = newStu.getAverGrade();
		Stu bestStu = newStu;
		double average = 0;
		for(int i=0;i<30;i++)
		{
			average += stus[i].averGrade;
			if(best < stus[i].averGrade)
			{
				best = stus[i].averGrade;
				bestStu = stus[i];
			}
		}
		average/=30;
		System.out.println(bestStu.getName()+"(ID:"+bestStu.getId()+") ƽ���� "+bestStu.getAverGrade()
		+" ��߷� "+bestStu.getMax());
		System.out.println(newStu.getName()+" ��ƽ���ɼ�"+(newStu.getAverGrade()>average?"����":"����")+"ȫ���ƽ����");
	}
}
