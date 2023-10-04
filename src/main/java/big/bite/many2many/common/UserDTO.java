package big.bite.many2many.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private String firstName;

    private String lastName;

    private String lang;

    private String status;

    private String userType;

    private List<String> businesses;

}
