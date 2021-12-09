package qa.automation.api.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import qa.automation.api.support.api.UserApi;

public class Config {

    private UserApi userApi;

    public Config(){
        userApi = new UserApi();
    }

    @Before
    public void setup() {
        //RestAssured.registerParser("text/html", Parser.JSON);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.baseURI = "http://localhost:12345";
        RestAssured.basePath = "/api";
        RestAssured.requestSpecification = new RequestSpecBuilder().
                addHeader("Authorization",getToken()).
                //setContentType(ContentType.JSON).
                       setContentType("application/json").
                build();
//        RestAssured.responseSpecification = new ResponseSpecBuilder().
//                expectContentType(ContentType.JSON).
//                expectContentType("application/json").
//                build();

    }

    private String getToken() {
        return "grant access";
    }

    @After("@deleteAllUsers")
    public void deleteAllUsers(){
        System.out.println("Deletando Usuarios");
        userApi.deleteAllUsers();
    }
}
