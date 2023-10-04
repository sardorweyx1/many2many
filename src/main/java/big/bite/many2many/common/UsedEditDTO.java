package big.bite.many2many.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UsedEditDTO {

    private String firstName;

    private String lastName;

    private String lang;

    private List<String> businesses;

}
