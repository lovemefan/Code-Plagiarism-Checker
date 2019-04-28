import java.util.Scanner;
public class Grade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student []s = new Student[31];   //建立31个学生对象
        char ch = '\0'; //初始化字符
        int num = 17201101;  //起始学号
        int []array = new int[4]; //建立数组将成绩传给对象
        for(int i = 0;i < 30; i ++) {
            String name = ""; //每次循环重置字符串为0
            for(int j = 0;j < 4;j ++) {
                ch = (char) (Math.random()* 26 + 97); //随机ch字符为a-z之间
                name += ch ; //将四个字符合起来为字符串
                array[j] = (int) (Math.random()* 101); //随机分数为0-100之间
            }
            String str = num + i + ""; //将整数型转换为字符串
            s[i] = new Student(name,str,array); //将学生信息赋给对象
            System.out.println(s[i].getID() + "  "+s[i].getName() + " " + s[i].getScore(0) + " " + s[i].getScore(1) + " " + s[i].getScore(2) + " " + s[i].getScore(3) +"   "+s[i].averageScore());
        }
        System.out.print("请输入学生学号: ");
        String ID = input.nextLine(); //输入学生学号
        System.out.print("请输入学生姓名:");
        String Name = input.nextLine(); //输入学生姓名
        System.out.print("请输入四门课的成绩，以空格分隔:");
        int []grade = new int[4]; //建立学生成绩数组
        grade[0] = input.nextInt(); //输入第一门成绩
        grade[1] = input.nextInt(); //输入第二门成绩
        grade[2] = input.nextInt(); //输入第三门成绩
        grade[3] = input.nextInt(); //输入第四门成绩
        s[30] = new Student(Name,ID,grade); ////将学生信息传给给对象
        System.out.println(s[30].getName() + "(ID:" +s[30].getID() +")" +" 平均分:" + s[30].averageScore() + "  最高分:" + s[30].max());
        double max = s[0].averageScore(); //max先设为第一个学生的平均成绩
        int j = 0; //用在for循环中记住i的值
        int sum = 0; //统计学生平均分数和
        //for循环遍历求30个学生最大平均成绩
        for(int i = 0; i < 30 ;i ++) {
            sum += s[i].averageScore();
            if(max < s[i].averageScore()) {
                max = s[i].averageScore();
                j=i;  //记住最大平均成绩的学生对象的位置
            }
        }
        double average = sum/30.0; //计算全班所有人平均成绩
        System.out.println(s[j].getName() + "(ID:" +s[j].getID() +")" +" 最高平均分:" + s[j].averageScore() + "  最高分:" + s[j].max()); //输出最高分学生信息
         if(s[30].averageScore() >100) {
            System.out.println("课程成绩不能高于100分！");
            return;
        }
        if(s[30].averageScore() == 100 || s[30].averageScore() > s[j].averageScore()) {
            System.out.println(s[30].getName() + "现在是班上成绩最好的学生了");
        }
        if(s[30].averageScore() > average) {
            System.out.println(s[30].getName() + "的平均成绩高于全班的平均分");
        }
        else if(s[30].averageScore() < average) {
            System.out.println(s[30].getName() + "的平均成绩低于全班的平均分");
        }
        else {
            System.out.println(s[30].getName() + "的平均成绩等于全班的平均分");
        }
    }

}
