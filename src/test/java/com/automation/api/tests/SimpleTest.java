package com.automation.api.tests;

import com.automation.api.data.Data;
import com.automation.api.pojo.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.automation.api.steps.Users;


public class SimpleTest {

    private Users steps;

    @BeforeMethod
    @Parameters({"uri"})
    public void test(String uri){
        steps = new Users(uri);
    }

    @Test(description = "Get list of users")
    public void getUsersTest(){
        steps.getUsersAPIEndpoint();
        steps.getUsers();
        steps.isStatusCode(200);
        steps.showActualUsersList();
    }

    @Test(description = "Get a user")
    @Parameters({"name", "email"})
    public void getUserTest(String name, String email){
        steps.getUsersAPIEndpoint();
        steps.getUsers();
        steps.isStatusCode(200);
        String id = steps.getUserID(name);
        Assert.assertNotEquals(id, "", "User doesn't exists");
        steps.getUser(id);
        steps.isStatusCode(200);
        steps.userEmailShouldBe(email);
    }

    @Test(description = "Create a new user post", dataProviderClass = Data.class, dataProvider = "users")
    public void postUsersTest(User user){
        steps.getUsersAPIEndpoint();
        steps.createUser(user);
        steps.isStatusCode(201);
    }

    @Test(description = "Update user", dataProviderClass = Data.class, dataProvider = "users")
    public void putTest(User user){
        steps.getUsersAPIEndpoint();
        steps.getUsers();
        steps.isStatusCode(200);
        String id = steps.getUserID(user.getFirst_name() + " " + user.getLast_name());
        Assert.assertNotEquals(id, "", "User doesn't exists");
        steps.getUsersAPIEndpoint();
        steps.updateUser(id, "Mesero");
        steps.isStatusCode(200);
        steps.jobTitleChanged("Mesero");
    }

    @Test(description = "delete las user")
    public void deleteUserTest(){
        steps.getUsersAPIEndpoint();
        steps.getUsers();
        steps.isStatusCode(200);
        String id = steps.getLastId();
        Assert.assertNotNull(id, "NOT HAVE USERS");
        steps.deleteUser(id);
        steps.isStatusCode(200);
        steps.getUser(id);
        steps.isStatusCode(404);
    }
}
