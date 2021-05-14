package FinalProject.Main;

import FinalProject.Data.CourseRoom;
import FinalProject.Data.Student;
import FinalProject.Data.Teacher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class main {
    private static int initializationt = 2;
    private static boolean exit = true;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Teacher> teacherList = new ArrayList<>();
        ArrayList<CourseRoom> courseList = new ArrayList<>();

        //Students info
        Student s1 = new Student("Fabio", 2201688, 19);
        Student s2 = new Student("Juan", 2210562, 20);
        Student s3 = new Student("Nathalia", 2152682, 16);
        Student s4 = new Student("Daniela", 1010526, 21);
        Student s5 = new Student("Daniel", 21526501, 20);
        Student s6 = new Student("Fabian", 2021594, 20);
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);

        //Teacher info
        Teacher t1 = new Teacher("Marcela", 41585462, true, 1000000, 15, 8);
        Teacher t2 = new Teacher("Alex", 40525930, true, 1000000, 12, 1);
        Teacher t3 = new Teacher("Veronica", 42957532, false, 1000000, 13, 0);
        Teacher t4 = new Teacher("Martha", 26351859, false, 1000000, 8, 12);
        teacherList.add(t1);
        teacherList.add(t2);
        teacherList.add(t3);
        teacherList.add(t4);

        //Teacher calc = new Teacher()

        double salaystest = teacherList.get(2).teacherSalary(teacherList.get(2).getTeachertype(), teacherList.get(2).getBaseSalary(), teacherList.get(2).getExperienceyears(), teacherList.get(2).getHourswork());
        System.out.println("validar test salary " + salaystest);


        for (int i = 0; i < teacherList.size(); i++) {
            double salary = teacherList.get(i).teacherSalary(teacherList.get(i).getTeachertype(), teacherList.get(i).getBaseSalary(), teacherList.get(i).getExperienceyears(), teacherList.get(i).getHourswork());
            teacherList.get(i).setBaseSalary(salary);
        }

        for (int i = 0; i < teacherList.size(); i++) {
            String tType = teacherList.get(i).teacherTyDef(teacherList.get(i).getTeachertype());
            teacherList.get(i).setType(tType);
            System.out.println("nombre: " + teacherList.get(i).getname() + " tipo de prof: " + teacherList.get(i).getType());
        }

        for (int j = 0; j < teacherList.size(); j++) {
            System.out.println("Teacher name: " + teacherList.get(j).getname() + " teacher id: " + teacherList.get(j).getId() + " teacher salary: " + teacherList.get(j).getBaseSalary());
        }


        //Course

        Random random = new Random();
        ArrayList<Student> stinclass = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(3);
            stinclass.add(studentList.get(number));
        }

        CourseRoom clas1 = new CourseRoom("Finance", 505, teacherList.get(0), stinclass);
        CourseRoom clas2 = new CourseRoom("Math", 101, teacherList.get(1), studentList);
        ArrayList<Student> stinclass1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(3);
            stinclass1.add(studentList.get(number));
        }
        CourseRoom clas3 = new CourseRoom("Business", 405, teacherList.get(2), stinclass1);
        ArrayList<Student> stinclass2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(3);
            stinclass2.add(studentList.get(number));
        }
        CourseRoom clas4 = new CourseRoom("Projection", 302, teacherList.get(0), stinclass2);
        ArrayList<Student> stinclass3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(3);
            stinclass3.add(studentList.get(number));
        }
        CourseRoom clas5 = new CourseRoom("Econometrics", 504, teacherList.get(3), stinclass3);
        courseList.add(clas1);
        courseList.add(clas2);
        courseList.add(clas3);
        courseList.add(clas4);
        courseList.add(clas5);


        //main main = new main();


        do {
            System.out.println("\nWelcome to the University. Pls indicate what you would like to do:");
            System.out.println("1. Print all the professors with its data");
            System.out.println("2. Print all the classes and a submenu to select a class in order to print " +
                    "the class data including its teacher and students");
            System.out.println("3. Create a new student and add it to an existing class");
            System.out.println("4. Create a new class and add a teacher, students and its relevant data");
            System.out.println("5. List all the classes in which a given student is included");
            System.out.println("6. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Please initialize two different teachers of each type");

                    for (int i = 0; i < initializationt; i++) {

                        System.out.println("Please insert the teacher name");
                        String name = scanner.next();

                        System.out.println("\nPlease insert the teacher type of contract \n 1. Full time \n 2. Part time");
                        boolean teachertype = scanner.nextBoolean();

                        System.out.println("\nPlease insert the teacher base salary");
                        double baseSalary = scanner.nextDouble();

                        System.out.println("\n*Please insert the hours worked if applicable*");
                        double hourswork = scanner.nextDouble();

                        System.out.println("\n*Pleas insert the experience years if applicable*");
                        double experienceyears = scanner.nextDouble();

//                        Teacher addoptions = new Teacher(name,id,teachertype,baseSalary,hourswork,experienceyears);
//                        teacherList.add(addoptions);


                        //Falta agregar los metodos de calculo
//
//                        System.out.println(teacherList.get(i).teacherType() + "  $" + teacherList.get(i).teacherSalary());


                    }
                    break;

                case 2:
                    break;

                case 3:
                    System.out.println("\nPlease insert the information of the new student");
                    System.out.println("Insert the student name");
                    String name = scanner.next();

                    System.out.println("Insert the student ID");
                    int id = scanner.nextInt();

                    System.out.println("Insert the student age");
                    int age = scanner.nextInt();

                    Student nst = new Student(name, id, age);
                    studentList.add(nst);

                    Iterator itr = studentList.iterator();
                    while (itr.hasNext()) {
                        Student st = (Student) itr.next();
                        System.out.println(st.name + " " + st.getId() + " " + st.getAge());
                    }

                    //Adding the student in a class

                    System.out.println("Please select a class to enroll: ");

                    for (int i = 0; i < courseList.size(); i++) {
                        System.out.println((i + 1) + ". " + courseList.get(i).getNameCourse());
                    }
                    int selectClass = scanner.nextInt();
                    courseList.get(selectClass - 1).getSbyclass().add(studentList.get(6));

                    System.out.println("The student was enrolled to the class " + courseList.get(selectClass - 1).getNameCourse());

//                    System.out.print("\nThe full student list in the " + courseList.get(selectClass-1).getNameCourse() + " are " + courseList.get(selectClass-1).getNameCourse());

                    System.out.println("The full student list for the class " + courseList.get(selectClass - 1).getNameCourse() + " are: ");
                    for (int i = 0; i < courseList.get(selectClass - 1).getSbyclass().size(); i++) {
                        System.out.println(courseList.get(selectClass - 1).getSbyclass().get(i).name);
                    }

                    //Compulsory class = math, sorry. University laws
                    courseList.get(1).getSbyclass().add(studentList.get(6));
                    System.out.println("\nUnder the University law you were enrolled as compulsory class to " + courseList.get(1).getNameCourse());


                    break;


            }


        } while (exit == true);


    }
}
