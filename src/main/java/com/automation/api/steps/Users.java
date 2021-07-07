package com.automation.api.steps;

import com.automation.api.pojo.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.Optional;

/**
 * Class that contains the methods used in the @Test
 * @author fabio.alarcon
 */
public class Users {

    private final String endpoint;
    private Response response;
    public Logger log = Logger.getLogger(Users.class);

    /**
     * Constructor.
     * @param uri String
     */
    public Users(String uri) {
        endpoint = uri + "/Transactions/";
    }

    /**
     * Get users endpoint print.
     */
    public void getUsersAPIEndpoint() {
        log.info(endpoint);
    }


    /**
     * GET Method users (list of users).
     */
    public void getUsers() {
        response = given().get(endpoint);
    }

    /**
     * Method to check if the email already exist in the data
     * @param user1 list
     */
    public void getUsersEmail(User user1) {
        List<User> users = response.then().extract().response().jsonPath().getList("$", User.class);

        boolean emailValidation = true;

        for (int i =0; i<users.size(); i++){
            if(users.get(i).getEmail().equals(user1.getEmail())){
                emailValidation = false; }
        }

        if(emailValidation == false){
            log.info("The email already exist");
        }else {
            response = given().contentType(ContentType.JSON).body(user1).when().post(endpoint);
            log.info("User created");

        }

    }


    /**
     * POST Method create new user.
     * @param user {@link User}
     */
    public void createUser(User user) {
        response = given().contentType(ContentType.JSON).body(user).when().post(endpoint);
    }

    /**
     * Method to create multiple users
     * @param multipleData list
     */
    public void createMultipleUsers(Object[] multipleData) {
        for (Object data : multipleData) {
            response = given().contentType(ContentType.JSON).body(data).when().post(endpoint);
        }
    }
    /**
     * PUT Method update AccountNumber of a user.
     * @param id String
     * @param AccountNumber double
     */
    public void updateUser(String id, double AccountNumber) {
        User user = new User();
        user.setAccountNumber(AccountNumber);
        response = given().contentType(ContentType.JSON).body(user).when().put(endpoint + id);
    }

    /**
     * DELETE Method, delete user by id.
     * @param id String
     */
    public void deleteUser(String id) {
        response = given().delete(endpoint + id);
    }

    /**
     * Method to delete all the users
     */
    public void deleteAllUser() {
        List<User> users = response.then().extract().response().jsonPath().getList("$", User.class);
        if (users.isEmpty()){
            log.info("There is no data");
        }else {
            int i = 0;
            while (i < users.size()) {
                String id = users.get(i).getId();
                deleteUser(id);
                i++;
            }
            log.info("Warning: All the data was deleted!");
        }
    }


    /**
     * get response status code.
     * @return status code int
     */
    public int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * Print list of users.
     */
    public void showActualUsersList() {
        List<User> users = response.then().extract().response().jsonPath().getList("$", User.class);
        log.info(users);
    }


    /**
     * Find first user with the name.
     * @param name String name
     * @return sting with the id
     */
    public String getUserID(String name) {
        List<User> users = response.then().extract().response().jsonPath().getList("$", User.class);

        Optional<User> id = users.stream().filter(user ->
                name.equals(user.getName() + " " + user.getLastName()))
                .findFirst();

        if (id.isPresent())
            return id.get().getId();
        else
            return "";
    }


    /**
     * get user response.
     * @return User
     */
    public User getUserResponse() {
        return response.then().extract().as(User.class);
    }
}