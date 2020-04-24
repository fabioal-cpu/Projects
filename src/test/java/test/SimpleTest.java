package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.User;
import steps.Users;

import java.util.ArrayList;
import java.util.List;

public class SimpleTest {

    private Users steps;

    private List<User> users;

    @DataProvider(name = "ids")
    public Object[][] inputData() {
        return new Object[][] {{"200"}, {"201"}};
    }

    @BeforeMethod
    @Parameters({"uri"})
    public void test(String uri){
        steps = new Users(uri);

        users = new ArrayList<>();

        User carlos = User.builder()
        .first_name("Chapo")
        .last_name("Guzman")
        .email("hoyoEnUno@gmail.com")
        .country("Mexico")
        .active("true")
        .telephone("2452345234532")
        .job_title("Minero")
        .build();

        User carla = new User("carla",
                "pondrea",
                "lasdffuidsa@p.com",
                "Colombia",
                "3452345",
                "true",
                "Java  dev");

        users.add(carlos);
        users.add(carla);
    }

    @Test
    public void getUsersTest(){
        steps.getUsersAPIEndpoint();
        steps.getUsers();
        steps.isStatusCode(200);
        steps.showActualUsersList();
    }

    @Test
    public void getUserTest(){
        steps.getUsersAPIEndpoint();
        steps.getUser("125");
        steps.isStatusCode(200);
        steps.userEmailShouldBe("CinderellaAkela@globant.com");
    }

    @Test
    public void postUsersTest(){
        steps.getUsersAPIEndpoint();
        steps.createUsers(users);
        steps.isStatusCode(201);
    }

    @Test
    public void putTest(){
        steps.getUsersAPIEndpoint();
        steps.updateUser("200", "Mesero");
        steps.isStatusCode(200);
        steps.jobTitleChanged("Mesero");
    }

    @Test(dataProvider = "ids")
    public void deleteUserTest(String id){
        steps.getUsersAPIEndpoint();
        steps.deleteUser(id);
        steps.isStatusCode(200);
        //Verify that the user doesn't exists
        steps.getUser(id);
        steps.isStatusCode(404);
    }
}
