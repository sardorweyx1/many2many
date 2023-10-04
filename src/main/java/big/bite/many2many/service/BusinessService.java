package big.bite.many2many.service;

import big.bite.many2many.common.*;
import big.bite.many2many.entity.Business;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BusinessService {
    Object createBusiness(BusinessCreateDTO dto);

    List<Business> getBusinesses(UserCreateDTO dto);


    PageItemResponse<BusinessDTO> getAll(Pageable pageable);

    BusinessDTO getById(Long id);

    BusinessDTO editById(Long id, String newName);

    void deleteById(Long id);

    Business getByName(String name);

    List<Business> getBusinessesById(CreateUserRequest request);

}
