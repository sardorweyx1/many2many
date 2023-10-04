package big.bite.many2many.common;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageDTO {

    private Integer current;

    private Integer previous;

    private Integer next;

    private Integer total;

    private Integer perPage;

}
