package big.bite.many2many.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "business")
public class Business {

    @Transient
    static final String sequenceName = "business_seq";

    @Id
    @SequenceGenerator(name = sequenceName,sequenceName = sequenceName, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = sequenceName)
    private Long id;

    @Column(name ="business")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "businesses",fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

}
