package big.bite.many2many.common;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String firstName;

    private String lastName;

    private String lang;

    private List<Long> businessId;

}
