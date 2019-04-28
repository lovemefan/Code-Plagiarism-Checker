//学生类，存储学生信息
class Student{
    private String studentID; //学生学号
    private String studentName; //学生姓名
    private int []score = new int[4]; //学生四门成绩
    //无参构造方法
    Student(){
    }

    //获得学生学号
    public String getID(){
        return studentID;
    }

    //获得学生的姓名
    public String getName(){
        return  studentName;
    }

    //获得学生成绩
    public int getScore(int i) {
        return score[i];
    }

    //学生类的构造方法
    public Student(String studentName,String studentID,int []score){
        this.studentName =studentName;
        this.studentID =studentID;
        this.score[0] = score[0];
        this.score[1] = score[1];
        this.score[2] = score[2];
        this.score[3] = score[3];
    }

    //求学生平均最大成绩
    public int max(){
        int temp = score[0];
        for(int i = 1;i < 4;i ++) {
            if(temp < score[i]) {
                temp = score[i];
            }
        }
        return temp;
    }

    //求学生平均成绩
    public double averageScore(){
        return (score[0]+score[1]+score[2]+score[3])/4.0;

    }
}

