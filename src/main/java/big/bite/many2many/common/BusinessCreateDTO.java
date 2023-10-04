package big.bite.many2many.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class BusinessCreateDTO {

    private Long id;

    private String name;

}
