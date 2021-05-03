package Runner;

import java.io.IOException;
import java.util.*;

import Data.Glober;
import Data.JuniorEngineer;
import Data.SeniorEngineer;
import Data.TechLead;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        ArrayList<Glober> myList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);


        boolean exit = false;


        do {
            System.out.println(" what do you want to do:");
            System.out.println("1 - add a glober");
            System.out.println("2 - print amount of Globers");
            System.out.println("3 - print whole list of Globers");
            System.out.println("4 - list of responsibilities");
            System.out.println("5 - exit");
            int opt = scan.nextInt();




            switch (opt) {
                    case 1:

                        System.out.println("Please enter the name of the Glober: ");
                        String name2 = scan.next();
                        System.out.println("Please enter the salary of the Glober: ");
                        double salary2 = scan.nextDouble();
                        //JuniorEngineer x = new JuniorEngineer(salary2,name2);
                        System.out.println("Please select the Glober's rol: 1. (JuniorEng), 2. (SeniorEng) OR 3. (TechLead)");
                        int option = scan.nextInt();
                        if (option == 1) {
                            Glober juniorengineer = new JuniorEngineer(salary2, name2);
                            myList.add(juniorengineer);
                        } else if (option == 2) {
                            Glober seniorengineer = new SeniorEngineer(salary2, name2);
                            myList.add(seniorengineer);
                        } else if (option == 3) {
                            Glober techlead = new TechLead(salary2, name2);
                            myList.add(techlead);
                        } else {
                        }


                        break;


                    case 2:

                        System.out.println("The current amount of Globers is : " + myList.size());
                        break;


                    case 3:


                        for (int i = 0; i < myList.size(); i++) {

                            System.out.println("Glober's name: " + myList.get(i).getName() + " " + "Glober's salary: " + myList.get(i).getSalary() + "\n");
                        }

                        break;

                    case 4:


                        System.out.println("The current amount of Globers is : " + myList.size());
                        System.out.println("Please enter the id of the Glober you want to search");
                        int item = scan.nextInt();
                        System.out.println("The following are the responsibilities of  " + myList.get(item-1).getName());
                        myList.get(item - 1).debuggingSW();
                        myList.get(item - 1).codingSW();
                        myList.get(item - 1).executingTestCases();
                        myList.get(item - 1).designingTestPlans();
                        myList.get(item - 1).coachingATeam();
                        myList.get(item - 1).leadingATeam();
                        break;

                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Errore, scelta non esistente");
                        break;
                }




        } while (exit == false);


    }
}









