package big.bite.many2many.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserCreateDTO {

    private String fullName;

    private String lang;

    private List<Long> businesses;
}
