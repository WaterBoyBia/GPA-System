package stdinfo;

public class Course {
    private	double grade;
    private	int credit;
    private double GPA;
    private String name;
    private boolean importance;
    public Course(String name,double grade,int credit,boolean importance)
    {
        this.credit=credit;
        this.grade=grade;
        this.name=name;
        this.importance=importance;
    }
    public int credit()
    {
        return credit;
    }
    public double grade()
    {
        return grade;
    }
    public boolean importance()
    {
        return importance;
    }
    public double GPA()
    {
        if(90<=grade&&grade<=100)
        {
            GPA=4.0;
        }
        if(85<=grade&&grade<=89)
        {
            GPA=3.7;
        }
        if(80<=grade&&grade<=84)
        {
            GPA=3.3;
        }
        if(76<=grade&&grade<=79)
        {
            GPA=3.0;
        }
        if(73<=grade&&grade<=75)
        {
            GPA=2.7;
        }
        if(70<=grade&&grade<=72)
        {
            GPA=2.3;
        }
        if(66<=grade&&grade<=69)
        {
            GPA=2.0;
        }
        if(63<=grade&&grade<=65)
        {
            GPA=1.7;
        }
        if(62<=grade&&grade<=61)
        {
            GPA=1.3;
        }
        if(60==grade)
        {
            GPA=1.0;
        }
        if(grade<60)
        {
            GPA=0;
        }
        return GPA;
    }

}