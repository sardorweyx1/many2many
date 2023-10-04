package big.bite.many2many.repository;

import big.bite.many2many.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessRepository extends JpaRepository<Business,Long> {

    @Query(value = "select * from business where business.id in (:businessId);",nativeQuery = true)
    List<Business> getBusinessById(@Param("businessId") List<Long> businessId);

    boolean existsByName(String name);

    Optional<Business> findByName(String name);
}
