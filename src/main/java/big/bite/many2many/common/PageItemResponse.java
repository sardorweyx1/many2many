package big.bite.many2many.common;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageItemResponse<T> {

    private PageDTO pagination;

    private List<T> items;
}
