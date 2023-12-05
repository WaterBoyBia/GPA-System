package stdinfo;

import java.util.*;
public class GPA {
    public static void main(String[] args)
    {
        int a;
        Scanner in=new Scanner(System.in);
        System.out.print("  GPA计算系统  \n"
                +"  [1]进入系统  \n"
                +"  [0]退出  \n"
                +"您的选择为："
        );
        a=in.nextInt();
        if(a==1) {
            System.out.println("请先输入学生姓名，该学生已修课程数目\n"+"再依次按照以下格式来输入课程名称，课程成绩，课程学分和课程性质");
            System.out.println("课程名称 课程成绩 课程学分 课程是否为必修课(true)或(false)");
            System.out.println("例如：\n"
                    +"李明  2\n"
                    +"数学 100 2 true\n"
                    +"体育 60 1 false\n"
                    +"【输入”q“可退出系统】");
            while(true){
                int p=0;
                String studentname=in.next();
                //是否退出系统的检验
                if(studentname.charAt(0)=='q'&&studentname.length()==1)
                {
                    System.out.print("欢迎您再次使用");
                    System.exit(0);
                }
                int coursenum=in.nextInt();
                Course[] g=new Course[coursenum];
                int totalcredit=0;
                int importantcredit=0;
                double totalscore=0;
                double importantscore=0;
                double GPA;
                double importantGPA;
                for(int i=0;i<coursenum;i++)
                {
                    String KeChengName=in.next();
                    double KeChengScore=in.nextDouble();
                    int KeChengCredit=in.nextInt();
                    String ShiFouBiXiu=in.next();
                    if(KeChengScore<0||KeChengScore>100)
                    {
                        System.out.println("错误，请检查课程成绩");
                        p++;
                        break;
                    }
                    if(KeChengCredit<0)
                    {
                        System.out.println("错误，请检查课程学分");
                        p++;
                        break;
                    }
                    if(!ShiFouBiXiu.equals("true")&&!ShiFouBiXiu.equals("false"))
                    {
                        System.out.println("错误，请检查课程性质");
                        p++;
                        break;
                    }
                    // TODO: 2022/3/19 其余输入检验
                    g[i]=new Course(KeChengName,KeChengScore,KeChengCredit,importance(ShiFouBiXiu));
                    totalcredit+=g[i].credit();
                    totalscore+=g[i].GPA()*g[i].credit();
                    if(g[i].importance())
                    {
                        importantcredit+=g[i].credit();
                        importantscore+=g[i].GPA()*g[i].credit();
                    }
                }
                if(p==0)
                {
                    GPA=totalscore/totalcredit;
                    importantGPA=importantscore/importantcredit;
                    System.out.println(studentname+"同学的必修课程GPA为："+String.format("%.2f",importantGPA));
                    System.out.println(studentname+"同学的全部课程GPA为："+String.format("%.2f", GPA));
                }
            }
        }
        System.out.print("欢迎您再次使用");
    }
    public static boolean importance(String a)
    {
        boolean b=true;
        if(a.equals("true"))
        {
            b=true;
        }
        if(a.equals("false"))
        {
            b=false;
        }
        return b;
    }
}