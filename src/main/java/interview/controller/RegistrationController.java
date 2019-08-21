package interview.controller;

import interview.dto.CustomerDto;
import interview.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/register")
public class RegistrationController {

    private CustomerService customerService;

    @Autowired
    public RegistrationController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CustomerDto register(@Validated @RequestBody CustomerDto customerDto) {
        return customerService.register(customerDto);
    }
}
