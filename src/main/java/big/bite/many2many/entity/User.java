package big.bite.many2many.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Transient
    static final String sequenceName = "users_seq";

    @Id
    @SequenceGenerator(name = sequenceName, sequenceName = sequenceName,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequenceName)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "lang")
    private String lang;

    @ManyToMany
    @JoinTable(
            name = "user_business",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "busines_id")
    )
    private List<Business> businesses;

    public void addBusiness(List<Business> businessList){
        this.businesses.addAll(businessList);
        businessList.forEach(business -> business.getUsers().add(this));
    }

}
