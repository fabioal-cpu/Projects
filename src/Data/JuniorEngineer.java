package Data;

import java.util.ArrayList;

public class JuniorEngineer extends Glober implements Responsibilities {

    private int id;


    public JuniorEngineer(double salary, String name){
        super(salary,name);
        this.id=id;
    }


   @Override
    public void setSalary(double salary) {
        this.salary=salary;
    }

    @Override
    public void setProject() {
        ArrayList<String> pro = new ArrayList <String>();
        // Initialize an ArrayList with add()
        pro.add("The glober is assigned to a project");
        pro.add("The glober has not been assigned to a project yet");
    }


    @Override
    public double getSalary() {
        return salary;
    }


    public void setName(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }



    @Override
    public void toWork(){
        System.out.println("This Glober works as a Junior Engineer");
    }


    @Override
    public void codingSW() {
        System.out.println("Basic Coding Abilities");
    }

    @Override
    public void debuggingSW() {
        System.out.println("Basic Debugging Abilities");
    }

    @Override
    public void designingTestPlans() {
        System.out.println("Basic Designing Test Plans Abilities");
    }

    @Override
    public void executingTestCases() {
        System.out.println("Basic Executing Test Plans Abilities");
    }

    @Override
    public void leadingATeam() {
        System.out.println("Not able to do lead a team");
    }

    @Override
    public void coachingATeam() {
        System.out.println("Not able to coach a team");
    }
}
