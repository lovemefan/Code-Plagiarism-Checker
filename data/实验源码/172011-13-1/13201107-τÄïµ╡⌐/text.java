/*
 * ʵ��Ŀ�ģ�
    1.��ϰ��Ĺ��췽���������ĵ��á��������ݡ�����Ĺ�����ʹ�ã�
	2.��ϰѭ���ṹ�����ƽṹ��
	3.��ϰ���ݵ������������
	4.ѧϰ��д�ṹ�������߼���ȷ���������Ƶ�java���롣
	ĳ����30��ѧ����ÿ��ѧ����ѧ�š�������4�ųɼ���ѧ����Ϣ�������������һ���������飩������ת��һ��ѧ����
	��������λѧ����ѧ�š������ͳɼ������ſεĳɼ�С��100�֣��Ӽ������룬�Կո�Ϊ���֣���Ȼ����ʾ����ѧ��ƽ
	���֡���߷֣�ȫ������ƽ����ѧ����Ϣ����ͬѧ�ڰ༶�еĳɼ�ˮƽ.
  */
import java.util.*;

public class text {
	public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String[] stuName= {"����","����","����","�ֿ�˹","���˹","ޱ��","��ɯ","��ʯ","��ŷ��","������","ά����","����˹��","��˹����","��˹��","����˹","��������","����","��ϣ","��ܽ��","��ɪ��","¬����","�������","��","̩¡","����","������","����","������","ε","�¶�"};
        long[] stuID= {13201101,13201102,13201103,13201104,13201105,13201106,13201107,13201108,13201109,13201110,13201111,13201112,13201113,13201114,13201115,13201116,13201117,13201118,13201119,13201120,13201121,13201122,13201123,13201124,13201125,13201126,13201127,13201128,13201129,13201130};
        int[][] score= {
                {89,84,78,89},
                {89,78,89,78},
                {74,78,78,45},
                {46,89,65,64},
                {78,98,56,45},
                {78,89,56,45},
                {45,87,98,94},
                {65,98,87,54},
                {56,53,59,98},
                {87,88,86,84},
                {78,56,84,89},
                {64,86,56,56},
                {15,53,53,15},
                {95,56,54,56},
                {54,89,98,97},
                {99,100,87,99},
                {78,56,56,23},
                {56,52,51,56},
                {56,89,78,45},
                {78,98,65,84},
                {12,56,23,12},
                {45,45,45,56},
                {45,21,12,78},
                {85,56,23,51},
                {15,56,84,89},
                {56,48,47,45},
                {85,23,54,65},
                {85,26,41,45},
                {48,16,23,19},
                {85,56,56,23}
        };
        //score����ƽ��ֵ�����average
        double[] average = new double[30];

        //��ʼѭ��score
        for (int i=0;i<score.length;i++){
            int totals = 0;
            for (int j=0;j<score[i].length;j++){
                //��ȡ��i�еĸ������ݣ�����������
                totals = totals + score[i][j];
            }
            //ѭ���������ȡ����i�е�����
            //��������ʼ�����i��ƽ����
            double average_score = totals / 4;
            //��������Ľ���ŵ�������ȥ
            average[i] = average_score;
        }//���ѭ�����������Ǿ��ܻ��һ������ average ������������һ��


        //��ʼѭ�� average ��ȡ�����,
      //��ʼѭ�� average ��ȡ�����,
        double k = 0;
        int index = 0; //������±�ŵ�ֵ
        for(int i = 0;i<average.length;i++) {
            /*//��ʼk��0��Ȼ���ÿ�ζԱȱ�k�������k
            k = max(average[i],k);*/
            //�����ǰ�����ֵ��K�󣬾Ͱѵ�ǰ������±��index��ֵ��k
            if (max(average[i],k) > k) {
                index = i;
                k = max(average[i],k);
            }
        }
        //����༶ƽ����
        double average3 = 0;
        int sum = 0;
        for (int i = 0;i < score.length;i++){
            for (int j = 0;j <score[i].length;j++){
                sum = sum + score[i][j];
            }
        }
        average3 = sum / 120;
        System.out.println("�༶ƽ������"+average3);
        //����ɼ���õ�ѧ����������ѧ�ţ�ƽ����
        System.out.println("�ɼ���õ�ѧ����:"+stuName[index]+stuID[index]+"���ƽ������:"+k);
        //����������ͬѧ����Ϣ
        System.out.println("��������ת��ͬѧ��������");
        String stuName1 = input.next();
        System.out.println("��������ת��ͬѧ��ѧ�ţ�");
        int StuID1 = input.nextInt();
        int[] score1 = new int[4];
        System.out.println("��������ת��ͬѧ�����ſγ̳ɼ���");
        //����������  ����ѭ�����룬int����
        for (int i = 0; i < score1.length; i++) {
            //�������ֵ���ŵ����score1��������
            score1[i] = input.nextInt();
        }
        //����������
        System.out.println("��ͬѧ��������"+stuName1+" ��ͬѧ��ѧ��:"+StuID1);
        for (int i = 0; i < score1.length; i++) {
            System.out.print(score1[i]+" ");
        }

        int sums = 0;
    	int average2 = 0;
        for(int n=0;n<4;n++) {
        	sums=sums+score1[n];
        }
        average2 = sums/4;
        if(average2>average3) {
        	if(average2>k) {
        		System.out.println("��ͬѧ�����ǰ��ϳɼ���õ�ͬѧ��ƽ����Ϊ"+average2);
        	}else  {
        		System.out.println("��ͬѧ�����˰��ϵ�ƽ���֣�ƽ����Ϊ"+average2);
        	}
        }else {
        	System.out.println("��ͬѧ���ڰ༶ƽ���֣�ƽ����Ϊ"+average2);
        }
	}


    public static int max(double num1,double num2){

        double result;

        if(num1>num2)
            result=num1;
        else
            result=num2;

        return (int)result;
    }
}

