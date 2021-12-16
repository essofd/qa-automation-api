package qa.automation.api.support.api;

import io.restassured.response.Response;
import qa.automation.api.support.domain.Pet;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetApi {
    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "/v3/pet/findByStatus?status={status}";
    private static final String PET_ENDPOINT = "/v3/pet/{id}";

    public List<Pet> getPetsByStatus(String status){
        return given().
                   pathParam("status",status).
                when().
                   get(FIND_PETS_BY_STATUS_ENDPOINT).
                then().
                    extract().body().jsonPath().getList("", Pet.class);
    }

    public Response getPetsResponseByStatus(String status){
        return given().
                  pathParam("status",status).
                when().
                  get(FIND_PETS_BY_STATUS_ENDPOINT);
    }

    public void deletePetsByStatus(String status){

        List<Integer> petsId = given().
                                  pathParam("status",status).
                               when().
                                  get(FIND_PETS_BY_STATUS_ENDPOINT).
                               thenReturn().
                                  path("id");

        if (!petsId.isEmpty()) {
            for (Integer id : petsId) {
                given().pathParam("id", id).delete(PET_ENDPOINT);
            }
        }
    }
}
