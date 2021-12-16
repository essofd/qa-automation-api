package qa.automation.api.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import qa.automation.api.support.api.PetApi;
import qa.automation.api.support.domain.Pet;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PetStepDefinitions {

    private PetApi petApi;
    private List<Pet> actualPets;

    public PetStepDefinitions(){
        petApi = new PetApi();
    }

    @Dado("que eu possua animais {word}")
    public void queEuPossuaAnimais(String Status)  {
//       Pet pet = Pet.builder().build();
//       ObjectMapper mapper = new ObjectMapper();
//       String json = mapper.writeValueAsString(pet);
//       System.out.println(json);
    }

    @Quando("eu pesquiso por todos os animais {word}")
    public void euPesquisoPorTodosOsAnimais(String status) {
         actualPets = petApi.getPetsByStatus(status);
    }

    @Entao("eu recebo a lista de animais available")
    public void euReceboAListaDeAnimaisDisponiveis() {
        assertThat(actualPets, is(not(empty())));
    }


    @E("eu recebo uma lista de animais {word}")
    public void euReceboUmaListaDeAnimais(String status) {
        Response actualPetsResponse = petApi.getPetsResponseByStatus(status);

        actualPets =  actualPetsResponse.body().jsonPath().getList("", Pet.class);
         actualPetsResponse.
                 then().
                    statusCode(HttpStatus.SC_OK).
                 body(
                  "size()", is(actualPets.size()),
                       "findAll {it.status == 'available'}.size()", is(actualPets.size())
                 );
    }

    @Entao("eu recebo a lista com {} animais/animal")
    public void euReceboAListaComAnimais(int petsQuantity) {
        assertThat(actualPets.size(), is(petsQuantity));
    }

    @Dado("que eu nao possua animais {word}")
    public void queEuNaoPossuaAnimaisSold(String status) {
        petApi.deletePetsByStatus(status);
    }

}
