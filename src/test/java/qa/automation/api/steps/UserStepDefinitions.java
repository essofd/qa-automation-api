package qa.automation.api.steps;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.apache.http.HttpStatus;
import qa.automation.api.support.api.UserApi;
import qa.automation.api.support.domain.User;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserStepDefinitions {

    private Map<String, String> expectedUser = new HashMap<>();
    private User user;
    private UserApi userApi;

    public UserStepDefinitions(){
        userApi = new UserApi();
    }

    @Quando("faco um POST para {word} com os seguintes valores:")
    public void facoUmPOSTParaVUserComOsSeguintesValores(String endpoint, Map<String, String> user) {
        expectedUser = user;
        given().
            body(user).
        when().
            post(endpoint).
        then().
            statusCode(HttpStatus.SC_OK);
    }

    @Entao("faco um GET para {word}, o usuario criado eh retornado")
    public void faco_um_get_para_v2_user_renato_o_usuario_criado_e_retornado(String endpoint) {
        when().
             get(endpoint).
         then().
             statusCode(HttpStatus.SC_OK).
             body("username", is(expectedUser.get("username")));

    }

    @Quando("crio um usuario")
    public void crioUmUsuario() {
        user = User.builder().build();
        userApi.createUser(user);
    }

    @Entao("o usuario e criado com sucesso")
    public void oUsuarioECriadoComSucesso() {
        String actualUserName = userApi.getUsername(user);
        assertThat(actualUserName,is(user.getUsername()));
    }

}
