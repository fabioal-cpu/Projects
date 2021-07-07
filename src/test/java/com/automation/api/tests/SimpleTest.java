package com.automation.api.tests;

import com.automation.api.data.Data;
import com.automation.api.pojo.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.automation.api.steps.Users;

/**
 * Class that contains @Test
 * @author fabio.alarcon
 */
public class SimpleTest {

    private Users user_steps;

    @BeforeMethod
    @Parameters({"uri"})
    public void test(String uri){
        user_steps = new Users(uri);
    }


    @Test(description = "Test 1. Verify the endpoint data and empty it")
    public void firstPoint(){
        user_steps.getUsersAPIEndpoint();
        user_steps.getUsers();
        Assert.assertEquals(user_steps.getStatusCode(), 200, "Status is not correct");
        user_steps.showActualUsersList();
        user_steps.deleteAllUser();
        Assert.assertEquals(user_steps.getStatusCode(), 200, "Status is not correct");
    }


    @Test(description = "Test 2. Create new users", dataProviderClass = Data.class, dataProvider = "allUsers")
    public void postUsersTest(Object[] inputData){
        user_steps.createMultipleUsers(inputData);
        Assert.assertEquals(user_steps.getStatusCode(), 201, "Status is not correct");
    }


    @Test(description = "Test 3. Send a POST with previous validation of emails in the endpoint database", dataProviderClass = Data.class, dataProvider = "user1")
    public void validationOfEmail(User oneUser){
        user_steps.getUsersAPIEndpoint();
        user_steps.getUsers();
        user_steps.getUsersEmail(oneUser);
        Assert.assertEquals(user_steps.getStatusCode(), 201, "Status is not correct");
    }


    @Test(description = "Test 4. Update user", dataProviderClass = Data.class, dataProvider = "user1")
    public void putTest(User user){
        user.setAccountNumber(123456);
        user_steps.getUsersAPIEndpoint();
        user_steps.getUsers();
        Assert.assertEquals(user_steps.getStatusCode(), 200, "Status is not correct");
        String id = user_steps.getUserID(user.getName() + " " + user.getLastName());
        Assert.assertNotEquals(id, "", "User doesn't exists");
        user_steps.getUsersAPIEndpoint();
        user_steps.updateUser(id, user.getAccountNumber());
        Assert.assertEquals(user_steps.getStatusCode(), 200, "Status is not correct");
        Assert.assertEquals(user_steps.getUserResponse().getAccountNumber(),  user.getAccountNumber(), "Account Number is not correct");
    }

}
