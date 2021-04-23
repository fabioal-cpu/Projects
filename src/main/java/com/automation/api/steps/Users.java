package com.automation.api.steps;

import com.automation.api.pojo.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;

public class Users {

    private final String endpoint;
    private Response response;
    public Logger log = Logger.getLogger(Users.class);

    /**
     * Constructor.
     * @param uri String
     */
    public Users(String uri) {
        endpoint = uri + "/v1/users/";
    }

    /**
     * Get users endpoint print.
     */
    public void getUsersAPIEndpoint() {
        log.info(endpoint);
    }

    /**
     * GET Method users/:id.
     * @param id String
     */
    public void getUser(String id) {
        response = given()
                .contentType(ContentType.JSON)
            .when()
                .get(endpoint + id);
        log.info(response.asString());
    }

    /**
     * GET Method users (list of users).
     */
    public void getUsers() {
        response = given()
                .contentType(ContentType.JSON)
        .when()
                .get(endpoint);
    }

    /**
     * POST Method create new user.
     * @param user {@link User}
     */
    public void createUser(User user) {
        response = given()
                .contentType(ContentType.JSON)
                .body(user)
            .when()
                .post(endpoint);
    }

    /**
     * PUT Method update job title of a user.
     * @param id String
     * @param jobTitle String
     */
    public void updateUser(String id, String jobTitle) {

        /*Option 1 (not a good practice)
         String requestBody = "{\r\n" +
                        "   \"job_title\":\"QC Analyst\", + \r\n" +
         "}";*/

        //Option 2
        User user = new User();
        user.setJob_title(jobTitle);

        response = given()
                .contentType(ContentType.JSON)
                .body(user)
            .when()
                .put(endpoint + id);
    }

    /**
     * DELETE Method, delete user by id.
     * @param id String
     */
    public void deleteUser(String id) {
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete(endpoint + id);
    }

    /**
     * Verify expected title.
     * @param jobTitle String
     */
    public void jobTitleChanged(String jobTitle) {
        response.then()
                .body("job_title", equalTo(jobTitle));
    }

    /**
     * Verify expected status code.
     * @param statusCode int
     */
    public void isStatusCode(int statusCode) {
        response.then()
                .statusCode(statusCode);
    }

    /**
     * Print list of users.
     */
    public void showActualUsersList() {
        List<User> users = response.then()
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .jsonPath()
                .getList("$", User.class);

        log.info(users);
    }


    /**
     * Find first user with the name.
     * @param name String name
     * @return sting with the id
     */
    public String getUserID(String name) {
        List<User> users = response.then()
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .jsonPath()
                .getList("$", User.class);

        Optional<User> id = users.stream().filter(user ->
                name.equals(user.getFirst_name() + " " + user.getLast_name()))
                .findFirst();

        if (id.isPresent())
            return id.get().getId();
        else
            return "";
    }


    /**
     * Get last id in the list.
     * @return sting with the id
     */
    public String getLastId() {
        List<User> users =response.then()
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .jsonPath()
                .getList("$", User.class);

        return users.get(users.size() - 1).getId();
    }

    /**
     * Verify expected email.
     * @param email String
     */
    public void userEmailShouldBe(String email) {
        response.then().body("email", equalTo(email));
        User user = response.then().contentType(ContentType.JSON).extract().response().jsonPath()
                .getObject("$", User.class);
        log.info(user.getEmail());
    }
}
