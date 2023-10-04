package big.bite.many2many.service.impl;

import big.bite.many2many.common.UserCreateDTO;
import big.bite.many2many.entity.Business;
import big.bite.many2many.entity.User;
import big.bite.many2many.repository.BusinessRepository;
import big.bite.many2many.repository.UserRepository;
import big.bite.many2many.service.BusinessService;
import big.bite.many2many.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final BusinessService businessService;
    private final UserRepository userRepository;

    @Override
    public Object createUser(UserCreateDTO dto) {

        List<Business> businesses = businessService.getBusinesses(dto);

        User user = User.builder()
                .fullName(dto.getFullName())
                .lang(dto.getLang())
                .businesses(businesses)
                .build();
        return userRepository.save(user);
    }

}
