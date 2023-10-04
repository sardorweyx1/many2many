package big.bite.many2many.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class BusinessDTO {

    private Long id;

    private String name;

    private List<String> usersName;

}
