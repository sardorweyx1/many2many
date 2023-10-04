package big.bite.many2many.service.impl;

import big.bite.many2many.common.*;
import big.bite.many2many.entity.Business;
import big.bite.many2many.entity.User;
import big.bite.many2many.repository.BusinessRepository;
import big.bite.many2many.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinessService {

    private final BusinessRepository businessRepository;

    @Override
    public Object createBusiness(BusinessCreateDTO dto) {
        if(businessRepository.existsByName(dto.getName()))
            throw new  RuntimeException("Business Already Exists");
        return businessRepository.save(
                Business.builder()
                        .name(dto.getName())
                        .build()
        );
    }

    @Override
    public List<Business> getBusinesses(UserCreateDTO dto) {
        return businessRepository.getBusinessById(dto.getBusinesses());
    }
    @Override
    public List<Business> getBusinessesById(CreateUserRequest request) {
        try {
            return businessRepository.getBusinessById(request.getBusinessId());
        } catch (Exception e) {
            throw new  RuntimeException();
        }
    }
    @Override
    public PageItemResponse<BusinessDTO> getAll(Pageable pageable) {

        Page<Business> businessPage = businessRepository.findAll(pageable);

        List<BusinessDTO> result = businessPage.getContent().stream()
                .map(business -> BusinessDTO.builder()
                        .id(business.getId())
                        .name(business.getName())
                        .build()).collect(Collectors.toList());

        PageDTO pagination = PageDTO.builder()
                .total((int) businessPage.getTotalElements())
                .current(businessPage.getNumber() + 1)
                .perPage((int) (businessPage.getTotalElements() / businessPage.getTotalPages()))
                .previous(businessPage.hasPrevious() ? businessPage.getNumber() : null)
                .next(businessPage.hasNext() ? businessPage.getNumber() + 2 : null)
                .build();

        return PageItemResponse.<BusinessDTO>builder()
                .pagination(pagination)
                .items(result)
                .build();
    }

    @Override
    public BusinessDTO getById(Long id) {
        Business business = businessRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        List<String> owners = business.getUsers().stream()
                .map(User::getFullName)
                .collect(Collectors.toList());

        return BusinessDTO.builder()
                .id(business.getId())
                .name(business.getName())
                .usersName(owners)
                .build();
    }

    @Override
    public BusinessDTO editById(Long id, String newName) {

        Business business = businessRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        business.setName(newName);
        businessRepository.saveAndFlush(business);

        return BusinessDTO.builder()
                .name(business.getName())
                .build();

    }

    @Override
    public void deleteById(Long id)  {

        Business business = businessRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        business.getUsers().stream()
                .map(user -> user.getBusinesses().remove(business))
                .close();

        businessRepository.delete(business);

    }

    @Override
    public Business getByName(String name) {
        return businessRepository.findByName(name)
                .orElseThrow(RuntimeException::new);
    }


}
