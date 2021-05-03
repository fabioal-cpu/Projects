package Data;

import java.util.ArrayList;

public abstract class Glober {

    protected double salary;
    protected String name;


    public Glober(double salary, String name){
        this.name=name;
        this.salary=salary;

    }

    public abstract void setSalary(double salary);

    public abstract void setProject();

    public String getName(){
        return name;
    }

    public void toWork()
    {
        System.out.println("Working (Parent Class)");
    }



    public abstract double getSalary();

    public abstract void designingTestPlans();

    public abstract void executingTestCases();

    public abstract void codingSW();

    public abstract void debuggingSW();

    public abstract void coachingATeam();

    public abstract void leadingATeam();
}
