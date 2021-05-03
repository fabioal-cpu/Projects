package Data;

import java.util.ArrayList;

public class SeniorEngineer extends Glober implements Responsibilities {

        private int id;

        public SeniorEngineer(double salary, String name){
            super(salary,name);
            this.id=id;
        }


        @Override
        public void setSalary(double salary) {
            this.salary=salary;
        }

    @Override
    public void setProject() {
        ArrayList<String> project = new ArrayList <String>();
        // Initialize an ArrayList with add()
        project.add("The glober is assigned to a project");
        project.add("The glober has not been assigned to a project yet");
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
            System.out.println("This Glober works as a Senior Engineer");
        }


    @Override
    public void codingSW() {
        System.out.println("High Coding Abilities");
    }

    @Override
    public void debuggingSW() {
        System.out.println("High Debugging Abilities");
    }

    @Override
    public void designingTestPlans() {
        System.out.println("High Designing Test Plans Abilities");
    }

    @Override
    public void executingTestCases() {
        System.out.println("High Executing Test Plans Abilities");
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
