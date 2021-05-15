package FinalProject.Main;

import FinalProject.Data.CourseRoom;
import FinalProject.Data.Student;
import FinalProject.Data.Teacher;

import java.util.ArrayList;
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
        Student s5 = new Student("Daniel", 2152601, 20);
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

        ArrayList<Student> studenttest = StudentbyeachClass(studentList);

        CourseRoom clas1 = new CourseRoom("Finance", 505, teacherList.get(0), studenttest);
        CourseRoom clas2 = new CourseRoom("Math", 101, teacherList.get(1), studentList);
        CourseRoom clas3 = new CourseRoom("Business", 405, teacherList.get(2), Distribution2(studentList));
        CourseRoom clas4 = new CourseRoom("Statistic", 302, teacherList.get(0), Distribution3(studentList));
        CourseRoom clas5 = new CourseRoom("Econometrics", 504, teacherList.get(3), Distribution4(studentList));
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
                        teacherList.get(i).setBaseSalary(teacherList.get(i).teacherSalary(teacherList.get(i).getTeachertype(), teacherList.get(i).getBaseSalary(), teacherList.get(i).getExperienceyears(), teacherList.get(i).getHourswork()));
                        teacherList.get(i).setType(teacherList.get(i).teacherTyDef(teacherList.get(i).getTeachertype()));
                        System.out.println("Teacher name: " + teacherList.get(i).getName() + ", teacher id: " + teacherList.get(i).getId() + ", teacher type: " + teacherList.get(i).getType() + ", teacher salary: $" + teacherList.get(i).getBaseSalary());
                    }
                    break;

                case 2:
                    boolean exitsubmenu = true;

                    do {
                        System.out.println("\nPlease select the class that you would like to see more information:");
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
                                System.out.println("Class name: " + courseList.get(0).getNameCourse() + ", classroom #: " + courseList.get(0).getClassRoom() + ", teacher name: " + courseList.get(0).gettAssignation().getName() + ", and the students are: ");
                                for (int i = 0; i < courseList.get(0).getSbyclass().size(); i++) {
                                    System.out.println(courseList.get(0).getSbyclass().get(i).getName());
                                }
                                break;
                            case 2:
                                System.out.println("This is the full information of the class selected: ");
                                System.out.println("Class name: " + courseList.get(1).getNameCourse() + ", classroom #: " + courseList.get(1).getClassRoom() + ", teacher name: " + courseList.get(1).gettAssignation().getName() + ", and the students are: ");
                                for (int i = 0; i < courseList.get(1).getSbyclass().size(); i++) {
                                    System.out.println(courseList.get(1).getSbyclass().get(i).getName());
                                }
                                break;
                            case 3:
                                System.out.println("This is the full information of the class selected: ");
                                System.out.println("Class name: " + courseList.get(2).getNameCourse() + ", classroom #: " + courseList.get(2).getClassRoom() + ", teacher name: " + courseList.get(2).gettAssignation().getName() + ", and the students are: ");
                                for (int i = 0; i < courseList.get(2).getSbyclass().size(); i++) {
                                    System.out.println(courseList.get(2).getSbyclass().get(i).getName());
                                }
                                break;
                            case 4:
                                System.out.println("This is the full information of the class selected: ");
                                System.out.println("Class name: " + courseList.get(3).getNameCourse() + ", classroom #: " + courseList.get(3).getClassRoom() + ", teacher name: " + courseList.get(3).gettAssignation().getName() + ", and the students are: ");
                                for (int i = 0; i < courseList.get(3).getSbyclass().size(); i++) {
                                    System.out.println(courseList.get(3).getSbyclass().get(i).getName());
                                }
                                break;
                            case 5:
                                System.out.println("This is the full information of the class selected: ");
                                System.out.println("Class name: " + courseList.get(4).getNameCourse() + ", classroom #: " + courseList.get(4).getClassRoom() + ", teacher name: " + courseList.get(4).gettAssignation().getName() + ", and the students are: ");
                                for (int i = 0; i < courseList.get(4).getSbyclass().size(); i++) {
                                    System.out.println(courseList.get(4).getSbyclass().get(i).getName());
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

                    System.out.println("\nAs new student, please select a class to enroll: ");

                    for (int i = 0; i < courseList.size(); i++) {
                        System.out.println((i + 1) + ". " + courseList.get(i).getNameCourse());
                    }
                    int selectClass = scanner.nextInt();
                    courseList.get(selectClass - 1).getSbyclass().add(studentList.get(6));

                    System.out.println("The student was enrolled to the class " + courseList.get(selectClass - 1).getNameCourse());

                    System.out.println("The full student list for the class " + courseList.get(selectClass - 1).getNameCourse() + " are: ");
                    for (int i = 0; i < courseList.get(selectClass - 1).getSbyclass().size(); i++) {
                        System.out.println(courseList.get(selectClass - 1).getSbyclass().get(i).getName());
                    }

//                    //Compulsory class = math, sorry. University laws
//                    courseList.get(1).getSbyclass().add(studentList.get(6));
//                    System.out.println("\nUnder the University law you are enrolled in the compulsory class of " + courseList.get(1).getNameCourse());

                    //The full list of students
                    System.out.println("\nThe full student list is: ");
                    for (int i =0; i < studentList.size(); i++){
                        System.out.println(studentList.get(i).getName());
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
                    Random random = new Random();
                    for (int i = 0; i < 3; i++) {
                        int number = random.nextInt(6);
                        stinclass4.add(studentList.get(number));
                    }

                    CourseRoom newclass = new CourseRoom(className, nClassRoom, teacherList.get(0), stinclass4);
                    courseList.add(newclass);

                    //Printing the new class information
                    System.out.println("This is the full information of the class recently created: ");
                    System.out.println("Class name: " + courseList.get(5).getNameCourse() + ", classroom #: " + courseList.get(5).getClassRoom() + ", teacher name: " + courseList.get(5).gettAssignation().getName() + ", and the students are: ");
                    for (int i = 0; i < courseList.get(5).getSbyclass().size(); i++) {
                        System.out.println(courseList.get(5).getSbyclass().get(i).getName());
                    }

                    //Printing the full list of classes
                    System.out.println("The new full list of classes is: ");
                    for (int i = 0; i < courseList.size(); i++) {
                        System.out.println(courseList.get(i).getNameCourse());
                    }

                    break;

                case 5:

                    boolean exitst = true;
                    do{
                        System.out.println("Based on the following list, please indicate the student id which you are seeking information from: ");
                        System.out.println("id: " + studentList.get(0).getId());
                        System.out.println("id: " + studentList.get(1).getId());
                        System.out.println("id: " + studentList.get(2).getId());
                        System.out.println("id: " + studentList.get(3).getId());
                        System.out.println("id: " + studentList.get(4).getId());
                        System.out.println("id: " + studentList.get(5).getId());

                        int choicest = scanner.nextInt();

                            for (int i = 0; i < studentList.size(); i++) {
                                if (choicest == studentList.get(i).getId()) {
                                    System.out.println("The name of the student is: " + studentList.get(i).getName());
                                }
                            }

                            System.out.println("The student is enrolled in the following courses: ");
                            for (int i = 0; i < courseList.size(); i++) {
                                for (int j = 0; j < courseList.get(i).getSbyclass().size(); j++) {
                                    if (choicest == courseList.get(i).getSbyclass().get(j).getId()) {
                                        System.out.println(courseList.get(i).getNameCourse());

                                    }
                                }
                            }

                        System.out.println("Exit?: True o false");
                            exitst = scanner.nextBoolean();

                    }while (!exitst);
                    break;

                case 6:
                    exit = false;
                    break;
            }

        } while (exit == true);

    }

    private static ArrayList Distribution(ArrayList<Student> studentArrayList){
        Random random = new Random();
        ArrayList<Student> studing = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(6);
            studing.add(studentArrayList.get(number));
        }

        return studing;
    }

    private static ArrayList Distribution2(ArrayList<Student> studentArrayList){
        Random random = new Random();
        ArrayList<Student> studing = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(6);
            studing.add(studentArrayList.get(number));
        }

        return studing;
    }

    private static ArrayList Distribution3(ArrayList<Student> studentArrayList){
        Random random = new Random();
        ArrayList<Student> studing = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(6);
            studing.add(studentArrayList.get(number));
        }

        return studing;
    }

    private static ArrayList Distribution4(ArrayList<Student> studentArrayList){
        Random random = new Random();
        ArrayList<Student> studing = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(6);
            studing.add(studentArrayList.get(number));
        }

        return studing;
    }


    private static ArrayList StudentbyeachClass(ArrayList<Student> studentArrayList){
        Random random = new Random();
        ArrayList<Student> stinclass = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int randomIndex;
            do{
                randomIndex = random.nextInt(5);

            }while (search(studentArrayList, randomIndex));

            stinclass.add(studentArrayList.get(randomIndex));

        }
        return stinclass;
    }

    public static boolean search(ArrayList<Student> studentArrayList, int randomIndex){

        for (int i = 0; i < studentArrayList.size(); i++){
            if (studentArrayList.get(i).getId() == studentArrayList.get(randomIndex).getId()){
                return false;
            }
        }

        //If we've reach this point, then the entire array was searched and the value was not found

        return true;
    }


}