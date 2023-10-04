package big.bite.many2many.controller;

import big.bite.many2many.common.BusinessCreateDTO;
import big.bite.many2many.service.BusinessService;
import com.sun.istack.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/business")
public class BusinessController {

    private final BusinessService businessService;
    @PostMapping("/create")
    public ResponseEntity<?> createBusiness(@RequestBody BusinessCreateDTO dto){
        return ResponseEntity.ok(businessService.createBusiness(dto));
    }


    @GetMapping()
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0")
                                    @PositiveOrZero(message = "PARAMETERS_NOT_VALID") int page,
                                    @RequestParam(defaultValue = "50")
                                    @Positive(message = "PARAMETERS_NOT_VALID") int size) {
        return ok(businessService.getAll(PageRequest.of(page, size > 50 ? 50 : size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable @NotNull @Positive Long id) {
        return ok(businessService.getById(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<?> editById(@PathVariable @NotNull @Positive Long id,
                                      @RequestParam String newName) {
        return ok(businessService.editById(id, newName));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        businessService.deleteById(id);
        return accepted().build();
    }

}
