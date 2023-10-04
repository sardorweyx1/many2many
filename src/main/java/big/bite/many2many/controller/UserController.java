package big.bite.many2many.controller;

import big.bite.many2many.common.UserCreateDTO;
import big.bite.many2many.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserCreateDTO dto){
       return ResponseEntity.ok(userService.createUser(dto));
    }
}
