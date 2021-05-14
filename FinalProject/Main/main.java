package FinalProject.Main;

import FinalProject.Data.CourseRoom;
import FinalProject.Data.Student;
import FinalProject.Data.Teacher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class main {

    private static boolean exit = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Teacher> teacherList = new ArrayList<>();
        ArrayList<CourseRoom> courseList = new ArrayList<>();

        //Students initialization
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

        //Teacher initialization
        Teacher t1 = new Teacher("Marcela", 41585462, true, 1000000, 15, 8);
        Teacher t2 = new Teacher("Alex", 40525930, true, 1000000, 12, 1);
        Teacher t3 = new Teacher("Veronica", 42957532, false, 1000000, 13, 0);
        Teacher t4 = new Teacher("Martha", 26351859, false, 1000000, 8, 12);
        teacherList.add(t1);
        teacherList.add(t2);
        teacherList.add(t3);
        teacherList.add(t4);


        //Class initialization
        //Selecting students in class
        Random random = new Random();
        ArrayList<Student> stinclass = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(6);
            stinclass.add(studentList.get(number));
        }
//        for (int i = 0; i < 3; i++) {
//            int randomIndex;
//            do{
//                randomIndex = random.nextInt(3);
//            }while (search(stinclass, randomIndex));
//
//            stinclass.add(studentList.get(randomIndex));
//        }
        ArrayList<Student> stinclass1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(6);
            stinclass1.add(studentList.get(number));
        }

        ArrayList<Student> stinclass2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(6);
            stinclass2.add(studentList.get(number));
        }

        ArrayList<Student> stinclass3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(6);
            stinclass3.add(studentList.get(number));
        }

        //University Information
        CourseRoom clas1 = new CourseRoom("Finance", 505, teacherList.get(0), stinclass);
        CourseRoom clas2 = new CourseRoom("Math", 101, teacherList.get(1), studentList);
        CourseRoom clas3 = new CourseRoom("Business", 405, teacherList.get(2), stinclass1);
        CourseRoom clas4 = new CourseRoom("Statistic", 302, teacherList.get(0), stinclass2);
        CourseRoom clas5 = new CourseRoom("Econometrics", 504, teacherList.get(3), stinclass3);
        courseList.add(clas1);
        courseList.add(clas2);
        courseList.add(clas3);
        courseList.add(clas4);
        courseList.add(clas5);


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
                    for (int i = 0; i < teacherList.size(); i++) {
                        double salary = teacherList.get(i).teacherSalary(teacherList.get(i).getTeachertype(), teacherList.get(i).getBaseSalary(), teacherList.get(i).getExperienceyears(), teacherList.get(i).getHourswork());
                        teacherList.get(i).setBaseSalary(salary);
                    }

                    for (int i = 0; i < teacherList.size(); i++) {
                        String tType = teacherList.get(i).teacherTyDef(teacherList.get(i).getTeachertype());
                        teacherList.get(i).setType(tType);
                    }

                    for (int j = 0; j < teacherList.size(); j++) {
                        System.out.println("Teacher name: " + teacherList.get(j).getname() + ", teacher id: " + teacherList.get(j).getId() + ", teacher type: " + teacherList.get(j).getType() + ", teacher salary: $" + teacherList.get(j).getBaseSalary());
                    }
                    break;

                case 2:
                    System.out.println("The full list of classes is: ");
                    for (int i = 0; i < courseList.size(); i++) {
                        System.out.println(courseList.get(i).getNameCourse());
                    }

                    boolean exitsubmenu = true;

                    System.out.println("\nPlease select the class that you would like to see more information:");
                    do {
                        System.out.println("1. " + courseList.get(0).getNameCourse());
                        System.out.println("2. " + courseList.get(1).getNameCourse());
                        System.out.println("3. " + courseList.get(2).getNameCourse());
                        System.out.println("4. " + courseList.get(3).getNameCourse());
                        System.out.println("5. " + courseList.get(4).getNameCourse());
                        System.out.println("6. Exit");

                        int classselected = scanner.nextInt();

                        switch (classselected) {
                            case 1:
                                System.out.println("This is the full information of the class selected: ");
                                System.out.println("Class name: " + courseList.get(0).getNameCourse() + ", classroom #: " + courseList.get(0).getClassRoom() + ", teacher name: " + courseList.get(0).gettAssignation().name + ", and the students are: ");
                                for (int i = 0; i < courseList.get(0).getSbyclass().size(); i++) {
                                    System.out.println(courseList.get(0).getSbyclass().get(i).name);
                                }
                                break;
                            case 2:
                                System.out.println("This is the full information of the class selected: ");
                                System.out.println("Class name: " + courseList.get(1).getNameCourse() + ", classroom #: " + courseList.get(1).getClassRoom() + ", teacher name: " + courseList.get(1).gettAssignation().name + ", and the students are: ");
                                for (int i = 0; i < courseList.get(1).getSbyclass().size(); i++) {
                                    System.out.println(courseList.get(1).getSbyclass().get(i).name);
                                }
                                break;
                            case 3:
                                System.out.println("This is the full information of the class selected: ");
                                System.out.println("Class name: " + courseList.get(2).getNameCourse() + ", classroom #: " + courseList.get(2).getClassRoom() + ", teacher name: " + courseList.get(2).gettAssignation().name + ", and the students are: ");
                                for (int i = 0; i < courseList.get(2).getSbyclass().size(); i++) {
                                    System.out.println(courseList.get(2).getSbyclass().get(i).name);
                                }
                                break;
                            case 4:
                                System.out.println("This is the full information of the class selected: ");
                                System.out.println("Class name: " + courseList.get(3).getNameCourse() + ", classroom #: " + courseList.get(3).getClassRoom() + ", teacher name: " + courseList.get(3).gettAssignation().name + ", and the students are: ");
                                for (int i = 0; i < courseList.get(3).getSbyclass().size(); i++) {
                                    System.out.println(courseList.get(3).getSbyclass().get(i).name);
                                }
                                break;
                            case 5:
                                System.out.println("This is the full information of the class selected: ");
                                System.out.println("Class name: " + courseList.get(4).getNameCourse() + ", classroom #: " + courseList.get(4).getClassRoom() + ", teacher name: " + courseList.get(4).gettAssignation().name + ", and the students are: ");
                                for (int i = 0; i < courseList.get(4).getSbyclass().size(); i++) {
                                    System.out.println(courseList.get(4).getSbyclass().get(i).name);
                                }
                                break;

                            case 6:
                                exitsubmenu = false;
                        }
                    } while (exitsubmenu == true);

                    break;

                case 3:

                    //Creating the new student
                    System.out.println("\nPlease insert the information of the new student");
                    System.out.println("Insert the student name");
                    String name = scanner.next();

                    System.out.println("Insert the student ID");
                    int id = scanner.nextInt();

                    System.out.println("Insert the student age");
                    int age = scanner.nextInt();

                    Student nst = new Student(name, id, age);
                    studentList.add(nst);

                    //Adding the student in a class

                    System.out.println("\nAs new student please select a class to enroll: ");

                    for (int i = 0; i < courseList.size(); i++) {
                        System.out.println((i + 1) + ". " + courseList.get(i).getNameCourse());
                    }
                    int selectClass = scanner.nextInt();
                    courseList.get(selectClass - 1).getSbyclass().add(studentList.get(6));

                    System.out.println("The student was enrolled to the class " + courseList.get(selectClass - 1).getNameCourse());

                    System.out.println("The full student list for the class " + courseList.get(selectClass - 1).getNameCourse() + " are: ");
                    for (int i = 0; i < courseList.get(selectClass - 1).getSbyclass().size(); i++) {
                        System.out.println(courseList.get(selectClass - 1).getSbyclass().get(i).name);
                    }

                    //Compulsory class = math, sorry. University laws
                    courseList.get(1).getSbyclass().add(studentList.get(6));
                    System.out.println("\nUnder the University law you are enrolled compulsory class of " + courseList.get(1).getNameCourse());

                    //The full list of students
                    System.out.println("\nThe full student list is: ");

                    Iterator itr = studentList.iterator();
                    while (itr.hasNext()) {
                        Student st = (Student) itr.next();
                        System.out.println(st.name + " " + st.getId() + " " + st.getAge());
                    }

                    break;
                case 4:

                    //Creating the new class
                    System.out.println("\nPlease insert the information of the new class");
                    System.out.println("Insert the class name");
                    String className = scanner.next();

                    System.out.println("Insert the classroom where the the new class will be offered: ");
                    int nClassRoom = scanner.nextInt();

                    ArrayList<Student> stinclass4 = new ArrayList<>();
                    for (int i = 0; i < 3; i++) {
                        int number = random.nextInt(6);
                        stinclass4.add(studentList.get(number));
                    }

                    CourseRoom newclass = new CourseRoom(className, nClassRoom, teacherList.get(0), stinclass4);
                    courseList.add(newclass);

                    //Printing the new class information
                    System.out.println("This is the full information of the class recently created: ");
                    System.out.println("Class name: " + courseList.get(5).getNameCourse() + ", classroom #: " + courseList.get(5).getClassRoom() + ", teacher name: " + courseList.get(5).gettAssignation().name + ", and the students are: ");
                    for (int i = 0; i < courseList.get(5).getSbyclass().size(); i++) {
                        System.out.println(courseList.get(5).getSbyclass().get(i).name);
                    }

                    //Printing the full list of classes
                    System.out.println("The new full list of classes is: ");
                    for (int i = 0; i < courseList.size(); i++) {
                        System.out.println(courseList.get(i).getNameCourse());
                    }

                    break;

                case 5:
                    break;

                case 6:
                    exit = false;
                    break;


            }


        } while (exit == true);


    }
}