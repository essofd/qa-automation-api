package qa.automation.api.support.domain;


import lombok.Builder;
import lombok.Data;

@Data //@Data é igual o getter e setter juntos
@Builder
public class User {
    @Builder.Default //Serve para criar valores default para as variaveis
    private int id = 12;
    @Builder.Default
    private String username = "essofd";
    @Builder.Default
    private String firstName = "Edson";
    @Builder.Default
    private String lastName = "Costa";
    @Builder.Default
    private String email = "abc@gmail.com";
    @Builder.Default
    private String password = "12345";
    @Builder.Default
    private String phone = "997589561";
    @Builder.Default
    private int userStatus = 1;
}
