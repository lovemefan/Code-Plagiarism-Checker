/*
 * 实验目的：
    1.练习类的构造方法、方法的调用、参数传递、对象的构造与使用；
	2.练习循环结构、控制结构；
	3.练习数据的输入与输出；
	4.学习编写结构清晰、逻辑正确、功能完善的java代码。
	某班有30名学生，每个学生有学号、姓名和4门成绩（学生信息随机产生，存入一个对象数组），现新转来一名学生，
	请输入这位学生的学号、姓名和成绩（四门课的成绩小于100分，从键盘输入，以空格为区分），然后显示这名学生平
	均分、最高分，全班的最高平均分学生信息、新同学在班级中的成绩水平.
  */
import java.util.*;

public class text {
	public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String[] stuName= {"亚索","李青","瑞文","贾克斯","金克斯","薇恩","卡莎","锤石","蕾欧娜","戴安娜","维克托","卡莉斯塔","崔斯塔娜","崔斯特","吉格斯","嘉文四世","盖伦","艾希","伊芙琳","凯瑟琳","卢锡安","伊泽瑞尔","劫","泰隆","菲兹","阿卡丽","安妮","布兰德","蔚","奥恩"};
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
        //score数据平均值存放在average
        double[] average = new double[30];

        //开始循环score
        for (int i=0;i<score.length;i++){
            int totals = 0;
            for (int j=0;j<score[i].length;j++){
                //获取第i行的各个数据，并计算总数
                totals = totals + score[i][j];
            }
            //循环结束会获取到第i行的总数
            //接下来开始计算第i行平均数
            double average_score = totals / 4;
            //把算出来的结果放到数组里去
            average[i] = average_score;
        }//这个循环结束后，我们就能获得一个数组 average 你可以输出来看一下


        //开始循环 average 获取最大数,
      //开始循环 average 获取最大数,
        double k = 0;
        int index = 0; //这个是下标放的值
        for(int i = 0;i<average.length;i++) {
            /*//开始k是0，然后把每次对比比k大的数给k
            k = max(average[i],k);*/
            //如果当前数组的值比K大，就把当前数组的下标给index，值给k
            if (max(average[i],k) > k) {
                index = i;
                k = max(average[i],k);
            }
        }
        //计算班级平均分
        double average3 = 0;
        int sum = 0;
        for (int i = 0;i < score.length;i++){
            for (int j = 0;j <score[i].length;j++){
                sum = sum + score[i][j];
            }
        }
        average3 = sum / 120;
        System.out.println("班级平均分是"+average3);
        //输出成绩最好的学生的姓名，学号，平均分
        System.out.println("成绩最好的学生是:"+stuName[index]+stuID[index]+"最高平均分是:"+k);
        //输入新来的同学的信息
        System.out.println("请输入新转来同学的姓名：");
        String stuName1 = input.next();
        System.out.println("请输入新转来同学的学号：");
        int StuID1 = input.nextInt();
        int[] score1 = new int[4];
        System.out.println("请输入新转来同学的四门课程成绩：");
        //这里是输入  且是循环输入，int类型
        for (int i = 0; i < score1.length; i++) {
            //把输入的值，放到这个score1数组里面
            score1[i] = input.nextInt();
        }
        //输出这个数组
        System.out.println("新同学的姓名："+stuName1+" 新同学的学号:"+StuID1);
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
        		System.out.println("该同学现在是班上成绩最好的同学，平均分为"+average2);
        	}else  {
        		System.out.println("该同学超过了班上的平均分，平均分为"+average2);
        	}
        }else {
        	System.out.println("该同学低于班级平均分，平均分为"+average2);
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

