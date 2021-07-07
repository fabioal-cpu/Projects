package com.automation.api.data;

import com.automation.api.pojo.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

import java.util.*;

/**
 * Class where the data test is generated
 * @author fabio.alarcon
 */
public class Data {

    private Random random = new Random();
    private int totalNewUsers = 12;

    @DataProvider(name = "user1")
    public Object[][] inputSingleData() {
        User testSingle = new User("name 1",
                "lastName 1",
                100,
                19023,
                "Income",
                "email 1",
                true,
                "USA",
                "332423");
        return new Object[][] {{testSingle}};
    }

    @DataProvider(name = "allUsers")
    public Object[][] inputData() {
        return new Object[][] {dataProviderFullList().toArray()};
    }

    /**
     * Method to provide a list of new data (new users)
     */
    ArrayList<User> finalList = new ArrayList<>();
    Set<Integer> randomNumbers = new HashSet<>();
    List<Integer> preList = new ArrayList<>();
    public List<User> dataProviderFullList(){
        int i=0;
        while (i<totalNewUsers){
            int j = 0;
            while (j<totalNewUsers){
                if(randomNumbers.add(randomNumbers())){
                    j++;
                }
            }
            preList.addAll(randomNumbers);
            finalList.add(new User(names(),
                    lastNames(),
                    randomNumbers(),
                    randomNumbers(),
                    transaction(),
                    "fabio.test"+randomNumbers()+"@aol.com",
                    activeRequest(),
                    countries(),
                    sevenNumbers()));
            i++;
        }
        return finalList;
    }

    /**
     * Select a random name
     * @return names String
     */
    public String names() {
        String name[] = {"Juan", "Pedro", "Andrea", "Pepito", "Fabio", "Maria", "Juana", "David"};
        int idx = random.nextInt(name.length);
        String nameSelected = name[idx];
        return nameSelected;
    }

    /**
     * Select a random last name
     * @return lastname String
     */
    public String lastNames() {
        String lastName[] = {"Alarcon", "Rodriguez", "Herrera", "Cepeda", "Quintana", "Baracaldo", "Camacho"};
        int idx = random.nextInt(lastName.length);
        String lastNSelected = lastName[idx];
        return lastNSelected;
    }

    /**
     * Generate random numbers
     * @return randomNumbers integer
     */
    public int randomNumbers(){
        int number = random.nextInt(100);
        return number;
    }

    /**
     * Generate seven phone numbers
     * @return sevenNumbers String
     */
    public String sevenNumbers(){
        String seven = RandomStringUtils.randomNumeric(7);
        return seven;
    }

    /**
     * Generate active or inactive
     * @return active boolean
     */
    public boolean activeRequest(){
        boolean active = random.nextBoolean();
        return active;
    }

    /**
     * Generate income or withdraw type of transactions
     * @return transaction String
     */
    public String transaction(){
        String type;
        if (activeRequest() == true){
            type = "Income";
        }else {
            type = "Withdraw";
        }
        return type;
    }

    /**
     * Select a random country
     * @return
     */
    public String countries(){
        String countries[] = {"Colombia", "USA", "Canada", "Panama", "Brazil"};
        int idx = random.nextInt(countries.length);
        String countryselected = countries[idx];
        return countryselected;
    }
}